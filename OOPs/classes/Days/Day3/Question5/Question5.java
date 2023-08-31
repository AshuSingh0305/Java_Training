package classes.Days.Day3.Question5;

import interfaces.Start;

class CustomException1 extends Exception {
	   public CustomException1(String message) {
	       super(message);
	   }
	}

	class CustomException2 extends Exception {
	   public CustomException2(String message) {
	       super(message);
	   }
	}

	class CustomException3 extends Exception {
	   public CustomException3(String message) {
	       super(message);
	   }
	}
	
class ExceptionThrower {
	   public void throwAllExceptions(int choice) throws CustomException1, CustomException2, CustomException3 {
	       if (choice == 1) {
	           throw new CustomException1("Custom Exception 1 occurred.");
	       } else if (choice == 2) {
	           throw new CustomException2("Custom Exception 2 occurred.");
	       } else {
	           throw new CustomException3("Custom Exception 3 occurred.");
	       }
	   }
	}


public class Question5 implements Start {

	@Override
	public void start() {
		 ExceptionThrower thrower = new ExceptionThrower();

	       try {
	           thrower.throwAllExceptions(1);
	       } catch (CustomException1 | CustomException2 | CustomException3 e) {
	           System.out.println("Caught exception: " + e.getMessage());
	       }

	}

}
