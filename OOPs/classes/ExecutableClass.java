package classes;

import java.util.Scanner;
import classes.Days.*;
import interfaces.Start;

public class ExecutableClass implements Start {		//using method from the interface Start;
	
	@Override
	public void start() {	// Redefining the method 
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Day Number you want to access Questions of: \n 1-Day One \n 2- Day Two");
		int choice = scanner.nextInt();
		DayChoice dayChoice = new DayChoice(choice);	// Creating Object of DayChoice and passing the variable to the constructor to initialize its value
		dayChoice.start();		// Calling start method
		scanner.close();		//closing the object for Scanner Class
	}
}
