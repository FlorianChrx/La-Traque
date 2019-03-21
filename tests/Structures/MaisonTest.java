package Structures;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.Position;
import util.Surface;

public class MaisonTest {

	private Maison maisonTemoin;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		maisonTemoin = new Maison(null, 0, 0, 20, 20);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testConstructors() {
		Village village = new Village();
		Position position = new Position(0, 0);
		Surface surface = new Surface(position, 20, 20);
		ArrayList<Maison> liste = new ArrayList<Maison>();
		liste.add(new Maison(village, Statut.ALIVE, surface));
		liste.add(new Maison(village, position, 20, 20));
		liste.add(new Maison(village, 0, 0, 20, 20));
		liste.add(new Maison(village, Statut.ALIVE, position, 20, 20));
		for (Maison maison : liste) {
			maison.equals(maisonTemoin);
		}
	}
}
