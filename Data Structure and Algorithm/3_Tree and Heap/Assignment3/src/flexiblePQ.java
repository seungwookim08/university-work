
public class flexiblePQ <K,V>{
	// 2 attributes to keep either max or min priority queue and 
	// the data (key and value) will stored in ARRAY (in question, I'm only allowed to use array)
	private String comparator;
	private Entry<K,V>[] pqArr;
	
	// Constructor, no default and copy constructor is needed (Extandable array is dealt in another function) 
	public flexiblePQ(String comp) {
		pqArr = new Entry[0];
		comparator = comp.toLowerCase();
	}
	
	// remove function. There are also private swap, newArr, downheap function used. 
	public Entry<K,V> remove(){
		if (isEmpty())
			return null;
		else {
			Entry<K,V> temp = pqArr[0];
			swap(0, this.size()-1);
			pqArr = newArr(-1);
			downheap(0);
			return temp;			
		}
			
	}
	
	// insert function. There are also private newArr, upheap function used. 
	public void insert(K key, V value) {
		Entry<K,V> newEntry = new Entry<>(key,value);
		pqArr = newArr(1);
		pqArr[this.size()-1] = newEntry;
		upheap(this.size()-1);		
	}
	
	// Simply shows what is stored in the root
	public Entry<K,V> top() {
		if (isEmpty())
			return null;
		else
			return pqArr[0];
	}
	
	// If current state is min, it changes to max; otherwise, it changes to min
	public void toogle() {
		if (comparator.equals("min"))
			switchToMax();
		else
			switchToMin();
	}
	
	// So, upheap from 
	// At the end, getting the array which reconstructed and set the comparator to min. 
	// If it's not the case (i.e. if current state is min), nothing will change.
	public void switchToMin() {
		if (!comparator.equals("min")) {
			comparator = "min";
			for (int i = 0; i<size(); i++) {
				upheap(i);
			}			
			System.out.println("It has been transformmed to min-priority queue");
		}
		else
			System.out.println("Current state is " + this.state() + " so switchToMin() will leave unchanged");
	}
	
	// Same as switchToMin, create another flexiblePQ and insert (and remove) all values in original flexible PQ. 
	// At the end, getting the array which reconstructed and set the comparator to max. 
	// If it's not the case (i.e. if current state is max), nothing will change.
	public void switchToMax() {
		if (!comparator.equals("max")) {
			comparator = "max";
			for (int i = 0; i<size(); i++) {
				upheap(i);
			}		
			System.out.println("It has been transformmed to max-priority queue");
		}
		else
			System.out.println("Current state is " + this.state() + " so switchToMax() will leave unchanged");
	}
	
	// Simply return comparator
	public String state() {
		return comparator;
	}
	
	// if size is zero, it means it is empty. 
	public boolean isEmpty() {
		if (this.size() == 0)
			return true;
		else
			return false;
	}
	
	// Basically, size is the length of array. 
	public int size() {
		return pqArr.length;
	}
	
	// swap function exchanges the location of Entry in array
	private void swap(int i, int j) {
		Entry<K,V> temp = pqArr[i];
		pqArr[i] = pqArr[j];
		pqArr[j] = temp;
	}
	
	// to reach parent node.
	private int parent(int i) {
		return (i-1)/2;
	}
	
	// to reach the left child of current node
	private int left(int i ) {
		return 2*i + 1;
	}
	
	// to reach the right child of current node
	private int right(int i ) {
		return 2*i + 2;
	}
	
	// to know if left child exists or not
	private boolean hasLeft(int i ) {
		return (left(i) < this.size());
	}
	
	// to know if right child exists or not
	private boolean hasRight(int i ) {
		return (right(i) < this.size());
	}
	
	// if parent is larger (in max case), swap it. In min case, if parent is smaller, swap it. To do that, please check compare function as well.
	private void upheap(int i) {
		while (i>0) {
			int p = parent(i);
			if (compare(pqArr[i],pqArr[p])>=0)
				break;
			swap(i,p);
			i = p;
		}
	}
	
	// Similar to the upheap. Just verification of which child is larger (or smaller) and compare it. 
	private void downheap(int i) {
		int temp;
		while (hasLeft(i)) {
			if (hasRight(i)) {
				if (compare(pqArr[left(i)],pqArr[right(i)])>=0)
					temp = right(i);
				else
					temp = left(i);
			}
			else
				temp = left(i);
			if (compare(pqArr[temp],pqArr[i])>=0)
				break;
			swap(i,temp);
			i = temp;
		}
	}
	
	// This method will determine max or min heap flexibly. Compare function is working depending on either max or min. 
	// In this way, we do not need to duplicate code for implementing min or max heap.
	private int compare(Entry<K, V> e1,Entry<K, V> e2) {
		if (comparator.equals("min")) {
			if (e1.compareKey(e2)>=0)
				return 1;
			else
				return -1;
		}
		else {
			if (e1.compareKey(e2)<=0)
				return 1;
			else
				return -1;
		}
			
	}
	
	// Extend array while insert or remove
	// Create new array and copy with the size which is incremented (if it's insert) or decremented (if it's remove)
	private Entry<K,V>[] newArr(int i){
		int size = this.size() + i;
		Entry<K,V>[] newA = new Entry[size];
		if (i == -1) {
			for (int j = 0;j<size;j++) {
				newA[j] = pqArr[j];
			}
		}
		else if (i == 1) {
			for (int j = 0;j<size-1;j++)
				newA[j] = pqArr[j];
			newA[size-1] = null; 
		}
		return newA;
	}
	
}
