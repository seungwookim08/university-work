/*
 * Author - Seungwoo Kim
 * Date - Apr-11-2017
 * Purpose - Class Robot for Assignment 4 
 *			 Using this class for TestingDriver and RobotRace drivers. 			 
 */

public class Robot 
{
	
	private String name;
	private int x;
	private int y;
	private char direction;
	// 4 private instances variables (name, x, y, direction)
	
	public Robot() 
	{
		name = "noName";
		direction = 'E';
		x = 0;
		y = 0;
		// default constructor
	}
	

	public Robot(String name)
	{
		this.name = name;
		direction = 'E';
		x = 0;
		y = 0;
		// 1 parameter (which is robot's name) constructor 
	}
	
	public Robot(Robot a)
	{
		this.name = a.getName();
		this.direction = a.getDirection();
		this.x = a.getX();
		this.y = a.getY();
		// copy constructor 
	}

	public String getName() {
		return name;
		// Accessor method for name
	}

	public int getX() {
		return x;
		// Accessor method for x
	}

	public int getY() {
		return y;
		// accessor method for y
	}

	public char getDirection() {
		return direction;
		// accessor method for direction
	}
	

	public void setName(String name) {
		this.name = name;
		// mutator method (only need for name, no other mutator method needed) 
	}
	
	public String toString()
	{
		return (getName() + " is facing " + getDirection()  +" and at position ("+ getX() +"," + getY() +")");
		// return robot's information with format given
	}
	
	public boolean equals(Robot compare)
	{
		return (this.direction == compare.direction && this.x == compare.x && this.y == compare.y);
		// comparing their content (not an object itself), in question, it's mentioning only x,y(position) and direction
	}
	
	public void changeDirection(char direction)
	{
		if (direction == 'E')
			this.direction = 'N';
		else if (direction == 'W')
			this.direction = 'S';
		else if (direction == 'N')
			this.direction = 'W';
		else if (direction == 'S')
			this.direction = 'E';
		// simply, changing its direction as given in the document of question. 
		
	}
	
	public void move(int steps, int size)
	{
		// steps is randomly generate from driver (check below of this source code and driver)
		// int size is size of grid
		if (direction == 'E' && (size >= steps + x))
		{
			x = x + steps;
			steps = 0;
		}
		else if (direction == 'E' && (size < steps + x))
		{
			steps = x - size + steps;
			x = size;
			changeDirection(direction);
			y = steps;
		}
		// if direction is E, and if position x + steps doesn't exceed size, it simply position x = x+steps
		// if position x + steps exceed its size, then position x becomes its grid size
		// and least steps will go to y(because y = 0 when direction is E), calculate steps x-size and add steps(because x will be its size)  
		
		else if (direction == 'W' && (0 <= x - steps))
		{
			x = x - steps;
			steps = 0;
		}
		else if (direction == 'W' && (0 > x - steps))
		{
			steps = steps - x;
			x = 0;
			changeDirection(direction);
			y = size - steps;
		}
		// similarly, when the direction is W, and if x-steps are 0 or bigger than 0, then, the position x = x - steps
		// if not, then, x = 0, and steps will be steps - its x position(because x became 0) and
		// y is its size - steps(because when direction is W, its y value is maximum(size of grid))
		
		else if (direction == 'N' && (size >= steps + y))
		{
			y = y + steps;
			steps = 0;
		}
		else if (direction == 'N' && (size < steps + y))
		{
			steps = y - size + steps;
			y = size;
			changeDirection(direction);
			x = size - steps;
		}
		// it has same concept when the direction is E, just x become y and y become x  
			
		else if (direction == 'S' && (0 <= y - steps))
		{
			y = y - steps;
			steps = 0;
		}
		else if (direction == 'S' && (0 > y - steps))
		{
			steps = steps - y;
			y = 0;
			changeDirection(direction);
			x = steps;
		}
		// it has same concept when the direction is W, just x become y and y become x
			
			
	}
	public boolean won(int size)
	{
		// it should reach top right corner to win, whose position is (grid size, grid size)
		if (size == x && size == y )
			return true;
		else
			return false;
		// so if both x and y reaches at the top corner (position is (grid size, grid size), it returns true
		// else it return false
		
	}
	
	public static int randomSteps(int size)
	{
		// method using for generate random steps to take
		return (int)(Math.random() * size) + 1;
		// Math.random() will generate the value from 0 to less than 1 and multiply by size + 1 will be
		// the range of steps (it should be 1 to and the maximum size of grid(which is N))
	}

}
