package org.apache.maventraining.Demo.Exercise;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateDatabase {
	private Connection connection;
	public CreateDatabase(Connection connection) {
		this.setConnection(connection);
	}
	public void start() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Statement statement = connection.createStatement();
		System.out.println("Enter Database name you want to create: ");
		String database = scanner.next();
		
		String sql = "CREATE DATABASE ";
		StringBuffer finalString = new StringBuffer();
		finalString.append(sql+database);
		statement.executeUpdate(finalString.toString());
		System.out.println("Database Created!");
		scanner.close();
	}
	
	//getter for connection object
	public Connection getConnection() {
		return connection;
	}
	
	//setter of connection object
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
