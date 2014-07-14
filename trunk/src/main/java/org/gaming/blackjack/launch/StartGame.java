package org.gaming.blackjack.launch;

import org.gaming.balckjack.message.BlackJackMessage;
import org.gaming.blackjack.cards.Deck;
import org.gaming.blackjack.player.Player;
import org.gaming.blackjack.scan.ScanInput;

public class StartGame {

	 static Deck theDeck;
	 static int chips = 100; // Initialing the chips value as per requirement 
	 static int bet = 0;    //  its the variable to holds the bet value

	 /**
	 * blackjack flag is to mark the blackjack trigger,to determine
	 * whether if dealer or player have the blackjack
	 */
	  static boolean blackjack = false;
	 


	
	
	public static void main(String args[]) throws InterruptedException {

		String ans = "Yes";   // Initialing to Yes as Player wants to play the Game
		BlackJackMessage.welcomeMessage(chips);  // calling welcome message 
		bet=ScanInput.scanBetInput(chips);  // Scanning Input for a bet
		
		/** while loop 
		 *  Game will continue till chips are available to user
		 */
		while (chips > 0) {

			/**
			 * In this while loop System will ask if user wants
			 * to continue or not if he has avialable chips
			 */
			while (ans.equalsIgnoreCase("Yes") && chips > 0) {
				
				start(bet);  // to start bet on table
				System.out.println();
				if (chips > 0) {
					ans = ScanInput.scanRoundInput();
					BlackJackMessage.newRoundMessage(chips);
					bet=ScanInput.scanBetInput(chips);
				} else {
					System.out.println("You do not have any chips to play, Game Over !!! ");
					QuitGame.exit();
				}
			}

		}
	}
	
	
	
	public static void start(int bet)  {

		/** Initializing  the set of cards with 2 decks, 
		     as need for game setup we can change this 
		*/
		if (theDeck == null || theDeck.getNumCards() < 10) {
			theDeck = new Deck(2, true);
		}

	   // creating the  player and dealer Objects
	    Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		 
		dealtIntialCards(player ,dealer);		
		singlePlayerPlay(player);
		dealerPlay(player,dealer);
		printFinalHands(player ,dealer);
        determineWhoWon(player, dealer);
		
	

	}
	
	
    /**
     * 
     * Intail set up of dealting the cards to player and dealer
     * @param player
     * @param dealer
     */
	public static void dealtIntialCards(Player player,Player dealer){
		
		/** deal two cards to player and for dealer him self
		 *  
		 */
		player.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());		
		player.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());

		// print initial hands for dealer and player
		
		System.out.println("Cards are dealt \n");
		player.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
	}

	/**
	 * Start playing with additional cards, 
	 * if player wants to continue after seeing his first 2 cards
	 * @param player
	 */
	public static void singlePlayerPlay(Player player){
		
		// flags for when each player  finished hitting
				boolean isPlayerDone = false;
				
				/**
				 *  ans variable  will store the value for player feedback whether he wants to hit or stay
				 */
				String ans = "";    
				int playerturns = 0; // to determine the whether player got the count of 21 at the first dealt or not

				/**
				 *  while loop will continue till the player turn is completed 
				 *  and will take the input from  player
				 */
				while (!isPlayerDone) {
					if (player.getHandSum() < 21) {
						
						++playerturns;				
						ans = ScanInput.scanHitStayInput(); // to scan the input

						// if the player answer for H -- (Hit)
						if (ans.compareToIgnoreCase("H") == 0) {

							// add next card and store 

							isPlayerDone = !player.addCard(theDeck.dealNextCard());
							player.printHand(true);
						} else {
							isPlayerDone = true;
						}
					} else if (player.getHandSum() == 21 && playerturns == 0) {
						blackjack = true;
						isPlayerDone = true;
					} else {
						isPlayerDone = true;
					}
				}
		
		
	}

	/**
	 * Dealer will start playing once the player decided to stay
	 * @param player
	 * @param dealer
	 */
    public static void dealerPlay(Player player,Player dealer) {
	   
	   
	   boolean isDealerDone = false;
		/**
		 *  while loop will continue till the player turn is completed 
		 *  and will take the input from  player
		 */
		while (!isDealerDone) {
			
			if (dealer.getHandSum() != 21 && player.getHandSum() <= 21) {
				if (dealer.getHandSum() < 17) {

					System.out.println(" \nThe Dealer hits\n");
					QuitGame.sleep();
					isDealerDone = !dealer.addCard(theDeck.dealNextCard());
					// System.out.println(dealerDone);
					dealer.printHand(true);
				} else {
					System.out.println();
					System.out.println("The Dealer stays\n");
					isDealerDone = true;
				}
			} else {

				isDealerDone = true;

			}
		}

	   
   }
    
    /**
     * This function is to print final hands of player and dealer
     * @param player
     * @param dealer
     */
    public static void  printFinalHands(Player player ,Player dealer){

	   
	       // print final hands
			System.out.println();
			QuitGame.sleep();
			System.out.println("****** FINAL HANDS ********");
			player.printHand(true);
			if (player.getHandSum() > 21) {
				System.out.println();
				System.out.println("Player Bust !! ");
			}
			dealer.printHand(true);
	   
   }
    
    /**
     * Calucalting the scores and determining who won
     * @param player
     * @param dealer
     */
	public static void determineWhoWon(Player player, Player dealer){
		
		
		/**
		 * determine the winning 
		 * 
		 */

		int mySum = player.getHandSum();
		int dealerSum = dealer.getHandSum();

		if (mySum > dealerSum && mySum <= 21 || dealerSum > 21) {

			System.out.println();

			if (blackjack) {
				System.out.println("You Won ! , Its a BlackJack  !!!");
				chips = chips + bet + Math.round(bet / 2);
				blackjack=false;
			} else {
				System.out.println("You won !");
				chips = chips + bet;
			}
			
			System.out.println("\n You have  " + chips + " chips. \n ");
			
		} else if (mySum == dealerSum && (mySum <= 21 || dealerSum <= 21)) {

			System.out.println(" \n Its a draw ! ,This round is a push");
			System.out.println(" \n You have  " + chips + " chips. ");

		} else if (dealerSum > mySum && dealerSum <= 21 || mySum > 21) {
			System.out.println();
			System.out.println("Dealer won!");
			chips = chips - bet;
			System.out.println();
			if (chips > 0) {
				System.out.println("You have  " + chips + " chips. ");
				System.out.println();
			}

		} else if (dealerSum > 21 && mySum > 21) {

			System.out.println("This round is a push");

		}
	}
	

}
