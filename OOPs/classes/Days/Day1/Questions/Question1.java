package classes.Days.Day1.Questions;

import java.util.Scanner;

import classes.Days.Day1.Questions.Classes.ConDigits;
import interfaces.Start;

public class Question1 implements Start{
	@Override		
	public void start() {		//Redefining the Start method According to Question1 usage
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of Array: ");
		int num = scanner.nextInt();		//Size of array
		int arr[] = new int[num];
		System.out.print("Enter "+num+" Numbers: ");
		for(int i=0;i<num;i++) {			//Adding Numbers to the Array using for loop
			arr[i]=scanner.nextInt();
		}
		System.out.print(checkNine(arr));	//Calling checkNine Method
		scanner.close();
	}
	public String checkNine(int[] array) {	
		for(int num: array) {				//iterating through each input of Array
			ConDigits conDigits = new ConDigits(num, 9);		//using ConDigits class 
			if(conDigits.conDigit(num, 9)) {					//using the method created inside the ConDigits Class 
				return "Bingo";
			}
		}
		return "There is no 9 in the array";			//if the conditions turns out to be false
	}
	
	
}
