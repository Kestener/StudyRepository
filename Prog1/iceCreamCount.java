/*
 * This program reads the file icecream.dat, count the total number of cones
 * sold and then the number of "Stawberry" cones sold and the percentage of
 * them from the total of ice creams.
 */
package icecreamcount;

/**
 *
 * @author macbook
 */
public class IceCreamCount {

    public static void main(String[] args) {
    
    while(true) {
        try {
            TextIO.readUserSelectedFile(); // Try to open the file to read
            break; // If that succeeds, break out of the loop.
        }
        catch ( IllegalArgumentException e) {
            System.out.println("Can't read from the file.");
            System.out.println("Please try again. \n");
        }
    }
    /* Now the TextIO is reading from the file. */
    
    String iceCreamType; // Type of Ice Cream read from the file.
    double iceCount; // The number of ice creams counted in total.
    double strawSum; // The number of Strawberries icecreams.
    
    iceCount = 0;
    strawSum = 0;
    
        try {
            while (true){
                iceCreamType = TextIO.getln();
                iceCount++; 
                if (iceCreamType.equals("Strawberry")) {
                    strawSum++;
                }   
            }
        }
        catch ( IllegalArgumentException e ) {
            // We expect this to occur when the end-of-file is encountered.
            // We don't consider this to be an error, so there is nothing to do
            // in this catch clause.  Just proceed with the rest of the program.
        }
    
    // Output part of the program.
    
    System.out.println();
    System.out.println("Number of ice creams sold: " +iceCount);
    System.out.println("Number of Strawberry ice creams sold: " +strawSum);
    System.out.println((strawSum/iceCount)*100 + " percent of total");
    }
    
}
