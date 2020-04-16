
public class Main {

	public static void main(String[] args) {
		
		// Not to have repeated code, all keys and values that I wanan test is stored in array
		int[] keyArr = {31,2,45,54,4,34,30,29,39,98,76,1,22};
		String[] valueArr = {"Anna","Becky","Cindy","Daniel","Eric","Ferry","Groza","Hand","Ionic","Jack","Koala","Lissa","Messi"};
		
		// initialize flexiblePQ with max
		flexiblePQ<Integer,String> test = new flexiblePQ<Integer,String>("Max");
		
		System.out.println("Is this empty? " + test.isEmpty()); // Testing if isEmpty works (should be true since nothing is added)
		for (int i =0;i<keyArr.length;i++) {
			test.insert(keyArr[i], valueArr[i]); // Testing insert
		}
		System.out.println("Is this empty? " + test.isEmpty()); // Testing if isEmpty works (should be false since something is added)
		System.out.println("What's the size of Priority Queue? " + test.size() + ". Originally, there are " + keyArr.length + " keys"); // Check size() is working
		for (int i =0;i<keyArr.length;i++) {
			System.out.println(test.remove()); // Testing if remove works
		}
		System.out.println("What's the size of Priority Queue? " + test.size()); // Testing empty size is working.
		
		System.out.println("\nLet's see if toggle works!\n");
		for (int i =0;i<keyArr.length;i++) {
			test.insert(keyArr[i], valueArr[i]); // Since we removed all value, add them again
		}
		test.toogle(); // It should transformed to Min
		for (int i =0;i<keyArr.length;i++) {
			System.out.println(test.remove()); // Test if it's really min heap
		}
		
		System.out.println("\nGoing back to Max-heap status!");
		System.out.println("test has state of " + test.state() + " now"); // testing state()
		test.switchToMax(); // testing switchToMax
		System.out.println("test has state of " + test.state() + " now");  // testing state()
		test.switchToMax(); // Check what happens if current state is max and try to use switchToMax

		for (int i =0;i<keyArr.length;i++) {
			test.insert(keyArr[i], valueArr[i]);
		}
		for (int i =0;i<keyArr.length;i++) {
			System.out.println(test.remove()); // Check if it's now max heap
		}
		
		System.out.println("\nLet's test some others");
		for (int i =0;i<7;i++) {
			test.insert(keyArr[i], valueArr[i]); // testing only 7
		}
		System.out.println(test.size()); // Checking the size
		System.out.println(test.top()); // Checking top()
				
		System.out.println(test.size());
		System.out.println(test.remove());
		System.out.println(test.size());
		
		test.insert(10000, "Very Large Value");
		test.switchToMin();
		int temp = test.size();
		for (int i =0;i<temp;i++) {
			System.out.println(test.remove());
		}
		System.out.println("Is this empty? " + test.isEmpty());
			
	}

}
