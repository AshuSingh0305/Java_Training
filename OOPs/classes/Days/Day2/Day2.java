package classes.Days.Day2;

import classes.Days.Day2.Question1.Question1;
import classes.Days.Day2.Question10.Question10;
import classes.Days.Day2.Question2.Question2;
import classes.Days.Day2.Question3.Question3;
import classes.Days.Day2.Question4.Question4;
import classes.Days.Day2.Question5.Question5;
import classes.Days.Day2.Question6.Question6;
import classes.Days.Day2.Question7.Question7;
import classes.Days.Day2.Question9.Question9;
import interfaces.Start;

public class Day2 implements Start{
	
	private int question;
	public Day2(int question){
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
			case 5:
				Question5 question5 = new Question5();
				question5.start();
				break;
			case 6:
				Question6 question6 = new Question6();
				question6.start();
				break;
			case 7:
				Question7 question7 = new Question7();
				question7.start();
				break;
			case 9:
				Question9 question9 = new Question9();
				question9.start();
				break;
			case 10:
				Question10 question10 = new Question10();
				question10.start();
				break;
		}
	}
	
}
