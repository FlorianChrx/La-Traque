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

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMaisonVillageStatutSurface() {
		Village village = new Village();
		Statut statut = Statut.ALIVE;
		Surface surface = new Surface(5, 5, 20, 20);
		Maison maison = new Maison(village, statut, surface);
		assertEquals(village, maison.getVillage());
		assertEquals(statut, maison.getStatut());
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testMaisonVillageStatutPositionIntInt() {
		Village village = new Village();
		Statut statut = Statut.ALIVE;
		Surface surface = new Surface(0, 0, 20, 20);
		Maison maison = new Maison(village, statut, new Position(0, 0), 20, 20);
		assertEquals(village, maison.getVillage());
		assertEquals(statut, maison.getStatut());
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testMaisonVillagePositionIntInt() {
		Village village = new Village();
		Statut statut = Statut.ALIVE;
		Surface surface = new Surface(7, 7, 20, 20);
		Maison maison = new Maison(village, new Position(7, 7), 20, 20);
		assertEquals(village, maison.getVillage());
		assertEquals(statut, maison.getStatut());
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testMaisonVillageIntIntIntInt() {
		Village village = new Village();
		Statut statut = Statut.ALIVE;
		Surface surface = new Surface(5, 5, 20, 20);
		Maison maison = new Maison(village, 5, 5, 20, 20);
		assertEquals(village, maison.getVillage());
		assertEquals(statut, maison.getStatut());
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testGetPosition() {
		Maison maison = new Maison(new Village(), 5, 5, 20, 20);
		assertEquals(new Position(5,5), maison.getPosition());
	}

	@Test
	void testGetVoisins() {
	}

	@Test
	void testGetSurface() {
		Maison maison = new Maison(new Village(), 5, 5, 20, 20);
		assertEquals(new Surface(5,5,20,20), maison.getSurface());
	}

	@Test
	void testSetPositionPosition() {
		Position position = new Position(5,5);
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setPosition(position);
		assertEquals(position, maison.getPosition());
	}

	@Test
	void testSetPositionIntInt() {
		Position position = new Position(5,5);
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setPosition(5,5);
		assertEquals(position, maison.getPosition());
	}

	@Test
	void testSetSurfaceSurface() {
		Surface surface = new Surface(5,5, 15, 15);
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setSurface(surface);
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testSetSurfacePositionIntInt() {
		Surface surface = new Surface(5,5, 15, 15);
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setSurface(new Position(5,5),15,15);
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testSetSurfaceIntIntIntInt() {
		Surface surface = new Surface(5,5, 15, 15);
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setSurface(5,5,15,15);
		assertEquals(surface, maison.getSurface());
	}

	@Test
	void testNextDay() {
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
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
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setDead();
		assertEquals(Statut.DEAD, maison.getStatut());
	}

	@Test
	void testSetAlive() {
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setDead();
		maison.setAlive();
		assertEquals(Statut.ALIVE, maison.getStatut());
	}

	@Test
	void testSetMurder() {
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setMurder();
		assertEquals(Statut.MURDER, maison.getStatut());
	}

	@Test
	void testSetInvestigate() {
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setInvestigate();
		assertEquals(Statut.INVESTIGATE, maison.getStatut());
	}

	@Test
	void testSetStatut() {
		Maison maison = new Maison(new Village(), 10, 10, 20, 20);
		maison.setStatut(Statut.INVESTIGATE);
		assertEquals(Statut.INVESTIGATE, maison.getStatut());
	}

	@Test
	void testEqualsObject() {
		Village village = new Village();
		Maison maison = new Maison(village, 10, 10, 20, 20);
		Maison maison2 = new Maison(village, 10, 10, 20, 20);
		Maison maison3 = new Maison(village, 5, 5, 20, 20);
		assertTrue(maison.equals(maison2));
		assertFalse(maison2.equals(maison3));
	}

}
