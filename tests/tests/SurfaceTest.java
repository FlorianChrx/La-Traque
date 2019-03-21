package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Position;
import util.Surface;

class SurfaceTest {
	Surface s1 = new Surface(new Position(0,0), 10, 10);
	Surface s2 = new Surface(new Position(100,100), 10, 42);
	
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
		s2 = new Surface(new Position(100,100), 10, 42);
	}

	@Test
	void inContactSurfaceTest() {
		assertFalse(s1.inContact(s2));
		assertFalse(s2.inContact(s1));
		s2.setOrigine(new Position(1, 1));
		assertTrue(s1.inContact(s2));
		assertTrue(s2.inContact(s1));
	}
	
	@Test
	void inContactPositionTest() {
		assertTrue(s1.inContact(new Position(0,0)));
		assertTrue(s1.inContact(new Position(5,5)));
		assertTrue(s1.inContact(new Position(10,10)));
		assertFalse(s1.inContact(new Position(100, 100)));
		assertFalse(s1.inContact(new Position(11, 11)));
		assertFalse(s1.inContact(new Position(-1, -1)));
	}
	
	@Test
	void compareToTest() {
		assertTrue(s1.compareTo(s2) < 0);
		assertTrue(s2.compareTo(s1) > 0);
		s2.setHeight(9);
		assertTrue(s1.compareTo(s2) > 0);
		assertTrue(s2.compareTo(s1) < 0);
		s2.setHeight(10);
		assertTrue(s1.compareTo(s2) == 0);
	}

}
