package org.gaming.blackjack.player;

import static org.junit.Assert.*;

import org.gaming.blackjack.cards.Deck;
import org.junit.Test;

public class PlayerTest {
	
	
	Player player = new Player("Player");
	Deck theDeck = new Deck(2, true);


	@Test
	public void playerAddCards() {
		
		player.addCard(theDeck.dealNextCard());
		// theDeck.printDeck();
		assertTrue(theDeck.getNumCards()==103);
		
	}

}
