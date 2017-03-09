package brojevi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
* Predstavlja jedan kruzic sa brojem
* 
* @author Dusan Radovanovic
*
*/

public class Broj {
	/**
	 *  poluprecnik kruga
	 */
	public static final int POLUPRECNIK=20;
	/**
	 * vrednost kruga
	 */
	private int vrednost;
	/**
	 * mesto gde se krug nalazi
	 */
	private Point lokacija;
	
	
	/**
	 * Metoda vraca vrednost koja se nalazi u krugu
	 * @return vrednost u krugu kao int
	 */
	public int getVrednost() {
		return vrednost;
	}
	/**
	 * Metoda postavlja vrednost koja se nalazi u krugu
	 * @param vrednost vrednost u krugu
	 */
	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	/**
	 * Metoda vraca mesto gde se krug nalazi
	 * @return mesto kao Point
	 */
	public Point getLokacija() {
		return lokacija;
	}
	/**
	 * Metoda postavlja mesto gde ce krug da se crta
	 * @param lokacija lokacija kruga
	 */
	public void setLokacija(Point lokacija) {
		this.lokacija = lokacija;
	}
	/**
	 * Metoda crta krug sa centrom u lokaciji i poluprecnikom datim kao konstanta i ispisuje vrednost u krug
	 * @param g graficka komponenta
	 */
	public void crtaj(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(lokacija.x-POLUPRECNIK, lokacija.y-POLUPRECNIK, 2*POLUPRECNIK, 2*POLUPRECNIK);
		Font f=g.getFont();
		f=f.deriveFont((float) (35 / 2));
		f=f.deriveFont(Font.BOLD);
		g.setFont(f);
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(vrednost), lokacija.x-5, lokacija.y+3);
	}
	/**
	 * Metoda proverava da li se tacka(x,y) nalazi u krugu
	 * @param x x-koordinata
	 * @param y y-koordinata
	 * @return da li se tacka (x,y) nalazi u krugu kao boolean
	 */
	public boolean proveri(int x,int y){
		if(lokacija.x-Broj.POLUPRECNIK<=x && lokacija.x+Broj.POLUPRECNIK>=x &&
				lokacija.y-Broj.POLUPRECNIK<=y && lokacija.y+Broj.POLUPRECNIK>=y) return true;
		return false;
	}
	/**
	 * Metoda crta krug sa centrom u lokaciji i poluprecnikom datim kao konstanta 
	 * @param g graficka komponenta
	 */
	public void crtajPrazno(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(lokacija.x-POLUPRECNIK, lokacija.y-POLUPRECNIK, 2*POLUPRECNIK, 2*POLUPRECNIK);
	}
}
