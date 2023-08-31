package classes.Days;

import java.util.Scanner;

import classes.Days.Day1.Day1;
import classes.Days.Day2.Day2;
import classes.Days.Day3.Day3;
import interfaces.Start;

public class DayChoice implements Start{
	Scanner scanner = new Scanner(System.in);
	private int choice;
	public DayChoice(int choice) {		//initializing the value of variable received from the ExecutableClass about day you want to access
		this.choice = choice;
	}
	
	@Override
	public void start() {		// Overriding the start Method of Start Interface
		System.out.println("Enter Question you want to see: \n Day One Consists of 4 Questions, so options are 1-4 \n Day Two consists of "
				+ "10 Questions, so options are 1-10: ");
		int question = scanner.nextInt();		//Taking input for Question number you want to Access
		switch (choice) {
			case 1:
				Day1 day1 = new Day1(question);		//Passing value to the Constructor
				day1.start();		//Calling start method of Day1 class
				break;
			case 2:
				Day2 day2 = new Day2(question);		//Passing value to the Constructor
				day2.start();		//Calling start method of Day2 class
				break;
			case 3:
				Day3 day3 = new Day3(question);
				day3.start();
				break;
			default:
				System.out.print("You entered a Wrong choice!");
				break; //default case
				
		}
	}
}
