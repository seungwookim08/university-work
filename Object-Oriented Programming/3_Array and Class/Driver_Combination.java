
/*
 * Author - Seungwoo Kim
 * Date - Mar-25-2017
 * Purpose - Question 3 for Assignment 3 
 *			 Driver for the class and display the program. 			 
 */

public class Driver_Combination
{
	public static void main(String args[])
	{
		System.out.println("========================");
		System.out.println("Welcome to Kim's program");
		System.out.println("    Locksmith Program");
		System.out.println("========================");
		// welcome message
		
		CombinationLock lock1 = new CombinationLock(); // default constructor
		CombinationLock lock2 = new CombinationLock(13,7,11); // parameter constructor
		
		System.out.println("\nCombination for lock 1 is : " + lock1.toString());
		// display lock1 combination
		System.out.println("Combination for lock 2 is : " + lock2.toString());
		// display lock 2 combination
		// method used : constructors, toString()
		
		System.out.println("\n===>  Attempting to open lock 1");
		// alert that opening lock 1
		
		if (lock1.openLock(0, 0, 1))
			// giving a wrong combination
			System.out.println("Congratulation, you opened lock 1!");	
		else
			System.out.println("Sorry, the combination you supplied for lock 1 is incorrect");
		// lock1 cannot be opened because it is not the same combination. 
		// as instructed in question, first attempt is fail
		
		if (lock1.openLock(0, 0, 0))
			// giving a good combination
			System.out.println("Congratulation, you opened lock 1!");
		else
			System.out.println("Sorry, the combination you supplied for lock 1 is incorrect");
		// lock1 is opened because it is the same combination between actual parameter and formal parameter
		// as instructed in question, it is the correct combination
		
		// in both cases, since openLock is boolean method, I used if-else statement, when openlock is true, then, it will print success message
		// otherwise, it will print fail message.
		// method used : openLock()
		
		
		System.out.println("\n===>  Attempting to change the combination of lock 1");
		// alert that try to change the combination of lock1
		while (true)
		{
			if (lock1.isLockOpen())
				// verify if lock1 is opened or not, if it's opened returned value is true
			{
				System.out.println("You can't change the combination if the lock is open. Close the lock and try again");
				// when lock1 is opened, and we can't use setCombination method. 
				lock1.closeLock(true);
				// and close the lock because it was opened
			}
						
			else
				// since it's closed we can proceed setcombination method.
			{
				lock1.setCombination(3, 11, 7);
				System.out.println("Congratulations you successfully changed the combination of lock 1 to " + lock1.toString());break;
				// otherwise, since the lock is closed, then you can use setCombination and print out changed lock 
				// break the loop since new combination has been set  
			}		
		} 
		// method used : setCombination(),isLockOpen(), closeLock()	
		
		System.out.println("\n===>  Attempting to open lock 2");
		// alert that try to open lock 2
		
		if (lock2.openLock(13, 7, 10))
			// giving a wrong combination 
			System.out.println("Congratulations you opened lock 2");
			// if it's good combination, display that success message 
		
		else
			System.out.println(lock2.HowManyCorrect(13, 7, 10) + " of the numebers are correct. Try again.");
			// otherwise, display fail message with how many correct combination numbers exist. 
		
		if (lock2.openLock(13, 7, 11))
			// giving a good combination 
			System.out.println("Congratulations you opened lock 2");
			// // if it's good combination, display that success message  
		else
			System.out.println(lock2.HowManyCorrect(13, 7, 11) + " of the numebers are correct. Try again.");
		// otherwise, display fail message with how many correct combination numbers exist.
		// as instructed in question, first attempt to be failed to open and second attempt to be successed.
		// Method used : openLock(), howManyCorrect()
		
		System.out.println("\n===> Testing the two locks for equality");
		// now alert that testing two of locks are equal or not.
		
		System.out.println("Lock 1 combination is: " + lock1.toString());
		System.out.println("Lock 2 combination is: " + lock2.toString());
		// display current combination numbers of each lock 
		// using toString for the correct format
		
		if (lock1.equals(lock2))
			System.out.println("Combination of both locks is the same"); 
		else
			System.out.println("Combination of both locks is the NOT same");
		// verify if they are equal or not, if it's true, then gives message that they're same otherwise message with they're not the same
		
		System.out.print("Lock 1 is ");
		if (lock1.isLockOpen())
			System.out.println("open");
		else
			System.out.println("not open");
		// verify lock is is open or not and display that opened or not
		
		System.out.print("Lock 2 is ");
		if (lock2.isLockOpen())
			System.out.println("open");
		else
			System.out.println("not open");
		// verify lock is is open or not and display that opened or not
		
		
		lock1.setCombination(13, 7, 11);
		// set the lock1 for the same value as instructed in question and since lock1 is not opened, we can use setCombination method right away
		
		System.out.println("\nLock 1 combination is: " + lock1.toString());
		System.out.println("Lock 2 combination is: " + lock2.toString());
		// display current combination numbers of each lock 
		// using toString for the correct format
		
		if (lock1.equals(lock2))
			System.out.println("Combination of both locks is the same"); 
		else
			System.out.println("Combination of both locks is the NOT same");
		// verify if they are equal or not, if it's true, then gives message that they're same otherwise message with they're not the same
		
		System.out.print("Lock 1 is ");
		if (lock1.isLockOpen())
			System.out.println("open");
		else
			System.out.println("not open");
		// verify lock is is open or not and display that opened or not
		
		System.out.print("Lock 2 is ");
		if (lock2.isLockOpen())
			System.out.println("open");
		else
			System.out.println("not open");
		// verify lock is is open or not and display that opened or not
		// method used : equals(), isLockOpen (), setCombination()
		
		System.out.println("\nHope you are comfortable with the manipulation of objects after this!!!");
		System.out.println("And also, Thank you for using Kim's program. BYE!!!");
		// closing message 
		
	}
}
