
/*
 * Author - Seungwoo Kim
 * Date - Mar-25-2017
 * Purpose - Class Question 3 for Assignment 3 
 *			 Make a class for driver(Assignment_3_Q_3_Driver) and define combinationLock class 			 
 */
public class CombinationLock 
{

	private int num1;
	private int num2;
	private int num3;
	// declare instance variables
	// 3 combination numbers, num1 is first combination number, num 2 is second combination number and num 3 is third combination number
	
	private boolean open;
	// boolean, if it's true, it's opened. if not, it's closed(not opened = false)
		
	public CombinationLock()
	{
		num1 =0; num2 =0 ;num3=0;
		open = false;
	}
	// default constructor set all numbers to zero and marks the lock as closed
	
	public CombinationLock(int num1, int num2, int num3)
	{
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.open = true;
	}
	//Three parameter constructor. All numbers will set as passed integers and lock as opened. this. for actual parameter and formal parameter
	
	public boolean setCombination(int num1, int num2, int num3)
	// boolean mutator setCombination 
	{
		if (open)
		{
			return false;
		}
		// when the lock is open, it will return false
		else
			this.num1 = num1;
			this.num2 = num2;
			this.num3 = num3;
			
		return true;
		// otherwise, set the num1, num2 and num3 
		// this. for actual parameter and formal parameter
	}
	
	public void closeLock(boolean open)
	{
		this.open = !open; 
		// when closeLock is true, open should be false to be closed so it's opposite. 
		// this. for actual parameter and formal parameter
	}
	
	public boolean isLockOpen()
	{
		if (open) 
			return true;
		// if lock is open, isLockOpen will return true
		else
			return false;
		// otherwise it will return false
	}
	
	public boolean openLock(int num1, int num2, int num3)
	{
		if (num1 == this.num1 && num2 == this.num2 && num3 == this.num3)
		{
			open = true;
			return true;
			// if each of all actual parameter and formal parameter is the same, then the lock will open, so it will return true
		}
		else
		{			
			return false;
		}
		// otherwise, return false
	}
	
	public int HowManyCorrect(int num1, int num2, int num3)
	{
		int sum = 0;
		if (this.num1==num1)
			sum += 1;
		if (this.num2==num2)
			sum += 1;
		if (this.num3==num3)
			sum += 1;
		return sum;
		
		// simply, just checking actual parameter and formal parameter are same 
		// and if they are same, then value of sum will be increased 
		// like it if there's 1 correct, then sum will be 1, 2 correct ones, then, sum will be 2.
		// and return value of sum
		
		
	}
	public String toString()
	{
		
		return ("Clockwise " + num1 + " - Counter-Clockwise "+ num2 + " - "+ "Clockwise "+ num3);
		// using the following format Clockwise - num1, and counter-clockwise + num2 and clockwise num3 
		
	}
	
	public boolean equals(CombinationLock compare )
	{
		return (this.num1==compare.num1 && this.num2==compare.num2 && this.num3 == compare.num3);
		// if all of them are equal, then, it will return true, otherwise, it return give false(which means it is not exactly equal)
	}
	

}
