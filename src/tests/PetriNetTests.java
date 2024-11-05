package tests;

import org.junit.jupiter.api.*;
import bad4debug.*;

public class PetriNetTests {
	
	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll executed");
	}
	
	@Test
	@Order(0)
	void testAdders() {
		PetriNet pn = new PetriNet();
		pn.addPlace(5);
		pn.addPlace("P0", 7);
		pn.addTokens(pn.getPlaces().firstElement(),3);
		pn.removeTokens(pn.getPlaces().lastElement(), 2);
		pn.addTransition();
		pn.addTransition("T0");
		pn.addPlace2TransitionArc(pn.getPlaces().getFirst(), pn.getTransitions().getFirst(), 2);
		pn.addTransition2PlaceArc(pn.getTransitions().getFirst(), pn.getPlaces().getLast(), 3);
		Assertions.assertEquals(pn.getPlaces().getFirst().getTokens(), 8);
		Assertions.assertEquals(pn.getPlaces().getLast().getTokens(), 5);
		Assertions.assertEquals(pn.getPlaces().getLast().getName(), "P0");
		Assertions.assertEquals(pn.getTransitions().getLast().getName(), "T0");
		Assertions.assertEquals(pn.tokens(pn.getPlaces().firstElement()), 8);
	}
	
	@Test
	@Order(1)
	void testToString() {
		PetriNet pn = new PetriNet();
		pn.addPlace(5);
		pn.addPlace("P0", 7);
		pn.addTokens(pn.getPlaces().firstElement(),3);
		pn.addTransition();
		pn.addTransition("T0");
		pn.addPlace2TransitionArc(pn.getPlaces().getFirst(), pn.getTransitions().getFirst(), 2);
		pn.addTransition2PlaceArc(pn.getTransitions().getFirst(), pn.getPlaces().getLast(), 3);
		Assertions.assertEquals(pn.toString(), "****************************\n"+ " -------------- Places \n"+ "Place: P_21 = 8\n"+ "Place: P0 = 7\n"+ "----------------- Transitions \n"+ "Transition: T_9\n"+ "Transition: T0\n"+ "----------------- Arcs \n"+ "P_21 --2-> T_9\n"+ "T_9 --3-> P0\n"+ "************\n");
	}
	
	@Test
	@Order(2)
	void testTrigger() {
		PetriNet pn = new PetriNet();
		pn.addPlace(5);
		pn.addPlace("P0", 7);
		pn.addTokens(pn.getPlaces().firstElement(),3);
		pn.addTransition();
		pn.addTransition("T0");
		pn.addPlace2TransitionArc(pn.getPlaces().getFirst(), pn.getTransitions().getFirst(), 2);
		pn.addTransition2PlaceArc(pn.getTransitions().getFirst(), pn.getPlaces().getLast(), 3);
		pn.trigger(pn.getTransitions().getFirst());
		Assertions.assertEquals(pn.getPlaces().getFirst().getTokens(), 6);
		Assertions.assertEquals(pn.getPlaces().getLast().getTokens(), 10);	
	}
	
	@AfterAll
	static void tear() {
		System.out.println("@AfterAll executed");
	}
	
}
