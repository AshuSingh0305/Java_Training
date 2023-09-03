package org.apache.maventraining.Demo.Exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MysqlJDBC {

	public void start() throws ClassNotFoundException, SQLException{
		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","As030501");
		System.out.println("Success! MySql connection established. \nSelect what you want to perform \n"
				+ "1-Create Database \n2-Select Database");
		int choice = scanner.nextInt();
		
		switch(choice) {
			case 1:
				CreateDatabase createdatabase = new CreateDatabase(connection);
				createdatabase.start();
				break;
			case 2:
				SelectDatabase selectdatabase = new SelectDatabase();
				selectdatabase.start();
				break;
				
			default:
				System.out.print("Wrong Input!");
				break;
		}
		connection.close();
		scanner.close();

	}

}
