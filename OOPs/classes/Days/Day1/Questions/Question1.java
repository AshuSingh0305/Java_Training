package classes.Days.Day1.Questions;

import java.util.Scanner;

import classes.Days.Day1.Questions.Classes.ConDigits;
import interfaces.Start;

public class Question1 implements Start{
	@Override
	public void start() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of Array: ");
		int num = scanner.nextInt();
		int arr[] = new int[num];
		System.out.print("Enter "+num+" Numbers: ");
		for(int i=0;i<num;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.print(checkNine(arr));
		scanner.close();
	}
	public String checkNine(int[] array) {
		for(int num: array) {
			ConDigits conDigits = new ConDigits(num, 9);
			if(conDigits.conDigit(num, 9)) {
				return "Bingo";
			}
		}
		return "There is no 9 in the array";
	}
	
	
}
