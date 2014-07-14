package org.gaming.blackjack.launch;

import org.gaming.balckjack.message.BlackJackMessage;
import org.gaming.blackjack.scan.ScanInput;

public class QuitGame {
	
	public static void exit() {
		
		BlackJackMessage.quitMessage();
		ScanInput.sc.close();
		System.exit(0);
		
	}
	
	public static void sleep(){
		
		try{
		Thread.sleep(1000);
		}catch(InterruptedException e){
			
			System.out.println("There is a problem ");
		}
	}

}
