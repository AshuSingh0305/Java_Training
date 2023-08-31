package classes.Days.Day3.Question1;

import classes.Days.Day3.Question1.Classes.CustomException;
import interfaces.Start;

public class Question1 implements Start{
	@Override
	public void start() {
		try {
			throwCustomException();
		}catch (CustomException exception) {
			System.out.println("Caught the custom exception: " + exception.getMessage());
		}finally {
			System.out.println("This messgae is from Finally block");
		}
	}
	public static void throwCustomException() throws CustomException{
		throw new CustomException("This is Custom Exception!");
	}

}
