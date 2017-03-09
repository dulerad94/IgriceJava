package memorygame;

import gui.GUIKontoler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import memorygame.MemoryGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;

/**
 * Predstavlja vizuelnu klasu koja sadrzi kartice za igru memorije i metode za
 * nasumicno generisanje kartica i njihovo poredjenje.
 * 
 * @author FILIP
 *
 */
public class MemoryPanel extends JPanel implements Serializable {
	public final static int X_OFFSET = 5;
	public final static int Y_OFFSET = 5;
	public final static int X_INDENT = 5;
	public final static int Y_INDENT = 5;
	public int row = 4;
	public int col = 4;
	/**
	 * Predstavlja pozadinsku sliku panela sa karticama
	 */
	private Image currentImage;
	/**
	 * Predstavlja niz sa karticama za igru memorije.
	 */
	private JLabel[] lbl;
	/**
	 * Predstavlja brojac otvorenih kartica.
	 */
	private int selectCounter = 0;
	/**
	 * Predstavlja indexe prve i druge odabrane karitce.
	 */
	private int firstPick, secondPick;
	/**
	 * Predstavlja niz Stringova koji ce se naci na "donjoj" strani kartica
	 */
	private String[] match;
	/**
	 * Predstavlja listu Stringova koji ce se naci na "donjoj" strani kartica
	 * Ova lista omogucava lako nasumicno generisanje elemenata, koji ce se
	 * kasnije naci u nizu match.
	 */
	private List<String> matchList = new ArrayList<String>();
	/**
	 * Predstavlja tajmer kojim se postavlja vrijeme cekanja izmedju svakog
	 * poteza.
	 */
	private Timer displayDelay;
	private boolean ignoreInput = false;
	/**
	 * Broj pogodaka
	 */
	private int hits = 0;
	/**
	 * Broj promasaja
	 */
	private int misses = 0;
	/**
	 * Najmanji broj promasaja 
	 */
	private static int recordMisses = 0;
	
	/**
	 * Konstruktor kojim se kreira panel.
	 */
	public MemoryPanel() {
		setLayout(new GridLayout(4, 4, 0, 0));
		initPanel();
	}

	/**
	 * Metoda za inicijalizaciju panela:
	 * <ul>
	 * <li>Metoda koja puni listu karakterima, zatim elemente liste nasumicno
	 * generise i prebacuje ih u niz.
	 * <li>Metoda zatim elemente iz tog niz postavlja na labele i definise
	 * izgled labela,
	 * <li>zatim inicijalizuje tajmer i postavlja vrijeme cekanja.
	 * </ul>
	 */
	private void initPanel() {
		Character c;

		for (int i = 0; i < row * col / 2; i++) {
			c = new Character((char) ('A' + i));
			matchList.add(c.toString());
			matchList.add(c.toString());
		}

		Collections.shuffle(matchList);

		match = new String[row * col];
		lbl = new JLabel[row * col];

		for (int i = 0; i < row * col; i++) {
			match[i] = matchList.get(i);

			lbl[i] = new JLabel();
			lbl[i].setFont(new Font("SansSerif", Font.BOLD, 24));
			lbl[i].setOpaque(true);
			lbl[i].setHorizontalTextPosition(SwingConstants.CENTER);
			lbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			lbl[i].setForeground(Color.black);
			lbl[i].setBorder(new LineBorder(Color.black));
			lbl[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					mouseClickedHandler(e);
				}
			});

			add(lbl[i]);
		}

		displayDelay = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timerActionPerformed();
			}
		});
		displayDelay.setRepeats(false);
	}

	/**
	 * Metoda kojom se postavlja pozadinska slika na panel.
	 * 
	 * @param imgIcon
	 */
	public void setImage(Image img) {
		currentImage = img;
	}

	/**
	 * Metoda kojom se postavlja pozadinska slika na panel.
	 * 
	 * @param imgIcon
	 */
	public void setImage(ImageIcon imgIcon) {
		currentImage = imgIcon.getImage();
	}

	/**
	 * Metoda koja omogucava prikaz pozadinske slike
	 * 
	 * @param imgIcon
	 */
	public void displayImage(ImageIcon imgIcon) {
		setImage(imgIcon);
		repaint();
	}

	/**
	 * Metoda koja omogucava prikaz pozadinske slike
	 * 
	 * @param img
	 */
	public void displayImage(Image img) {
		setImage(img);
		repaint();
	}

	/**
	 * Metoda koja omogucava prikaz slike koja se nalazi iza kartica, kada dodje
	 * do brisanja istih kartica
	 * 
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = this.getWidth() - X_OFFSET - X_INDENT;
		int height = this.getHeight() - Y_OFFSET - Y_INDENT;
		g.drawImage(currentImage, X_OFFSET, Y_OFFSET, width, height, this);
	}

	/**
	 * Metoda koja brise kartice ukoliko su prva i druga otvorena kartica iste,
	 * odnosno vraca kartice u prvobitni polozaj ukoliko s u kartice razlicite.
	 */
	private void timerActionPerformed() {
		if (match[firstPick].equals(match[secondPick])) {
			lbl[firstPick].setBorder(null);
			lbl[secondPick].setBorder(null);
			lbl[firstPick].setOpaque(false);
			lbl[secondPick].setOpaque(false);
			lbl[firstPick].setText("");
			lbl[secondPick].setText("");
			lbl[firstPick].setEnabled(false);
			lbl[secondPick].setEnabled(false);
			hits++;
			MemoryGame.getLblHitsVal().setText(hits + "");
			if(hits == 8) {
				
				if(recordMisses == 0) {
					recordMisses = getMisses();
					JOptionPane.showMessageDialog(getParent(), "Cestitamo! Pobijedili ste!");
					GUIKontoler.sacuvajRez("highscoreMemoryGame.out", recordMisses);
				} else if(getMisses() < recordMisses) {
					recordMisses = getMisses();
					GUIKontoler.sacuvajRez("highscoreMemoryGame.out", recordMisses);
					JOptionPane.showMessageDialog(getParent(), "Cestitamo! Pobijedili ste sa novim rekordom!");
				} else {
					JOptionPane.showMessageDialog(getParent(), "Čestitamo! Pobijedili ste!");
				}
				
				
			}
		} else {
			lbl[firstPick].setText("");
			lbl[secondPick].setText("");
			misses++;
			MemoryGame.getLblMissesVal().setText(misses + "");
			
		}
		ignoreInput = false;
	}

	/**
	 * metoda koja registruje label na koji se klikne, manipulise
	 * selectCounterom onemogucavajuci otvaranje vise od dvije kartice, i
	 * sprecava da kartice koje se "izbrisu" reaguju na evente.
	 * 
	 * @param e
	 */
	private void mouseClickedHandler(MouseEvent e) {
		if (ignoreInput)
			return;

		JLabel l = null;

		int index = -1;

		for (int i = 0; i < row * col; i++) {
			if (e.getSource() == lbl[i]) {
				l = lbl[i];
				index = i;

				if (!l.isOpaque())
					return;

				l.setText(match[i]);

				break;
			}
		}

		if (l == null)
			return;

		selectCounter++;
		if (selectCounter == 1) {
			firstPick = index;
		}
		if (selectCounter == 2) {
			if (firstPick == index) {
				selectCounter--;
				return;
			}

			selectCounter = 0;
			secondPick = index;
			ignoreInput = true;
			displayDelay.start();
		}

	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getMisses() {
		return misses;
	}

	public void setMisses(int misses) {
		this.misses = misses;
	}

	public static int getRecordMisses() {
		return recordMisses;
	}

}
