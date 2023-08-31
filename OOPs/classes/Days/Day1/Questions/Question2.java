package classes.Days.Day1.Questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import interfaces.Start;

public class Question2 implements Start{		//implements the interface Start

	@Override
	public void start() {						//Redefining the start function according to Question2 Class
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the String you want to order by length: ");
		String string = scanner.nextLine();		//string you want to use as input
		System.out.print(checkLength(string));	//calling the checkLength function which aligns the words by length 
		scanner.close();
	}
	public String checkLength(String string) {
		String[] words = string.split("\\s+");	//Splitting the words after every space " "
		Arrays.sort(words, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())); /* using inbuilt sort function*/
		
		return String.join(" ", words);
	}
	
}
