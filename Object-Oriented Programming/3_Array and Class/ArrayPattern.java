
/*
 * Author - Seungwoo Kim
 * Date - Mar-25-2017
 * Purpose - Display two patterns of set 
 * 			 using with2-dimensional arrays, while loops & do/while loops (Question 2)
 */


import java.util.Scanner;
// import Scanner to use Scanner function.
public class ArrayPattern
{
	public static void main(String args[])
	{
		System.out.println("=========================");
		System.out.println("Welcome to Kim's program");
		System.out.println("	Array patterns");
		System.out.println("=========================");
		int userinput,row,column; 
		// variable userinput is the value that user will type, row and column will be the variable of each row and column 
		int element = 1;
		// the first element is start from 1
		
		Scanner sc = new Scanner(System.in);
		//Scanner sc declare to input
		
		do 
		{	
			System.out.println("How many rows/columns do you want your arrays to have?(must be at least 3)");
			userinput = sc.nextInt();
			// Ask to user to enter input for determining table size
			
			if (userinput<3)
				System.out.println("Please enter the integer 3 or more than 3!");
			// minimum size is 3! in case user input less than 3
		}
		while (userinput<3); // do the same loop if it's not 3
		
		int table[][] = new int[userinput][userinput];
		// Determine array table and determine the size with userinput.
		
		
		System.out.println("Pattern number 1: ");
		// print pattern number 1
		for (row=0;row<table.length;row++) 
		{
			if (row%2==0)
				// differentiate for row for even number and row for odd number
			{
				for (column=0; column<table[row].length;column++, element++)
				{
					table[row][column] = element;
				
					System.out.printf("%4d", table[row][column]);
					// for the first row (row =0) and third row(row = 2), 5th row... extra, the element increment left to right
					// using printf for formatting properly
				}
			
			System.out.println(); // for a new line for next row)
			}
			else
			{
				for (column=0, element+=table[row].length-1;column<table[row].length;column++, element --)
				{
					table[row][column] = element;
					
					System.out.printf("%4d", table[row][column]);
					// for the second row (row =1) and fourth row(row = 3), 6th row... extra, the element increment right to left
					// therefore, first column is maximum value so element + size of its table - 1(because element is increment already)
					// using printf for formatting properly
				}
			System.out.println();
			element += table.length+1;
			// make a new line for each row and and element will recover for next row (+1 for decremented element) 
			}
			
		}
		// pattern 1 is done
		
				
		int max, min, temp; // variables for sorting by maximum, minimum and temporary values
		int columnMod,scan, scanMax, scanMod; // all variables are using for for loop
		
		System.out.println("\nPattern number 2: ");
		// display Pattern number 2:
		
		for (row=1;row<table.length;row++) // since first row (row = 0) is not affected to be changed, it starts from second row(row = 1)
		{
			for (column = 0; column < table[row].length-1; column++) // variable column is for column, starts from 0(first column)
		    {
		         for (scan = column+1; scan< table[row].length; scan++) // variable scan is to compare columns
		         {  
		        	 if (table[row][scan] < table[row][column])
		        	 {
		        		 temp = table[row][scan];
				         table[row][scan] = table[row][column];
				         table[row][column] = temp;
				         // purpose of this for loop is sorting the arrays by numeric orders to make it easier
		        	 }
		         }
		         
		    }

			for (column=0, scanMax = table[row].length-row;column<row;column++,scanMax++) 
				// variable column is starting from 0
				// variable scanMax is using for changed value, 
			{
				max = table[row][scanMax];
				table[row][scanMax] = table [row][column];
				table[row][column] = max;
				
				// at this point, array has been sorted as pattern 2, but not yet sorted for least columns.		
				// for the tendency of this pattern, for example, for the 3rd row(row = 2), first column is second largest number, and second column is largest number 
				// since I arranged to numeric order, column of second to the last is second largest number, and last column is the largest number,
				// same thing for the others; therefore, first column is changing the value with the length of table - row,
				// for the second row(row =1), only first column (column = 0) is affected and for the third row(row=2), only first and second column(column = 0,1).. and so on
				// so affected column value is always smaller than row value  
			}
			
			for (columnMod=0+row;columnMod<table[row].length-1;columnMod++)
			{
				for (scanMod=columnMod+1;scanMod<table[row].length;scanMod++)
				{
					if (table[row][scanMod]<table[row][columnMod])
					{
						min = table[row][scanMod];
						table[row][scanMod] = table[row][columnMod];
						table[row][columnMod] = min;
					}
				}
			}
			// sorting the least columns(not affected columns), since columnMod is starting from its row value columnMod is determined as row,
			// once row is growing up, the least column are getting higher as well. 
			// scanMod is used for comparing, it's +1 value of scanMod for comparing
		}
		
		
		
		for (row=0;row<table.length;row++) 
		{
			for (column=0;column<table[row].length;column++)
			{
				System.out.printf("%4d", table[row][column]);
			}
			System.out.println();
		}
		// print out Pattern 2, like I did in Pattern 1, using printf for formatting properly 
		
		System.out.println("\nThis is the end of program and thank you for using Kim's program!");
		// close message
		
		sc.close();
		// scanner close
		
		
	}
}