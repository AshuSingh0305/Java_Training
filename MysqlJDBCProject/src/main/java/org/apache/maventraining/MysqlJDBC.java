package org.apache.maventraining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlJDBC {

	public static void main(String[] args) {
		try (
		        Connection conn = DriverManager.getConnection(
		               "jdbc:mysql://localhost:3306/ebookshop","root", "As030501");
		         Statement stmt = conn.createStatement();
		      ) {
		         String strSelect = "select title, price, qty from books";
		         System.out.println("The SQL statement is: " + strSelect + "\n");
		 
		         ResultSet rset = stmt.executeQuery(strSelect);
		         
		         System.out.println("The records selected are:");
		         int rowCount = 0;
		         
		         while(rset.next()) {
		            String title = rset.getString("title");
		            double price = rset.getDouble("price");
		            int    qty   = rset.getInt("qty");
		            System.out.println(title + ", " + price + ", " + qty);
		            ++rowCount;
		         }
		         System.out.println("Total number of records = " + rowCount);
		 
		      } catch(SQLException ex) {
		         ex.printStackTrace();
		      }  

	}

}
