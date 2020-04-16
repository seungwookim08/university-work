/**
 * Grid object to be used in the 2 dimension array in Battleship class
 * @version 1.0
 * Name(s) and ID(s) Seungwoo Kim, 40000230
 * COMP249
 * Assignment #      Assignment 1
 * Due Date  		September 22, 2017
 */

package battleship;

public class Grid {
	
	/**
	 *  I simplify type and owner in one variable. And it will directly show on board. 
	 *  gridTaken and gridCalled are boolean used to check if grid is taken or already called
	 */
	private char typeAndOwner;
	private boolean gridTaken;
	private boolean gridCalled;
	
	/**
	 * default constructor, when Battleship makes board.
	 * default type is _ since it will print directly)
	 */
	public Grid()
	{
		typeAndOwner = '_';
		gridTaken = false;
		gridCalled = false;
	}  
	
	/**
	 * This method will be used to set grid up with setting typeAndOwner
	 * @param type is type entered from Battleship class and it will set up character typeAndOwner 
	 */
	public void gridSetting(char type)
	{
		if(gridTaken == false)
		{
			typeAndOwner = type;
			gridTaken = true;
		}
	}
	
	/**
	 * If the owner is Computer which is C then, it will print like nothing on grid " _ "
	 * Otherwise, it will simply print it's type determined.
	 */
	public void printGrid()
	{
		if (gridCalled == false)
			System.out.print("_ ");
		else
			System.out.print(typeAndOwner + " ");
	}
	
	// Accessor and Mutator (which are necessary)
	
	public char getTypeAndOwner() {
		return typeAndOwner;
	}
	
	public void setTypeAndOwner(char typeAndOwner) {
		this.typeAndOwner = typeAndOwner;
	}

	public boolean isGridTaken() {
		return gridTaken;
	}	

	public void setGridCalled(boolean gridCalled) {
		this.gridCalled = gridCalled;
	}

	public boolean isGridCalled() {
		return gridCalled;
	}
	
	/**
	 *  In case to know what type is it on selected grid.
	 * @return String is returned to indicate type of selected grid.
	 */
	public String whatType()
	{
		if (typeAndOwner == 's' || typeAndOwner == 'S')
			return "The type of element at this position is Ship";
		if (typeAndOwner == 'g' || typeAndOwner == 'G')
			return "The type of element at this position is Grenade";
		if (typeAndOwner == '_')
			return "At this position, there is nothing and it has never been called during the game";
		if (typeAndOwner == '*')
			return "At this position, there is nothing and it has already been called";
		return null;
	}
	
	/**
	 *  in case to know who is the owner on selected grid.
	 * @return String is returned to indicate the owner of selected grid
	 */
	public String whosOwner()
	{
		if (typeAndOwner == 's' || typeAndOwner == 'g')
			return "The owner of this grid is Human";
		if (typeAndOwner == 'S' || typeAndOwner == 'G')
			return "The owner of this grid is Computer";
		if (typeAndOwner == '_' || typeAndOwner == '*')
			return "There is nothing so no one is owner of this grid";
		return null;
	}
	
	/**
	 *  toString method
	 */
	public String toString()
	{
		return whatType() + whosOwner();
	}
}