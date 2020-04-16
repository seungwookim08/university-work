// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
package paperpublication;

public class PaperPublication {
	
	/**
	 * Attributes are protected to have appropriated rights 
	 */	
	protected String title;
	protected double price;
	protected int numOfPages;
	

	/**
	 * Default Constructor.
	 */
	public PaperPublication() 
	{
		price = 25.00;
		numOfPages = 200;
		title = "Unknown";
	}

	/**
	 * Parameterized Constructor.
	 * @param t input t will be title
	 * @param p input p will be price
	 * @param n input n will be number of pages
	 */
	public PaperPublication(String t, double p, int n)
	{
		title = t;
		price = p;
		numOfPages = n;
	}
	
	/**
	 * Copy constructor
	 * @param p input p is original object which will be copied
	 */
	public PaperPublication(PaperPublication p)
	{
		title = p.title;
		price = p.price;
		numOfPages = p.numOfPages;		
	}
	
	// getter and setters 

	public void setPrice(double p)
	{
		price = p;
	}

	public void setNumOfPages(int np)
	{
		numOfPages = np;
	}
	
	public double getPrice()
	{
		return price;
	}

	public int getNumOfPages()
	{
		return numOfPages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * toString method
	 */
	public String toString()
	{
		return "\nThe object of type is "+ getClass().getSimpleName() + ". The name of title is " + title + " which costs $" + String.format("%.2f", price) + 
				" and there are " + numOfPages + " pages. " ; 
	}

	/**
	 * equals method
	 * Doing null verifications inside equal methods method will protecting not having crash if the passed object is null.
	 */
	public boolean equals(Object o)
	{
		if (o==null || this.getClass() != o.getClass())
			return false;
		PaperPublication p = (PaperPublication) o;
		return (price == p.price && numOfPages == p.numOfPages && title == p.title);
	}
	
	
} 

