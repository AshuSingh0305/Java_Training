package org.apache.maventraining.CaseStudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		System.out.println("Enter Table Name: ");
		String tableName = scanner.next();
		if (tableExistsSQL(connection, tableName)) {
			System.out.println("Enter ID: ");
			int id = scanner.nextInt();
			System.out.println("Enter Name: ");
			String name = scanner.next();
			System.out.println("Enter Designation: ");
			String Designation = scanner.next();
			System.out.println("Enter Qualification: ");
			String Qualification = scanner.next();
			System.out.println("Enter DOB: ");
			String DOB = scanner.next();
			System.out.println("Enter Contact Number: ");
			String contactNum = scanner.next();
			System.out.println("Enter Salary: ");
			String salary = scanner.next();
			System.out.println("Enter Total Experience: ");
			int exp = scanner.nextInt();

			String sql = "INSERT INTO " + tableName + " VALUES (" + id + ",'" + name + "', '" + Designation + "', '"
					+ Qualification + "', '"+ DOB + "', '" + contactNum 
					+ "', '" + salary + "', " + exp + ");";

			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			if (result == 1)
				System.out.println("Transaction Successful " + sql);
			else
				System.out.println("Transaction Failed");
		}else {
			System.out.print("Table Not Found!");
		}
		
		scanner.close();
	}

	public boolean tableExistsSQL(Connection connection, String tableName) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT count(*) " + "FROM information_schema.tables " + "WHERE table_name = ?" + "LIMIT 1;");
		preparedStatement.setString(1, tableName);

		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return resultSet.getInt(1) != 0;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
