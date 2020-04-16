
/*
 * Author - Seungwoo Kim
 * Date - Feb-27-2017
 * Purpose - multiplication table (Question2)
 */

public class Multiplication
{
   public static void main (String[] args) 
   {
	  System.out.println("----------------------------\nWelcomd to Kim's Program\n----------------------------\n\n"); 
		// welcome message
	   
      System.out.print("    |");
      // For the first print header
      int header = 1;
      while (header <=10)
      	{System.out.print(header + "     ");
      	header++;
      	}
      	// Using while loop for the first line and varaible 'header' is using for 1 to 10 and print out with spaces
            
      System.out.print("\n_____");
      // Similarly for the first header, make underscore line. And \n for make a new line
      
      for (int i = 1; i <= 10; i++)
         System.out.print("______");
      // to have the same amount of underscore line, similar as first while loop but using for loop for this time.
      
      System.out.println();
      // for the next line
      
      
      for (int i = 1; i <= 15; i++) 
      { // variable i will be a each row 1 to 15, the statement is located last 
        {
        	if (i<10)System.out.print(i + "   |");
        	else System.out.print(i + "  |"); 
        // if i is less than 10, it needs 1 more space so using if and else statement(because 10 to 15, they're using 2 digits).
        }
      
        	for (int j = 1; j <= i && j <=10; j++) 
        	{ 
        		// another for loop to make a each component. And also, component cannot exceed each row value
        		// And the maximum number of components is 10
        		if (i*j<10)
        			System.out.print(i*j + "     ");
        		else if (i*j<100)
        			System.out.print(i*j + "    ");
        		else
        			System.out.print(i*j + "   ");
        		// we need multiplication table so simply using i(row)*j(column) 
        		// similarly, if it's less than 10, it takes only 1 digit so make 5 spaces
        		// if it's 10 to 99, it takes 2 digits so make 4 spaces
        		// and lastly, if it's more than 100, it takes 3 digits so make 3 spaces.
        	} // multiplication 'loop for' ended
        	System.out.println();
        	// for make a new line for the rows.
      }// row 'loop for' ended.
     
      System.out.println("\nThank you for using Kim's program - bye !!!"); //Closing message
   }
      
}

