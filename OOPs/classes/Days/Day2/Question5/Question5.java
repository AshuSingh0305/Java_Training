package classes.Days.Day2.Question5;

import interfaces.Start;

public class Question5 implements Start{
	public void start() {
		String inputString = "String: Quote: The Quick brown fox jumps over a lazy dog";
		String [] spliting = inputString.split(":");
		System.out.println("Original String-> "+ inputString);
		System.out.println("After Spliting");
		for (String string: spliting) {
			System.out.println(string.trim());
		}
	}
}
