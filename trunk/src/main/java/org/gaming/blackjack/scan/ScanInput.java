package org.gaming.blackjack.scan;

import java.util.Scanner;

import org.gaming.blackjack.launch.QuitGame;

public class ScanInput {
	
	
	public static Scanner sc = new Scanner(System.in);
	/**
	 * to scan the input of user for whether he wants to go for another round or not .. , 
	 * using recursive function to ask user till he/she provides the valid input
	 * @return
	 */
	public static String scanRoundInput() {

		System.out.print("Wanna bet for another round .. ?, ");
		String ansYN="";
		do
		{
			System.out.print("Please type Yes / No : ");
			ansYN = sc.next();
			
		}while(!(ansYN.equalsIgnoreCase("yes")|| ansYN.equalsIgnoreCase("no")));

		if(ansYN.equalsIgnoreCase("no")){			
			QuitGame.exit();			
		}
		return ansYN;
	}

	
	/**
	 * to scan the input of Hit or Stay .. , 
	 * using recursive function to ask user till he/she provides the valid input
	 * @return
	 */
	public static String scanHitStayInput() {
				
		String ans="";		
		do
		{
			   System.out.print("\nPlayer Hit or Stay? (Enter H or S): ");
		       ans = sc.next();
		}
		while(!(ans.equalsIgnoreCase("H") || ans.equalsIgnoreCase("S")));
        return ans;
	}
	
	
	
	/**
	 * to scan the input of valid number .. , 
	 * using recursive function to ask user till user provides the valid input
	 * @return
	 */
	public static int scanBetInput(int chips) {
		System.out.print("\nHow many chips would you like to bet? ( 0 to leave the table)  :  ");		

		int bet=0;
		
			     do{
                	do {
                				
				      while (!sc.hasNextInt()) {
				        String input = sc.next();
				        System.out.print("Please enter a positive number :");
				          }
				        bet = sc.nextInt();
				         if(bet==0){
	                		   QuitGame.exit();
	                	   }
				         if(bet<chips){
				           System.out.print("Please enter a positive number :");
				            }
				       } while (bet <0);
				
                	   if(bet > chips){	
					   System.out.print("You have only  " + chips + " chips. Please enter a valid number less than or qual " + chips+" :" );
		               }
		               
                        
	            	} while ((bet > chips || bet <= 0));

		
		return bet;

	}

}
