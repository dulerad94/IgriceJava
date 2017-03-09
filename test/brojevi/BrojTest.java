package brojevi;
import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import brojevi.Broj;


public class BrojTest {
	Broj b;
	@Before
	public void setUp() throws Exception {
		b=new Broj();
	}

	@After
	public void tearDown() throws Exception {
		b=null;
	}
	@Test
	public void proveriTestDobro(){
		b.setLokacija(new Point(100,100));
		assertEquals(true,b.proveri(120, 97) );
	}
	@Test
	public void proveriTestLose(){
		b.setLokacija(new Point(100,100));
		assertEquals(false,b.proveri(200, 100) );
	}

}
