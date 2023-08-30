package classes.Days.Day1.Questions;

import java.util.Scanner;

import interfaces.Start;

public class Question3 implements Start{
	
	@Override
	public void start() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number of letter you want to enter");
		int num = scanner.nextInt();
		char arr[] = new char[num];
		System.out.print("Enter " +num+ " Letters");
		for(int i=0;i<num;i++) {
			arr[i] = scanner.next().charAt(0);
		}
		System.out.print(findLetter(arr));
		scanner.close();
	}
	public char findLetter(char[] arr) {
		char missLetter = 0;
		int prevChar = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-prevChar>1) {
				missLetter = (char) (prevChar+1);
				break;
			}
			prevChar = arr[i];
		}
		return missLetter;
	}
}
