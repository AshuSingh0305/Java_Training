package classes.Days.Day2.Question4.Classes;

public class SmartTelephone extends Telephone {

	@Override
	void lift() {
		System.out.print("Smartphone Lifted!");
	}

	@Override
	void disconnected() {
		System.out.print("Smartphone Disconnected!");
	}

}
