package org.apache.maventraining.Demo.Exercise;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDynamicData {
	private Connection connection;

	public InsertDynamicData(Connection connection) {
		this.setConnection(connection);
	}

	public void start() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Table Name you want to add Data to: ");
		String tableName = scanner.next();
		System.out.println("Enter Id:");
		String id = scanner.next();
		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter Age:");
		String age = scanner.next();
		System.out.println("Enter Address:");
		String address = scanner.next();
		System.out.println("Enter Salary:");
		String salary = scanner.next();
		String sql = "insert into "+ tableName+" values("+id+",'"+name+"',"+ age+", '"+address+"' ,"+salary+")";
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(sql);
		if (result == 1)
			System.out.println("Transaction Successful" + sql);
		else
			System.out.println("Transaction Failed");
		connection.close();
		scanner.close();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
