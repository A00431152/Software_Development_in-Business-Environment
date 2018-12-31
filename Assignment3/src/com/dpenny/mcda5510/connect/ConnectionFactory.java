package com.dpenny.mcda5510.connect;

import java.sql.Connection;

public class ConnectionFactory {

	// use getShape method to get object of type shape
	public Connection getConnection(String connectionType) {
		if (connectionType == null) {
			return null;
		}
		if (connectionType.equalsIgnoreCase("mySQLJDBC")) {
			MySQLJDBCConnection dbConnection = new MySQLJDBCConnection();
			return dbConnection.setupConnection();

		} else if (connectionType.equalsIgnoreCase("Mock")) {
			return new MockConnection();

		} else if (connectionType.equalsIgnoreCase("CSSMUCA")) {
			// TODO

		}

		return null;
	}

}
