
public class Stack {
	// Initialize enough length of array
	private String[] store = new String[1000];
	
	// top is indicate which is last in and tells you what will be out. Since it's array, denoted top = -1 at first which is empty array.
	private int top = -1;
	
	// Default constructor
	public Stack(){
	}
	
	// The size of array is length of array where top is located. So top + 1 is length.
	public int size() {
		return(top + 1);
	}
	
	// As I commented, if top is -1, it means empty.
	public boolean isEmpty() {
		if (top ==-1)
			return true;
		return false;
	}
	
	// Show what is top. Technically, it's exactly same as pop and push again. 
	public String top() {
		if (top == -1)
			return null;
		return store[top];
	}
	
	// Pop out the top value. Popped out location of array becomes null.
	public String pop() {
		if (top == -1 )
			return null;
		String temp = store[top];
		store[top] = null;
		top--;
		return temp;
	}
	
	// Push to the stack. It will assign given value. 
	public void push(String s) {
		top++;
		store[top] = s;
	}


}
