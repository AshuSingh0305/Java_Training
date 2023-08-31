package classes.Days.Day3.Question2;

import interfaces.Start;

class NormalClass{
	public void method() {
		System.out.print("Method called!");
	}
}

public class Question2 implements Start{
	
	@Override
	public void start() {
		NormalClass normalClass = null;
		
		try {
			normalClass.method();
		}catch (NullPointerException e) {
			System.out.print("You caught NullPointerException");
		}
		
	}

}
