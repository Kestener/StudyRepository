/*
 * Given a square matrix this program calculates the value of its secondary
 * Diagonal. The array is hardcoded in the program and an if statement checks
 * the square quality of the matrix before outputing the result.
 */
package matrixdiagonal;

import java.util.*;

/**
 *
 * @author Kestener
 */
public class MatrixDiagonal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Hardcoded array
        int[][] m = {{10,12},{9,8}};
        // To hold the sum of the secondary diagonal
        int sum = 0;
        
        // If statement to check if row and column are equal.
        if(m.length == m[1].length){
            
            // Nested for loop to iterate through rows and columns.
            for (int i = 0; i < m.length; i++){
                for (int j = 0; j < m.length; j++){
                
                    // secondary diagonal location statement
                    if (i == m.length - j - 1) {
                        sum += m[i][j]; 
                    }
                }
            }
            System.out.println("Secondary Diagonal sum is: "+ sum);
        }else{
        System.out.println("This is not a square matrix.");    
        }      
    }
}
