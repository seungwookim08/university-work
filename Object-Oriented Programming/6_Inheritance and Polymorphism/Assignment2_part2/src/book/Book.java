// -----------------------------------------------------
// Assignment 2
// Part: 2
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
package book;

public class Book extends paperpublication.PaperPublication{

	/**
	 * Attributes have been changed to private since the question asks to have most restrictive access rights 
	 */
	private long isbn; 
	private int issueYear;
	private String authorName;

	/**
	 * Default Constructor.
	 */
	public Book() 
	{	
		super();
		isbn = 0000000;
		issueYear = 0;
		authorName = "";
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
	 * Also, since we do not have access to parent attribute, we must use setters to setting parent class attribute.
	 * @param b input b is original object which will be copied
	 */
	public Book(Book b)
	{
		isbn = b.isbn;
		issueYear = b.issueYear;
		authorName = b.authorName;
		setPrice(b.getPrice());
		setNumOfPages(b.getNumOfPages());
		setTitle(b.getTitle());			
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
		return super.toString() +
				"\nThe author is " + authorName + " and issued in " + issueYear +". ISBN is " + String.format("%07d", isbn);
	}

	/**
	 * equals method. Since I have no access to parent attributes I must use getters to get these attribute and comparing it.
	 */
	public boolean equals(Object o)
	{
		if (o==null || this.getClass() != o.getClass())
			return false;
		Book b = (Book) o;
		return ((isbn == b.isbn) && (issueYear == b.issueYear)&& (authorName.equalsIgnoreCase(b.authorName)) && getNumOfPages() == b.getNumOfPages() && getPrice() == b.getPrice() && getTitle()==b.getTitle());
	}
}
