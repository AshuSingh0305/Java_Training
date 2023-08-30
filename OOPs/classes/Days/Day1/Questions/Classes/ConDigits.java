package classes.Days.Day1.Questions.Classes;

public class ConDigits {
	int number;
	int testNumber;
	public ConDigits(int number, int testNumber) {		//Constructor initialization 
		this.number=number;
		this.testNumber=testNumber;
	}
	public boolean conDigit(int numb, int digit) {		/* Method conDigit which takes input numb i.e. the input from the array and digit 
															variable is the the digit you want to check if present in the number*/
		while(numb > 0) {							//Checking if the number is greater than 0
			int lastDigit = numb % 10;				// checking for remainder
			if(lastDigit == digit) {
				return true;
			}
			numb /=10;								
		}
		return false;
	}
}
