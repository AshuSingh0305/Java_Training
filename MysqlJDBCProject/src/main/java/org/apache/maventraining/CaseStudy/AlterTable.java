package org.apache.maventraining.CaseStudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AlterTable {
	private Connection connection;

	public AlterTable(Connection connection) {
		this.setConnection(connection);
	}

	public void start() throws SQLException {
		Statement statement = connection.createStatement();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Table Name: ");
		String tableName = scanner.next();
		if (tableExistsSQL(connection, tableName)) {
			System.out.println("Enter Update you want to perfrom: \n1-Update Record \n2-Drop Column \n3-Delete Row \n4-Truncate Table \n5-Drop table");
			int choice =scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the Row Name you want to update: ");
				String varName = scanner.next();
				System.out.println("What you want to replace with: ");
				String value = scanner.next();
				System.out.println("Enter the ID where you want to set this: ");
				int id = scanner.nextInt();
				String upd = "UPDATE " + tableName + " SET " + varName + " = '" + value + "' WHERE ID = " + id + ";";
				statement.executeUpdate(upd);
				System.out.println("Success");
				connection.close();
				scanner.close();
				break;
			case 2:
				System.out.println("Enter Column you want to drop: ");
				String colname = scanner.next();
				String del = "ALTER TABLE "+tableName+" DROP COLUMN "+colname;
				statement.executeUpdate(del);
				System.out.println("Success");
				connection.close();
				scanner.close();
				break;
			case 3:
				System.out.println("Enter ID of Employee who's data you want to delete: ");
				id = scanner.nextInt();
				String deleteRow = "DELETE FROM "+tableName+ " WHERE ID = "+id;
				statement.executeUpdate(deleteRow);
				System.out.print("Success! Row Deleted.");
				break;
			case 4:
				String truncatetable = "TRUNCATE TABLE "+tableName;
				statement.executeUpdate(truncatetable);
				System.out.print("Success! Data removed.");
				break;
			case 5:
				String droptable = "DROP TABLE "+tableName;
				statement.executeUpdate(droptable);
				System.out.print("Success! Table Removed.");
				break;
			default: 
				System.out.println("Wrong Input!");
			}
			
		}else {
			System.out.print(tableName+ "table Not Found");
		}
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
