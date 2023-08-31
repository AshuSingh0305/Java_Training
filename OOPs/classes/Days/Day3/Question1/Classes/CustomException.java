package classes.Days.Day3.Question1.Classes;

public class CustomException extends Exception {		// Extending the built-in `Exception` class
	public CustomException(String message) {			// Constructor that takes a `string` argument
		super(message);									// Calling superclass constructor using (message)
	}
}
