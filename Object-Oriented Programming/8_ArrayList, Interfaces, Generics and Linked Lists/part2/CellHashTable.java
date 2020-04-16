package part2;

public class CellHashTable
{
	// In class, professor suggests to use hash table for efficiency of searching for assignment 4 even though it was not written in question.
	
	// Attributes 
	private CellList[] hashArr;
	private static final int SIZE = 10;
	
	// This constructor make size 10. And each index has new CellList (which is empty at default)
	public CellHashTable()
	{
		hashArr = new CellList[SIZE];	
		for (int i = 0; i < hashArr.length; i++)
			hashArr[i] = new CellList();
	}
	
	/**
	 * this method will compute the serial number to be organized hash value (which is reminder of serial)
	 * @param serial	computing this serial
	 * @return	return computed serial
	 */
	private int computeHash(long serial)
	{
		int hashValue = (int) serial%SIZE;
		return hashValue;
	}
	
	/**
	 * Check if this serial contains or not in hash table
	 * @param serial	searched serial
	 * @return	return true if it contains else, return false. The method is derived from CellList
	 */
	public boolean containsCell(long serial)
	{
		int hashValue = computeHash(serial);
		
		CellList mlst = hashArr[hashValue];
		
		if(mlst.contains(serial))
			return true;
		return false;
	}
	
	/**
	 * Adding to hash. We don't need any other method since it is just simple hash table method. 
	 * for duplication, it is handled in CellListUtilization. 
	 * @param cp	given CellPhone to be added.
	 */
	public void addToHash(CellPhone cp)
	{
		int hashValue = computeHash(cp.getSerialNum());
		CellList mlst = hashArr[hashValue];
		hashArr[hashValue].addToStart(cp);		
	}
	
	/**
	 * This method calls showContentOfCellPhone method in CellList and if we found serial, it will return true.
	 * That method will print toString of CellPhone and to avoid privacy leaking, this is called in CellList not CellHashTable
	 * @param serial searched serial
	 * @return	if we found, return true, otherwise, return false.
	 */
	public boolean showHashObject(long serial){
		int hashValue = computeHash(serial);
		CellList mlst = hashArr[hashValue];
		if (mlst.showContentOfCellPhone(serial) == false)
			return false;
		else
			return true;
	}
	
}
