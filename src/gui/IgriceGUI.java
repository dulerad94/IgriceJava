package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import skocko.Skocko;

import java.awt.SystemColor;

public class IgriceGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnBrojevi;
	private JButton btnMemorija;
	private JButton btnSkocko;
	private JButton btnOAutorima;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public IgriceGUI() {
		setResizable(false);
		setBackground(new Color(175, 238, 238));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Skocko.class.getResource("/gui/slike/igre.jpg")));
		contentPane.setLayout(null);
		contentPane.add(getBtnBrojevi());
		contentPane.add(getBtnMemorija());
		contentPane.add(getBtnSkocko());
		contentPane.add(getBtnOAutorima());
		contentPane.add(getLabel_1());
		setLocationRelativeTo(null);
	}
	private JButton getBtnBrojevi() {
		if (btnBrojevi == null) {
			btnBrojevi = new JButton("BROJEVI");
			btnBrojevi.setForeground(new Color(30, 144, 255));
			btnBrojevi.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
			btnBrojevi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontoler.prikaziBrojeviGUI();
				}
			});
			btnBrojevi.setBounds(178, 180, 115, 79);
		}
		return btnBrojevi;
	}
	private JButton getBtnMemorija() {
		if (btnMemorija == null) {
			btnMemorija = new JButton("MEMORIJA");
			btnMemorija.setForeground(new Color(30, 144, 255));
			btnMemorija.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
			btnMemorija.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontoler.prikaziMemoriju();
				}
			});
			btnMemorija.setBounds(259, 67, 115, 79);
		}
		return btnMemorija;
	}
	private JButton getBtnSkocko() {
		if (btnSkocko == null) {
			btnSkocko = new JButton("SKO\u010CKO");
			btnSkocko.setForeground(new Color(30, 144, 255));
			btnSkocko.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
			btnSkocko.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontoler.prikaziSkocko();
				}
			});
			btnSkocko.setBounds(86, 67, 115, 79);
		}
		return btnSkocko;
	}
	private JButton getBtnOAutorima() {
		if (btnOAutorima == null) {
			btnOAutorima = new JButton("O AUTORIMA");
			btnOAutorima.setForeground(new Color(30, 144, 255));
			btnOAutorima.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
			btnOAutorima.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontoler.prikaziAutore(null);
				}
			});
			btnOAutorima.setBounds(178, 492, 115, 37);
		}
		return btnOAutorima;
	}
	private JLabel getLabel_1() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/gui/slike/dasads.jpg")));
			lblNewLabel.setBounds(0, 0, 450, 542);
		}
		return lblNewLabel;
	}
}
