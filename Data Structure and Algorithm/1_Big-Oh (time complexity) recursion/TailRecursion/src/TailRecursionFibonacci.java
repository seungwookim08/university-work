import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
public class TailRecursionFibonacci {
	public static void main (String args[]){
		PrintWriter pw = null;
		long startTime = 0;
		long endTime = 0;
		
		try{
			pw = new PrintWriter(new FileOutputStream("out.txt"));
			pw.println("Tail Recursion Fibonacci time record :");
			for (int i = 5; i<=90;i+=5){
				// Instead of using currentTimeMillis(), I use nanoTime() Because first 3 - 4 running time is too short. 
				startTime = System.nanoTime();
				
				// Same reason as LinearFibonacci, I will stop at 90 instead of 100 not to exceed limit of primitive type long range.
				// And to have comparable result. 
				// Plus, second and third parameter should be 1 and 0 to have proper Fibonacci result. It is similar as base case of Linear Fibonacci (in a reverse way).   
				long result = TailRecFib(i,1,0);
				endTime = System.nanoTime();
				pw.println("Fibonnaci (" + i +") time record : "+(endTime-startTime)+" ns. Fibonacci " + i + " number is " + result +".");
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
	
	public static long TailRecFib(int k,long prevFib,long prevprevFib) {
		// To have tail recursion, adjustment is needed from linear fibonacci.
		// instead of using pair, these became input. As I commented, we just need to return prevFib.
		if (k==1)
			return prevFib;
		// Since only TailRecFib is returned, it is tail recursion. Also, code becomes very simpler as well. 
		return TailRecFib(k-1,prevFib+prevprevFib,prevFib);
	}
}