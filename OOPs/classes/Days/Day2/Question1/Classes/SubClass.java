package classes.Days.Day2.Question1.Classes;

public class SubClass {
	private int choice;
	public SubClass(int choice) {
		this.choice=choice;
	}
	public void run() {
		switch (choice) {
			case 1:
				Square square = new Square();
				square.draw();
				break;
			case 2:
				Circle circle = new Circle();
				circle.draw();
				break;
			case 3:
				Hexagon hexagon = new Hexagon();
				hexagon.draw();
				break;
		}
	}
}
