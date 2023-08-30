package classes.Days.Day1;

import classes.Days.Day1.Questions.Question1;
import classes.Days.Day1.Questions.Question2;
import classes.Days.Day1.Questions.Question3;
import classes.Days.Day1.Questions.Question4;
import interfaces.Start;

public class Day1 implements Start{
	private int question;		//declaring a variable 
	public Day1(int question){		//initializing the value of question which was passed from DayChoice class
		this.question=question;
	}
	
	@Override
	public void start() {		//Overriding the start method of interface Start
		
		switch(question) {		//Switch case to go to a particular question of Day-1
			case 1:
				Question1 question1 = new Question1();		//Creating an object
				question1.start();							//Using a start method to initiate the process
				break;
			case 2:
				Question2 question2 = new Question2();		//Creating an object
				question2.start();							//Using a start method to initiate the process
				break;
			case 3:
				Question3 question3 = new Question3();		//Creating an object
				question3.start();							//Using a start method to initiate the process
				break;
			case 4:
				Question4 question4 = new Question4();		//Creating an object
				question4.start();							//Using a start method to initiate the process
				break;
			default:										// Default method
				System.out.println("Wrong input!");			
		}
	}
}
