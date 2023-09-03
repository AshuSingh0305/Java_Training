package org.apache.maventraining.CaseStudy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class ReadData {
	private Connection connection;

	public ReadData(Connection connection) {
		this.setConnection(connection);
	}

	public void start() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Table Name: ");
		String tableName = scanner.next();
		Statement statement = connection.createStatement();
		if (tableExistsSQL(connection, tableName)) {
			System.out.println("Enter Employee ID you want to Read data of: ");
			int id = scanner.nextInt();
			String sql = "SELECT * FROM " + tableName + " WHERE ID= " + id + ";";
			ResultSet rset = statement.executeQuery(sql);

			System.out.println("The records selected are:");
			int rowCount = 0;

			while (rset.next()) {
				String str = (rset.getInt("ID")+ ", " + rset.getString("Name")+ ", " + rset.getString("Designation")+ ", "
						+rset.getString("Qualification")+ ", "+rset.getDate("DOB")+ ", "+rset.getString("ContactNumber")+ ", "
						+rset.getDouble("Salary")+ ", "+rset.getInt("TotalExperience"));
				++rowCount;
				File file = new File("C:\\Users\\ashu.singh\\eclipse-workspace\\MysqlJDBCProject\\src\\main\\java\\org\\apache\\maventraining\\CaseStudy\\Output.txt");
				writeToFile(file, str);
			}
			System.out.println("Total number of records = " + rowCount);
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
	
	public void writeToFile(File filename, String text) {
		try {
			long currentTime = System.currentTimeMillis();
			Date currentDate = new Date(currentTime);
			FileWriter filewriter = new FileWriter(filename, true);
			filewriter.write("\n \n"+currentDate+"\n"+text);
			System.out.println("text written to "+ filename);
			filewriter.close();
		}catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
