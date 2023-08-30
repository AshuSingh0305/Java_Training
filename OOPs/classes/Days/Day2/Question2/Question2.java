package classes.Days.Day2.Question2;

import classes.Days.Day2.Question2.Classes.ChildClass;
import classes.Days.Day2.Question2.Classes.ParentClass;
import interfaces.Start;

public class Question2 implements Start{
	
	@Override
	public void start() {
		ParentClass parentClass = new ParentClass();
		parentClass.printParentMessage();
		ChildClass childClass = new ChildClass();
		childClass.printChildMessage();
		childClass.printParentMessage();
	}
}
