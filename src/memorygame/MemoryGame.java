package memorygame;

import gui.GUIKontoler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import brojevi.BrojeviGUI;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MemoryGame extends JFrame {
	/**
	 * Slika koja ce se koristiti za pozadinu
	 */
	private ImageIcon bkgndIcon;
	/**
	 * Memory
	 */
	private JLabel jLabel1;
	/**
	 * Game
	 */
	private JLabel jLabel2;
	/**
	 * Panel na kom se nalaze kartice  i metode za
	 * nasumicno generisanje kartica i njihovo poredjenje.
	 */
	private memorygame.MemoryPanel mp;
	/**
	 * Dugme za novu igru.
	 */
	private JButton btnNewGame;
	private JLabel lblHits;
	private JLabel lblMisses;
	/**
	 * Prikazuje broj pogodaka
	 */
	private static JLabel lblHitsVal;
	/**
	 * Prikazuje broj promasaja
	 */
	private static JLabel lblMissesVal;
	/**
	 * Prikazuje dialog sa informacijom o rekordu u najmanjem broju promsaja
	 */
	private JButton btnRecord;

	/** Konstruktor za kreiranje prozora sa igricom */
	public MemoryGame() {
		getContentPane().setBackground(new Color(255, 255, 102));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MemoryGame.class.getResource("/memorygame/slike/memorija.jpg")));
		setResizable(false);
		initComponents();

		bkgndIcon = new ImageIcon(this.getClass().getResource("/memorygame/slike/bojan.jpg"));
		mp.displayImage(bkgndIcon);
	}
	/**
	 * Metoda koja inicijalizuje i postavlja elemente prozora i panela mp.
	 */
	private void initComponents() {
		mp = new MemoryPanel();
		mp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Igra Memorije");
		mp.setBorder(new LineBorder(new Color(0, 0,
				0), 4));
		getContentPane().add(mp);
		mp.setBounds(10, 10, 230, 230);
		jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Igra");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(250, 10, 210, 50);
		jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("Memorije");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(250, 60, 210, 50);
		getContentPane().add(getBtnNewGame());
		
		lblHits = new JLabel("Pogoci:");
		lblHits.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHits.setBounds(250, 132, 62, 20);
		getContentPane().add(lblHits);
		
		lblMisses = new JLabel("Promasaji:");
		lblMisses.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMisses.setBounds(250, 176, 90, 16);
		getContentPane().add(lblMisses);
		
		lblHitsVal = new JLabel("0");
		lblHitsVal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHitsVal.setBounds(320, 132, 46, 20);
		getContentPane().add(lblHitsVal);
		
		lblMissesVal = new JLabel("0");
		lblMissesVal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMissesVal.setBounds(342, 178, 24, 14);
		getContentPane().add(lblMissesVal);
		
		btnRecord = new JButton("Rekord");
		btnRecord.setBackground(new Color(255, 100, 51));
		btnRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int record = GUIKontoler.ucitajRez("highscoreMemoryGame.out");
				new JOptionPane().showMessageDialog(getParent(), "Najmanji broj promasaja: " +record);
			}
		});
		btnRecord.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRecord.setBounds(373, 130, 97, 60);
		getContentPane().add(btnRecord);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		setBounds((screenSize.width - 486) / 2, (screenSize.height - 287) / 2,
				486, 287);
	}

	private JButton getBtnNewGame() {
		if (btnNewGame == null) {
			btnNewGame = new JButton("Nova Igra ");
			btnNewGame.setBackground(new Color(255, 153, 51));
			btnNewGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					MemoryGame mg = new MemoryGame();
					mg.setVisible(true);
					MemoryGame.this.setVisible(false);

				}
			});
			btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnNewGame.setBounds(250, 201, 220, 39);
		}
		return btnNewGame;
	}
	public static JLabel getLblHitsVal() {
		return lblHitsVal;
	}
	public void setLblHitsVal(JLabel lblHitsVal) {
		this.lblHitsVal = lblHitsVal;
	}
	public static JLabel getLblMissesVal() {
		return lblMissesVal;
	}
	public void setLblMissesVal(JLabel lblMissesVal) {
		this.lblMissesVal = lblMissesVal;
	}
	

}
