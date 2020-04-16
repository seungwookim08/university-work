// -----------------------------------------------------
// Assignment 2
// Part: 2
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
package book;

public class EducationalBook extends Book{
	
	/**
	 * Attribute has same access right
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
	 * Also, since we do not have access to parent attribute, we must use setters to setting parent class attribute(Book and PaperPublication).
	 * @param e input e is original object which will be copied
	 */
	public EducationalBook(EducationalBook e)
	{	
		setIsbn(e.getIsbn());
		setIssueYear(e.getIssueYear());
		setAuthorName(e.getAuthorName());
		setPrice(e.getPrice());
		setNumOfPages(e.getNumOfPages());
		setTitle(e.getTitle());
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
	 * equals method. Since I have no access to parent attributes I must use getters to get these attribute and comparing it. 
	 */
	public boolean equals(Object o)
	{
		if (o==null || this.getClass() != o.getClass())
			return false;
		EducationalBook e = (EducationalBook) o;
		return ((getIsbn() == e.getIsbn()) && (getIssueYear() == e.getIssueYear())&& (getAuthorName() == e.getAuthorName()) && getTitle()==e.getTitle()
			&& getNumOfPages() == e.getNumOfPages() && getPrice() == e.getPrice() && editionNum == e.editionNum && specialField == e.specialField);
	}
}
