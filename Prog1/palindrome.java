/*
 * This program contains one main and two subroutines to request a string input
 * and then output if this string is a palindrome (a.k.a reads the same
 * backwards. The input must always be a string without special characters. It
 * can have whitespaces and upper and lowercase letters. The program converts
 * then to lowercase and removes the whitespaces.
 */
package firstsubroutines;

/**
 *
 * @author macbook
 */
public class Firstsubroutines {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("This program check if a word is a palindrome");
        System.out.println("for the word that you specify.");
        System.out.println();
        
        String palindrome;  // To store the user word input.
        
        System.out.println("Enter your word:");
        palindrome = TextIO.getln();    // Get the user input.
        
        // The methods below set everything to lower case and remove white
        // spaces and non-visible symbols.
        palindrome = palindrome.toLowerCase().replaceAll("\\s+",""); 
        
        // Call to the reverse subroutine and attribute the return to
        // reverseCheck variable.
        String reverseCheck = reverse(palindrome);
        
        // Call to the palindrome check subroutine that automatically returns
        // the print messages to state if the word is a palindrome.
        isPalindrome(palindrome, reverseCheck);
        
    } // end main
    
    
   /* Reverse subroutine where we input the string and reverse the characteres
    * and then return then for use in the program. To better results I recommend
    * the formatted input with low case letters and no spaces.
   */
    static String reverse(String str) {
        String copy;    // The reversed copy.
        int i;          // One of the positions in str,
                        // from str.length() - 1 down to 0.
        copy = "";      // Start with an empty string.
        for (i = str.length() - 1; i >= 0; i--) {
                // Append i-th char of str to copy.
            copy = copy + str.charAt(i);
        }
        return copy;
    }
    
    /* Palindrome determination subroutine. This needs two string inputs to
     * check if the original and reversed words or sentences are equal. It
     * then print the results for each situation. The first parameter must
     * be the regular input and the second the reversed.
    */
    static void isPalindrome(String str1, String str2) {
        System.out.println("stripped: "+str1);
        System.out.println("reversed: "+str2);
        System.out.println();
        
        if(str1.equals(str2)) {
            System.out.println("This IS a palindrome");
        }
        else{
        System.out.println("This is NOT a palindrome");
        }
    }
}
