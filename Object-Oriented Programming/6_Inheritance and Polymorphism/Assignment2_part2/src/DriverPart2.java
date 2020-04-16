// -----------------------------------------------------
// Assignment 2
// Part: 2
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
import book.*;
import journal.Journal;
import magazine.Magazine;
import paperpublication.PaperPublication;

public class DriverPart2 {

	/**
	 * Create temporary PaperPublication array and the length will be same as original(input) one.
	 * I have to use "Copy Constructor", not "Clone Method", if I do not use conditions such as "if", I have no choice to make in this way.
	 * @param p original input PaperPublication array 
	 * @return it will return copied array from original one
	 */
	public static PaperPublication[] copyBooks(PaperPublication[] p)
	{
		PaperPublication[] pCopy = new PaperPublication[p.length];
		for (int i=0;i<pCopy.length;i++)
		{
			pCopy[i] = new PaperPublication(p[i]);
		}
		
		return pCopy;
	}
	
	public static void main(String args[]) {
		
		/**
		 * PaperPublication array which can contain PaperPublication object. The length of array is 12 since part 2 needs 12 objects.
		 */ 
		PaperPublication paperArray[] = new PaperPublication[12];
		

		/**
		 * Creating PaperPublication, Book, ChildrenBook, EudcationBook, and Journal with default and parameterized constructor.
		 */
		PaperPublication p1 = new PaperPublication();
		PaperPublication p2 = new PaperPublication("First draft", 0.01, 340);
		
		Book b1 = new Book();
		Book b2 = new Book("Fantasy world guide", 45.25, 548, 9989789, 2017, "Martine Godin");
		
		ChildrenBook cb1 = new ChildrenBook();
		ChildrenBook cb2 = new ChildrenBook("Happy Ballon", 35.50, 323,1002359, 2017, "Seungwoo", 3);
		
		EducationalBook eb1 = new EducationalBook();
		EducationalBook eb2 = new EducationalBook("Introduction to Coding 101", 102.30, 670, 8853421, 2012, "Aiman Hanna", 4, "Computer Science");
				
		Journal j1 = new Journal();
		Journal j2 = new Journal("Montreal Engineering Times", 3.00, 24, 151, "Engineering");
		
		Magazine m1 = new Magazine();
		Magazine m2 = new Magazine("Weekly STM", 10.00, 80, Magazine.PaperQuality.High, Magazine.IssueFrequency.Weekly);
		
		
		
		/**
		 *  Fill array of paperArray for each object.
		 */
		paperArray[0] = p1;
		paperArray[1] = p2;
		paperArray[2] = b1;	
		paperArray[3] = b2;
		paperArray[4] = cb1;
		paperArray[5] = cb2;
		paperArray[6] = eb1;
		paperArray[7] = eb2;
		paperArray[8] = m1;
		paperArray[9] = m2;
		paperArray[10] = j1;
		paperArray[11] = j2;
		
		/**
		 * Creating copy array and pass paperArray to the static method copyBooks
		 */
		PaperPublication[] copy = {};
		copy = copyBooks(paperArray);
		
		/**
		 * Copying was unsuccessful. Because when we create new object to copy, it does not do polymorphism since each of class has different name. 
		 * Since it is not correspond one by one in copyBooks method for creating new class, it will give an error message. 
		 * Overriding <<clone method>> will work correctly in this case, but the question asks to use <<copy constructors>> so the result is unsuccessful. 
		 * Only Paper Publication is working correctly because they have the same class name. 
		 */
		System.out.println("Display original and copied information! and it will also verify if copy was correct or not!");
		for (int i=0;i<copy.length;i++)
		{
			if(!copy[i].equals(paperArray[i]))
				System.out.println("\nError! Origninal and Copied Objects are not the same!");
			else
				System.out.println("\nCopying was successful");
			System.out.println("Original array in index of " + i + paperArray[i] );
			System.out.println("Copied array in index of " + i + copy[i] );			
		}		
		
		System.out.println("\nThat's the end of the program. Thank you!");
	}
}
