package classes.Days.Day2.Question9;

import java.util.Date;

import interfaces.Start;

public class Question9 implements Start{
	
	@Override
	public void start(){
		long currentTime = System.currentTimeMillis();
		
		Date currentDate = new Date(currentTime);
		System.out.println("Current date and Time: "+currentDate);
	}
}
