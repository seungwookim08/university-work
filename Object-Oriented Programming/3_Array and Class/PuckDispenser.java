
/*
 * Author - Seungwoo Kim
 * Date - Mar-25-2017
 * Purpose - Display NHL Puck Vending Machine Programming 
 * 			 using with Arrays and Loops (Question 1)
 */

import java.util.Scanner;
// import Scanner to use Scanner function.
public class PuckDispenser 
{
	public static void main(String[] args)
	{
		 System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0");
		 System.out.println("= 0 Welcome to Kim's Program");
		 System.out.println("= 0 NHL Miniature Hockey Puck Vending Machine" );
		 System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0\n");
		 // Welcome message
		 
		 Scanner sc = new Scanner(System.in);
		 //Scanner sc declare to input
		 
		 String[] teams = {"St. Louis Blues","Nashville Predators","Detroit Red Wings","Florida Panthers","Montreal Canadiens",
				 "Ottawa Senators", "Tampa Bay Lightning", "Toronto Maple Leafs", "Winnipeg Jets","Washington Capitals" };
		 // declare 10 NHL teams and directly assign into declaration.
		 
		 int[] numberOfPurchase = new int[teams.length]; 
		 // declare an array for how many purchases that will make and store each purchases
		 
		 int sumPurchase = 0; // the total number of purchases for buying 10 teams pucks
		 
		 int priceOfPucks = 2; // price of pucks, it's 2 dollars each
		 
		 System.out.print("What is your first name? ");
		 String firstname = sc.nextLine();
		 // Ask to user to enter input for user's name
		 
		 System.out.println("Welcome " + firstname + "! Let's see how much money you will need to spend to get all of the pucks\n");
		
		 for (int i = 0; i < teams.length; i++ )
			 // int i is for place of array
		 {
			while (numberOfPurchase[i] == 0)
			{
				int j = (int)(Math.random()*10);
				numberOfPurchase[j] += 1;
				// since there is 10 teams, double(which is Math.random) to integer and it will store each element of arrays
				// (For example, 0.924 * 10 = 9.24 => (int) 9.24 = 9, and it will store numberofPurchase[9]) 
				// And using while loop for at least one miniature puck of each team has been dispensed. 
				// For that, int j is using for once system purchase one and determine which element of array was purchased
				// And once it is purchased, then while loop will not start because that element would not be zero
				// When every element of array(numberofPurchase) is not zero, while loop will be terminated 
			}
		 }
		 
		 System.out.println("Here is the break down of the pucks dispensed: ");
		 for (int i=0; i < teams.length; i++)
		 {
			 System.out.println(teams[i] + ": " + numberOfPurchase[i]);
			 sumPurchase += numberOfPurchase[i];
		 }
		 // // int i is for place of array, and print out the result of each teams' numbers of purchases. 
		 
		 System.out.println("\nWow " + firstname +", you bought a total of " + sumPurchase + " pucks and you spent");
		 System.out.println("$" + sumPurchase * priceOfPucks + " to get a miniature puck of each team.");
		 System.out.println("Enjoy!\n");
		 // Summary that how much money user will spend and how many pucks user will get.
		 
		 System.out.println("This is the end of program and thank you for using Kim's program!");
		 // close message.
		 
		 sc.close();
		 // Scanner close.
		 
	}
}
