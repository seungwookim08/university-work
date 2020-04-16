// -----------------------------------------------------
// Assignment #3
// Part: Part 2(include Part Number)
// Written by: Seungwoo Kim, 400000230 (include your name(s) and student ID(s))
// -----------------------------------------------------
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookInventory2 {
	
	// static attributes. 
	static String originalFileName = "Sorted_Book_Info.txt";
	static Book bkArr[];
	static int binaryCtr=0;
	static int sequentialCtr=0;
	static Scanner userInput = new Scanner(System.in);
	public static void main(String args[])
	{	
		// We will use BufferedReader and ObjectOutputStream so we declare as null and we try in try block.
		// When I use scanner to read file (not for keyboard) I use them in method to avoid complexity.
		// Also, I use PrintWriter in method, check add record method.
		PrintWriter pw = null;
		BufferedReader br = null;		
		ObjectOutputStream oos = null;
		
		// These 3 variables use for searching ISBN.
		long searchingISBN;
		int result1;
		int result2;
		
		System.out.println("Start of the program! We will fisrt try to add records.");
    	try{
    		pw = new PrintWriter(new FileOutputStream(originalFileName,true));
    		// adding record in exist file.
    		addRecords(pw);
    		
    		// display file contents.
    		br = new BufferedReader(new FileReader(originalFileName));
    		displayFileContents(br);
    		
    		// This method will take Book object into Book array.
    		recordInArray();
    		
    	} catch(FileNotFoundException e)
    	{
    		System.out.println("There is file not found exception. System will be terminated.");
    		System.exit(0);
    	} catch (IOException e)
    	{
    		System.out.println("There is Input output exception. System will be terminated.");
    		System.exit(0);
    	}
    	
		// Binary search and sequential search and result. It also track how many time method (counter) is used.
		System.out.println("\nNow it is time for searching ISBN!! Please enter ISBN :");
		while(true){
			try{
				searchingISBN = userInput.nextLong();
				break;
			} catch(InputMismatchException e){
				userInput.nextLine();
				System.out.println("You put the wrong type of input. Try again! :");
			}
			
		}
		
		result1 = binaryBookSearch(bkArr,0,(bkArr.length-1),searchingISBN);
		result2 = sequentialBookSearch(bkArr,0,(bkArr.length-1),searchingISBN);
		if (result1 == -1)
			System.out.println("We could not found such ISBN from binary search! It takes " + binaryCtr + " times to search.");
		else
			System.out.println("\nBinary Search result! we have found ISBN in index # " + (result1+1) + " and it takes " + binaryCtr + " times of binary Search!");
		if (result2 == -1)
			System.out.println("We could not found such ISBN from sequential search! It takes " + sequentialCtr + " times to search." );
		else
			System.out.println("Sequential Search result! we have found ISBN in index # " + result2 + " and it takes " + sequentialCtr + " times of binary Search!");
		
		// ObjectOutputStream for writing object in .dat, check binaryWriting method.
		try{
			System.out.println("Binary Writing operation!");
			oos = new ObjectOutputStream(new FileOutputStream("Books.dat"));
    		binaryWriting(oos);
		}catch(FileNotFoundException e)
    	{
    		System.out.println("There is file not found exception. System will be terminated.");
    		System.exit(0);
    	} catch (IOException e)
    	{
    		System.out.println("There is Input output exception. System will be terminated.");
    		System.exit(0);
    	}
		
		System.out.println("We have copied object data in <<Books.dat>>");
		// the end of program.
    	System.out.println("\nThis is the end of program for assignment 3 part 2. Thank you for using Kim's program!");
    	userInput.close();
	}
	
	/**
	 * This method will add the line for appending information. It will prompt that if user wants to add new information or not. 
	 * Furthermore, newly added ISBN should be greater than recorded ISBN so we use method traceGreatestISBN 
	 * @param pw	output file stream name.
	 */
	public static void addRecords(PrintWriter pw) throws IOException
	{
		
		System.out.println("We will add information in the records. do you wish to add? (Y/N)");
		String yn = userInput.next();
		while (!yn.equalsIgnoreCase("n")&&!yn.equalsIgnoreCase("y")){
			System.out.println("You have to put Y or N!! try again! (Y/N)");
			yn = userInput.next();
		}
		long inputISBN;
		while (yn.equalsIgnoreCase("y"))
		{	    	
			System.out.println("You want to add information. Please enter ISBN (greater than "+traceGreatestISBN(originalFileName)+"):");
			try{
				while (true)
				{
					inputISBN = userInput.nextLong();
					
					//traceGreatestISBN will find greatest number of ISBN. If user input is less than this, then it will keep going
					if (inputISBN>traceGreatestISBN(originalFileName))
						break;
					
					System.out.println("Sorry, your entered ISBN is less or equal than greatest ISBN(" + traceGreatestISBN(originalFileName)+") in our records. try new ISBN :");
				}
				// note that in this way, it will be recorded as the same way in original file.
				pw.print(inputISBN + " ");
				System.out.println("Please enter title of book :");
				pw.print(userInput.next() +" ");
				System.out.println("Please enter issue year :");
				pw.print(userInput.nextInt() +" ");
				System.out.println("Please enter author name :");
				pw.print(userInput.next() +" ");
				System.out.println("Please enter price :");
				pw.print(userInput.nextDouble() +" ");
				System.out.println("Please enter number of pages :");
				pw.print(userInput.nextInt() +" ");
				pw.println();
				System.out.println("Do you want to add another information in the records? (Y/N)");
				yn = userInput.next();
				while (!yn.equalsIgnoreCase("n")&&!yn.equalsIgnoreCase("y")){
					System.out.println("You have to put Y or N!! try again! (Y/N)");
					yn = userInput.next();
				}
			} catch(InputMismatchException e)
			{
				System.out.println("You put wrong input type. Program will be terminated!");
				System.exit(0);
			}
			pw.close();
			if (yn.equalsIgnoreCase("y"))				
				try{
		    		pw = new PrintWriter(new FileOutputStream(originalFileName,true));
		    	} catch(FileNotFoundException e)
		    	{
		    		System.out.println("There is file not found exception. System will be terminated.");
		    		System.exit(0);
		    	}
				
			
		}
		
		System.out.println("You want to stop adding!\n");
		
	}
	
	/**
	 * We can know how many lines with howManyRecords method so last line has greatest ISBN since text file is sorted ISBN order.
	 * So we simply get the last ISBN. 
	 * @param in	this parameter is used for reading file name.
	 * @return	the greatest number of ISBN in text file (which are sorted by ISBN order)
	 */
	private static long traceGreatestISBN(String in){
		Scanner sc = null;
    	try{
    		sc = new Scanner(new FileInputStream(in));
    	} catch(FileNotFoundException e)
    	{
    		System.out.println("There is file not found exception. System will be terminated.");
    		System.exit(0);
    	}
    	for (int i=0;i<(howManyRecords(in)-1);i++)
    		sc.nextLine();
    	long tempo = sc.nextLong();
    	sc.close();
    	return tempo;
    	
	}
	
	/**
	 * Similar method as first part of assignment, it will find how many records there is (input parameter is String). 
	 * @param in	Reading file name to search how many lines there is
	 * @return	return the number of lines.
	 */
	private static int howManyRecords(String in)
    {
    	Scanner sc = null;
    	try{
    		sc = new Scanner(new FileInputStream(in));
    	} catch(FileNotFoundException e)
    	{
    		System.out.println("There is file not found exception. System will be terminated.");
    		System.exit(0);
    	}
    	
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
	 * Since the question asks to use BufferedReader, I will use BufferedReader instead of Scanner.
	 * It will simply display file contents. Similar method as first part of assignment.
	 * @param br	input stream file name (buffered reader) 
	 */
	public static void displayFileContents(BufferedReader br) throws IOException
	{
		System.out.println("Here are the contents of file " + originalFileName + "!");
		String s;
		s = br.readLine();
		while (s!=null){
			System.out.println(s);
			s = br.readLine();			
		} 
		br.close();
	}
	/**
	 * This method will help to record all the array. Since bkArr is static so we don't need to use input method.
	 */
	private static void recordInArray(){
		System.out.println("Now, we start to record in Book object in bkarr array!");		
		bkArr = new Book[howManyRecords(originalFileName)];
		Scanner sc = null;
		try{
			sc = new Scanner(new FileInputStream(originalFileName));
		}catch(FileNotFoundException e){
			System.out.println("There is file not found exception. System will be terminated.");
    		System.exit(0);
		}
		
		// If there is empty line, the program will be terminated as indicated in question
    	if (bkArr.length == 0)
    	{
    		System.out.println("It is empty! Nothing to deal with, so the program will be terminated.");
    		System.exit(0);
    	}
    	    	
    	// Note that, the order of text is ISBN, book name, issue year, author name, price, and number of pages, 
    	// As I put parameterized constructor in the same order, it will store in a right way. 
    	for (int i=0; i<bkArr.length;i++)
    	{
    		Book b = new Book(sc.nextLong(), sc.next(), sc.nextInt(), sc.next(), sc.nextDouble(), sc.nextInt());
    		bkArr[i] = b;
    	}
    	sc.close();
	}
	/**
	 * This method will do binary search in bkArr. Please note that our index is start from 1 not 0! 
	 * @param bk	entered Book array
	 * @param s	start index
	 * @param e	end index
	 * @param ISBN	the ISBN that user is searching for
	 * @return returning -1 or found index value. 
	 */
	public static int binaryBookSearch(Book[] bk, int s, int e, long ISBN)
	{
		// we let foundIndex -1 to denote invalid value. 
		int foundIndex = -1, mid;		
		binaryCtr++;
		
		// at this point, there is no ISBN matched
		if(s > e )		
			return -1;								
		
		mid = (s + e)/2;	
		
		// the index will be returned when we find matched ISBN
		if(bk[mid].getISBN() == ISBN )				
		{						
			System.out.println("We found the value from binary search!");
			return mid;		
		}
		
		else	
		{
			// if it's less than middle (note that it is recursive way)
			if(ISBN < bk[mid].getISBN())	
			{
				System.out.println("Searching between index # " + (s+1) + " and index # " + (mid));
				foundIndex = binaryBookSearch(bk, s, mid-1, ISBN); 
			}
			//if it's more than middle (note that it is recursive way)
			else			
			{
				System.out.println("Searching between index # " + (mid) + " and index # " + (e+1));
				foundIndex = binaryBookSearch(bk, mid+1, e, ISBN); 				
			}
		}
		return foundIndex;
	}
	
	/**
	 * This method will do sequential search in bkArr. Please note that our index is start from 1 not 0!  
	 * @param bk	entered Book array
	 * @param s	start index
	 * @param e	end index
	 * @param ISBN	the ISBN that user is searching for
	 * @return returning -1 or found index value. 
	 */
	public static int sequentialBookSearch(Book[] bk, int s, int e, long ISBN)
	{
		int foundIndex = -2;
		for (int i = s; i <= e; i++)
		{
			sequentialCtr++;
			if (bk[i].getISBN() == ISBN)
			{
				System.out.println("\nWe found tha value from sequential search!");				
				foundIndex = i;
				break;		
			}
		}
		// note that our index is +1 more. 
		return (foundIndex +1) ;
	}
	
	/**
	 * This will store all the objects from the bkArr[] into a binary file.
	 * Note that we do not need to use writeUTF, writeLong... etc since the question asks to store all the <<objects>> from bkArr[] 
	 * @param oos	binary output stream
	 */
	public static void binaryWriting(ObjectOutputStream oos) throws IOException
	{
		for (int i=0;i<bkArr.length;i++)
		{
			oos.writeObject(bkArr[i]);
		}
		oos.close();
	}
}
