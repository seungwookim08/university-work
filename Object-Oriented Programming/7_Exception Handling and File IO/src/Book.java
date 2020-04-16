// -----------------------------------------------------
// Assignment #3
// Part: Part 1 and 2(include Part Number)
// Written by: Seungwoo Kim, 400000230 (include your name(s) and student ID(s))
// -----------------------------------------------------
import java.io.Serializable;

@SuppressWarnings("serial")
public class Book implements Serializable
{
	// 6 attributes
	private long ISBN;
	private int issueYear;
	private String title;
	private String authorNames;
	private double price;
	private int numOfPages;
	
	/**
	 * parameterized constructor
	 * @param i	ISBN number
	 * @param t	title
	 * @param iy	issue year
	 * @param an	author name
	 * @param p	price
	 * @param nop	number of pages
	 */
	public Book (long i, String t, int iy, String an, double p, int nop)
	{
		ISBN = i;
		issueYear = iy;
		title = t; 
		authorNames = an;
		price = p;
		numOfPages = nop;
	}
	
	//getter and setter for ISBN, we do not need other getters and setters. 
	public long getISBN()
	{
		return ISBN;
	}
	
	public void setISBN(long i)
	{
		ISBN = i;
	}
	
	// toString method to properly store(or write) in text file. 
	public String toString()
	{
		return ISBN + " " + title + " " + issueYear + " " + authorNames + " " + price + " " + numOfPages; 
	}
}
