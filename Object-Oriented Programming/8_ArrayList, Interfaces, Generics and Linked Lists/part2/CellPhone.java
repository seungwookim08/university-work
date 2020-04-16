package part2;

import java.util.Scanner;

public class CellPhone {
	
	//4 attributes
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	// using it for clone method
	static Scanner kb = new Scanner(System.in);
	
	// parameterized constructor that accepts for values 
	public CellPhone(long s, String b, double p,int y){
		serialNum = s;
		brand = b;
		year = y;
		price = p;
	}
	
	// it will copy except the serial number. serial number will be given.
	public CellPhone(CellPhone c, long v)
	{
		this(v,c.brand,c.price,c.year);
	}	
	
	// this clone method will be used to create new CellPhone object exception of serial number. serial number will be created by user. 
	// it might have duplication serial number but it will be handled in CellListUtilization (main method)
	public CellPhone clone(){		
		System.out.println("Please enter new serial number! :");
		long v = kb.nextLong();		
		return new CellPhone(this,v);
	}
	
	/**
	 * toString method will display a CellPhone object in terms of list form. Check showContents method as well.
	 * @return String of CellPhone
	 */
	public String toString(){
		return ( "[" +serialNum + " " + brand + " $" + price + " " + year +"]");
	}
	
	/**
	 * equals method will return if brand year and price are the same. otherwise return false ( not serial number) . 
	 * @return true if they are the same object of given attributes, otherwise false.
	 */
	public boolean equals(Object o){
		if (o==null || this.getClass()!=o.getClass())
			return false;
		CellPhone c = (CellPhone) o;
		return ((this.brand==c.brand) && (this.year == c.year) && (this.price == c.price));
	}
	
	// mutator and accessor. 
	public long getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}	



