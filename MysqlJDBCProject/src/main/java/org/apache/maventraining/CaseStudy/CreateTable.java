package org.apache.maventraining.CaseStudy;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {
	private Connection connection; 
	public CreateTable(Connection connection) {
		this.setConnection(connection);
	}

	public void start() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of table: ");
		String tableName = scanner.nextLine();
		StringBuffer sql = new StringBuffer();
		Statement statement = connection.createStatement();
		System.out.println("Enter the Number of fields you want to enter in Table: ");
		int fields = scanner.nextInt();
		sql.append("CREATE TABLE "+ tableName+"(\n");
		for(int i=0;i<fields;i++) {
			System.out.println("Enter the type of field: \n1-String \n2-Int \n3-Int (Auto Increment) \n4-Double \n4-Date ");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter Variable Name: ");
					String varName1 = scanner.next();
					sql.append(varName1 + " VARCHAR(50) NOT NULL,\n");
					break;
				case 2:
					System.out.println("Enter Variable Name: ");
					String varName2 = scanner.next();
					sql.append(varName2 + " INT NOT NULL,\n");
					break;
				case 3: 
					System.out.println("Enter Variable Name: ");
					String varName3 = scanner.next();
					sql.append(varName3 + " INT NOT NULL AUTO_INCREMENT,\n");
					break;
				case 4:
					System.out.println("Enter Variable Name: ");
					String varName4 = scanner.next();
					sql.append(varName4+ " DECIMAL (18,2), \n");
					break;
				case 5:
					System.out.println("Enter Variable Name: ");
					String varName5 = scanner.next();
					sql.append(varName5+" DATE,\n");
				default:
					System.out.print("Wrong Input!");
			}
		}

		System.out.println("Update Primary Key, Enter Variable name of Primary Key: ");
		sql.append("PRIMARY KEY ("+scanner.next()+")\n);");

		statement.executeUpdate(sql.toString());
		System.out.println("Success table created named : "+tableName);
		
		System.out.println("Enter Your Choice: \n1-Insert Data into Table \n2-Exit Program");
		int choice=scanner.nextInt();
		if(choice==1) {
			InsertDynamicData insertdynamicdata = new InsertDynamicData(connection);
			insertdynamicdata.start();
		}else if(choice==2){
			System.out.print("Program terminated!");
		}else {
			System.out.print("Wrong Choice! Program terminated!");
		}
		
		scanner.close();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
