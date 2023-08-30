package classes.Days.Day2.Question4.Classes;

import classes.Days.Day2.Question4.Interfaces.BasicAnimal;

public class Human extends Monkey implements BasicAnimal {

	@Override
	public void eat() {
		System.out.print("Human is eating!");

	}

	@Override
	public void sleep() {
		System.out.print("Human is Sleeping!");

	}

}
