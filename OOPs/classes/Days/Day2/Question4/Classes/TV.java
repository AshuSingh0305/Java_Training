package classes.Days.Day2.Question4.Classes;

import classes.Days.Day2.Question4.Interfaces.TVRemote;

public class TV implements TVRemote {

	@Override
	public void turnOn() {
		System.out.print("TV turned On!");

	}

	@Override
	public void turnOff() {
		System.out.print("TV turned off!");

	}

}
