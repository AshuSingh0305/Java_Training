package classes.Days.Day3.Question3;

import interfaces.Start;

public class Question3 implements Start {

	@Override
	public void start() {
		int arr[] = {1,2,3,4,5};
		try {
			for (int i=0;i<=5;i++) {
				System.out.print(arr[i]+"\n");
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.print("You caught ArrayIndexOutOfBoundException \n"+e);
		}

	}

}
