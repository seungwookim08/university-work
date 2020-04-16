package part2;

import java.util.NoSuchElementException;

public class CellList {
	
	// inner class called CellNode.
	private class CellNode{
		
		// CellPhone pointer and CellNode object
		private CellPhone v;
		private CellNode next;
		
		// Defult constructor becomes null
		private CellNode(){
			v = null;
			next = null;
		}
		
		// Parameterized constructor which accepts CellPhone and CellNode
		private CellNode(CellPhone cp, CellNode cn){
			this.v = cp;
			this.next = cn;
		}
		
		// Copy constructor
		private CellNode(CellNode c){
			v = c.v;
			next = c.next;
		}
		
		
		// Clone method 
		protected CellNode clone()
		{
			return new CellNode(this);
		}
		
		// mutator and accessor methods 
		private CellPhone getCp() {
			return v;
		}

		private void setCp(CellPhone cp) {
			this.v = cp;
		}

		private CellNode getCn() {
			return next;
		}

		private void setCn(CellNode cn) {
			this.next = cn;
		}
	}
	
	// CellNode head which point to the first node and size which shows how many nodes are there.
	private CellNode head;
	private int size;
	
	// Default constructor which creates empty list 
	public CellList(){
		head = null;
		size = 0;
	}
	
	
	// Copy constructor which accepts a CellList object and creates a copy of it. 
	// Note that shallow copy is not allowed.
	public CellList(CellList cl){
		if (cl.head == null) {
            head = null;
            size = 0;
        } else {
        	// note that CellNode  has its own clone method which will create new copy of it (deep copy) 
            this.head = cl.head.clone();
            CellNode originalNode = cl.head;
            CellNode newNode = this.head;
            while (originalNode.next != null) {
                newNode.next = originalNode.next.clone();
                originalNode = originalNode.next;
                newNode = newNode.next;
            }
            size = cl.size;
        }
	}
	
	/**
	 * Creates a node with that passed object and inserts this node at the head of the list
	 * @param cp	CellPhone class which will be added in list
	 */
	public void addToStart(CellPhone cp){
		head = new CellNode(cp,head);
		size++;
	}
	
	/**
	 * If index is valid, it will find the right index and insert CellPhone in list. Otherwise, throw NoSuchElementException
	 * Note that the last index is size-1. However, insert means push the located index to index +1 and insert Object in index. 
	 * That means that since the last index is not null, we are not able to add last of list; however, it is not required in question so I let it like that.
	 * Plus, the question clearly indicates "a valid index must have a value between 0 and size-1".
	 * @param cp	CellPhone Object to be inserted
	 * @param index	index which indicate where to insert
	 * @throws NoSuchElementException	Any invalid case will throw NoSuchElementException.
	 */
	public void insertAtIndex(CellPhone cp, int index) throws NoSuchElementException{
		if (index <0 || index >(size-1) || cp == null)
				throw new NoSuchElementException();
		if (index == 0)
			addToStart(cp);
		else
		{
			CellNode t = head;
			for (int i =0;i<index-1;i++)
				t = t.next;
			t.next = new CellNode(cp, t.next);
			size++;
		}		
	}			
	
	/**
	 * Simply delete from the index
	 * @param index	which will be deleted index
	 * @throws NoSuchElementException	Any invalid case will throw NoSuchElementException.
	 */
	public void deleteFromIndex(int index) throws NoSuchElementException{
		if (index <0 || index >(size-1))
			throw new NoSuchElementException();
		if (index == 0)
		{
			deleteFromStart();
		}
		else
		{			
			CellNode t = head;
	        for (int i = 0; i < index - 1; i++) {
	            t = t.next;
	        }
	        t.next = t.next.next;
	        size--;
		}
	}
	
	/**
	 * Simply delete from the start (unless head is not null. if head is null, does nothing)
	 */
	public void deleteFromStart(){
		if (head == null) {
            return;
        }
        head = head.next;
        size--;
	}
	
	/**
	 * If index is not valid, does nothing (simply return); otherwise, replace entered index and replace with entered CellPhone 
	 * @param cp	this object will replace
	 * @param index	that index will be replaced.
	 */
	public void replaceAtIndex(CellPhone cp, int index){
		if (index < 0 || index >= size || (index ==0 && head == null))
			return;
		CellNode t = head;
		for (int i = 0; i < index; i++) {
		    t = t.next;
		}
		t.v = cp;
	}
	
	/**
	 * If entered serial is found, it will return pointer of that node; otherwise, it will return null. Should call how many iterations were made as well.
	 * Privacy leak can occur. To avoid privacy leak, make it inner class in private which makes unreachable (which I have done).
	 * Other solution is that since we use them inside of class as used method will not return this reference. Then privacy leaking is forbidden as well.
	 * @param serial	finding a serial number in that place
	 * @return	return the CellNode. note that CellNode is cloned version one.
	 */
	public CellNode find(long serial){
		 int ctr = 1;
		CellNode n = head;
		while (n != null && n.v.getSerialNum() != serial) 
		{
			n = n.next;
		    ctr++;
		}
		if (ctr == 1)
			System.out.println(ctr + " iteration was made.");
		else
			System.out.println(ctr + " iterations were made.");
		if (n == null) 
		    return null;
		return n.clone();
		 
	}
	
	/**
	 * tells you if this serial is contained or not using with find method.
	 * @param serial	searched serial
	 * @return	return true if it contains, otherwise return false.
	 */
	public boolean contains(long serial){
		if (find(serial) == null)
			return false;
		return true;
	}
	
	/**
	 * Show the content of the list. At the end it will print X
	 */
	public void showContents(){
		CellNode t = head;
		int ctr = 0;
		while (t!=null){
			System.out.print(t.v + " ---> ");
			t = t.next;
			ctr++;
			if (ctr%5==0)
				System.out.println();
			
		}
		System.out.println("X");
	}
	
	/**
	 * This method does not have any privacy leaking since it returns boolean only and made sure t becomes null (if it returns CellPhone, we have to consider)
	 * @param serial	showing the content of wanted serial number.
	 * @return 	like contains, it will return true if it finds, otherwise, return false.
	 */
	public boolean showContentOfCellPhone(long serial){
		CellNode t = find(serial);
		if(t == null)
			return false;
		System.out.println(t.getCp());
		t = null;
		return true;
	}
	
	/**
	 * the list is the same while the list order is the same and the content (CellPhone) is also the same. 
	 * @param cl 	compared CellList
	 * @return	return false if anyone list is not equal; otherwise return true. 
	 */
	public boolean equals(CellList cl){
		if (cl == null) {
            return false;
        }
        if (this.size != cl.size) {
            return false;
        }
        CellNode n1 = head;
        CellNode n2 = cl.head;
        while (n1 != null) {
            if (!n1.v.equals(n2.v)) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
	}
	
	/**
	 * Simply tells the size of list
	 * @return	size of list
	 */
	public int getSize(){
		return size;
	}
}
