package turingMachine;

import java.lang.StringBuilder;

/**
 * The class has an instance variable of type Cell currentCell that points to the current
 * one being visualized by the machine. It also has the requested methods of the assignment
 * to be compatible with the programs provided.
 * @author macbook
 *
 */
public class Tape {
	
	private Cell currentCell;
	private char initialValue = '\0';
	
	/**
	 * Constructor to create the initial cell with blank value.
	 */
	public Tape () {
		
		currentCell = new Cell();
		setContent(initialValue);
		
	}
	
	/**
	 * Setter to define the content of the current selected cell on the tape.
	 * @param content must be a char element
	 */
	public void setContent(char content) {
		getCurrentCell().content = content;
	}
	
	/**
	 * Getter to return the content of the current selected cell on the tape.
	 * @return the value content of the current selected cell on the tape.
	 */
	public char getContent() {
		return getCurrentCell().content;
	}
	
	/**
	 * 
	 * @return the pointer that points to the current cell.
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}
	
	/**
	 * Moves the current cell one position to the left in the tape.
	 */
	public void moveLeft() {
		if ( getCurrentCell().prev == null) {
			getCurrentCell().prev = new Cell();
			getCurrentCell().prev.next = getCurrentCell();
			getCurrentCell().prev.content = initialValue;
		}
		currentCell = getCurrentCell().prev;
	}
	
	/**
	 * Moves the current cell one position to the right in the tape.
	 */
	public void moveRight() {
		if ( getCurrentCell().next == null) {
			getCurrentCell().next = new Cell();
			getCurrentCell().next.prev = getCurrentCell();
			getCurrentCell().next.content = initialValue;
		}
		currentCell = getCurrentCell().next;
	}
	
	/**
	 * This method uses the StringBuilder class to parse the chars in the tape and then
	 * append them before returning the String value. The first while loop runs to the first
	 * position (leftmost) of the tape and the second loop start appending each char to the
	 * content StringBuilder object.
	 * @return the String after converting the result toString and trim the spaces.
	 */
	public String getTapeContents() {
		StringBuilder content = new StringBuilder();
		Cell runner = getCurrentCell();
		
		while (runner.prev != null) {
			runner = runner.prev;
		}
		while (runner.next != null) {
			content.append(runner.content);
			runner = runner.next;
		}
		content.append(runner.content);
		return content.toString().trim();
	}
}
