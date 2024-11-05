package tests;

import org.junit.jupiter.api.*;
import bad4debug.*;

public class ArcTests {
	
	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll executed");
	}
	
	@Test
	@Order(0)
	void testArc() {
		Place p1 = new Place();
        Transition t1 = new Transition();
        Arc a1 = new Arc(p1,t1,0);
        Arc a2 = new Arc(p1,t1);
        Assertions.assertNotEquals(a1, a2);
        Assertions.assertEquals(a1.getWeight(), 1);
	}
	
	@Test
	@Order(1)
	void testToString() {
		Place p1 = new Place();
        Transition t1 = new Transition();
        Arc a1 = new Arc(p1,t1,0);
        Arc a2 = new Arc(t1,p1,2);
		Assertions.assertEquals(a2.toString(), "T_4 --2-> P_14\n");
		Assertions.assertEquals(a1.toString(), "P_14 --1-> T_4\n");
	}
	
	@Test
	@Order(2)
	void testIsEnable() {
		Place p1 = new Place(3);
		Place p2 = new Place(3);
		Transition t1 = new Transition();
		Arc a1 = new Arc(p1,t1,5);
		Assertions.assertFalse(a1.isEnable());
		Arc a2 = new Arc(p2,t1,2);
		Assertions.assertTrue(a2.isEnable());
	}
	
	@Test
	@Order(3)
	void testFire() {
		Place p1 = new Place(4);
		Place p2 = new Place(3);
        Transition t1 = new Transition();
        Arc a1 = new Arc(p1,t1,1);
        Arc a2 = new Arc(t1,p2,2);
        a1.fire();
        a2.fire();
        Assertions.assertEquals(p1.getTokens(), 3);
        Assertions.assertEquals(p2.getTokens(), 5);
	}
	
	@Test
	@Order(4)
	void testGetters() {
		Place p1 = new Place(4);
		Place p2 = new Place(3);
        Transition t1 = new Transition();
        Arc a1 = new Arc(p1,t1,1);
        Arc a2 = new Arc(t1,p2,2);
        Assertions.assertEquals(p1, a1.getSource());
        Assertions.assertEquals(p2, a2.getTarget());
	}
	
	@AfterAll
	static void tear() {
		System.out.println("@AfterAll executed");
	}
	
}
