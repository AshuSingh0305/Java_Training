package classes.Days.Day3;

import classes.Days.Day3.Question1.Question1;
import classes.Days.Day3.Question2.Question2;
import classes.Days.Day3.Question3.Question3;
import classes.Days.Day3.Question4.Question4;
import classes.Days.Day3.Question5.Question5;
import interfaces.Start;

public class Day3 implements Start{
	private int question;		
	public Day3(int question) {		//initializing the question variable through constructor
		this.question=question;
	}
	
	@Override
	public void start() {
		switch (question) {			//switch case to access questions of day 3
			case 1:					// All the cases with there corresponding Question according to case number
				Question1 question1 = new Question1();		
				question1.start();
				break;
			case 2:
				Question2 question2 = new Question2();
				question2.start();
				break;
			case 3:
				Question3 question3 = new Question3();
				question3.start();
				break;
			case 4:
				Question4 question4 = new Question4();
				question4.start();
				break;
			case 5:
				Question5 question5 = new Question5();
				question5.start();
				break;
			default:		//default case
				System.out.print("Wrong Input!");
		}
	}
}
