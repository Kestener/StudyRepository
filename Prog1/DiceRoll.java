/*
 * This program generates two random numbers between 1 and 6 to simulate die
 * rolls. The objective is to try as many rolls necessary to get one in both
 * dies, what is called Snake Eyes. It includes the challenge for loop to take
 * the average of Snake Eyes after 1000 rounds.
 */
package diceroll;

/**
 *
 * @author macbook
 */
public class DiceRoll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int die1; // to hold die1 result
        int die2; // to hold die2 result
        int countRolls; // for counting the number of die rolls
        int game; // control variable for the number of games to take average
        int sum; // The sum of the countRolls variable for each Snake Eye try
        double average; // Calculate the average of the sum of countRolls
        
        sum = 0; // Initialize the summation variable
        
        for ( game = 0; game < 1000; game++) {
            die1 = (int)(Math.random()*6)+1;
            die2 = (int)(Math.random()*6)+1;
            countRolls = 1; // Counter start with 1 to consider first try
        
            while (die1 + die2 != 2 ) {  // Possible true when 1+1
                die1 = (int)(Math.random()*6)+1;
                die2 = (int)(Math.random()*6)+1;
                countRolls++; // count increment
            }
            sum += countRolls;
        }
        average = ((double)sum) / 1000;
        TextIO.putln("We have got Snake Eyes after "+average+" dice rolls on"
                + " average.");
    }    
}
