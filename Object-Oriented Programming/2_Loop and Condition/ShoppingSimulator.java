
/*
 * Author - Seungwoo Kim
 * Date - Feb-27-2017
 * Purpose - Shopping program (Question3)
 */

import java.util.Scanner;
//import Scanner to use Scanner function.

public class ShoppingSimulator
{

	public static void main(String[] args) 
	{
		System.out.println("----------------------------\nWelcomd to Kim's Program\n----------------------------\n\n"); 
			// welcome message
		 
		Scanner sc = new Scanner(System.in);
		// define scanner for user to prompt user to input
		System.out.print("Enter the initial amount : ");
		double money = sc.nextDouble();
		// print out a message for user to enter initial amount that he/she wants. Variable money is initial amount.
		
		int n = 0;
		double asset = money;
		double sumprice = 0 ;
		// Variable int n is using for number of purchases
		// variable double asset will be using the initial amount and the subtracts money from purchases and last value of money
		// Variable sumprice is total prices of all purchases.  
		
		if (money <= 100)
			System.out.println("Please save money and come back again !!\n");		
		// He's only invited if he has "more than 100" so if he has equal to 100 or less, he can't purchases anything the point followed by (a) in Question 3 
			
		
		while (n<=9 && money > 100) 
		{ 
			//Since Toto should not buy "more than 10", it means that he can buy maximum 10(by definition), since n = 0, the number of 0 to 9 is 10
			// the point followed by (c) in Question 3 
			
			if (n==0) System.out.print("Do you want to make a purchase (Y/N) ?");
			else System.out.print("Do you want to continue (Y/N) ?");
				
			String answer = sc.next();			
			// Print out a message to check a desire of a purchase
			// for the first time and other times, it has different message like in examples 
			// Variable answer is user to enter that if Toto wants to purchase or not. Simply user can type Y and N 
			
			if (answer.equalsIgnoreCase("n")) //ignore the case in case
			{
				System.out.println("lack of desire of Mr. Toto\n");	break;
			}	
			// he lost his desire and using break to end while statement and directly go to summary 	
			
			else if (answer.equalsIgnoreCase("y")) //ignore the case in case
			{
				System.out.print("Please enter the price of item : ");
				double price = sc.nextDouble();
				// Print out a message for user to enter the prices.
				// Variable price is the value that user enters.
				
				asset -= price;
				sumprice += price;
				// For asset, it will subtract from all purchases made
				// And for sumprice, it will sum up all purchases made
				// at last these values will using for the summary 
				
				if (asset < 10) 
					// if he has less than 10 dollars, he's not able to go home which means he can't buy at this price 
					// Return to desire loop to ask if he wants to buy more or not, and if yes, he must have $10 in his pocket  
					// the point followed by (b) in question 3
				
				{
					System.out.println("Insufficient assets!!\n"); asset += price; sumprice -= price;
				}
					// Print out the message given in (d) in question 3  
					// also asset and sumprice should not be subtracted and added because of insufficient fund that he can't buy more.
				
				else 
				{
					System.out.println("A purchase is accepted!\n"); n++;
				}
			}
					// If there is no problem, purchase is accepted and the number of purchases will increase.
			
			else
			{
				System.out.println("you entered wrong character\n");
			} // in case user put a wrong alphabet 
		}
		
		if (n == 10) //the number of 0 to 9 is 10, and because when the purchase is accepted, n++ is applied so n==10 means exceeding more than 10.
		 System.out.println("Maximum number of purchases is reached!!\n"); 
		// the message given in (d) in question 3
		
		// Start of summary
		System.out.println("-----------------------------------------");
		System.out.println("Here is a summary of Mr.toto's purchases");
		System.out.println("-----------------------------------------");
		System.out.println("Number of items    Assets    Spending");
		System.out.println("       " + n + "            " + asset + "       " + sumprice + "\n\n"); 
		
		//print out the summary and variables used  
		
		System.out.println("Thank you for your visit and goodbye!" );
		//closing message given in example
		
		sc.close(); // Scanner closed
		
		System.out.println("\n\nThank you for using Kim's program - bye !!!"); //Closing message			
			
	}

}