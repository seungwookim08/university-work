// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
package book;

public class ChildrenBook extends Book{
	
	/**
	 * Attribute is private to have appropriated rights
	 */
	private int minAge;
	
	/**
	 * Default Constructor
	 */
	public ChildrenBook() 
	{	
		super();
		minAge =99;
	}
	
	/**
	 * Parameterized constructor
	 * @param t input t will be title and pass to the parent constructor
	 * @param p input p will be price and pass to the parent constructor
	 * @param n input n will be number of pages and pass to the parent constructor
	 * @param i input i will be ISBN and pass to the parent constructor
	 * @param y input y will be issue year and pass to the parent constructor
	 * @param a input a will be author's name and pass to the parent constructor
	 * @param m input m will be minimum age 
	 */
	public ChildrenBook(String t, double p, int n,long i, int y, String a, int m) 
	{	
		super(t,p,n,i,y,a);
		minAge =m;
	}
	
	/**
	 * Copy constructor
	 * Also, since we have access to parent attribute, we can simply call by attribute name.
	 * @param c input c is original object which will be copied
	 */
	public ChildrenBook(ChildrenBook c)
	{
		isbn = c.isbn;
		issueYear = c.issueYear;
		authorName = c.authorName;
		price = c.price;
		numOfPages = c.numOfPages;
		title = c.title;
		minAge=c.minAge;
	}
	
	// getter and setter
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return super.toString() + ". Minimum age for this children book is " + minAge + " years old.";
	}
	
	/**
	 * equals method. Since I have access to parent attributes, we can simply call by attributes name. 
	 * Doing null verifications inside equal methods method will protecting not having crash if the passed object is null.
	 */
	public boolean equals(Object o)
	{
		if (o==null || this.getClass() != o.getClass())
			return false;
		ChildrenBook c = (ChildrenBook) o;
		return (isbn == c.isbn && issueYear == c.issueYear&& authorName == c.authorName && numOfPages == c.numOfPages && price == c.price && title == c.title && minAge == c.minAge);
	}
}
