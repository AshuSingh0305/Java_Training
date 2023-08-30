package classes.Days.Day2.Question4.Classes;

public class FountainPen extends Pen {

	@Override
	void write() {
		System.out.print("Writing with Fountain Pen!");

	}

	@Override
	void refill() {
		System.out.print("Refilling a fountain Pen!");
	}
	
	public void changeNib() {
		System.out.print("Changing Nib of Pen");
	}

}
