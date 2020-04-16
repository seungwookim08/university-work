// -----------------------------------------------------
// Assignment #3
// Part: Part 1(include Part Number)
// Written by: Seungwoo Kim, 400000230 (include your name(s) and student ID(s))
// -----------------------------------------------------
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookInventory1 {

    static Book bkArr[];
    public static void main(String args[])
    {
    	 String fileName;
    	 
    	 // for the compiler, before using in try, I have to declare PrintWriter and Scanner
         PrintWriter pw = null;
         Scanner sc = null;
         Scanner userInput = new Scanner(System.in);
         
         // File class to check if there is same file name exists or not. 
         File f = null;
         System.out.print("Write the name of output file, which will be recoreded corrected version of information :");
         fileName = userInput.next();
         f = new File(fileName);                 
         while (f.exists()) {
             System.out.println(fileName + " is already existing file therefore, we cannot use it.");
             System.out.println("That file has a size of " + f.length() + "bytes.");
             System.out.print("Try to put new file name :\t");
             fileName = userInput.next();
             f = new File(fileName);
         }
         
         // In this try block, I open Scanner and PrintWriter. these are closed in method.
         // and open Scanner again to display as well. If one of the step fails, it will throw Exception and the program will be terminated.
         try {
             sc = new Scanner(new FileInputStream("Initial_Book_Info.txt"));
             pw = new PrintWriter(new FileOutputStream(fileName));
             // Check howManyRecords method for detail.
             bkArr = new Book[howManyRecords(sc)];
             
             // since I close the scanner in method I will have to reopen Scanner
             // and it is still in try block so if there's file not found exception, it will throw. 
             sc = new Scanner(new FileInputStream("Initial_Book_Info.txt"));
             fixInventory(sc, pw);
             
             //Display older version and corrected version of text file using displayFileContent method.
             sc = new Scanner(new FileInputStream("Initial_Book_Info.txt"));
             System.out.println("Contents for Initial_Book_Info.txt!!");
             System.out.println("\n=====================================================");
             displayFileContent(sc);
             
             sc = new Scanner(new FileInputStream(fileName));
             System.out.println("\nContents for " + fileName + "!!" );
             System.out.println("=====================================================");
             displayFileContent(sc);
             
         } catch(FileNotFoundException e)
     	{
     		System.out.println("There is file not found exception. System will be terminated.");
     		System.exit(0);
     	} catch (IOException e)
     	{
     		System.out.println("There is Input output exception. System will be terminated.");
     		System.exit(0);
     	}
         System.out.println("\nThis is the end of program for assignment 3 part 1. Thank you for using Kim's program!");
         // Scanner for keyboard is closed.
         userInput.close();
         
         
    }
    
    /**
     * fixInventory method which is indicated in question. 
     * For detailed explanation, check comment inside method.  
     * @param sc input file stream name
     * @param pw output file name
     */
    private static void fixInventory(Scanner sc, PrintWriter pw) throws IOException{
    	// If there is empty or 1 line, the program will be terminated as indicated in question
    	if (bkArr.length == 0 || bkArr.length == 1 )
    	{
    		System.out.println("There is nothing to be fixed since we have only empty or 1 line");
    		System.exit(0);
    	}
    	    	
    	// Note that, the order of text is ISBN, book name, issue year, author name, price, and number of pages, 
    	// As I put parameterized constructor in the same order, it will store in a right way. 
    	// Plus, question asks to copy first in array so copying it first.
    	for (int i=0; i<bkArr.length;i++)
    	{
    		Book b = new Book(sc.nextLong(), sc.next(), sc.nextInt(), sc.next(), sc.nextDouble(), sc.nextInt());
    		bkArr[i] = b;
    	}
    	
    	// This method will fix duplication error with prompting user to input. Please check duplicationCorrection method.
    	duplicationCorrection();
    	
    	// Record in output file for corrected version. 
    	for (int i =0;i<bkArr.length;i++)
    	{
    		// Check toString in Book class. 
    		pw.println(bkArr[i]);
    	}
    	pw.close();
    	sc.close();
    }
    
    /**
     * howManyRecords will calculate how many records there is and it will return integer howManyLines
     * @param sc name of input stream file
     * @return returning how many lines there is and this value will be the length of array
     */
    private static int howManyRecords(Scanner sc)
    {
    	int howManyLines = 0;    	
    	while (sc.hasNextLine())
    	{
    		String tempo = sc.nextLine();
    		if (tempo == null);
    		else
    			howManyLines++;
    		
    	}
    	sc.close();
    	return howManyLines;
    }
    
  
    /**
     * duplicationDetect method will find duplication of ISBN. Once there is no more duplication, the given array will be filled correctly.
     * Please check comments in the method. This method is used in fixInventory method.
     */
    private static void duplicationCorrection()
    {
    	Scanner scInput = new Scanner(System.in);
    	long newISBN =0;
	
		// Double for loop for comparing index of array
		for (int i =0;i<bkArr.length;i++)
		{
			for (int j=i+1;j<bkArr.length;j++)
			{
				if (bkArr[i].getISBN() == bkArr[j].getISBN())
				{
					// Also note that, in the example in question, index start from 1 so i need to +1 for i or j value.
					System.out.println("There is duplication of ISBN in record of " + (j+1) + " which is the same ISBN in record of " + (i+1)
								+ ". ISBN is " + bkArr[i].getISBN() +". Please enter new duplicate ISBN: ");	
					
					// this while loop forever run until user enter good ISBN
					while(true)
						try {
							newISBN = scInput.nextLong();
							// verifying that entered input has no other duplication. 
							for (int k =0;k<bkArr.length;k++)
							{
								if (bkArr[k].getISBN() == newISBN)    									
									throw new DuplicateISBNException("In record of "+ (k+1) + ". We found duplication! Try again! new ISBN :");
    						}
							bkArr[j].setISBN(newISBN);
							// break while loop and j will increment
							break;
															
						} catch(DuplicateISBNException d){
							// Otherwise, it will keep going. simply, using continue, while loop will work until there is no duplicateISBN Exception.
							System.out.println(d.getMessage());
							continue;
						}catch (InputMismatchException e)
						{
							// If input is invalid, it will throw InputMismatchException
							scInput.nextLine();
							System.out.println("You put a wrong input, try new ISBN! :");
					
						}
					 
					
					// Since there is no problem, new ISBN is okay to enter, so setISBN.
					bkArr[j].setISBN(newISBN);
						
				}
					
				
			}    	
		}
		System.out.println("\nYou corrected all ISBN!");
		scInput.close();    	
    }
    
    /**
     * Using with Scanner, it will display the content
     * @param sc	input Scanner to read file.
     */
    public static void displayFileContent(Scanner sc)
    {    	    	
    	while (sc.hasNextLine())
    	{
    		System.out.println(sc.nextLine());
    	}
    	sc.close();
    }
}
