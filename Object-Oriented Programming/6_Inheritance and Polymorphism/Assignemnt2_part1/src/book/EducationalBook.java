// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
package book;

public class EducationalBook extends Book{
	
	/**
	 * Attribute are private to have appropriated rights
	 */
	private int editionNum;
	private String specialField;
	
	/**
	 * Default Constructor
	 */
	public EducationalBook()
	{
		super();
		editionNum = 0;
		specialField = "Unknown";
	}
	
	/**
	 * Parameterized constructor
	 * @param t input t will be title and pass to the parent constructor
	 * @param p input p will be price and pass to the parent constructor
	 * @param n input n will be number of pages and pass to the parent constructor
	 * @param i input i will be ISBN and pass to the parent constructor
	 * @param y input y will be issue year and pass to the parent constructor
	 * @param a input a will be author's name and pass to the parent constructor
	 * @param e input e will be edition number
	 * @param s input s will be speciality field 
	 */
	public EducationalBook(String t, double p, int n,long i, int y, String a, int e, String s)
	{
		super(t,p,n,i,y,a);
		editionNum = e;
		specialField = s;
	}
	
	/**
	 * Copy constructor
	 * Also, since we have access to parent attribute, we can simply call by attribute name.
	 * @param e input e is original object which will be copied
	 */
	public EducationalBook(EducationalBook e)
	{
		isbn = e.isbn;
		issueYear = e.issueYear;
		authorName = e.authorName;
		price = e.price;
		numOfPages = e.numOfPages;
		title = e.title;
		editionNum = e.editionNum;
		specialField = e.specialField;
	}
	
	// getters and setters
	public int getEditionNum() {
		return editionNum;
	}

	public void setEditionNum(int editionNum) {
		this.editionNum = editionNum;
	}

	public String getSpecialField() {
		return specialField;
	}

	public void setSpecialField(String specialField) {
		this.specialField = specialField;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return super.toString()	+ ". Edition Number is " + editionNum + " and its speciality field is " + specialField;
	
	}
	
	/**
	 * equals method. Since I have access to parent attributes, we can simply call by attributes name. 
	 * Doing null verifications inside equal methods method will protecting not having crash if the passed object is null.
	 */
	public boolean equals(Object o)
	{
		if (o==null || this.getClass() != o.getClass())
			return false;
		EducationalBook e = (EducationalBook) o;
		return (isbn == e.isbn && issueYear == e.issueYear&& authorName == e.authorName && numOfPages == e.numOfPages && price == e.price && title == e.title
				&& editionNum == e.editionNum && specialField == e.specialField);
	}
}
