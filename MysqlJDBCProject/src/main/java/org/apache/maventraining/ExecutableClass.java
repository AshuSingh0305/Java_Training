package org.apache.maventraining;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.maventraining.CaseStudy.CaseStudy;
import org.apache.maventraining.Demo.ExerciseChoice;

public class ExecutableClass {
	public void start() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose what you want to access: \n1-Demo Exercise \n2-Case Study ");
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				ExerciseChoice exerciseChoice = new ExerciseChoice();
				exerciseChoice.start();
				break;
			case 2:
				CaseStudy caseStudy = new CaseStudy();
				caseStudy.start();
				break;
				
			default:
				System.out.print("Wrong Input");
		}
		scanner.close();
	}
}