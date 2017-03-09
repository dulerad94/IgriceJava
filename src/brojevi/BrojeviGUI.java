package brojevi;
import gui.GUIKontoler;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;


public class BrojeviGUI extends JFrame {
	/**
	 * panel koji sadrzi ceo izgled igrice
	 */
	private JPanel contentPane;
	/**
	 * panel koji sadrzi dugmice i informacije o rezultatu
	 */
	private JPanel panelEast;
	/**
	 * labela HighScore
	 */
	private JLabel lblHighScore;
	/**
	 * polje gde pise najbolji rezultat
	 */
	private JTextField txtHighScore;
	/**
	 * labela Trenutni nivo
	 */
	private JLabel lblTrenutniNivo;
	/**
	 * polje gde pise trenutni rezultat
	 */
	private JTextField txtTrenutniNivo;
	/**
	 * dugme koje resetuje igru
	 */
	private JButton btnIgraj;
	/**
	 * Brojevi koji se postavljaju i pogadjaju
	 */
	private  Brojevi brojevi;
	/**
	 * tajmer
	 */
	private Timer timer;
	/**
	 * broj sekundi koliko se gleda u brojeve
	 */
	private int vreme;
	/**
	 * trenutni nivo
	 */
	private int nivo;
	/**
	 * najbolji ostvaren nivo
	 */
	private int highScore;

	/**
	 * Create the frame.
	 */
	public BrojeviGUI() {
		setBackground(new Color(255, 255, 102));
		addWindowListener(new WindowAdapter() {		
			@Override
			public void windowClosing(WindowEvent arg0) {
					izadji();
			}
		
		});
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 817, 437);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
//		contentPane.setVisible(true);
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		highScore=GUIKontoler.ucitajRez("highScoreBrojevi.out");
		txtHighScore.setText(Integer.toString(highScore));
		setIconImage(Toolkit.getDefaultToolkit().getImage(BrojeviGUI.class.getResource("/brojevi/slike/kuglica.png")));	
		timer=new Timer();		
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				vreme--;
				if(vreme==0) {
					brojevi.setIstekloVreme(true);	
					brojevi.repaint();
					brojevi.setEnabled(true);
				}				
			}
		};
		timer.schedule(task, 0,1000);
		brojevi=new Brojevi(0);
		contentPane.add(brojevi);
	}
	/**
	 * metoda koja postavlja nove brojeve na ekran
	 */
	private void postavi(){
		brojevi.setVisible(false);
		brojevi=new Brojevi(5+nivo);
		brojevi.setVisible(true);
		if(nivo>highScore) highScore=nivo;
		txtTrenutniNivo.setText(Integer.toString(nivo));
		txtHighScore.setText(Integer.toString(highScore));		
		nivo++;
		brojevi.setEnabled(false);
		brojevi.paintComponents(getGraphics());
		brojevi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(brojevi.isEnabled())
				{
					brojevi.proveri(e.getX(), e.getY(), brojevi);		
					if (brojevi.isPredjen()){
						postavi();
					}
				}
			}
		});
		brojevi.setPreferredSize(new Dimension(650,400));
		brojevi.setLayout(null);
		if(nivo>=10) vreme=15;
		if(nivo<10)
			vreme=8;
		if(nivo<7)
			vreme=6;
		if(nivo<4)
			vreme=4;
		contentPane.add(brojevi, BorderLayout.CENTER);
	}
	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setPreferredSize(new Dimension(150, 10));
			panelEast.setLayout(null);
			panelEast.add(getLblHighScore());
			panelEast.add(getTxtHighScore());
			panelEast.add(getLblTrenutniNivo());
			panelEast.add(getTxtTrenutniNivo());
			panelEast.add(getBtnIgraj());
		}
		return panelEast;
	}
	private JLabel getLblHighScore() {
		if (lblHighScore == null) {
			lblHighScore = new JLabel("HighScore");
			lblHighScore.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblHighScore.setBounds(45, 11, 80, 24);
		}
		return lblHighScore;
	}
	private JTextField getTxtHighScore() {
		if (txtHighScore == null) {
			txtHighScore = new JTextField();
			txtHighScore.setDisabledTextColor(Color.BLACK);
			txtHighScore.setHorizontalAlignment(SwingConstants.CENTER);
			txtHighScore.setFont(new Font("Papyrus", Font.BOLD, 38));
			txtHighScore.setEnabled(false);
			txtHighScore.setBounds(45, 36, 80, 80);
			txtHighScore.setColumns(10);
		}
		return txtHighScore;
	}
	private JLabel getLblTrenutniNivo() {
		if (lblTrenutniNivo == null) {
			lblTrenutniNivo = new JLabel("Trenutni nivo");
			lblTrenutniNivo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTrenutniNivo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTrenutniNivo.setBounds(45, 126, 80, 31);
		}
		return lblTrenutniNivo;
	}
	private JTextField getTxtTrenutniNivo() {
		if (txtTrenutniNivo == null) {
			txtTrenutniNivo = new JTextField();
			txtTrenutniNivo.setDisabledTextColor(Color.BLACK);
			txtTrenutniNivo.setHorizontalAlignment(SwingConstants.CENTER);
			txtTrenutniNivo.setFont(new Font("Papyrus", Font.BOLD, 38));
			txtTrenutniNivo.setEnabled(false);
			txtTrenutniNivo.setBounds(45, 168, 80, 80);
			txtTrenutniNivo.setColumns(10);
		}
		return txtTrenutniNivo;
	}
	private JButton getBtnIgraj() {
		if (btnIgraj == null) {
			btnIgraj = new JButton("");
			btnIgraj.setBorder(null);
			btnIgraj.setIcon(new ImageIcon(BrojeviGUI.class.getResource("/brojevi/slike/play.png")));
			btnIgraj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					nivo=0;
					postavi();
				}
			});
			btnIgraj.setBounds(45, 286, 80, 80);
		}
		return btnIgraj;
	}
	
	/**
	 * metoda koja izlazi iz igrice
	 */
	 private void izadji(){
		GUIKontoler.sacuvajRez("highscoreBrojevi.out",highScore);
		dispose();		
	}
}
