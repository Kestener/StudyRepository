package turingMachine;

public class Tape {
	
	Cell currentCell;
	
	Tape() {
		Cell initialCell = new Cell();
		initialCell.content = '\0';
		currentCell = initialCell;
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}
	
	public char getContent() {
		return currentCell.content;
	}
	
	public void setContent(char ch) {
		currentCell.content = ch;
	}
	
	public void moveLeft() {
		if ( currentCell.prev == null) {
			Cell cellLeft = new Cell();
			cellLeft.content = currentCell.content; 
			cellLeft.next = currentCell;
			currentCell.content = '\0';
			currentCell.prev = cellLeft;
		}else {
			currentCell = currentCell.prev;
		}
	}
	
	public void moveRight() {
		if ( currentCell.next == null) {
			Cell cellRight = new Cell();
			cellRight.content = currentCell.content; 
			cellRight.prev = currentCell;
			currentCell.content = '\0';
			currentCell.next = cellRight;
		}else {
			currentCell = currentCell.next;
		}
	}

	public String getTapeContents() {
		return "test";
	}
}
