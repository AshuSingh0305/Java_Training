package org.apache.maventraining.CaseStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateDatabase {
	public void start() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Database Name: ");
		String dbName = scanner.next();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "As030501");
		Statement statement = connection.createStatement();
		String sql = "CREATE DATABASE " + dbName;
		statement.executeUpdate(sql);
		System.out.println("Success! Database Created.");
		CaseStudy casestudy = new CaseStudy();
		casestudy.start();
		scanner.close();

	}
}
