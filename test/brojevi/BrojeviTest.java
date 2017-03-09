package brojevi;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import brojevi.Broj;
import brojevi.Brojevi;

public class BrojeviTest {
	Brojevi b;

	@Before
	public void setUp() throws Exception {
		b = new Brojevi(10);
	}

	@After
	public void tearDown() throws Exception {
		b = null;
	}

	@Test
	public void sortirajTest() {
		boolean sortiran = true;
		for (int i = 0; i < b.getBrojevi().length - 1; i++) {
			Broj br = b.getBrojevi()[i];
			for (int j = i + 1; j < b.getBrojevi().length; j++) {
				if (br.getVrednost() >= b.getBrojevi()[j].getVrednost())
					sortiran = false;
			}
		}
		assertEquals(true, sortiran);
	}

	@Test
	public void podesiVrednostiTest() {
		boolean dobreVrednosti = true;
		for (int i = 0; i < b.getBrojevi().length - 1; i++) {
			Broj br = b.getBrojevi()[i];
			for (int j = i + 1; j < b.getBrojevi().length; j++) {
				if (br.getVrednost() == b.getBrojevi()[j].getVrednost()
						&& (br.getVrednost() > 30 || br.getVrednost() < 0))
					dobreVrednosti = false;
			}
		}
		assertEquals(true, dobreVrednosti);
	}

	@Test
	public void podesiLokacijeTest(){
		boolean dobreLokacije=true;
		for (int i = 0; i < b.getBrojevi().length-1; i++) {
			int brX=b.getBrojevi()[i].getLokacija().x;
			int brY=b.getBrojevi()[i].getLokacija().y;
			for (int j = i+1; j < b.getBrojevi().length; j++) {
				int br2X=b.getBrojevi()[j].getLokacija().x;
				int br2Y=b.getBrojevi()[j].getLokacija().y;
				if(brX>br2X-Broj.POLUPRECNIK && brX<br2X+Broj.POLUPRECNIK
						&& brY>br2Y-Broj.POLUPRECNIK && brY<br2Y+Broj.POLUPRECNIK)
					dobreLokacije=false;
			}
		}
		assertEquals(true,dobreLokacije);
	}
}
