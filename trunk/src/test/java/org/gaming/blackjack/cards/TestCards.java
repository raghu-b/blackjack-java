package org.gaming.blackjack.cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCards {

	@Test
	public void test() {
		
		
		Deck theDeck = new Deck(1, true);
		assertTrue(theDeck.getNumCards()==52);
		//theDeck.printDeck();
		
		
	}
	
	

}
