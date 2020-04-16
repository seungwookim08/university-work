
package battleship;

//import Scanner and Random 
import java.util.Random;
import java.util.Scanner;
/**
 * Battleship class which contains methods
 * @version 1.0
 * Name(s) and ID(s) Seungwoo Kim, 40000230
 * COMP249
 * Assignment #      Assignment 1
 * Due Date  		September 22, 2017
 */

public class Battleship 
	{	
	/**
	 *  Scanner for user to have keyboard input and Random to create random position for computer.
	 */
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	
	/**
	 *  These final variables are used as constant 
	 */
	final int SHIP_NUM =6;
	final int GRENADE_NUM =4;
	final int GRID_SIZE =8;
	
	/**
	 *  2 dimensional array of objects for grid which will use for a game board.
	 */
	private Grid[][] board = new Grid[GRID_SIZE][GRID_SIZE];
	
	/**
	 *  these variables are used to represent ship and grenade position. Please check stringToPosition method
	 */
	private String position;
	private int columnChar;
	private int rowInt;
		
	/**
	 *  These variables is used to count how many ship are left and checking if grenade was hit or not
	 *  Determine who's turn was it. if it's true, it's human's turn, otherwise, it's computer's turn. 
	 */
	private int humanShipleft=0;
	private int computerShipleft=0;
	private int humanTurnSkip = 0;
	private int computerTurnSkip = 0;
	private boolean humanTurnTrue = true;
		
	/**
	 *  Once game board is set, it will ask to user to put desired coordinate with player(); 
	 *  And it will generate computer's coordinate.
	 *  And it will begin the game.
	 */
	public Battleship()
	{
		/**
		 * Create Grid class in each place of empty array.
		 */
		for (int i=0; i<GRID_SIZE; i++)
			for (int j=0; j<GRID_SIZE; j++)
				board[i][j] = new Grid();
		
		player();
		computerPositionGenerate();
		launchingGame();		
	}

	/**
	 * Prompt user to enter input which desired coordinate. If user enter invalid input, it will start again.
	 * stringToPosition will verify if the length of String is 2 or not and if it's correct, it will convert to integer.
	 * verifyPosition will verify if each of Character and Integer was in range or not. 
	 * if all correct, they will be stored positionChar and positionInt and these will be a position in Array of Grid in its position.
	 */
	private void player()
	{
		System.out.println("WELCOME TO THE BATTLSHIP GAME!! \n");
		for (int i=0; i<(SHIP_NUM + GRENADE_NUM) ; )
		{			
			if (i<SHIP_NUM)
				System.out.print("Choose coordinate of your Ship #" + (i +1) + " : ");
			else
				System.out.print("Choose coordinate of your grenade #" + (i+1-SHIP_NUM) + " : ");
			String input = sc.nextLine();
			if(stringToPosition(input) == false || verifyPosition(columnChar,rowInt) == false)
				System.out.println("You put invalid coordinate. Range of coordinate is A to H and 1 to 8 Ex: A3 or G8");
			else if(board[columnChar][rowInt].isGridTaken()==true)
				System.out.println("Your input coordinate is already called or taken try again! ");
			else
			{
				if (i<SHIP_NUM)
				{
					board[columnChar][rowInt].gridSetting('s');
					// Character S represents human ship
					humanShipleft++;
				}
				else
					board[columnChar][rowInt].gridSetting('g');
					// Character G represents human ship
				i++;
				// int i will not increase unless entered position is good
			}			
		}		
		
	}
	
	/**
	 * Similar use of Player() but there is no keyboard input
	 * Takes random coordinates and it will locate if the place is not taken.
	 */
	private void computerPositionGenerate()
	{	
		for (int i=0; i<SHIP_NUM + GRENADE_NUM; )
		{
			int row = r.nextInt(GRID_SIZE);
			int column = r.nextInt(GRID_SIZE);
			if(board[column][row].isGridTaken()==false && i<SHIP_NUM)
			{				
				board[column][row].gridSetting('S');
				// character S represents computer ship
				computerShipleft++;
				i++;
			}
			else if(board[column][row].isGridTaken()==false && i>=SHIP_NUM)
			{
				board[column][row].gridSetting('G');
				// character G represents computer grenade
				i++;
			}					
		}
		System.out.println("\nComputer places his ships and grenades so we can play now! \n");
	}
			
	/**
	 * launchingGame method will launch a game and continue the game until there is no more ship is left for player or computer
	 * It will start from player's turn and continue to computer turn unless no one hit the grenade
	 * If someone hit the grenade, next turn will be skipped
	 * When the game is done, it will show the ending message with result board.
	 */
	private void launchingGame()
	{	
		while (true)
		{
			humanTurn();
			if (humanShipleft == 0 || computerShipleft ==0)
				break;
			if (computerTurnSkip>0)
			{
				humanTurnTrue = true;
				System.out.println("Computer's turn is skipped");
				computerTurnSkip--;
				humanTurn();
				if (humanShipleft == 0 || computerShipleft==0)
					break;
			}
			computerTurn();
			if (humanShipleft == 0 || computerShipleft==0 )
				break;
			if (humanTurnSkip >0)
			{
				humanTurnTrue = false;
				System.out.println("Your turn is skipped");
				humanTurnSkip--;
				computerTurn();
				if (humanShipleft == 0 ||computerShipleft==0)
					break;
			}
			// When there is no more ship for one of the player then, the while loop will be stopped			
		}
		if (humanShipleft == 0)
			System.out.println("Unfortunately, you lose. Try hard next time! ");
		if (computerShipleft==0)
			System.out.println("Congratulation, you win! ");
		printingResult();
	}	

	/**
	 * This method will change string to position of row and column
	 * Column is character in range between A to H so subtracting 'A' will get 0 to 7 range 
	 * Row is integer in range between 1 to 8 but it is value of character so subtracting '1' will get 0 to 7 range 
	 * @param input this input is what user entered
	 * @return boolean is returned. If entered string's length is incorrect, it will return false, otherwise it will return true
	 */
	private boolean stringToPosition(String input)
	{
		this.position = input.toUpperCase();
		if (position.length() != 2)
			return false;
		this.columnChar = position.charAt(0) - 'A';
		this.rowInt = position.charAt(1) - '1';
		return true;		
	}
	
	/**
	 * This method will verify if entered position was valid in range between 0 to 7
	 * @param column row of game board
	 * @param row column of game board
	 * @return Boolean is returned. If entered out of range, return false. Otherwise, it will return true
	 */
	private boolean verifyPosition(int column, int row)
	{		
		if (column < 0 || column > 7)
			return false;
		if (row <0 || row >7)
			return false;
		return true;
	}
	
	/**
	 * This method is used for player's turn. It will ask user to enter the position
	 * If it's invalid position, while loop will continue until valid position is entered.
	 * If valid position is entered, it will determine shooting result and show. 
	 * Once the turn is done, boolean humanTrueTurn becomes false.
	 */
	private void humanTurn()
	{
		while (true)
		{
			System.out.print("Your turn now. Enter where you want to shot :");
			String input = sc.nextLine();
			if(stringToPosition(input) == false || verifyPosition(columnChar,rowInt) == false)
				System.out.println("You put invalid coordinate. Range of coordinate is A to H and 1 to 8 "
						+ "Ex: A3 or G8");
			else
			{
				Shooting b = shoot(board[columnChar][rowInt]);
				shootResult (b,board[columnChar][rowInt]);
				printingWholeBoard();
				System.out.println("Your turn is done. ");
				humanTurnTrue = false;
				break;
			}
		}
	}	
	
	/**
	 * This method is for computer's turn and generate random position and determine shooting result and show. 
	 * Once the turn is done, boolean humanTrueTurn becomes false.
	 */
	private void computerTurn()
	{
		while (true)
		{
			int row = r.nextInt(GRID_SIZE);
			int column = r.nextInt(GRID_SIZE);
			System.out.println("Computer shoot the rocket to " + (char) (row + 'A') + "" + (column +1));
			Shooting b = shoot(board[row][column]);
			shootResult (b,board[row][column]);
			printingWholeBoard();
			humanTurnTrue = true;
			break;
		}		
	}	

	/**
	 * Show the entire board (only called position) during the game. Please also check method printGrid in Grid class 
	 */
	private void printingWholeBoard()
	{		
		for (int i=0;i<GRID_SIZE;i++)
		{
			System.out.print("\n\t\t");
			for (int j=0;j<GRID_SIZE;j++)
				board[j][i].printGrid();
		}
		System.out.println();
	}
	
	/**
	 * At the end of the game, it will show you where the ships and grenades located in a game board.
	 */
	private void printingResult()
	{
		for (int i=0;i<GRID_SIZE;i++)
		{
			System.out.print("\n\t\t");
			for (int j=0;j<GRID_SIZE;j++)
			{
				if (board[j][i].getTypeAndOwner() == '*')
					System.out.print("_ ");
				else 
					System.out.print(board[j][i].getTypeAndOwner()+" ");
			}
		}		
	}
	
	/**
	 * this enum will be used to classify the result of shooting.
	 */
	public enum Shooting
	{
		Ship,
		Grenade,
		Nothing,
		Called,		
	}
	
	/**
	 * This method will classify enumerated types case by case. 
	 * @param a grid which respends
	 * @return enum Shooting is returned by case
	 */
	private Shooting shoot(Grid a)
	{
		if (a.isGridCalled()==true)
			return Shooting.Called;
		if (a.isGridTaken()==false)
			return Shooting.Nothing;
		if (a.getTypeAndOwner() == 'S')
		{
			computerShipleft--;
			return Shooting.Ship;
		}
		if (a.getTypeAndOwner() =='s' )
		{
			humanShipleft--;
			return Shooting.Ship;
		}
		if (a.getTypeAndOwner() == 'G'|| a.getTypeAndOwner() == 'g')
			return Shooting.Grenade;
		return null;
	}
	
	/**
	 * @param a Grid a which respond 
	 * @param b Shooting emun actions by shoot result 
	 * Shooting result is classified from enumerated type.
	 */ 
	private void shootResult(Shooting b,Grid a)
	{
		switch (b)
		{
		case Nothing:	a.setGridCalled(true); a.setTypeAndOwner('*'); System.out.println("Nothing happened ");break;
		case Ship:	a.setGridCalled(true); System.out.println("Ship hit ");break;
		case Grenade:	a.setGridCalled(true); System.out.println("BOOM! the turn of the one who hit the grenade will be skipped ");
			if (humanTurnTrue == true) humanTurnSkip++; if (humanTurnTrue == false) computerTurnSkip ++; break;
		// If rocket falls on grenade position (whether it's computer or use, it doesn't matter), the one who hit the grenade will lose his/her turn.
		case Called: System.out.println("This place is already called! Nothing happens"); break;
		}
	}	
}