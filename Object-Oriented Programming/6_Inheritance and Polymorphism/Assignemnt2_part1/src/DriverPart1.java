// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
import book.*;
import journal.Journal;
import magazine.Magazine;
import paperpublication.PaperPublication;

public class DriverPart1 {

	public static void main(String args[]) {
		
		// These attributes will verify what has the most and least number of pages.
		int leastNumPage = 0;
		int mostNumPage = 0;
		
		// Create PaperPublication Array (15 array object)
		PaperPublication paperArray[] = new PaperPublication[15];
		

		// Create a Paper Publication
		PaperPublication p1 = new PaperPublication();
		PaperPublication p2 = new PaperPublication("First draft", 0.01, 340);
		PaperPublication p3 = new PaperPublication("Weekly STM", 10.00, 80);
		
		Book b1 = new Book();
		Book b2 = new Book("Fantasy world guide", 45.25, 548, 9989789, 2017, "Martine Godin");
		
		// Create some Children Books
		ChildrenBook cb1 = new ChildrenBook();
		ChildrenBook cb2 = new ChildrenBook("Happy Ballon", 35.50, 323,1002359, 2017, "Seungwoo", 3);
		ChildrenBook cb3 = new ChildrenBook(cb2);
		
		// Create Some Educational Books
		EducationalBook eb1 = new EducationalBook();
		EducationalBook eb2 = new EducationalBook("Introduction to Coding 101", 102.30, 670, 8853421, 2012, "Aiman Hanna", 4, "Computer Science");
		EducationalBook eb3 = new EducationalBook("Introduction to Coding 101 with solution", 140.25, 780, 8853422, 2012, "Aiman Hanna", 4, "Computer Science");
		
		
		// Create a Journal
		Journal j1 = new Journal();
		Journal j2 = new Journal("Montreal Engineering Times", 3.00, 24, 151, "Engineering");
		
		// Create a Magazine
		Magazine m1 = new Magazine();
		Magazine m2 = new Magazine("Weekly STM", 10.00, 80, Magazine.PaperQuality.High, Magazine.IssueFrequency.Weekly);
				
		// Fill our PaperPublication Array
		paperArray[0] = p1;
		paperArray[1] = p2;
		paperArray[2] = p3;
		paperArray[3] = b1;	
		paperArray[4] = b2;
		paperArray[5] = cb1;
		paperArray[6] = cb2;
		paperArray[7] = cb3;
		paperArray[8] = eb1;
		paperArray[9] = eb2;
		paperArray[10] = eb3;
		paperArray[11] = m1;
		paperArray[12] = m2;
		paperArray[13] = j1;
		paperArray[14] = j2;
		
		// Use toString to display info, and also save the most and the least number of pages of book 
		System.out.println("Display all information!\n");
		for (int i=0; i < paperArray.length; i++) 
		{
			System.out.println("Paper index " + i + " " + paperArray[i].toString());
			if (paperArray[leastNumPage].getNumOfPages() > paperArray[i].getNumOfPages())
				leastNumPage = i;
			
			if (paperArray[mostNumPage].getNumOfPages() < paperArray[i].getNumOfPages())
				mostNumPage = i;
		}

		System.out.println("\nEquals class test!!\n");
		
		/**
		 * Comparing cb2 and cb3 which is copied from copy constructor,
		 */
		if (cb3.equals(cb2))
			System.out.println("Children Book cb2 and Children Book cb3 are the same.");
		else
			System.out.println("Children Book cb2 and Children Book cb3 are not the same.");
		
		/**
		 * Comparing same classes but different value of attributes  
		 */			
		if (eb2.equals(eb3))
			System.out.println("Educational Book eb2 and Educational book eb3 are the same.");
		else
			System.out.println("Educational Book eb2 and Educational book eb3 are not the same.");
		
		/**
		 * Comparing different classes but they have same attribute except new attribute added for Magazine class
		 */
		if (m2.equals(p3))
			System.out.println("Magazine m2 and Paper Publication p3 are the same.");
		else
			System.out.println("Magazine m2 and Paper Publication p3 are not the same.");
			
		/**
		 * Doing null verification, if null check does not work in equals method, it will not even reach if condition sentence and it will crash directly. 
		 */
		Book nullOne = null;
		if (m2.equals(nullOne))
			System.out.println("Magazine m2 and null are the same.");
		else
			System.out.println("Magazine m2 and null are not the same. System did not crash!.");
		
		/**
		 * Comparing identical object.
		 */
		if (b2.equals(b2))		
			System.out.println("Book b2 and Book b2 are the same.");
		else
			System.out.println("Book b2 and Book b2 are not the same.");
		
		/**
		 * display Paper which has least number of pages and most number of pages book. 
		 */
		System.out.println("\nDisplay the paper has the least number of pages and the most number of pages!!!");
		System.out.println("\nThe Paper which has the least number of pages is in index of " + leastNumPage + " in array."+ paperArray[leastNumPage]);
		System.out.println("\nThe Paper which has the most number of pages is in index of " + mostNumPage + " in array." + paperArray[mostNumPage]);			

		System.out.println("\nThat's the end of the program. Thank you!");
	}
}
