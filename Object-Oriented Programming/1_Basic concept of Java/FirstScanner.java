

import java.util.Scanner; // import this class for question 2 and prompt the user to enter input

public class FirstScanner {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  // Scanner used for input
		/** 
		 * welcome message
		 */
		System.out.println("----------------------------\nWelcomd to Kim's Program\n----------------------------\n\n"); 
		//Simply type a message to display and using \n command to make a new line and also use as a Welcome message
		
		
		/**
		 * name, age, city, college, profession, animal, petName input/output
		 */
		
		System.out.print("Enter your name: ");
		String name = sc.nextLine(); 
		//declare string "name" and make the user enter his/her name. In case of space, using nextLine
		
		System.out.print("Enter your age: ");
		int age = sc.nextInt();  
		sc.nextLine();
		//declare integer "age" and make the user enter his/her age, also using sc.Nextline(); command to consume whole line not to make an error
				
		System.out.print("Enter the name of a city: "); 
		String city = sc.nextLine();
		//declare string "city" and make the user enter his/her city
		
		System.out.print("Enter the name of a college: "); 
		String college = sc.nextLine(); 
		//declare string "college" and make the user enter his/her college
		
		System.out.print("Enter profession: "); 
		String profession = sc.nextLine();
		//declare string "profession" and make the user enter his/her profession
		
		System.out.print("Enter a type of animal: "); 
		String animal = sc.nextLine(); 
		//declare string "animal" and make the user enter his/her animal type
		
		System.out.print("Enter a pet name: "); 
		String petName = sc.nextLine();
		//declare string "petName" and make the user enter his/her pet name. 
		
		
		/**
		 * message output
		 */
		System.out.printf("\nThere once was a person named " + "%s",name + " who lived in " + city + ". At the age of " + age + ",\n"); 
		// using printf command to use %s command with string "name". Also using \n command for making new line.
		System.out.println(name + " went to college at " + college + ". " + name + " graduated and went to work as a");
		System.out.println(profession + ". Then, " + name + " adopted a(n) " + animal + " named " + petName + ". They\nboth lived happily ever after!\n\n");
		
		// display the message as given, all variables will be on as typed with sentences which was asked from the question.  
						
		sc.close();
		// close the scanner 
		
		
		/**
		 * closing message
		 */
		System.out.println("Thank you for using Kim's program - bye !!!"); //Closing message
		
		//Question 2 completed
		
	
	
	
	}
}
