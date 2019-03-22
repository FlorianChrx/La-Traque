package Structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Position;
import util.Surface;

class MaisonTest {
	
	private static Village village;
	private static Statut statut;
	private static Surface surface;
	private static Maison maison;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		village = new Village();
		statut = Statut.ALIVE;
		surface = new Surface(5, 5, 20, 20);
		maison = new Maison(village, statut, surface);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		maison.setSurface(surface);
		maison.setStatut(statut);
		maison.setVillage(village);
		maison.resetDays();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMaisonVillageStatutSurface() {
		Maison maisonT = new Maison(village, statut, surface);
		assertEquals(village, maisonT.getVillage());
		assertEquals(statut, maisonT.getStatut());
		assertEquals(surface, maisonT.getSurface());
	}

	@Test
	void testMaisonVillageStatutPositionIntInt() {
		Maison maisonT = new Maison(village, statut, new Position(5, 5), 20, 20);
		assertEquals(village, maisonT.getVillage());
		assertEquals(statut, maisonT.getStatut());
		assertEquals(surface, maisonT.getSurface());
	}

	@Test
	void testMaisonVillagePositionIntInt() {
		Maison maisonT = new Maison(village, new Position(5, 5), 20, 20);
		assertEquals(village, maisonT.getVillage());
		assertEquals(statut, maisonT.getStatut());
		assertEquals(surface, maisonT.getSurface());
	}

	@Test
	void testMaisonVillageIntIntIntInt() {
		Maison maisonT = new Maison(village, 5, 5, 20, 20);
		assertEquals(village, maisonT.getVillage());
		assertEquals(statut, maisonT.getStatut());
		assertEquals(surface, maisonT.getSurface());
	}

	@Test
	void testGetPosition() {
		assertEquals(new Position(5,5), maison.getPosition());
	}

	@Test
	void testGetSurface() {
		assertEquals(new Surface(5,5,20,20), maison.getSurface());
	}

	@Test
	void testSetPositionPosition() {
		Position position = new Position(5,5);
		maison.setPosition(position);
		assertEquals(position, maison.getPosition());
	}

	@Test
	void testSetPositionIntInt() {
		Position position = new Position(5,5);
		maison.setPosition(5,5);
		assertEquals(position, maison.getPosition());
	}

	@Test
	void testSetSurfaceSurface() {
		Surface surface = new Surface(5,5, 15, 15);
		maison.setSurface(surface);
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testSetSurfacePositionIntInt() {
		Surface surface = new Surface(5,5, 15, 15);
		maison.setSurface(new Position(5,5),15,15);
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testSetSurfaceIntIntIntInt() {
		Surface surface = new Surface(5,5, 15, 15);
		maison.setSurface(5,5,15,15);
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testNextDay() {
		maison.nextDay();
		assertEquals(1, maison.getDays());
		maison.nextDay();
		assertEquals(2, maison.getDays());
		maison.nextDay();
		assertEquals(3, maison.getDays());
		maison.nextDay();
		assertEquals(4, maison.getDays());
		maison.nextDay();
		assertEquals(5, maison.getDays());
	}

	@Test
	void testSetDead() {
		maison.setDead();
		assertEquals(Statut.DEAD, maison.getStatut());
	}

	@Test
	void testSetAlive() {
		maison.setDead();
		maison.setAlive();
		assertEquals(Statut.ALIVE, maison.getStatut());
	}

	@Test
	void testSetMurder() {
		maison.setMurder();
		assertEquals(Statut.MURDER, maison.getStatut());
	}

	@Test
	void testSetInvestigate() {
		maison.setInvestigate();
		assertEquals(Statut.INVESTIGATE, maison.getStatut());
	}

	@Test
	void testSetStatut() {
		maison.setStatut(Statut.INVESTIGATE);
		assertEquals(Statut.INVESTIGATE, maison.getStatut());
	}

	@Test
	void testEqualsObject() {
		Maison maison2 = new Maison(village, 5, 5, 20, 20);
		Maison maison3 = new Maison(village, 10, 10, 20, 20);
		assertTrue(maison.equals(maison2));
		assertFalse(maison.equals(maison3));
	}
	
	@Test
	void testResetDays() {
		maison.nextDay();
		maison.resetDays();
		assertEquals(0, maison.getDays());
	}

}
