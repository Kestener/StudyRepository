import java.io.File;
import java.util.Scanner;

/**
 * This program lists the files in a directory specified by
 * the user.  The user is asked to type in a directory name.
 * If the name entered by the user is not a directory, a
 * message is printed and the program ends.
 */
public class DirectoryList {


   public static void main(String[] args) {

      String directoryName;  // Directory name entered by the user.
      File directory;        // File object referring to the directory.
      Scanner scanner;       // For reading a line of input from the user.

      scanner = new Scanner(System.in);  // scanner reads from standard input.

      System.out.print("Enter a directory name: ");
      directoryName = scanner.nextLine().trim();
      directory = new File(directoryName);

      if (directory.isDirectory() == false) {
         if (directory.exists() == false)
            System.out.println("There is no such directory!");
         else
            System.out.println("That file is not a directory.");
      }
      else {
    	  	// Call to the recursive method to list all directories and organize. Start without blank space.
    	  	recursiveDirectory(directory,"");
      }

   } // end main()
   
   /**
    * This subroutine uses recursion to list the contents of a directory and also the
    * contents of the directory inside it (and so on...) as it is defined recursively.
    * @param dir the directory to be listed. It must be a directory, as it is checked in the
    * main routine of the program.
    * @param indentation includes spaces to organize the output visually. It adds more space
    * as long as there are more sub-folders in the directory.
    */
   
   private static void recursiveDirectory (File dir, String indentation) {
 	  
	   String[] files; // // Array of file names in the directory moved from main.
	   
	   System.out.println(indentation + "Directory \""+ dir.getName()+"\":");
	   indentation += " "; // This adds the space when the contents are listed.
	   files = dir.list();
	   
	   for (int i = 0; i < files.length; i++) {
		   // Print the name if there are no more directories.
		   File f = new File(dir, files[i]);
		   
		   if (f.isDirectory())
			   // If the file is directory then the recursive call is done.
			   recursiveDirectory(f,indentation);
		   else
			   System.out.println(indentation + files[i]);
		     
	   }
	   
   } // end recursiveDirectory

} // end class DirectoryList
