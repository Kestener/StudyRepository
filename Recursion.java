/**
 * This program runs and compares four subroutines. Two factorial subroutines, one with iteration
 * and one with recursion implementation. Two Fibonacci subroutines, one with iteration and one
 * with recursion implementation.
 * @author macbook
 *
 */
public class RecursionExercise {
	
	public static void main(String[] args) {
		
		// Constants to pass the values easily to the subroutine calls.
		double FACTORIAL_TEST = 5;
		double FIBONACCI_TEST = 5;
		
		double startTimeFact1 = System.currentTimeMillis();
		double itFactorialTest = iterativeFactorial(FACTORIAL_TEST);
		double runTimeFact1 = System.currentTimeMillis() - startTimeFact1;
		System.out.println("The iterative factorial subroutine result is: "+ itFactorialTest);
		System.out.println("It took "+runTimeFact1+" milliseconds for the computer to calculate.");
		
		double startTimeFact2 = System.currentTimeMillis();
		double recFactorialTest = recursiveFactorial(FACTORIAL_TEST);
		double runTimeFact2 = System.currentTimeMillis() - startTimeFact2;
		System.out.println("The recursive factorial subroutine result is: "+ recFactorialTest);
		System.out.println("It took "+runTimeFact2+" milliseconds for the computer to calculate.");
		
		double startTimeFibo1 = System.currentTimeMillis();
		double itFibonacciTest = iterativeFibonacci(FIBONACCI_TEST);
		double runTimeFibo1 = System.currentTimeMillis() - startTimeFibo1;
		System.out.println("The iterative fibonacci subroutine result is: "+ itFibonacciTest);
		System.out.println("It took "+runTimeFibo1+" milliseconds for the computer to calculate.");
		
		double startTimeFibo2 = System.currentTimeMillis();
		double recFibonacciTest = recursiveFibonacci(FIBONACCI_TEST);
		double runTimeFibo2 = System.currentTimeMillis() - startTimeFibo2;
		System.out.println("The recursive fibonacci subroutine result is: "+ recFibonacciTest);
		System.out.println("It took "+runTimeFibo2+" milliseconds for the computer to calculate.");
	}
	
	/**
	 * Iterative version of the Factorial subroutine.
	 * @param N to define the factorial to be calculated.
	 * @return 1 for the 0! as convention and the factorial calculated for numbers above 0.
	 */
	static double iterativeFactorial (double N) {
		if (N == 0) return 1;
		
		double tmp = N;
		for (double k = N-1; k >= 1; k--)
			tmp = tmp*k;
			return(tmp);
		}
	
	/**
	 * Recursive version of the Factorial subroutine. Highlight to the recursive call on the
	 * else statement.
	 * @param N to define the factorial to be calculated.
	 * @return 1 for the 0! as convention and the factorial calculated for numbers above 0.
	 */
	static double recursiveFactorial (double N) {
		if (N == 0) return 1;
		else return (N*recursiveFactorial(N-1));
	}
	
	/**
	 * Iterative version of the Fibonacci subroutine.
	 * @param N to define the Fibonacci starting point.
	 * @return an integer with the result.
	 */
	static double iterativeFibonacci (double N) {
		double k1, k2, k3;
		k1 = k2 = k3 = 1;
		for (double j = 3; j <= N; j++) {
			k3 = k1 + k2;
			k1 = k2;
			k2 = k3;
		}
		return k3;
	}
	
	/**
	 * Recursive version of the Fibonacci subroutine.
	 * @param N to define the Fibonacci starting point.
	 * @return an integer with the result.
	 */
	static double recursiveFibonacci (double N) {
		if ((N == 1) || (N == 2)) return 1;
		else return (recursiveFibonacci (N-1) + recursiveFibonacci(N-2));
	}
		
}
