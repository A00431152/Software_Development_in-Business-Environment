package com.dpenny.mcda5510.connect;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLJDBCConnection implements DBConnection{

	public Connection setupConnection()  {

		Connection connection = null;
		try {
			// This will load the MySQL driver, each DB has its own driver
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB

		//	connection = DriverManager.getConnection("jdbc:mysql://localhost/transactoins?" 				+ "user=root&password=db123456" // Creds
		//			+ "&useSSL=false" // b/c localhost
		//			+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); // timezone


			connection = DriverManager.getConnection("jdbc:mysql://localhost/transaction?" 															
					+ "user=root&password=Secret@12" // Credentials
					+ "&useSSL=false" // b/c local host
					+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); 
			
		} catch (Exception e) {
			System.out.println("Error setting up connectino");
			e.printStackTrace();
		} finally {

		}
		return connection;
	}		
	
	
}
