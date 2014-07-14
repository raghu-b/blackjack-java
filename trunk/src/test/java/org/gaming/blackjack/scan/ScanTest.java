package org.gaming.blackjack.scan;

import static org.junit.Assert.*;

import org.gaming.balckjack.message.BlackJackMessage;
import org.junit.Test;

public class ScanTest {

	@Test
	public void testScanInputBet() {
		
		int chips=100;		
		BlackJackMessage.welcomeMessage(chips);
		//int bet=ScanInput.scanBetInput(chips);
		// System.out.println(bet);
		//assertTrue(bet>0);
		// assertTrue(bet<=chips);

	}

}
