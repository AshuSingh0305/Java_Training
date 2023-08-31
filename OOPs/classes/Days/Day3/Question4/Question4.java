package classes.Days.Day3.Question4;

import interfaces.Start;

public class Question4 implements Start {

	@Override
	public void start() {
		try {
			throwCustomException();
		} catch (CustomException e) {
			e.displayErrorMessage();
		}

	}
	public static void throwCustomException() throws CustomException {
		throw new CustomException("This is a custom Exception");
	}

}

class CustomException extends Exception{
	private String errorMessage;
	
	public CustomException (String errorMessage) {
		this.errorMessage=errorMessage;
	}
	
	public void displayErrorMessage() {
		System.out.print("Custom Exception: "+ errorMessage);
	}
}
