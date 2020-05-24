import java.util.TreeSet;

/**
 * This program is a demonstration of Sets in Java and how to calculate and handle them.
 * It uses TextIO class to handle spaces and the input, not allowing invalid characters into
 * TreeSet interface. The user is instructed to input set A between square brackets, then the
 * operator ('+' for union, '*' for intersection and '-' for difference) and the set B. All
 * numbers must be separated by commas, but the program handles spaces through skipBlanks
 * method.
 *
 */

public class SetCalculator {
	   public static void main(String[] args) {

		      System.out.println("This program calculates the union '+', intersection'*',");
		      System.out.println("and difference '-' of sets of integers.");
		      System.out.println("Use '[ ]' to define the sets, commas between the numbers");
		      System.out.println("and the proper operator between the sets.");
		      System.out.println("Input set computations (press return to end):");

		      while (true) {
		         char ch;
		         System.out.print("\n? ");
		         TextIO.skipBlanks();
		         if (TextIO.peek() == '\n') {
		               // If empty it ends the program.
		            break;
		         }
		         try {
		            calc(); // Reads and processes the input.
		         }
		         catch (IllegalArgumentException e) {
		            System.out.println("Error in input: " + e.getMessage());
		            System.out.print("Discarding input: ");
		         }
		         do {  // Copy extra characters on line to output.  If there 
		               // was no error, then the only character that is copied
		               // is the end-of-line character.
		            ch = TextIO.getAnyChar();
		            System.out.print(ch);
		         } while (ch != '\n');
		      }

		   } // end main()
	   
	   /**
	    * Stores in a TreeSet the input of non-negative integers. The
	    * set must be in the correct format provided by the initial 
	    * instructions. If it is not correct an IllegalArgumentException
	    * is thrown.
	    */
	   private static TreeSet<Integer> readSet() {

	      TreeSet<Integer> set = new TreeSet<Integer>();  // The set that will be read.

	      TextIO.skipBlanks();
	      if (TextIO.peek() != '[')
	         throw new IllegalArgumentException("Expected '[' at start of set.");
	      TextIO.getAnyChar(); // Read the '['.

	      TextIO.skipBlanks();
	      if (TextIO.peek() == ']') {
	            // This is the empty set, which is legal. Return the value.
	         TextIO.getAnyChar(); // Read the ']'.
	         return set;
	      }

	      while (true) {
	            // Read the next integer and add it to the set.
	         TextIO.skipBlanks();
	         if (! Character.isDigit(TextIO.peek()))
	            throw new IllegalArgumentException("Expected an integer.");
	         int n = TextIO.getInt(); // Read the integer.
	         set.add( new Integer(n) );
	         TextIO.skipBlanks();
	         if (TextIO.peek() == ']')
	            break;  // ']' marks the end of the set.
	         else if (TextIO.peek() == ',')
	            TextIO.getAnyChar(); // Read a comma and continue.
	         else
	            throw new IllegalArgumentException("Expected ',' or ']'.");
	      }

	      TextIO.getAnyChar(); // Read the ']' that ended the set.

	      return set;

	   } // end readSet()
	   
	   /**
	    * Read a line of input, consisting of two sets separated by
	    * an operator.  Perform the operation and output the value.
	    * If any syntax error is found in the input, an
	    * IllegalArgumentException is thrown.
	    */
	   private static void calc() {

	      TreeSet<Integer> A, B;  // The two sets of integers.
	      char op;                // The operator, +, *, or -.

	      A = readSet(); // Read the first set.

	      TextIO.skipBlanks();
	      if (TextIO.peek() != '*' && TextIO.peek() != '+' 
	                                         && TextIO.peek() != '-')
	         throw new IllegalArgumentException(
	         "Expected *, +, or  - after first set.");
	      op = TextIO.getAnyChar(); // Read the operator.

	      B = readSet(); // Read the second set.

	      TextIO.skipBlanks();
	      if (TextIO.peek() != '\n')
	         throw new IllegalArgumentException("Extra unexpected input.");

	      // Perform the operation.  This modifies set A to represent
	      // the answer.  Display the answer by printing out A. The
	      // output format for a set of integers is the same as the
	      // input format used by this program.

	      if (op == '+')
	         A.addAll(B);     // Union.
	      else if (op == '*')
	         A.retainAll(B);  // Intersection.
	      else
	         A.removeAll(B);  // Set difference.
	      
	      System.out.print("Value:  " + A);

	   } // end calc()
} // end class SetCalculator
