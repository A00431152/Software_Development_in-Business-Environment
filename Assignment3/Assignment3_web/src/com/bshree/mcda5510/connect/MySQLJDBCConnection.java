package com.bshree.mcda5510.connect;
import java.sql.Connection;
import java.sql.DriverManager;



public class MySQLJDBCConnection {

	static Connection con =null;
	private MySQLJDBCConnection() {
		
	}
	
	public static Connection getConnection() throws Exception {
		
		try {
			if (con ==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");	
//		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial_1?" 															
//					+ "user=root&password=Secret@12" // Credentials
//					+ "&useSSL=false" // b/c local host
//				+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b_shree?" 															
						+ "user=b_shree&password=A00431152" // Credentials
						+ "&useSSL=false" // b/c local host
						+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    return con;
	}
	
}
