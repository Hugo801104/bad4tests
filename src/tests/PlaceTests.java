package tests;

import org.junit.jupiter.api.*;
import bad4debug.*;

public class PlaceTests {
	
	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll executed");
	}
	
	@Test
	@Order(0)
	void testPlace() {
		Place place = new Place();
        Assertions.assertEquals("P_0", place.getName());
        Assertions.assertEquals(0, place.getTokens());
        Assertions.assertTrue(place.getSortants().isEmpty());
        Assertions.assertTrue(place.getEntrants().isEmpty());
	}
	
	@Test
	@Order(1)
	void testPlace1() {
		Place place = new Place(2);
        Assertions.assertEquals("P_8", place.getName());
        Assertions.assertEquals(2, place.getTokens());
        Assertions.assertTrue(place.getSortants().isEmpty());
        Assertions.assertTrue(place.getEntrants().isEmpty());
	}
	
	@Test
	@Order(2)
	void testPlace2() {
		Place place = new Place("P1",12);
        Assertions.assertEquals("P1", place.getName());
        Assertions.assertEquals(12, place.getTokens());
        Assertions.assertTrue(place.getSortants().isEmpty());
        Assertions.assertTrue(place.getEntrants().isEmpty());
        Place place1 = new Place(null,2);
        Assertions.assertEquals("PLACE", place1.getName());
	}
	
	
	@Test
	@Order(3)
	void testAddTokens() {
		Place place = new Place(13);
		place.addTokens(12);
		Assertions.assertEquals(place.getTokens(),25);
	}

	@Test
	@Order(4)
	void testRemTokens() {
		Place place = new Place(13);
		place.removeTokens(12);
		Assertions.assertEquals(place.getTokens(),1);
		place.removeTokens(3);
		Assertions.assertEquals(place.getTokens(), 1);
		// Ne fait rien car pas assez de jetons
		place.removeTokens(-6);
		Assertions.assertEquals(place.getTokens(), 1);
		// Ne fait rien car négatif
	}
	
	@Test
	@Order(5)
	void testToString() {
		Place place = new Place("PLACE1",3);
		Assertions.assertEquals(place.toString(), "Place: PLACE1 = 3\n");
	}
	
	@Test
	@Order(6)
	void testAddArcEntrant() {
		Transition t1 = new Transition();
		Transition t2 = null;
		Place p1 = new Place();
		Arc a1 = new Arc(p1,t1,5);
		p1.addArcEntrant(t1, 8);
		Assertions.assertEquals(a1.getWeight(),5);
		Place p2 = p1;
		p1.addArcEntrant(t2, 3);
		Assertions.assertEquals(p1,p2);
	}
	
	@Test
	@Order(7)
	void testAddArcSortant() {
		Transition t1 = new Transition();
		Transition t2 = null;
		Place p1 = new Place();
		Arc a1 = new Arc(p1,t1,5);
		p1.addArcSortant(t1, 8);
		Assertions.assertEquals(a1.getWeight(),5);
		Place p2 = p1;
		p1.addArcSortant(t2, 3);
		Assertions.assertEquals(p1,p2);
	}
	
	@Test
	@Order(8)
	void testEquals() {
		Place p1 = new Place();
		Place p2 = new Place();
		Place p3 = null;
		Integer i1 = 3;
		Assertions.assertFalse(p1.equals(p2));
		Assertions.assertFalse(p1.equals(p3));
		Assertions.assertFalse(p1.equals(i1));
	}
	
	@AfterAll
	static void tear() {
		System.out.println("@AfterAll executed");
	}
	
}
