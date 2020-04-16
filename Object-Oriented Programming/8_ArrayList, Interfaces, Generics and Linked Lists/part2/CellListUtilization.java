package part2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CellListUtilization {
	
	// keyboard and hash table which are static attributes. 
	static Scanner kb2 = new Scanner(System.in);
	static CellHashTable cHash = new CellHashTable();
	
	public static void main(String args[]){
		
		System.out.println("Beginning of the program, we will read text file and record into CellList object.");
		System.out.println("Also, it will demonstrate how many iterations were made during finding time.");
		// create two empty lists from the CellList class
		CellList cList1 = new CellList();
		CellList cList2 = new CellList();
		
		// Open the Cell_Info.txt file (and will be used to record) 
		Scanner sc = null;
		

		// temporary attributes. 
		long tempSerial;
		CellPhone tempCP = null;
		
		try {
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));
			while(sc.hasNextLine()){
				
				// Question asks to read line by line so used nextLine. split with \\s+ since there is tab and white space together. 
				String[] tempLine = sc.nextLine().split("\\s+");
				tempSerial = Long.parseLong(tempLine[0]);
				
				// note that the order of parameterized constructor of CellPhone is long, String, double, and integer
				// hash table is used to have efficiency of finding (searching). If I don't use hash table, whenever I add CellPhone on list
				// and it will be increment and the iteration to find will be O(n).
				if (!cHash.containsCell(tempSerial)){					
					tempCP = new CellPhone(tempSerial,tempLine[1],Double.parseDouble(tempLine[2]),Integer.parseInt(tempLine[3]));
					cList1.addToStart(tempCP);
					cHash.addToHash(tempCP);
					tempCP = null;
				}
				// if there is same serial number then, it will be called clone method and in clone method, user is asked to enter new serial number.
				else
				{
					// if given serial number by user is still the same, this loop will still work.
					do{
						System.out.println("There is the same serial number ("+tempSerial+"), you will need to provide new serial number! ");
						tempCP = new CellPhone(tempSerial,tempLine[1],Double.parseDouble(tempLine[2]),Integer.parseInt(tempLine[3]));
						tempCP = tempCP.clone();
						tempSerial = tempCP.getSerialNum();
					}	while (cHash.containsCell(tempSerial));
																				
					cList1.addToStart(tempCP);
					cHash.addToHash(tempCP);
					tempCP = null;				
				}			
			}
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found! system will be terminated!");
			System.exit(0);
		} 
		
		
		// Show the contents of the list I just initialized
		System.out.println("---------------------------------------\nInformation on current list\n---------------------------------------");
		cList1.showContents();
		
		// Prompt the user to enter a few serial numbers and search the list that I created from the input file. 
		// iterations will be displayed from find method in CellList.
		search();
		
		// Test constructor and methods. Note that to simplifying methods, Also, find or contain or anything related method will not be tested since we have already tested them previously. 
		// Therefore, I don't use hash table here since we don't search them. 
		cList2 = test(cList1, cList2);
		
		System.out.println("\nThank you for using Kim's program. That's the end of program! ");
		
		// closing scanners
		CellPhone.kb.close();
		kb2.close();
	}
	
	
	private static void search()
	{		
		// String yn is yes or no and serial is a value that user wants to find.
		String yn; 
		long serial;
		System.out.println("Do you want to search (Y/N)? ");
		yn = kb2.next();
		while (yn.equalsIgnoreCase("y"))
		{
			System.out.println("Please enter the serial number you want to search. (long type)");
			serial = kb2.nextLong(); 
			if (cHash.showHashObject(serial)){
				System.out.println("Above object is found CellPhone object with given serial number");
			}
			else
				System.out.println("Sorry, " + serial +" does not exist in our record.");
			
			System.out.println("Do you still want to search more? (Y/N)");
			yn = kb2.next();
		}
	}
	
	private static CellList test(CellList cList1,CellList cList2)
	{
		CellPhone cpTest1 = new CellPhone(1119012,"KimCell",999.99,2017);
		CellPhone cpTest2 = new CellPhone(1119013,"KimCell",1299.99,2017);
		CellPhone cpTest3 = new CellPhone(1119014,"KimCell",1699.99,2017);
		CellList tempCopy = null;
		for (int i =1;i<14;i++)
		{
			System.out.println("\n----------------------------------------------------");
			System.out.print("Test number " + i + " : ");
			// for simplicity, just using switch followed by int i from for loop. 
			switch (i){
			
				// these 2 cases will throw NoSuchElementException (as we wanted and directed in question). 
				case 1 : System.out.println("Check when list is null, insert at index");
						try{
							cList2.insertAtIndex(cpTest1, 2);
						}catch(NoSuchElementException e){
							System.out.println("We were not able to insert. NoSuchElementException occurs");
							break;
						}
				case 2 : System.out.println("check when list is null, delete from index");
						try{
							cList2.deleteFromIndex(0);
						}catch(NoSuchElementException e){
							System.out.println("We were not able to delete. NoSuchElementException occurs");
							break;
						}
						
				// checking copy constructor		
				case 3 : System.out.println("Copy Constructor");							
							cList2 = new CellList(cList1);							
							break;
				
				// inserAtIndex method to check whether it is exception case or not 
				case 4 : System.out.println("Insert at index of 0 (index of start)");
							cList2.insertAtIndex(cpTest1, 0); // this will directly calls insertAtStart
							break;
				
				// // deleteFromIndex method to check whether it is exception case or not 
				case 5 : System.out.println("Delete from index of 0 (index of start)");
							cList2.deleteFromIndex(0); // this will directly calls deleteFromStart
							break;
							
				// General indexAtIndex case
				case 6 : System.out.println("Insert at index of 2 (general index case, note that index starts from 0)");
							cList2.insertAtIndex(cpTest1, 2);
							break;
							
				// General DeleteFromIndex case
				case 7 : System.out.println("Delete from index of 2 (general index case, note that index starts from 0)");
							cList2.deleteFromIndex(2);
							break;
				// Last index delete case. Note that we don't need to think about insert last case because it is the same as general case 
				// Check more explanation (or comment) in insertAtIndex method in CellList
				case 8 : System.out.println("Delete from last index (size-1), checking getSize() method as well");
							cList2.deleteFromIndex(cList2.getSize()-1);
							break;			
				// replaceAtIndex method to check whether it is exception or not
				case 9 : System.out.println("Replace at index of 0 (index of start)");
							cList2.replaceAtIndex(cpTest1, 0);
							break;							
				// replaceAtIndex method in general case
				case 10 : System.out.println("Replace at index of 4 (general index case, note that index starts from 0)");
							cList2.replaceAtIndex(cpTest2, 4);
							break;
				case 11 : System.out.println("Replace at index of last (size -1)");
							cList2.replaceAtIndex(cpTest3, cList2.getSize()-1);
				// Testing equals methods. Two lists are the same if the content (CellPhone) in order is the same.
				case 12 : System.out.println("equals method");
							break;							
				case 13 : System.out.println("equals method (testing CellList copy constructor too (like case 3))");
							tempCopy = new CellList(cList2); // deep copy is used (not shallow copy)
							break;
									
			}
			System.out.println("----------------------------------------------------");
			if (i == 3){
				System.out.println("\tShow the contents of cList1");
				cList1.showContents();
				System.out.println("\tShow the contents of cList2");
			}
			if (i == 12){
				System.out.println("\tcList1 and cList2 are the same? ---> " + cList1.equals(cList2)); // since I add some new CellPhone during test, it should be false	
				System.out.println("\tShow the content of cList1");
				cList1.showContents();
				System.out.println("\tShow the content of cList2");
			}
			if (i == 13){
				System.out.println("\tcList2 and tempCopy are the same? ---> " + tempCopy.equals(cList2)); // deep copy used. it should be true. 
				System.out.println("\tShow the content of tempCopy");
				tempCopy.showContents();
				System.out.println("\tShow the content of cList2");
			}
			cList2.showContents();
		}
		return cList2;
	}
}
