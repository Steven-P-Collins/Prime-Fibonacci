//import java.util.Scanner;
public class FibMain {
	static public void main (String[] args){
	//	Scanner keyb = new Scanner(System.in);
		Fib F1 = new Fib();
		
		//System.out.println("Print a number for some shit to happen: ");
		//int x= keyb.nextInt();
		
		F1.iterative(1000);
		
		double recursiveStartTime = System.nanoTime();
		System.out.println(F1.recursive(25));
		System.out.println("It took " + F1.runTime(recursiveStartTime) 
				   + " milliseconds to find the value recursively.\n");
		
		F1.primefib();
		
		//12586269025
		//It took 314701.813993 milliseconds to find the value recursively.
	}
}
