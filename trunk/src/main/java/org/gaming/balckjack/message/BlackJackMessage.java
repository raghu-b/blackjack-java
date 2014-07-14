package org.gaming.balckjack.message;

import org.gaming.blackjack.scan.ScanInput;

public class BlackJackMessage {
	
	
	public static void welcomeMessage(int chips) {

		System.out.println("\n**********  Welcome to the BlackJack  *************");
		System.out.println("\n**********     Please have a seat     *************");
		System.out.println("\nYou have  "+ chips+ " chips.  Max bet 100 per hand And Minimum Bet is 1 chip  per hand");

	}
	
	public static void quitMessage(){
		
		System.out.println("\nThank you for playing the Game ! , hope you enjoyed !!");
		System.out.println("\nPlease come back  !!!");
	}
	
   public static void  newRoundMessage(int chips){
		
	    
		System.out.println("\n********* Starting a New round  ************");
		System.out.println("\nYou have  "+ chips+ " chips.  Max bet 100 per hand And Minimum Bet is 1 chip  per hand");
	}

}
