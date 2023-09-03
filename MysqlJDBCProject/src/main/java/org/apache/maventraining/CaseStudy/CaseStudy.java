package org.apache.maventraining.CaseStudy;

import java.sql.SQLException;
import java.util.Scanner;

public class CaseStudy {
	public void start() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Enter your choice: \n1-Create Database \n2-Select Database");
		int choice = scanner.nextInt();
		switch(choice) {
			case 1:
				CreateDatabase createdatabase = new CreateDatabase();
				createdatabase.start();
				break;
			case 2:
				SelectDatabase selectdatabase = new SelectDatabase();
				selectdatabase.start();
				break;
			case 3:
				System.out.println("Program Terminated!");
				break;
			default: 
				System.out.print("Wrong Input!");
		}
		scanner.close();
	}

}
