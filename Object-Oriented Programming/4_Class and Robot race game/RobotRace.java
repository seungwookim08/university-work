
/*
 * Author - Seungwoo Kim
 * Date - Apr-11-2017
 * Purpose - Second question of Assignment 4 
 *			 Driver to show the robot race (user determine the numbers of robots and their names) 			 
 */

import java.util.Scanner;

public class RobotRace 
{
	
	
	public static void main(String args[])
	{
		header();
		Scanner sc = new Scanner(System.in);
		// Scanner system in for main
		
		int turns = 0;
		// variable turns using for how many turns(rounds) it will take 
		int steps;
		// int variable steps using for randomly generated steps(see below source code)
		
		int size = Assignment_4_Q_1_TestingDriver.gridSize();
		// as mentioned in the question, make use static method that used in Question 1's driver
		
		int numberOfRobots = readNumberOfRobots();
		// using this method to determine the number of robots
		
		Robot[] arrayOfRobots = robotNamesDeclare(numberOfRobots);
		// using this method for construct each object in arrays 
		char tempDir;
		// char tempDir is using for checking if the direction is changed 
		boolean a = false;
		// a is using if there is a winning robot or not
		while (a == false)
		{
			turns++;
			// since turns is 0, starting with ++ and it will start from 1st round
			System.out.println("\nMove number " + turns);
			System.out.println("=================");
			// display which round it is
			for (int i=0; i<numberOfRobots; i++)
			{
				tempDir = arrayOfRobots[i].getDirection();
				// get Direction value for checking if the direction is changed 
				
				steps = Robot.randomSteps(size);
				// get the randomly generated steps 
				
				System.out.println(" * " + arrayOfRobots[i].toString() + " and need to take " + steps + " steps");
				// display how many steps the robot will take.
				
				arrayOfRobots[i].move(steps, size);
				// move the robot and display the robot's location after move.
				if (tempDir != arrayOfRobots[i].getDirection())
					System.out.println(" New direction : " + arrayOfRobots[i].getDirection());
					// if it changed, then display new direction
				
				System.out.println(" Result : " + arrayOfRobots[i].toString());
				// display the result of move
				if (arrayOfRobots[i].won(size))
				{
					System.out.println("\n ==> It took " + turns + " rounds for " + arrayOfRobots[i].getName() + " to win the race!!"); 
					a = true;
					// if  there is a winner, the loop directly stops because the winner is declared (mention in question)
				}
				if (a==true)
					break;
				// since there is a winner, for loop is break
										
			}
			// and since a == true, while loop will terminate as well 
			
		}
		
		
		System.out.println("\n Thank you for using Kim's program!");
		System.out.println(" Robot race is successfully done");
		// closing message
		sc.close();
		// scanner close
	}
	
	private static Scanner sc1;
	// Make private static Scanner for using Scanner in Method
	// check methodNumberOfRobots() method
	
	public static void header()
	{
		System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 =");
		System.out.println("= 0 \t\t\t\t\t  0 =");
		System.out.println("= 0 \t  Welcome to the Robot Race \t  0 =");
		System.out.println("= 0 \t\t\t\t\t  0 =");
		System.out.println("= 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 =\n");
	}
		
	public static int readNumberOfRobots()
	{
		sc1 = new Scanner(System.in);
		// instead of local variable, making field to avoid conflict. 
		
		int numberOfRobots;
		// variable numberOfRobots using for user input value 
		do
		{
			System.out.print("How many robots do you want to have (must be at least 1 robot for race) : ");
			numberOfRobots = sc1.nextInt();
			// read the value user input
		} while(numberOfRobots<1);
		// validating the number of robots, if it's less than 1, it cannot work and repeating to ask for user to enter good value 
		
		return numberOfRobots;
		//if the number of robot is good, then it will return the value that user input
				
	}
	// This static method is for reading and validating the number of robots
	
	public static Robot[] robotNamesDeclare(int numberOfRobots) 
	// that integer will determine the length of array of robot
	{
		sc1 = new Scanner(System.in);
		// instead of local variable, making field to avoid conflict. 
		
		Robot[] robotArray = new Robot[numberOfRobots];
		// the numberOfRobots that user enter 
		for (int i=0;i<robotArray.length;i++)
		{
			System.out.print("What is the name of robot " + (i+1) + " : ");
			String robotName = sc1.nextLine();
			robotArray[i] = new Robot(robotName);
		}	
		return robotArray;
	}
	// setting-up and using of arrays of Robots
}
