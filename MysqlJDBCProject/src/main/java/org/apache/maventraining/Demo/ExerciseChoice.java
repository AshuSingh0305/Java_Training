package org.apache.maventraining.Demo;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.maventraining.Demo.Exercise.*;

public class ExerciseChoice {
	public void start() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose the Exercise you want to access: \n1-MySQL JDBC connection");
		int choice = scanner.nextInt();
		switch(choice) {
			case 1:
				MysqlJDBC mysqljdbc = new MysqlJDBC();
				mysqljdbc.start();
				break;
				
			default: 
				System.out.println("Wrong Input!");
		}
		scanner.close();
	}
}
