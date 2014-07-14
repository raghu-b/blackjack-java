package org.gaming.blackjack.cards;

import java.util.Random;

/**
 * An implementation of a deck of cards.
 * 
 * This class is design for creating the Deck of cards upon user requests.
 * 
 * each deck creates 52 cards
 * 
 * This class has a method called shuffle which provides the random shuffle of
 * the cards.
 * 
 * @author RaghuBoddeti
 * @since 07/08/2014
 *
 */
public class Deck {

	/**
	 * The array of cards in the deck.
	 */
	private Card[] deckCards;

	/**
	 * The number of cards in the deck.
	 */
	private int numCards;

	public int getNumCards() {
		return numCards;
	}

	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}

	/**
	 * we are using constructor to create a default of one deck (i.e., 52 cards)
	 * and no shuffling.
	 */
	public Deck() {

		// call other constructor, defining one deck without shuffling
		this(1, false);
	}

	/**
	 * Constructor that defines the number of decks (i.e., how many sets of 52
	 * cards are in the deck) and whether it should be shuffled.
	 * 
	 * @param numDecks
	 *            the number of individual decks in this deck
	 * @param shuffle
	 *            whether to shuffle the cards
	 */
	public Deck(int numDecks, boolean shuffle) {

		this.numCards = numDecks * 52;
		this.deckCards = new Card[this.numCards];

		// card index
		int c = 0;

		// for each deck
		for (int deck = 0; deck < numDecks; deck++) {

			// for each suit
			for (int suit = 0; suit < 4; suit++) {

				// for each number
				for (int n = 1; n <= 13; n++) {

					// add a new card to the deck
					this.deckCards[c] = new Card(Suit.values()[suit], n);

					// increment card index
					c++;

				}
			}
		}

		// shuffle, if necessary
		if (shuffle) {
			this.shuffle();
		}

	}

	/**
	 * Shuffle the deck by randomly swapping cards.
	 * 
	 * This function shuffles the cards in two ways
	 * 
	 * one is using Random and the otherwise is use Math.Random()
	 * Just to make sure to shuffle them well. otherwise one time is ok.
	 * 
	 */
	public void shuffle() {

		try {
			// init random number generator
			Random rng = new Random();			
			int j;
			for (int i = 0; i < this.numCards; i++) {

				// get card to swap card i with
				j = rng.nextInt(this.numCards);

				// do swap
				swap(i, j);
			}

			int k = 0;
			int l = 0;
			for (int i = 0; i < this.numCards; i++) {

				// get card to swap card i with
				k = (int) (this.numCards - 2 * Math.random());
				l = (int) (this.numCards - 2 * Math.random());

				// do swap
				swap(k, l);

			}
		} catch (ArrayIndexOutOfBoundsException e) {

			/* To catch the exception for Array of  elements accessing. It won't happen but
			 * its just a precaution			    
			*/
			System.out.println("There is a problem in software");

		}
	}

	/*
	 * This swap function will swap cards from  k'th position  to l'th position  and vice versa 
	 * 
	 */
	public void swap(int k, int l) {
		
		// to hold the card temporarily while swapping
		Card temp;
		temp = this.deckCards[k];
		this.deckCards[k] = this.deckCards[l];
		this.deckCards[l] = temp;
	}

	/**
	 * Fetch the next card from the top of the deck.
	 * 
	 * @return the dealt card
	 */
	public Card dealNextCard() {

		// fetch top card
		Card top = this.deckCards[0];

		// shift all other cards to the left by one
		for (int c = 1; c < this.numCards; c++) {
			this.deckCards[c - 1] = this.deckCards[c];
		}
		this.deckCards[this.numCards - 1] = null;

		// decrement number of cards
		this.numCards--;

		// return top card
		return top;

	}


	/**
	 *  
	 * @param Print all cards in Deck	 
	 */
	public void printDeck() {

		// print the top cards
		for (int c = 0; c < this.numCards; c++) {
			System.out.printf("% 3d/%d) %s\n", c + 1, this.numCards,
					this.deckCards[c].toString());
		}

		System.out.printf("         [%d consumed]\n\n", this.numCards
				- this.deckCards.length);

	}

}
