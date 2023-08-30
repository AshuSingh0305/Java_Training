package classes.Days.Day1.Questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import interfaces.Start;

public class Question2 implements Start{

	@Override
	public void start() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the String you want to order by length: ");
		String string = scanner.nextLine();
		System.out.print(checkLength(string));	
		scanner.close();
	}
	public String checkLength(String string) {
		String[] words = string.split("\\s+");
		Arrays.sort(words, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
		
		return String.join(" ", words);
	}
	
}
