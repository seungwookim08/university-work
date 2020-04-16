// -----------------------------------------------------
// Assignment #3
// Part: Part 1(include Part Number)
// Written by: Seungwoo Kim, 400000230 (include your name(s) and student ID(s))
// -----------------------------------------------------
@SuppressWarnings("serial")
public class DuplicateISBNException extends Exception{
	public DuplicateISBNException() {
		super("Duplication of ISBN has been found.");
	}
	public DuplicateISBNException(String m) {
		super(m);

	}

}
