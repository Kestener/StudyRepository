import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;

/**
 * This program implements a spell checker following the assignment requirements. It uses a
 * HashSet to handle the dictionary and a TreeSet to handle the spellChecker and the corrections
 * suggested by the program. The program need the input of two txt files to work, one with the
 * dictionary words provided by the assignment and one that can be selected by the user. A sample
 * file is provided in the attachment.
 * @author macbook
 *
 */

public class SpellChecker {
	
	public static void main(String[] args) {
		
		HashSet<String> dictionary = new HashSet<String>();
		
		System.out.println("Select a file to be used as a dictionary in the Spell Checker.");
		dictionary = defineDictionary();
		
		System.out.println("The dictionary contains: "+dictionary.size()+" words.");
		
		System.out.println("Select a file to spell check.");
		File spellInput = getInputFileNameFromUser();
		spellCheck(spellInput, dictionary);
	
	}

	/**
	 * This subroutine handles the selection of the dictionary file with try..catch to handle
	 * issues with the file selection. The file must have only words separated by spaces or
	 * non-letter characters.
	 * @return the dictionary words filled in a HashSet to be handled by the Spell Checker
	 * subroutine.
	 */
	
	private static HashSet<String> defineDictionary() {
		
		HashSet<String> dict = new HashSet<String>();
		
		File input = getInputFileNameFromUser();
		
		if (input != null) {
			// Try statement added to cover an possible error in the input file.
			try {
				// Scanner code provided by the assignment to read the selected file.
				Scanner filein = new Scanner(input);
				
				while (filein.hasNext()) {
					String tk = filein.next();
					tk = tk.toLowerCase();
					dict.add(tk);
				}		
				filein.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("Can't find dictionary file.  No words "
					+ "added to dictionary.");
			}
		}
		
		return dict;
	}
	
	private static void spellCheck(File input, HashSet<String> dict) {
		
		/*
		 * HashSet outputWords to store words that are found to be printed. The objective
		 * is to avoid the same misspelled word to be printed multiple times.
		 */
		HashSet<String> outputWords = new HashSet<String>();
		
		try {
			// Command provided by the assignment to skip over any non-letter 
			// characters in the file
			Scanner in = new Scanner(input);
			in.useDelimiter("[^a-zA-Z]+");
			
			while (in.hasNext()) {
				String word = in.next();
				word = word.toLowerCase();
				
				if (!dict.contains(word)) {
					if (!outputWords.contains(word)) {
						outputSuggestions(word, dict);
						outputWords.add(word);
					}
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file to spell check words.");
		}
		
	}
	
	/**
	 * Prints potentially misspelled words along with possible corrections.
	 * 
	 * @param misSpell The word that is potentially misspelled.
	 * @param dict The dictionary to use as the correct spellings
	 *     of English words.
	 */
	private static void outputSuggestions(String misSpell, HashSet<String> dict) {
		
		/*
		 * Need to declare suggestions as a reference variable of type
		 * TreeSet to use specific methods.
		 */
		TreeSet<String> suggestions = new TreeSet<String>();
		
		/*
		 * The misspell highlights and the correction suggestions were divided in two
		 * subroutines to handle the details for each process. This is a call to merge
		 * the corrections routine.
		 */
		suggestions.addAll(corrections(misSpell, dict));
		
		if (suggestions.size() == 0) {
			System.out.println(misSpell + ": (no suggestions)");
		} else {
			
			/*
			 * Using Eck's code from chapter 10.4.2 to print the elements
			 * separated with commas from a TreeSet of Strings.
			 */
			System.out.print(misSpell + ": ");
			String firstWord = suggestions.first();  
			System.out.print(firstWord);
			for (String word : suggestions.tailSet(firstWord, false)) {
				System.out.print(", " + word);
			}
			System.out.println();
		}
	}
	
	
    /**
     * Subroutine provided by the assignment.
     * Lets the user select an input file using a standard file
     * selection dialog box.  If the user cancels the dialog
     * without selecting a file, the return value is null.
     */
    static File getInputFileNameFromUser() {
       JFileChooser fileDialog = new JFileChooser();
       fileDialog.setDialogTitle("Select File for Input");
       int option = fileDialog.showOpenDialog(null);
       if (option != JFileChooser.APPROVE_OPTION)
          return null;
       else
          return fileDialog.getSelectedFile();
    }
    
	/**
	 * Collects all the possible corrections to a misspelled word.
	 * 
	 * @param misSpell The word that is potentially misspelled.
	 * @param dict The dictionary selected by the user.
	 * @return The collection of possible corrections to the
	 *     misspelled word.
	 */
	private static TreeSet<String> corrections(String misSpell, HashSet<String> dict) {
		
		TreeSet<String> corrections = new TreeSet<String>();
		
		// Variables to hold the five corrections that the program handles.

		String insertedLetters;
		String changedLetters;
		String swappedLetters;
		String spaceInserted;
		String deletedLetters;
		
		for (int i = 0; i < misSpell.length(); i++) {
			
			/*
			 * Test each character of misSpell with i and i + 1
			 * to fulfill the Swap correction case.
			 */
			if (i < misSpell.length() - 1) {
				char[] c = misSpell.toCharArray();
				char temp = c[i];
				c[i] = c[i + 1];
				c[i + 1] = temp;
				
				swappedLetters = new String(c);
				
				if (dict.contains(swappedLetters)) {
					corrections.add(swappedLetters);
				}
			}
			
			/*
			 * Check each position that could have a space, testing if the two
			 * separate words are in the dictionary. This fulfills the space case
			 * requested in the assignment.
			 */
			if (dict.contains(misSpell.substring(0,  i)) && dict.contains(misSpell.substring(i))) {
				spaceInserted = misSpell.substring(0, i) + ' ' + misSpell.substring(i);
				corrections.add(spaceInserted);
			}
			
			/*
			 * Check each position with all of the letters a-z.
			 * This fulfills the changes, insertions and delete cases.
			 */
			for (char ch = 'a'; ch <= 'z'; ch++) {
				
				deletedLetters = misSpell.substring(0, i) + misSpell.substring(i + 1);
				if (dict.contains(deletedLetters)) {
					corrections.add(deletedLetters);
				}
				
				changedLetters = misSpell.substring(0, i) + ch + misSpell.substring(i + 1);
				if (dict.contains(changedLetters)) {
					corrections.add(changedLetters);
				}
				
				insertedLetters = misSpell.substring(0, i) + ch + misSpell.substring(i);
				if (dict.contains(insertedLetters)) {
					corrections.add(insertedLetters);
					
				} else if (dict.contains(misSpell + ch)) {
					corrections.add(misSpell + ch);
				}
			}
		}	
		return corrections;
	}
}
