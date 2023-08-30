package classes.Days.Day2.Question2.Classes;

import classes.Days.Day2.Question2.Interfaces.PrintParent;

public class ParentClass implements PrintParent{
	
	@Override
	public void printParentMessage() {
		System.out.println("You entered the Parent Class!");
	}

}
