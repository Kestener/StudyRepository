import java.util.Arrays;

// Array size 1000 Insertion algorithm = 5.0 ms / Sort Method algorithm = 1.0 ms
// Array size 10,000 Insertion algorithm = 72.0 ms / Sort Method algorithm = 5.0 ms
// Array size 100,000 Insertion algorithm = 6588.0 ms / Sort Method algorithm = 28.0 ms 

/**
 * This program initiates two arrays with random numbers. The size is based on the
 * constant SIZE, that can be modified in the program. Both arrays are created with
 * the same size and random numbers by the for loop and two sort algorithms run. Each
 * one have the time computation done and returned for comparison.
 * @author anonymous
 * @param SIZE constant
 * @return Time in milliseconds for each algorithm through print statements.
 */
public class Sorting {
	public static void main(String[] args) {
		
		// Constant variable that sets the array objects size.
		int SIZE = 100000;
		
		// Array initializations.
        int[] array1;
        array1 = new int[SIZE];
        int[] array2;
        array2 = new int[SIZE];
        
        // Random integers creation and attribution to the arrays
        for (int i = 0; i < SIZE; i++) {
        		int storeNumber = (int)(Integer.MAX_VALUE * Math.random()); 
        		array1[i] = storeNumber;
        		array2[i] = storeNumber;       		
        }
        
        // Run insertion sort algorithm to first array, compute and then print the time.
        double startTimeIn = System.currentTimeMillis();
        doInsertionSort(array1); 
        double runTimeIn = System.currentTimeMillis() - startTimeIn;
        System.out.println("The insertion sort algorithm took: "+ runTimeIn + " milliseconds.");
        
     // Run sort method algorithm to second array, compute and then print the time.
        double startTimeSort = System.currentTimeMillis();
        Arrays.sort(array2);
        double runTimeSort = System.currentTimeMillis() - startTimeSort;
        System.out.println("The Array.sort method algorithm took: "+ runTimeSort + " milliseconds.");
	}
	
	/**
	 * This class applies the insertion sort algorithm based on the input parameter.
	 * @author anonymous
	 * @param input requires an array of type int
	 * @return Sorted array of type int
	 */
    public static int[] doInsertionSort(int[] input){
        
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
}
