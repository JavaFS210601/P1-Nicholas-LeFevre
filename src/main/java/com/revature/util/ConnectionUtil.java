package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

public static Connection getConnection() throws SQLException {
		
		//For compatibility with other technologies/frameworks, we will need to register our driver
		//This process makes the application aware of what driver class (what SQL dialect) we're using
		
		try {
			Class.forName("org.postgresql.Driver"); //try to find and return the postgresql driver class
		}catch (ClassNotFoundException e) {
			System.out.println("Class wasn't found :(");
			e.printStackTrace(); //prints the exception message to the console
		}
		
		//We need to provide our databaase credentials
		//We'll hardcode them for now, but we'll see how to hide this username/password in environment variables
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=\"project1\"";
		String username = "postgres";
		String password = "Warminster11"; //this will be whatever password you set in postgres
		
		return DriverManager.getConnection(url, username, password);
	}
	
}
