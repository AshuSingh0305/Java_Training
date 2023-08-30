package classes.Days.Day1;

import classes.Days.Day1.Questions.Question1;
import classes.Days.Day1.Questions.Question2;
import classes.Days.Day1.Questions.Question3;
import classes.Days.Day1.Questions.Question4;
import interfaces.Start;

public class Day1 implements Start{
	private int question;
	public Day1(int question){
		this.question=question;
	}
	
	@Override
	public void start() {
		switch(question) {
			case 1:
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
		}
	}
}
