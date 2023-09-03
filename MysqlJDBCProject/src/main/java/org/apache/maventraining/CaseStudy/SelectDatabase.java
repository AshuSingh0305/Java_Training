package org.apache.maventraining.CaseStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectDatabase {
	public void start() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Database name you want to select: ");
		String databaseName = scanner.next();
		String serverName = "jdbc:mysql://localhost:3306/";
		StringBuffer dbName = new StringBuffer();
		dbName.append(serverName + databaseName);

		Connection connection = DriverManager.getConnection(dbName.toString(), "root", "As030501");

		System.out.println("Database Connected " + dbName.toString());

		System.out.println("Select Choice you want to perform: \n1-Create Table \n2-Insert Data in Table \n3-Alter Table \n4-Read Data");

		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			CreateTable createTable = new CreateTable(connection);
			createTable.start();
			break;
		case 2:
			InsertDynamicData insertDynamicData = new InsertDynamicData(connection);
			insertDynamicData.start();
			break;
		case 3:
			AlterTable altertable = new AlterTable(connection);
			altertable.start();
			break;
		case 4:
			ReadData readdata = new ReadData(connection);
			readdata.start();
			break;
			
		default:
			System.out.print("Wrong Input!");
		}

		connection.close();
		scanner.close();

	}
}
