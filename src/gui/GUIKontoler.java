package gui;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import brojevi.BrojeviGUI;
import memorygame.MemoryGame;
import skocko.Skocko;

/**
* Predstavlja kontrolni GUI iz koga se poyivaju svi prozori, ovo je preyentacioni nivo
*/
public class GUIKontoler {
	/**
	* instanca pocetnog prozora IgriceGUI
	*/
	private static IgriceGUI igrice;
	/**
	* pokretanje pocetnog proyora
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					igrice = new IgriceGUI();
					igrice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	* Metoda koja poyiva otvaranje prozora za igricu Skocko
	*/
	public static void prikaziSkocko() {
		Skocko prozor = new Skocko();
		prozor.setLocationRelativeTo(null);
		prozor.setVisible(true);
	}
	/**
	* Metoda koja poziva otvaranje prozora za igricu Brojevi
	*/
	public static void prikaziBrojeviGUI() {
		BrojeviGUI prozor = new BrojeviGUI();
		prozor.setLocationRelativeTo(null);
		prozor.setVisible(true);
	}
	/**
	* Metoda koja poziva otvaranje prozora za igricu Memorija
	*/
	public static void prikaziMemoriju() {
		MemoryGame prozor = new MemoryGame();
		prozor.setLocationRelativeTo(null);
		prozor.setVisible(true);
	}
	/**
	* Metoda koja otvara prozor u kome se vide podaci o autorima
	*/
	public static void prikaziAutore(JPanel contentPane){
		JOptionPane.showMessageDialog(contentPane,
				"Studenti Fakulteta Organizacionih Nauka  \n\n Dušan Radovanović \n\n Aleksandar Randjelović \n\n Filip Nedović ", "Autori",
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(igrice.getClass().getResource("/gui/slike/autori.jpg")));
	}
	/**
	 * metoda koja cuva najbolji rezultat
	 * @param putanja adresa fajla koji se ucitava
	 * @param skor skor koji se upisuje
	 */
	public static void sacuvajRez(String putanja,int skor){
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(putanja)));
			
			out.writeInt(skor);
			
			out.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * metoda koja ucitava najbolji rezultat
	 * @param putanja adresa fajla koji se ucitava
	 * @return vrednost HighScore-a kao int
	 */
	public static int ucitajRez(String putanja){
		try{
			
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(putanja)));
			int highScore;		
			highScore=in.readInt();
			
			in.close();
			return highScore;
		}catch(Exception e){
			return 0;
		}
	}
	
}
