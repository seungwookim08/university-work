// -----------------------------------------------------
// Assignment 2
// Part: 2
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
package book;

public class ChildrenBook extends Book{
	/**
	 * Attribute has same access right
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
	 * Also, since we do not have access to parent attribute, we must use setters to setting parent class attribute(Book and PaperPublication).
	 * @param c input c is original object which will be copied
	 */
	public ChildrenBook(ChildrenBook c)
	{
		setIsbn(c.getIsbn());
		setIssueYear(c.getIssueYear());
		setAuthorName(c.getAuthorName());
		setPrice(c.getPrice());
		setNumOfPages(c.getNumOfPages());
		setTitle(c.getTitle());
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
		return super.toString() + ". Minimum age for this book is " + minAge + " years old.";
	}
	
	/**
	 * equals method. Since I have no access to parent attributes I must use getters to get these attribute and comparing it. 
	 */
	public boolean equals(Object o)
	{
		if (o==null || this.getClass() != o.getClass())
			return false;
		ChildrenBook c = (ChildrenBook) o;
		return ((getIsbn() == c.getIsbn()) && (getIssueYear() == c.getIssueYear())&& (getAuthorName() == c.getAuthorName()) && 
				getNumOfPages() == c.getNumOfPages() && getPrice() == c.getPrice() && getTitle()==c.getTitle()&& minAge == c.minAge);
	}
}