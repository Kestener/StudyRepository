/**
 * This class generates automatically 30 random sentences following the rules defined on
 * lab 3 item 1 of this week assignment. It has one main "Sentence builder" subroutine with
 * 3 subroutines that construct the sentences using switches and conditionals based on randomly
 * generated numbers. This builds phrases of varying sizes and complexity. There are also two
 * methods that make the random number generation and the array Strings selection easier and the
 * code cleaner.
 * Known issues: sentences starting with conjunctions doesn't get to ProperCase. Some issues
 * with word spaces.
 * @author macbook
 *
 */

public class SimpleRandomSentences {
	
	// Declaration of the seven rules from the lab used by each subroutine.
	private static String[] properNoun = {"Fred","Jane","Richard Nixon","Miss America"};
	private static String[] determiner = {"a","the","every","some"};
	private static String[] adjective = {"big","tiny","pretty","bald"};
	private static String[] commonNoun = {"man","woman","fish","elephant","unicorn"};
	private static String[] intransitiveVerb = {"runs","jumps","talks","sleeps"};
	private static String[] transitiveVerb = {"loves","hates","sees","knows","looks for",
												   "finds"};
	private static String[] conjunction = {"and","or","but","because"};
	
	/**
	 * Main routine that uses a for loop to iterate through the Sentence subroutine 30 times, 
	 * generating 30 sentences and enumerating them accordingly.
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = 1; i < 31; i++) {
			System.out.print(i +"-) ");
			Sentence();
			System.out.print(".");
			System.out.println();
		}
	}
	
	/**
	 * The Sentence subroutine follow the main rule calling the SimpleSentence subroutine and
	 * with a 0.25% chance to include a conjunction and recursively call itself again, potentially
	 * building longer sentences.
	 */
	
	static void Sentence() {
		
		SimpleSentence();
		
		if (Math.random() > 0.75) {
			System.out.print(" ");
			RandomSelectItem(conjunction);
			System.out.print(" ");
			Sentence();
		}
		
	}
	
	/**
	 * The SimpleSentence subroutine integrate the NounPhrase and VerbPhrase subroutines and
	 * is used by the Sentence subroutine as the starting point for every random generated phrase.
	 */
	static void SimpleSentence( ) {
		NounPhrase();
		VerbPhrase();
	}
	
	/**
	 * The NounPhrase builds a "root" phrase following the rules determined by the assignment.
	 * To select the items it uses the randomSelectItem method.
	 */
	static void NounPhrase() {
		
		int switchSelect = RandomIntFromInterval(1,2);
		switch (switchSelect) {
			
			case 1: 	RandomSelectItem(properNoun);
					System.out.print(" ");
					break;
				
			case 2: 	RandomSelectItem(determiner);
					System.out.print(" ");
					
					// 50% chance to run this if condition.
					if (Math.random() > 0.5) {
						RandomSelectItem(adjective);
						System.out.print(" ");
					}
			
					RandomSelectItem(commonNoun);
					System.out.print(" ");
					
					// 50% chance to run this if condition.
					if (Math.random() > 0.5) {
						System.out.print("who ");
						VerbPhrase();
						System.out.print(" ");
					}
					break;
		}
		
		
	}
	/**
	 * This subroutine is part of the root SimpleSentence subroutine and also a possible 
	 * complement (and also starting point) for more complex concatenated phrases as highlighted
	 * on case 4.
	 */
	static void VerbPhrase() {
		
		int switchSelect = RandomIntFromInterval(1,4);
		switch (switchSelect) {
			
			case 1: RandomSelectItem(intransitiveVerb);
					break;
			
			case 2: RandomSelectItem(transitiveVerb);
					System.out.print(" ");
					NounPhrase();
					break;
			
			case 3: System.out.print("is ");
					RandomSelectItem(adjective);
					break;
		
			case 4: System.out.print("believes that ");
					SimpleSentence();
					break;		
		}
		
	}
	
	/**
	 * Method for picking a random item from an array of strings to be used by the sentence
	 * elements subroutines. It adapts the random method for each array length.
	 * @param listOfStrings point and select randomly the seven rules listed in the program.
	 */
	static void RandomSelectItem(String[] listOfStrings) {
		
		int item = (int)(Math.random()*listOfStrings.length);
		System.out.print(listOfStrings[item]);
		
	}
	
	/**
	 * Method for generate a random integer from a defined interval. Used with the switch
	 * statements in several subroutines of the program.
	 * @param min for the minimum value.
	 * @param max for the maximum value.
	 * @return a random generated integer between the minimum and maximum values defined.
	 */
	static int RandomIntFromInterval(int min, int max) {
	
		int result = (int)(Math.random()*(max-min+1)+min);
		return result;
		
	}
	
}
