import java.io.FileInputStream;
import java.util.Scanner;

public class calculation {
	// Stack used for this algorithm. Please, check stack class as well.
	public static Stack valStk = new Stack();
	public static Stack opStk = new Stack();
	public static void doOp(){
		// Since we have unary operation as well, we need to verify operator.
		String op = opStk.pop();
		
		// Factorial case
		if (prec(op)==2) {
			// Note that factorial is only valid for integer
			int y = Integer.parseInt(valStk.pop());
			int fac=1;
			if (y<1)
				valStk.push("1");
			else {
				for (int i=1;i<=y;i++) 
					fac *= i;				
				valStk.push(Integer.toString(fac));	
			}
		}		
		
		// Unary minus case. Make it negative. 
		else if (prec(op)==3) {
			double y = -Double.parseDouble(valStk.pop());
			valStk.push(Double.toString(y));
		}
		
		// Power case. 
		else if (prec(op)==4) {
			double x = Double.parseDouble(valStk.pop());
			double y = Double.parseDouble(valStk.pop());

			// Note that stack is last in first out. Therefore, if expression is for example, 3 ^ 4, 4 came later and out first.
			// So to have correct form, power is y ^ x.
			valStk.push(Double.toString(Math.pow(y, x)));
		}
		
		// I can use ScriptEngineManager for calculating this. But, since it's not too complicated (for if-else condition), I just used another if-else condition.
		else if ((prec(op)>=5 && prec(op)<=6)) {
			double x = Double.parseDouble(valStk.pop());
			double y = Double.parseDouble(valStk.pop());
			double sum = 0;
			if (op.equals("+"))
				sum = y+x;
			else if (op.equals("-"))
				sum = y-x;
			else if (op.equals("*"))
				sum = y*x;
			else if (op.equals("/"))
				sum = y/x;
			
			// This code is unnecessary if I just push double. Basically, it's testing if the result is double or integer.
			if ((double)(int)sum == sum )
				valStk.push(Integer.toString((int)sum));
			else
				valStk.push(Double.toString(sum));
		}
		
		// equality or comparing case. Based on the ranking given, it will be last step.  
		else if (prec(op)>=7) {
			double x = Double.parseDouble(valStk.pop());
			double y = Double.parseDouble(valStk.pop());
			if (op.equals(">"))
				if (y>x)
					valStk.push("Given expression is true");
				else
					valStk.push("Given expression is false");
			else if (op.equals(">="))
				if (y>=x)
					valStk.push("Given expression is true");
				else
					valStk.push("Given expression is false");
			else if (op.equals("<="))
				if (y<=x)
					valStk.push("Given expression is true");
				else
					valStk.push("Given expression is false");
			else if (op.equals("<"))
				if (y<x)
					valStk.push("Given expression is true");
				else
					valStk.push("Given expression is false");
			else if (op.equals("=="))
				if (y==x)
					valStk.push("Given expression is true");
				else
					valStk.push("Given expression is false");
			else if (op.equals("!="))
				if (y!=x)
					valStk.push("Given expression is true");
				else
					valStk.push("Given expression is false");
		}		
	}

	public static int prec(String refOp) {
		// Make an order as given in the question. (Another option is to use switch)
		if (refOp.equals("(")||refOp.equals(")"))
			return 1;
		if (refOp.equals("!"))
			return 2;
		if (refOp.equals("U-"))
			return 3;
		if (refOp.equals("^"))
			return 4;
		if (refOp.equals("*")||refOp.equals("/"))
			return 5;
		if (refOp.equals("+")||refOp.equals("-"))
			return 6;
		if (refOp.equals(">")||refOp.equals(">=")||refOp.equals("<")||refOp.equals("<="))
			return 7;
		if (refOp.equals("==")||refOp.equals("!="))
			return 8;
		if (refOp.equals("$")) // Indicates it reaches last. 
			return 0;
		else
			return -1; // error case.
	}
	
