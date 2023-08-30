package classes.Days.Day1.Questions;

import java.util.Scanner;

import interfaces.Start;

public class Question4 implements Start{
	public void start() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter input String: ");
		String input = scanner.next();
		System.out.print("Enter The Complete Word: ");
		String com = scanner.next();
		if(canComplete(input, com))
			System.out.print("True");
		else
			System.out.print("False");
		scanner.close();
	}
	public boolean canComplete(String input, String complete) {
		int index=0;
		for(char c: complete.toCharArray()) {
			if(index<input.length() && c==input.charAt(index)) {
				index++;
			}
		}
		return index==input.length();
	}

}
