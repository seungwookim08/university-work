/*
 * Author - Seungwoo Kim
 * Date - Feb-27-2017
 * Purpose - converting days to years (Question1)
 */

import java.util.Scanner;
// import Scanner to use Scanner function.

public class Year 
{
	public static void main(String[] args) 
	{
		
		System.out.println("----------------------------\nWelcomd to Kim's Program\n----------------------------\n\n"); 
		// welcome message
		
		Scanner sc =new Scanner(System.in);
		//define scanner for user to prompt user to input
		
		System.out.print("enter a positive number of days n: ");
		int days = sc.nextInt();
		//variable 'days', user will enter and input the data 
		
		int years = 0;
		// variable 'years' for the result
		
		if (days <365) 
		{
			years = 1;
			
		}
		// if days are less than 365, still it's 1 year so define years as integer 1. And also print the value of years
		
		else 
			// else for if not, and while to calculate years. 	
		{
			while (days>=365) 
			{
		
				days -= 365;
				years++;
				//Simply, when the days are bigger than 365, but less than 730; then, increment will apply only once 
				//Same thing for bigger numbers of days and it will execute exact calculation for years.
			}
		}
		
		System.out.print("Number of years :" + years);
		// print out calculated years		
		
		sc.close();
		//Scanner close
		
		System.out.println("\n\nThank you for using Kim's program - bye !!!"); //Closing message
		
	}
}