	public static void repeatOps(String refOp) {
		// error case. Not allowed operators are given.
		if (prec(refOp) == -1) {
			System.out.println("Invalid operator, system will be closed.");
			System.exit(0);
		}
		
		// If it reaches last, simply doing operation. But if "(" is on top, it should be stopped because parenthesis operation is working.
		if (prec(refOp) == 0) {
			while (valStk.size()>1 && !opStk.top().equals("(")) {
				doOp();	
			}
		}		
		
		// Doing operation if Value stack size is more than 1 and it doesn't have any parenthesis and only if reference operation has lower priority than top stack on operation stack.
		// Also, if top on operation stack is "(", it means in parenthesis so I skipped to another condition. 
		// There is another condition that while loop doesn't work is if it starts from unary operation (valStk.size is 1). I put if condition below as well.
		while (valStk.size()>1 && prec(refOp)>= prec(opStk.top()) && prec(opStk.top())!=1) {
			doOp();
		}
		if (valStk.size()==1 && (prec(refOp) == 2 || prec(refOp)==3)) {
			doOp();
		}

	}
	
	// Main algorithm. 
	public static String EvalExp(String exp) {
		// delete all the white space. My algorithm is working with or without white space. 
		String s = exp.replaceAll("\\p{Z}","");
		
		// temp is used as a token. However, I did not use Stringtokenizer instead, I used for loop not to have issue of unary operation (especially for minus sign).  
		String temp;
		String valTemp ="";
		for (int i=0;i<s.length();i++) {
			temp = s.substring(i,i+1);
			if (isNumber(temp)||temp.equals(".")) {
				valTemp += temp;
			}
			else {
				if (!valTemp.isEmpty()) { // We push the value until there is next operator so that we know how big value it is. 
					valStk.push(valTemp);
					valTemp="";
					if (!opStk.isEmpty() && opStk.top().equals("U-"))
						repeatOps("U-"); // Because unary minus is very special case which takes later value not previous value so I put this code
				}
				if (temp.equals("(")) { // Parenthesis case. 
					String newS = "";
					String newE = "";
					int count = 0;
					
					opStk.push("(");
					while (!(newS.equals(")")&&count==-1)&&i<s.length()-1) { // if there is multiple parenthesis
						i++;
						newE += newS;
						newS = s.substring(i,i+1);
						if (newS.equals("(")) {
							count++;
						}
							
						else if (newS.equals(")")) {
							count--;
						}
							
					}
					// This is recursive call; however, it uses exactly the same stacks and it just make more precedence on parenthesis(which is not based on recursion). 
					valStk.push(EvalExp(newE)); 
					opStk.pop();
				}				
				else if (temp.equals("-")) { // Verifying if it's unary minus or binary minus
					if (i==0||!(s.substring(i-1,i).equals(")")||isNumber(s.substring(i-1,i)))){
						 opStk.push("U-");													
					}
					else {
						repeatOps(temp);
						opStk.push("-");
					}
				}
				else if (temp.equals("!")) { // Verifying if it's factorial or not equal (!=). 
					if (i != s.length()-1 && s.substring(i+1,i+2).equals("=")) {
						repeatOps("!=");
						opStk.push("!=");
						i++; // Checked i+1 case as well so starting loop should be i+2
					}
					else {
						repeatOps(temp);
						opStk.push(temp);
					}
				}
				
				else if (temp.equals("<")||temp.equals(">")||temp.equals("=")) { // Verifying if it's for example < or <=
					if (s.substring(i+1,i+2).equals("=")) {
						repeatOps(temp+"=");
						opStk.push(temp+"=");
						i++;
					}
					else {
						repeatOps(temp);
						opStk.push(temp);						
					}
				}					
				else { // All other cases such as + * / - 
					repeatOps(temp);
					opStk.push(temp);
				}				
			}
		}
		// For the last (ending) value case, for loop is done and valTemp is not entered so I put it in case. 
		if (!valTemp.isEmpty())
			valStk.push(valTemp);
		repeatOps("$");
		return valStk.pop();
		
	}
	
	// Verifying if given expression number.
	public static boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This is test section!. Please check your console display and I make a test log!");

        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("expressions.txt"));
            while (sc.hasNextLine()) {
            	System.out.println(EvalExp(sc.nextLine()));
            }
        } catch(Exception e)
     	{
     		System.out.println("Exception found. System will be terminated.");
     		System.exit(0);
     	} 
        sc.close();
		System.exit(0);
		
	}
}
