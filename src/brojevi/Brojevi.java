package brojevi;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Predstavlja JPanel gde se iscrtavaju krugovi
 * 
 * @author Dusan Radovanovic
 * 
 */
public class Brojevi extends JPanel {
	/**
	 * niz Brojeva
	 */
	private Broj[] brojevi;
	/**
	 * random koji sluzi za dodeljivanje raznih brojeva
	 */
	private Random random = new Random();
	/**
	 * broj klikova na krugovima
	 */
	private int brojacKliknutih;
	/**
	 * ukazuje na to da li je proslo dovoljno vremena da se pogledaju krugovi
	 */
	private boolean istekloVreme;
	/**
	 * ukazuje na to da li su svi krugovi kliknuti pravim redosledom
	 */
	private boolean predjen;
	/**
	 * ukazuje na to da li se desila greska prilikom kliktanja brojeva
	 */
	private boolean greska;

	/**
	 * metoda pravi novi objekat klase Brojevi sa nizom velicine koja je data
	 * preko parametra
	 * 
	 * @param velicina
	 *            velicina niza brojeva
	 */
	public Brojevi(int velicina) {
		brojevi = new Broj[velicina];
		brojacKliknutih = 0;
		for (int i = 0; i < velicina; i++) {
			brojevi[i] = new Broj();
		}
		istekloVreme = false;
		greska=false;
		podesiLokacije();
		podesiVrednosti();
		sortiraj();
		paintComponents(getGraphics());
	}

	/**
	 * Metoda pokazuje da li je predjen nivo
	 * 
	 * @return da li je nivo predjen kao boolean
	 */
	public boolean isPredjen() {
		return predjen;
	}

	/**
	 * Metoda vraca niz Broj-eva
	 * 
	 * @return niz Broj-eva
	 */
	public Broj[] getBrojevi() {
		return brojevi;
	}

	/**
	 * Metoda vraca broj puta koliko su krugovi kliknuti
	 * 
	 * @return broj puta koliko su krugovi kliknuti
	 */
	public int getBrojacKliknutih() {
		return brojacKliknutih;
	}

	/**
	 * Metoda postavlja da li je isteklo vreme za gledanje
	 * 
	 * @param istekloVreme
	 *            da li je isteklo vreme za gledanje
	 */
	public void setIstekloVreme(boolean istekloVreme) {
		this.istekloVreme = istekloVreme;
	}

	/**
	 * Metoda crta krugove
	 * 
	 * @param g
	 *            graficka komponenta
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!greska) {
			for (int i = 0; i < brojevi.length; i++) {
				if (!istekloVreme)
					brojevi[i].crtaj(g);
				else
					brojevi[i].crtajPrazno(g);
			}
		}
	}

	/**
	 * Metoda sortira niz Broj-eva u rastucem redosledu
	 */
	private void sortiraj() {
		int iMin;
		for (int j = 0; j < brojevi.length; j++) {
			iMin = j;
			for (int i = j + 1; i < brojevi.length; i++) {
				if (brojevi[i].getVrednost() < brojevi[iMin].getVrednost()) {
					iMin = i;
				}
			}

			if (iMin != j) {
				Broj a = brojevi[j];
				brojevi[j] = brojevi[iMin];
				brojevi[iMin] = a;
			}

		}
	}

	/**
	 * Metoda zadaje vrednosti svim Broj-evima u krugu
	 */
	private void podesiVrednosti() {
		for (int i = 0; i < brojevi.length; i++) {
			brojevi[i].setVrednost(random.nextInt(30));
			if (postoji(brojevi[i].getVrednost(), i - 1)) {
				i--;
			}
		}
	}

	/**
	 * Metoda proverava da li se zadata vrednost nalazi u nizu
	 * 
	 * @param x
	 *            vrednost koja se proverava
	 * @param j
	 *            mesto od kog se proverava niz od kraja ka pocetku
	 * @return da li se vrednost nalazi u nizu kao boolean
	 */
	private boolean postoji(int x, int j) {
		if (x == 0)
			return true;
		for (int i = j; i >= 0; i--) {
			if (brojevi[i].getVrednost() == x)
				return true;
		}
		return false;
	}

	/**
	 * Metoda zadaje lokacije svim Broj-evima u krugu
	 */
	private void podesiLokacije() {
		for (int i = 0; i < brojevi.length; i++) {
			brojevi[i].setLokacija(new Point(Broj.POLUPRECNIK
					+ random.nextInt(610), Broj.POLUPRECNIK
					+ random.nextInt(360)));
			if (postoji(brojevi[i].getLokacija(), i - 1)) {
				i--;
			}
		}
	}

	/**
	 * Metoda proverava da li se dva kruga poklapaju
	 * 
	 * @param lokacija
	 *            lokacija koja se proverava
	 * @param j
	 *            mesto od kog se proverava niz od kraja ka pocetku
	 * @return da li se lokacija nalazi u nizu kao boolean
	 */
	private boolean postoji(Point lokacija, int j) {
		int x = lokacija.x;
		int y = lokacija.y;
		for (int i = j; i >= 0; i--) {
			int bX = brojevi[i].getLokacija().x;
			int bY = brojevi[i].getLokacija().y;
			if ((bX - x) * (bX - x) + (bY - y) * (bY - y) < (4 * Broj.POLUPRECNIK * Broj.POLUPRECNIK))
				return true;
		}
		return false;
	}

	/**
	 * Metoda proverava da li se kliknulo na neki krug iz niza
	 * 
	 * @param x
	 *            x-koodinata klika
	 * @param y
	 *            y-koordinata klika
	 * @param contentPane
	 *            panel na osnovu koga se izbacuju dodatni prozori
	 */
	public void proveri(int x, int y, JPanel contentPane) {
		for (int i = 0; i < brojevi.length; i++) {
			if (brojevi[i].proveri(x, y))
				if (brojevi[brojacKliknutih].getVrednost() == brojevi[i]
						.getVrednost()) {
					brojevi[i].crtaj(getGraphics());
					brojacKliknutih++;
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"Greška! Pokušajte ponovo!", "Brojevi",
							JOptionPane.ERROR_MESSAGE);
					this.setEnabled(false);
					greska=true;
					repaint();
				}
		}
		if (brojacKliknutih == brojevi.length) {
			predjen = true;
			JOptionPane.showMessageDialog(
					contentPane,
					"Bravo! Prešli ste nivo!",
					"Brojevi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(this.getClass().getResource(
							"/brojevi/slike/nikolamilikic.png")));
		}
	}

}
