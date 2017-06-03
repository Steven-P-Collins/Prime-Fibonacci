import java.math.BigInteger;

public class Fib {
	private BigInteger current = new BigInteger("0");
	private BigInteger previous = new BigInteger("1");
	private BigInteger fib = new BigInteger("1");
	private BigInteger two = new BigInteger("2");
	private BigInteger three = new BigInteger("3");
	private BigInteger j = new BigInteger("3");
	private BigInteger test = new BigInteger("1000000");
	private BigInteger billion = new BigInteger("1000000000");
	private BigInteger fibDiv = new BigInteger("0");
	private int primeCounter = 0, result = -1, counter = 0;
	private double startTime, duration;

	private void resetBigInt(){//method to reset values of
		current = BigInteger.ZERO;
	    previous = BigInteger.ONE;
	    fib = BigInteger.ONE;
	}
	
	public double runTime(double startTime){//converts nanoseconds to milliseconds
		duration = (System.nanoTime() - startTime)/1000000;
		return duration;
	}
	
	private void fibSequence(){//iteratively works fib numbers
		//System.out.println(fib);//prints all fib numbers
        current = fib.add(previous);
        fib = previous;
        previous = current;
	}
	
	public BigInteger iterative(int n){
		startTime = System.nanoTime();
		resetBigInt();
		if(n == 0){
			return BigInteger.ZERO;
		}
	    for(int x = 2; x < n+1; x++){
	    	fibSequence();
	    	if(x == 50|| x == 100 || x == 500 || x == 1000){
	    		System.out.println("Position in fibonacci sequence: " + x
	    				   + "\nThe value is: " + fib + "\n"
	    				   + "The number is " + (fib.toString()).length() 
	    				   + " digits long.");
	    		System.out.println("It took " + runTime(startTime) + " milliseconds to"
	    				   + " reach the number iteratively.\n");
	    	}
	    	else if(fib.compareTo(test) > 0 && counter < 2){
	    		System.out.println("The smallest fibonacci number greater than " + test
	    				   + " is " + fib + ". It's the " + x 
	    				   + " fibonacci number.\nIt took " 
	    				   + runTime(startTime) + " milliseconds to find" 
	    				   + " the number.\n");
	    		test = billion;//set test to 1 billion to check greater than billion
	    		counter++;//counter used to stop statement from printing more than twice
	    	}
	    	/*else{
	    		System.out.println("The fib value of " + x 
	    				+ " it took " + runTime(startTime) 
	    				+ " seconds to reach this number iteratively.");
	    	}*/
	    }
	    runTime(startTime);
	    return fib;
	}
	
	public BigInteger recursive(int n){
		if(n == 0){
			return BigInteger.ZERO;
		}
		else if(n < 2){
			return BigInteger.ONE;
		}
		else{
			return recursive(n-1).add(recursive(n-2));
		}
	}
	
	public BigInteger primefib(){
		startTime = System.nanoTime();
		resetBigInt();
		for(int i = 2; primeCounter != 12; i++){
			fibSequence();
	        if(checkPrime()){
	        	System.out.println(fib + " the fib numnber");
	        	System.out.println(i + " position in fib sequence");
	        	System.out.println("It took " + runTime(startTime) 
	        			   + " milliseconds to find the " + ++primeCounter 
	        			   + " prime in fib\n");
	        }
			j = three;
	    }
	    return fib; 
	}
	
	public boolean checkPrime(){
		if(fib.equals(two) || fib.equals(j)){
			return true;
		}
		else if(fib.equals(BigInteger.ONE) || fib.mod(two).equals(BigInteger.ZERO)){
			return false;
		}
		else{
			fibDiv = fib.divide(two);//Moved divide here to eliminate thousands of uneeded divides
			while(result < 0){
				if(fib.mod(j).equals(BigInteger.ZERO)){
					return false;
				}
				j = j.add(two);
				result = j.multiply(j).compareTo(fibDiv); //removed.divide(two) improved run time
			}						  //of 12th prime by 8 seconds
			result = -1;
			return true;
		}
	}
}
















