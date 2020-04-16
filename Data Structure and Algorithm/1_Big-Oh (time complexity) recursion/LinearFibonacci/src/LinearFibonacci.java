import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
public class LinearFibonacci {
	public static void main (String args[]){
		PrintWriter pw = null;
		long startTime = 0;
		long endTime = 0;
		
		try{
			pw = new PrintWriter(new FileOutputStream("out.txt"));
			pw.println("Linear Fibonacci time record :");
			for (int i = 5; i<=90;i+=5){
				// Instead of using currentTimeMillis(), I use nanoTime() Because first 3 - 4 running time is too short. 
				startTime = System.nanoTime();
				
				// As well, to have comparable result, even if it will not have much difference to loop until i = 100, I stop at 90 not to exceed limit (of long).
				// alternatively, I can use BigInteger object, but it may result different output, as I mentioned, to have comparable result with binary fibonacci, 
				// I stopped at 90. 
				long result[] = LinearFib(i);
				endTime = System.nanoTime();
				pw.println("Fibonnaci (" + i +") time record : "+(endTime-startTime)+" ns. Fibonacci " + i + " number is " + result[0] +".");
			}
		} 
		// Handling Exception
		catch (IOException e){
			System.out.println("There is IOException. program will be terminated.");
			System.exit(0);
		}
		pw.close();
		System.out.println("That's the end of the program. Please check output from text file.");
	}
	public static long[] LinearFib(int k) {
		// Note that to reserve right pair, the base case is only when k = 1. 
		if (k==1) {
			long[] fibPair = {1,0};
			return fibPair;
		}
		// temp will take temporary long pair which is previous fibonacci.
		long[] temp = LinearFib(k-1);
		// Basically, it is Pair of {Fibonacci(k),Fibonacci(k-1) where k is changed.
		long[] fibPair = {temp[0] + temp[1],temp[0]};
		return fibPair;
	}
}
