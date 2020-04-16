package part1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class DriverPart1 {
	
	// 3 static attributes using to find a result.
	private static int numOfWords = 0;
	private static int numOfHappax = 0;
	private static int numOfStopWord = 0;
	
	// static ArrayList which will take LetterWord object.
	private static ArrayList<LetterWord> wordArr = new ArrayList<LetterWord>();
	
	public static void main(String args[])
	{
		// Scanner for user input
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter your file name to test Zipf's law :");
		
		// filename will be what user enter
		String filename = kb.next();
		
		// sc will be a reading a text file. Check try/catch blcok
		Scanner sc = null;
		
		// Temporary String attribute.
		String temp = "";
		
		try
		{
			// If file is not found, it will throw FileNotFoundException
			sc = new Scanner(new FileInputStream(filename));
			
			//if it reaches at the end, while loop ends.
			while (sc.hasNext()){
				temp = sc.next();
				
				// if read String only contains letters. Check isLetterWord static method below
				if (isLetterWord(temp)){
					// if it's a letter word, then it store in ArrayList wordARR
					wordArr.add(new LetterWord(temp));					
					// increment total number of words (tokens)
					numOfWords++;
				}
			}
		}		
		catch (FileNotFoundException e) // Properly handle IOException (which is superclass of FIleNotFoundException)
		{
			System.out.println("There is no file, program will be terminated.");
			System.exit(0);
		}
		
		// Check these static method below
		sortArray(wordArr);
		displayAllTheInformation(wordArr);
		
		// Scanner close
		sc.close();
		kb.close();
		
	}
	
	/**
	 * This static method is used to verify if given String only contains letters (characters).
	 * @param s given String
	 * @return	return true if it is only letter word, else it returns false.
	 */
	private static boolean isLetterWord(String s)
	{
		//create char array to store each letter in String
		char[] characters = s.toCharArray();
		
		for (char c : characters)
			// Using Character object (instead of primitive type of char), default method isLetter is useful to verify if it's only character or not.
			if (!Character.isLetter(c))
				return false;
			// Alternatively, if we do not want to use Character object, 
			// we can do if (( c >= 'A' && c <= 'Z' || ( c >= 'A' && c <=  'Z')))
		return true;	
	}
	
	/**
	 * This method will sort whole array. Firstly, remove duplicated words regardless of upper case or lower case (Written in question). 
	 * And then, rearrange according to frequency order. If they have the same frequency, it will be stored in alphabetic order (uppercases before lowercases).
	 * @param lw	input parameter which is unsorted ArrayList (after this method, it will be sorted)
	 */
	private static void sortArray(ArrayList<LetterWord> lw){
		for (int i =0;i<lw.size()-1;i++)
		{
			for (int j=i+1;j<lw.size();j++)
			{
				// ignore case since question asks to do. and increment frequency with method in LetterWord
				// Furthermore, remove duplicated part. 
				if (lw.get(i).equals(lw.get(j))){
					lw.get(i).incrementFrequency();
					lw.remove(j);
					// Note that, if j is removed, next j is searched so it might cause skipping. 
					// For example, index 12 and 13 are the same word but if index 12 is removed, 13 will be replaced to 12 and it will be skipped and won't track by this loop.
					// Therefore, if j is removed, j should decrement to search correctly. 
					j--;						
				}					
			}	
		}			
				
		for (int i =0;i<lw.size();i++)
		{
			for (int j=i+1;j<lw.size();j++)
			{
				// check the frequency, and if later one has higher frequency, this should be switched. So making temporary LetterWord and method set will arrange.
				if (lw.get(i).getFrequency() <lw.get(j).getFrequency()){
					LetterWord temp = lw.get(j);
					lw.set(j,lw.get(i));
					lw.set(i, temp);
				}
				
				// If they're the same frequency, then check for alphabetic order (using with compareTo method). Switching them if it's not in order.
				// Check implemented Comparable Interface and overridden method compareTo as well (Note that this method used in LetterWord not String.
				else if (lw.get(i).getFrequency() == lw.get(j).getFrequency()){
					if (lw.get(i).compareTo(lw.get(j))>0){
						LetterWord temp = lw.get(j);
						lw.set(j,lw.get(i));
						lw.set(i, temp);
					}
				}
				
			}
			
			// Note that it is still in for loop of i, and it is already arranged status. 
			// Therefore, if frequency is only 1, simply increment number of Happax.
			if (lw.get(i).getFrequency() == 1){
				numOfHappax++;
			}
			
			// In the same way, if frequency is the same or greater than 10 and length is less than 4, stop word counter is incremented.
			if (lw.get(i).getFrequency()>=10 && lw.get(i).getWord().length() <=4){
				numOfStopWord++;
			}
		}
	}
	
	/**
	 * Displaying all the information as required in question.  
	 * @param lw	lw is used to display information.
	 */
	private static void displayAllTheInformation(ArrayList<LetterWord> lw){
		// using printf to have proper indent. 
		System.out.println("----------------------------------------");
		System.out.printf("%-10s%-10s%s\n","Rank","Frequency","Word(Ignore Case)");
		System.out.println("----------------------------------------");
		
		// display sorted array (information about ranking, frequency and the word stored).
		for (int i=0;i<lw.size();i++){
			System.out.printf("%-10d%-10d%s\n",i+1,lw.get(i).getFrequency(),lw.get(i).getWord());
		}
		System.out.println("----------------------------------------");
		
		// number of words are tracked and it will show all the number of  word regardless of duplication
		// size of array tells you that the total number of word after removing duplication
		System.out.println("\nNumber of word tokes: " + numOfWords );
		System.out.println("Number of word types: " + lw.size() );
		
		// display number of happax and % of happax and happax account for whole text.
		System.out.println("\nNumber of Happax: " + numOfHappax);
		System.out.printf("%% of Happax: %.2f%%\n", (numOfHappax/(double)lw.size()*100));
		System.out.printf("Happax account for: %.2f%% of the text\n",(numOfHappax/(double)numOfWords*100));
		
		// // display number of stop word and % of stop word and stop word account for whole text.
		System.out.println("\nNumber of stop words : " + numOfStopWord);
		System.out.printf("%% of stop words: %.2f%%\n", (numOfStopWord/(double)lw.size()*100));
		System.out.printf("Stop words account for: %.2f%% of the text\n",(numOfStopWord/(double)numOfWords*100));
		
		System.out.println("\nThis is the end of the program. Thank you!");
	}
	
}

