
/*
 * Author - Seungwoo Kim
 * Date - Apr-11-2017
 * Purpose - First question of Assignment 4 
 *			 include 3 static methods and driver to test Class robot			 
 */

import java.util.Scanner;

public class RobotWalk 
{
	
	public static void main(String args[])
	{
		header();
		// using static method for header
		
		Scanner sc = new Scanner(System.in);
		// scanner system in for name of robot
		
		int turns = 0; // variable turns for how many turns robot has taken
			
		System.out.println("\nWhat is the name of your robot?");
		String robotName = sc.nextLine();
		// Ask user to enter the name of robot
		
		int size = gridSize();
		// variable size is for the size of grid, size will be the return value of gridSize 
		
		int steps;
		// int steps are using for the moves that robot will take 
		
		char tempDir;
		// using for checking if direction has changed or not
		Robot robot1 = new Robot(robotName);
		// object for robot1 using with class Robot that I created. 
		
		System.out.println("\n\nTime for " + robotName + " to start walking!!" );
		// Print out alert message for the start, using variable robotName to specify the name of robot
		
		System.out.println("At start " + robot1.toString());
		// toString() will tell the start of robot located
		
		while (robot1.won(size) == false)
		{
			// the loop will keep continuing until the robot is winning 
			steps = Robot.randomSteps(size);
			// using randomSteps method for determine how many steps robot will take randomly
			
			System.out.println("==> number of steps to take " + steps);
			// print out that how many steps robot takes
			tempDir = robot1.getDirection();
			// get Direction value for checking if the direction is changed
			robot1.move(steps, size);
			// using move method for robot to move in grid. Checking Robot class for specific information.
			
			if (tempDir != robot1.getDirection())
				System.out.println("New direction : " + robot1.getDirection());
			// if direction is changed, then display new direction
			
			System.out.println(" Result : " + robot1.toString());
			// display the result
			turns++;
			// store how many turns(rounds) are.
			
		}
		
		
		closing(robot1.getName(), turns);
		// using closing static method for display closing message (with 2 parameter)
		sc.close();
		// scanner close
	}
	
	private static Scanner sc2;
	// Make private static Scanner for using Scanner in Method
	// check gridSize() method
	
	public static void header()
	{
		System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 =");
		System.out.println("= 0 \t\t\t  0 =");
		System.out.println("= 0 \t  Robot Walk \t  0 =");
		System.out.println("= 0 \t\t\t  0 =");
		System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 =");
	}
	// first static method for displaying header
	
	public static int gridSize()
	{
		sc2 = new Scanner(System.in);
		// instead of local variable, making field to avoid conflict. 
		
		int size;
		// variable size is for size of grid		
		do
		{
		System.out.print("What is the size of your grid? (must be at least 2) : ");
		size = sc2.nextInt();
		} while(size<2);
		// if it's less than 2, it will not work so using do, while loop 
		
		
		return size; // return the value that user entered
		
	}
	// second static method which prompts the user for the size of grid, read it and return(question asked only for the size of grid).
	
	public static void closing(String robotName,int turns)
	{		
		System.out.println("\n" + robotName + " reached its final destination in " + turns + " moves");
		System.out.println("Thank you for using Kim's program!");
		// last static method which display closing message
		// include two parameters which assigned in driver and as instructed in question 
		// and print out closing message
	}
	
	
}
