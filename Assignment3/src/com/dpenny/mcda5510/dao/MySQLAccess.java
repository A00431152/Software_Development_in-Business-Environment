package com.dpenny.mcda5510.dao;

/**
 * Original source code from 
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * 
**/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.dpenny.mcda5510.entity.Transaction;

public class MySQLAccess {



	public Collection<Transaction> getAllTransactions(Connection connection) {
		Statement statement = null;
		ResultSet resultSet = null;
		Collection<Transaction> results = new ArrayList<Transaction>();
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from transactoins.transaction");
			results = createTrxns(resultSet);

			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			statement = null;
			resultSet = null;
		}
		return results;

	}

	private Collection<Transaction> createTrxns(ResultSet resultSet) throws SQLException {
		Collection<Transaction> results = new ArrayList<Transaction>();

		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			Transaction trxn = new Transaction();
			trxn.setNameOnCard(resultSet.getString("NameOnCard"));
			trxn.setCardNumber(resultSet.getString("CardNumber"));
			results.add(trxn);

			// TODO
			/*
			 * String ID = resultSet.getString("ID"); String ExpDate =
			 * resultSet.getString("ExpDate"); String UnitPrice =
			 * resultSet.getString("UnitPrice"); Integer qty =
			 * resultSet.getInt("Quantity"); String totalPrice =
			 * resultSet.getString("TotalPrice"); Date createdOn =
			 * resultSet.getDate("CreatedOn"); String createdBy =
			 * resultSet.getString("CreatedBy");
			 */

		}

		return results;

	}

	public void updateTransaction(Connection connection,Transaction trxn) {
		// DO the update SQL here
		
	}

}
