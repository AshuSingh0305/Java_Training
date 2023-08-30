package classes.Days.Day2.Question2.Classes;

import classes.Days.Day2.Question2.Interfaces.PrintChild;

public class ChildClass extends ParentClass implements PrintChild{
	
	@Override
	public void printChildMessage(){
		System.out.println("You entered Child Class!");
	}
}
