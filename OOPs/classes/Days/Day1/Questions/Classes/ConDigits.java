package classes.Days.Day1.Questions.Classes;

public class ConDigits {
	int number;
	int testNumber;
	public ConDigits(int number, int testNumber) {
		this.number=number;
		this.testNumber=testNumber;
	}
	public boolean conDigit(int numb, int digit) {
		while(numb > 0) {
			int lastDigit = numb % 10;
			if(lastDigit == digit) {
				return true;
			}
			numb /=10;
		}
		return false;
	}
}
