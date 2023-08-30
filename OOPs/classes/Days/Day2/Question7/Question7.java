package classes.Days.Day2.Question7;

import java.util.Scanner;

import classes.Days.Day1.Questions.Classes.ConDigits;
import interfaces.Start;

public class Question7 implements Start {

	@Override
	public void start() {
		Scanner scanner = new Scanner(System.in);
		int array[] = new int[20];
		System.out.print("Enter 20 integers: ");
		for(int i=0;i<20;i++) {
			array[i]=scanner.nextInt();
		}
		System.out.println("Positive Numbers: "+positiveNumbers(array));
		System.out.println("Negative Numbers: "+negativeNumbers(array));
		System.out.println("Odd Numbers: "+oddNumbers(array));
		System.out.println("Even Numbers: "+evenNumbers(array));
		System.out.println("Number of Zeros: "+zeroNumbers(array));
		scanner.close();
	}
	public int positiveNumbers(int array[]) {
		int count=0;
		for(int i=0;i<20;i++) {
			if(array[i]>0) count++;
		}
		return count;
	}
	public int negativeNumbers(int array[]) {
		int count=0;
		for(int i=0;i<20;i++) {
			if(array[i]<0) count++;
		}
		return count;
	}
	public int oddNumbers(int [] array) {
		int count=0;
		for(int i=0;i<20;i++) {
			if(array[i]%2!=0) count++;
		}
		return count;
	}
	public int evenNumbers(int [] array) {
		int count=0;
		for(int i=0;i<20;i++) {
			if(array[i]%2==0) count++;
		}
		return count;
	}
	public int zeroNumbers(int[] array) {
		int count=0;
		for(int num: array) {
			ConDigits conDigits = new ConDigits(num, 0);
			if(conDigits.conDigit(num, 0)) {
				count++;
			}
		}
		return count;
	}
}
