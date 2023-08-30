package classes.Days.Day2.Question1;

import java.util.Scanner;

import classes.Days.Day2.Question1.Classes.SubClass;
import interfaces.Start;

public class Question1 implements Start{
	
	@Override
	public void start() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Choice number you want to enter: \n 1. Square Class \n 2. Circle Class\n 3. Hexagon Class");
		int choice = scanner.nextInt();
		SubClass subClass = new SubClass(choice);
		subClass.run();
		scanner.close();
	}
}
