package classes.Days.Day2.Question4;

import classes.Days.Day2.Question4.Classes.SmartTelephone;
import classes.Days.Day2.Question4.Classes.Telephone;
import interfaces.Start;

public class Question4 implements Start{
	public void start() {
		System.out.println("You can refer classes from Package Explorer. Question 4 was about creating Classes and Interfaces");
		System.out.println("Demonstrating Polymorphism: ");
		Telephone telephone = new SmartTelephone();
/*		
 			Telephone telephone2 = new Telephone() {
			@Override
			void disconnected() {
				System.out.print("Not Accessible!");
			}
		};
*/
//		telephone.lift();
	}
}
