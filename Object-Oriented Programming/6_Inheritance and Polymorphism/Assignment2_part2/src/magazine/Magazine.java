// -----------------------------------------------------
// Assignment 2
// Part: 2
// Written by: Seungwoo Kim, 40000230
// -----------------------------------------------------
package magazine;

public class Magazine extends paperpublication.PaperPublication{
	
	/**
	 * Enumerated type is public to have general access since it can be used generally such as in driver or other class. 
	 */
	public enum PaperQuality{
		High,
		Normal,
		Low,
	}
	
	/**
	 * Enumerated type is public to have general access since it can be used generally such as in driver or other class. 
	 */
	public enum IssueFrequency{
		Weekly,
		Monthly,
		Yearly,
	}
	
	/** 
	 * Attributes which hold enumerated type.
	 */
	private PaperQuality pq;
	private IssueFrequency ifr;
	
	/**
	 * Default Constructor
	 */
	public Magazine()
	{
		super();
		pq = PaperQuality.Low;
		ifr = IssueFrequency.Weekly;
	}
	
	/**
	 * Parameterized constructor
	 * @param t input t will be title and pass to the parent constructor
	 * @param p input p will be price and pass to the parent constructor
	 * @param n input n will be number of pages and pass to the parent constructor
	 * @param pq input pq will be quality of paper
	 * @param ifr input ifr will be issuing frequency
	 */
	public Magazine(String t, double p, int n,PaperQuality pq, IssueFrequency ifr)
	{
		super(t,p,n);
		this.pq = pq;
		this.ifr = ifr;		
	}
	
	/**
	 * Copy constructor
	 * Also, since we do not have access to parent attribute, we must use setters to setting parent class attribute(Book and PaperPublication).
	 * @param m input m is original object which will be copied
	 */
	public Magazine(Magazine m)
	{
		setPrice(m.getPrice());
		setNumOfPages(m.getNumOfPages());
		setTitle(m.getTitle());
		this.pq = m.pq;
		this.ifr = m.ifr;
	}

	// getters and setters
	public PaperQuality getPq() {
		return pq;
	}

	public void setPq(PaperQuality pq) {
		this.pq = pq;
	}

	public IssueFrequency getIfr() {
		return ifr;
	}

	public void setIfr(IssueFrequency ifr) {
		this.ifr = ifr;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return super.toString() + "\nThe quality of paper is " + pq + " and frequency of issue of this magazine is " + ifr;
	}
	
	/**
	 * equals method. Since I have no access to parent attributes I must use getters to get these attribute and comparing it. 
	 */
	public boolean equals(Object o)
	{
		if (o==null || this.getClass() != o.getClass())
			return false;
		Magazine m = (Magazine) o;
		return (this.ifr == m.ifr && this.pq == m.pq && 
				getNumOfPages() == m.getNumOfPages() && getPrice() == m.getPrice() && getTitle()==m.getTitle());
	}
}
