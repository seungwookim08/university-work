// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
package book;
import paperpublication.*;
public class Book extends PaperPublication{

	/**
	 * Attributes are protected to have appropriated rights and it is indicated in question. 
	 */
	protected long isbn; 
	protected int issueYear;
	protected String authorName;

	/**
	 * Default Constructor.
	 */
	public Book() 
	{	
		super();
		isbn = 0000000;
		issueYear = 0;
		authorName = "Unknown";
	}
	
	/**
	 * Parameterized constructor
	 * @param t input t will be title and pass to the parent constructor
	 * @param p input p will be price and pass to the parent constructor
	 * @param n input n will be number of pages and pass to the parent constructor
	 * @param i input i will be ISBN 
	 * @param y input y will be issue year
	 * @param a input a will be author's name
	 */
	public Book(String t, double p, int n,long i, int y, String a)
	{
		super(t,p,n);		
		isbn = i;
		issueYear = y;
		authorName = a;
	}
	
	/**
	 * Copy constructor
	 * Also, since we have access to parent attribute, we can simply call by attributes name. 
	 * @param b input b is original object which will be copied
	 */
	public Book(Book b)
	{
		isbn = b.isbn;
		issueYear = b.issueYear;
		authorName = b.authorName;
		price = b.price;
		numOfPages = b.numOfPages;
		title = b.title;
	}


	// getters and setters
	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public int getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(int issueYear) {
		this.issueYear = issueYear;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	/**
	 * toString method
	 */
	public String toString()
	{
		return super.toString() +"\nThe author is " + authorName + " and issued in " + issueYear +". ISBN is " + String.format("%07d", isbn);
	}

	/**
	 * equals method. Since I have access to parent attributes, we can simply call by attributes name. 
	 * Doing null verifications inside equal methods method will protecting not having crash if the passed object is null.
	 */
	public boolean equals(Object o)
	{
		if (o==null || this.getClass() != o.getClass())
			return false;
		Book b = (Book) o;
		return (isbn == b.isbn && issueYear == b.issueYear&& authorName == b.authorName && numOfPages == b.numOfPages && price == b.price && title == b.title);
	}
}
