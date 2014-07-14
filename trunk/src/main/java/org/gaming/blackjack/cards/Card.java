package org.gaming.blackjack.cards;


/**
 * An implementation of a card.java.
 * 
 * Card java file is designed for handling  the Card functionalities in a Deck.
 * Card is associated with a Number followed by what type of suite it belongs to. 
 * 
 * Card can have following numbers and associated suites
 * 
 *  2,3,4,5,6,7,8,9,10,King(10),Jack(10),Queen(10),Ace(1/11) and having the suites of CLUBS, SPADES, HEARTS, DIAMONDS
 *  
 *   
 * 
 * @author RaghuBoddeti
 * @since 07/08/2014
 * @version 1.0
 */
public class Card {
	
	/**
	 * All suits for this card.
	 */
	private Suit cardSuit;
	
	/**
	 * The number of this card, where Ace : 1/11, and Jack-King : 11-13
	 */
	private int cardNumber;
	
	
	/**
	 * Card constructor.
	 * 
	 * @param aSuit		the suit of the card
	 * @param aNumber	the number of the card, where Jack-King : 11-13 and 
	 * 					Ace : 1
	 */
	public Card(Suit suit, int number){
		
		this.cardSuit = suit;
		this.cardNumber = number;
	}
	
	/**
	 * Return the number of the card.
	 * 
	 * @return the number
	 */
	public int getNumber(){
		return this.cardNumber;
	}
	
	/**
	 * Override the toString() method to give the "Number of Suit" string for this 
	 * card. 
	 * 
	 * @return  describing the card's number and suit
	 */
	public String toString(){
		
		String numStr = "Invalid";
		
		switch(this.cardNumber){
		
			case 2:
				numStr = "2";
				break;
			case 3: 
				numStr = "3";
				break;
			case 4:
				numStr = "4";
				break;
			case 5:
				numStr = "5";
				break;
			case 6:
				numStr = "6";
				break;
			case 7:
				numStr = "7";
				break;
			case 8:
				numStr = "8";
				break;
			case 9:
				numStr = "9";
				break;
			case 10:
				numStr = "10";
				break;
			case 11:
				numStr = "Jack";
				break;
			case 12:
				numStr = "Queen";
				break;
			case 13:
				numStr = "King";
				break;
			case 1:
				numStr = "Ace";
				break;
			}
		
		return numStr + " of " + cardSuit.toString();
	}
}
