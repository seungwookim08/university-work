// -----------------------------------------------------
// Assignment 2
// Part: 2
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
package journal;

public class Journal extends paperpublication.PaperPublication{

	/**
	 * Attribute has same access right
	 */
	private int issueNum;
	private String specialField;
	
	/**
	 * Default Constructor
	 */
	public Journal()
	{
		super();
		issueNum = 0;
		specialField = "Unknwon";
	}
	
	/**
	 * Parameterized constructor
	 * @param t input t will be title and pass to the parent constructor
	 * @param p input p will be price and pass to the parent constructor
	 * @param n input n will be number of pages and pass to the parent constructor
	 * @param i input i will be issue number
	 * @param s input s will be speciality field
	 */
	public Journal(String t, double p, int n, int i, String s)
	{
		super(t,p,n);
		issueNum = i;
		specialField = s;
	}
	
	/**
	 * Copy constructor
	 * Also, since we do not have access to parent attribute, we must use setters to setting parent class attribute(Book and PaperPublication).
	 * @param j input j is original object which will be copied
	 */
	public Journal(Journal j)
	{
		setPrice(j.getPrice());
		setNumOfPages(j.getNumOfPages());
		setTitle(j.getTitle());
		issueNum = j.issueNum;
		specialField = j.specialField;
	}

	// getters and setters
	public int getIssueNum() {
		return issueNum;
	}

	public void setIssueNum(int issueNum) {
		this.issueNum = issueNum;
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
		return super.toString() + "\nThe issue numer is " + issueNum + ". And its speciality field is " + specialField + "."; 
	}
	
	/**
	 * equals method. Since I have no access to parent attributes I must use getters to get these attribute and comparing it. 
	 */
	public boolean equals(Object o)
	{
		if (o==null || this.getClass() != o.getClass())
			return false;
		Journal j = (Journal) o;
		return (issueNum == j.issueNum && specialField == j.specialField && getNumOfPages() == j.getNumOfPages() && getPrice() == j.getPrice() && getTitle() == j.getTitle());
	}
}
