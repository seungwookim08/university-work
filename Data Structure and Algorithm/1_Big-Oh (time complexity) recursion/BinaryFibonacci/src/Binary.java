import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Binary {
	public static void main(String args[]){
		// for making out, create PrintWriter and using 2 long constant to measure the run time. 
		PrintWriter pw = null;
		long startTime = 0;
		long endTime = 0;
		
		try{
			pw = new PrintWriter(new FileOutputStream("out.txt"));
			pw.println("Binary Fibonacci time record :");
			for (int i = 5; i<=40;i+=5){
				// Instead of using currentTimeMillis(), I use nanoTime() Because first 3 - 4 running time is too short. 
				startTime = System.nanoTime();
				
				
				// I run until 40 because after this, the running time is too long. 
				long result = BinaryFibonacci(i);
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
	
	private static long BinaryFibonacci(long n){
		// by definition, when n =1 or 2 the Fibonacci number is 1
		if (n==1 || n==2)
			return 1;
		return BinaryFibonacci(n-1) + BinaryFibonacci(n-2);		
	}
}
