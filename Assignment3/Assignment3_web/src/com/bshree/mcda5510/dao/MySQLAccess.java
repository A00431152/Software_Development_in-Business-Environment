package com.bshree.mcda5510.dao;

import java.io.IOException;

/**
 * Original source code from 
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * 
**/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bshree.mcda5510.connect.MySQLJDBCConnection;
import com.bshree.mcda5510.entity.Transaction;

import java.sql.PreparedStatement;

public class MySQLAccess {
	public static Logger logger = Logger.getLogger("MyLog");

	public static void log(Level l, String message) {
		try {
		
			//FileHandler handler = new FileHandler("./capturedlogs_web.log", true);
			//logger.addHandler(handler);
			 logger.setLevel(Level.ALL);
			 
			logger.log(l, message);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getAllTransactions() throws Exception {
		Statement statement = null;
		ResultSet resultSet = null;

		String res = "";
		try {

			Connection connection = MySQLJDBCConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from transaction");
			while (resultSet.next()) {

				Transaction trxn = new Transaction();
				trxn.setID(resultSet.getInt("ID"));
				trxn.setNameOnCard(resultSet.getString("NameOnCard"));
				trxn.setCardNumber(resultSet.getString("CardNumber"));
				trxn.setUnitprice(resultSet.getDouble("UnitPrice"));
				trxn.setQuantity(resultSet.getInt("Quantity"));
				trxn.setTotalPrice(resultSet.getDouble("TotalPrice"));
				trxn.setExpDate(resultSet.getString("ExpDate"));
				trxn.setSdate(resultSet.getString("CreatedOn"));
				trxn.setCreatedBy(resultSet.getString("CreateBy"));
				trxn.setCardType(resultSet.getString("CardType"));
				res = res + trxn.toString() + "\t";
			}

			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			res=e.getMessage();
			log(Level.INFO, e.getMessage());
			e.printStackTrace();
			return res;
		} finally {
			statement = null;
			resultSet = null;
		}

		log(Level.INFO, "read successfull");
		return res;

	}

	public static String getTrxns(Transaction t) throws Exception {

		ResultSet resultSet = null;
		String res = "";
		int cnt = 0;
		Transaction trxn = new Transaction();
		try {

			Connection connection = MySQLJDBCConnection.getConnection();

			PreparedStatement statement = connection.prepareStatement("select * from transaction where ID = ?");
			statement.setInt(1, t.getID());
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				trxn.setID(resultSet.getInt("ID"));
				trxn.setNameOnCard(resultSet.getString("NameOnCard"));
				trxn.setCardNumber(resultSet.getString("CardNumber"));
				trxn.setUnitprice(resultSet.getDouble("UnitPrice"));
				trxn.setQuantity(resultSet.getInt("Quantity"));
				trxn.setTotalPrice(resultSet.getDouble("TotalPrice"));
				trxn.setExpDate(resultSet.getString("ExpDate"));
				trxn.setSdate(resultSet.getString("CreatedOn"));
				trxn.setCreatedBy(resultSet.getString("CreateBy"));
				trxn.setCardType(resultSet.getString("CardType"));
				cnt++;
				res = res + trxn.toString() + "\t";

			}
			if (cnt == 0)
				res = res + "ID does'nt exist in db ...please try again";

			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			res=e.getMessage();
			log(Level.INFO, e.getMessage());
			e.printStackTrace();
			return res;
		} finally {

			resultSet = null;
		}

		log(Level.INFO, "read successfull");
		return res;
	}

	public static String insertTrxns(Transaction t) throws Exception {

		String res = "";
		Pattern pattern = Pattern.compile("[; : ! @ # $ % ^ * + ? < >]");
		Matcher matcher = pattern.matcher(t.getNameOnCard());
		Matcher matcher1 = pattern.matcher(t.getExpDate());
		Matcher matcher2 = pattern.matcher(t.getCardNumber());
		int month = Integer.parseInt(t.ExpDate.substring(0, t.ExpDate.lastIndexOf("/")));
		int year = Integer.parseInt(t.ExpDate.substring(t.ExpDate.lastIndexOf("/") + 1, t.ExpDate.length()));
		if (matcher.find() == true) {
			res = "name on card contains special character";
		} else if (matcher1.find() == true) {
			res = "exp date contains special character";
		} else if (month < 01 && month > 12 && year < 2015 && year > 2032) {
			res = "exp date is not in the range";
		} else if (matcher2.find() == true) {
			res = "cardNumber contains special character";
		}

		else {

			try {
				Connection connection = MySQLJDBCConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO transaction (ID,NameOnCard,CardNumber,UnitPrice,Quantity,TotalPrice,ExpDate,CreatedOn,CreateBy,CardType)VALUES(?,?,?,?,?,?,?,?,?,?)");

				statement.setInt(1, t.getID());
				statement.setString(2, t.getNameOnCard());
				statement.setString(3, t.getCardNumber());
				statement.setDouble(4, t.getUnitprice());
				statement.setDouble(5, t.getQuantity());
				statement.setDouble(6, t.getTotalPrice());
				statement.setString(7, t.getExpDate());
				statement.setString(8, t.getSdate());

				statement.setString(9, System.getProperty("user.name"));

				if (t.getCardNumber().startsWith("4") && t.getCardNumber().matches("[0-9]{16}"))
					statement.setString(10, "Visa");
				else if ((t.getCardNumber().startsWith("34") || t.getCardNumber().startsWith("37"))
						&& t.getCardNumber().matches("[0-9]{16}"))
					statement.setString(10, "American Express");
				else if (t.getCardNumber().matches("^[51-55]{2}.*$") && t.getCardNumber().matches("[0-9]{16}"))
					statement.setString(10, "Masters");
				else
					statement.setString(10, "other");
				int rowsinserted = statement.executeUpdate();

				if (rowsinserted > 0) {
					res = "Insert Successfull";
					logger.log(Level.INFO, "Insert successfull");

				} else {
					res = "insert not successfull";
					logger.log(Level.INFO, "Insert not successful");

				}
			} catch (SQLException e) {
	            res=e.getMessage();
				log(Level.SEVERE, e.getLocalizedMessage());
				e.printStackTrace();
				return res;
			}
		}
		return res;
	}

	public static String deleteTrxns(Transaction t) throws Exception {

		String res = "";
		try {

			Connection connection = MySQLJDBCConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM  transaction  WHERE ID = ?");
			statement.setInt(1, t.getID());
			int rowsdeleted = statement.executeUpdate();
			if (rowsdeleted > 0) {
				res = "delete Successfull";
				logger.log(Level.INFO, "delete successfull");
				return res;
			} else {
				res = "Id does'nt exist";
				logger.log(Level.INFO, "ID does'nt exist in database");
				return res;
			}

		} catch (SQLException e) {
			res=e.getMessage();
			log(Level.SEVERE, e.getLocalizedMessage());
			e.printStackTrace();
			return res;
		}
	
	}

	public static String updateTransaction(Transaction t) throws Exception {

		String res = "";
		Statement statement = null;
		ResultSet resultSet = null;
		int cnt = 0;
		Pattern pattern = Pattern.compile("[; : ! @ # $ % ^ * + ? < >]");

		try {

			Connection connection = MySQLJDBCConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from transaction");

			while (resultSet.next()) {
				int currentID = resultSet.getInt(1);
				if (t.getID() == currentID) {
					cnt++;

				}
			}

			if (cnt == 0) {
				res = res + " ID does'nt exist in database, cannot update.";
				return res;

			} else {

				if (t.getNameOnCard() != null) {
					Matcher matcher = pattern.matcher(t.getNameOnCard());
					if (matcher.find() == true) {
						res = "name on card contains special character ,update name again";
					} else {

						PreparedStatement preparestatement = connection
								.prepareStatement("UPDATE transaction Set NameOnCard=? WHERE ID=?");
						preparestatement.setString(1, t.getNameOnCard());

						preparestatement.setInt(2, t.getID());
						preparestatement.execute();
						res = res + "Name On Card Updated";

					}
				}

				if (t.getCardNumber() != null) {
					Matcher matcher2 = pattern.matcher(t.getCardNumber());
					if (matcher2.find() == true) {
						res = "cardNumber contains special character";
					} else {

						PreparedStatement preparestatement = connection
								.prepareStatement("UPDATE transaction Set CardNumber=?,CardType=? WHERE ID=?");
						preparestatement.setString(1, t.getCardNumber());

						if (t.getCardNumber().startsWith("4") && t.getCardNumber().matches("[0-9]{16}"))
							preparestatement.setString(2, "Visa");
						else if ((t.getCardNumber().startsWith("34") || t.getCardNumber().startsWith("37"))
								&& t.getCardNumber().matches("[0-9]{16}"))
							preparestatement.setString(2, "American Express");
						else if (t.getCardNumber().matches("^[51-55]{2}.*$") && t.getCardNumber().matches("[0-9]{16}"))
							preparestatement.setString(2, "Masters");
						else
							preparestatement.setString(2, "other");
						preparestatement.setInt(3, t.getID());
						preparestatement.execute();
						res = res + "\n" + "card Number updated" + "/n" + "CardType Updated";

					}
				}

				if (t.getUnitprice() != 0.0) {
					System.out.println(t.getUnitprice());
					PreparedStatement preparestatement = connection
							.prepareStatement("UPDATE transaction Set UnitPrice=? WHERE ID=?");
					preparestatement.setDouble(1, t.getUnitprice());
					preparestatement.setInt(2, t.getID());
					preparestatement.execute();
					res = res + "Unit Price Updated";

				}

				if (t.getQuantity() != 0) {

					PreparedStatement preparestatement = connection
							.prepareStatement("UPDATE transaction Set Quantity=? WHERE ID=?");
					preparestatement.setInt(1, t.getQuantity());
					preparestatement.setInt(2, t.getID());
					preparestatement.execute();
					res = res + "\n" + "Quantity Updated";

				}

				if (t.getTotalPrice() != 0.0) {

					PreparedStatement preparestatement = connection
							.prepareStatement("UPDATE transaction Set TotalPrice=? WHERE ID=?");
					preparestatement.setDouble(1, t.getTotalPrice());
					preparestatement.setInt(2, t.getID());
					preparestatement.execute();
					res = res + "\n" + "Total Price Updated";

				}

				if (t.getExpDate() != null) {
					Matcher matcher1 = pattern.matcher(t.ExpDate);
					int month = Integer.parseInt(t.ExpDate.substring(0, t.ExpDate.lastIndexOf("/")));
					int year = Integer
							.parseInt(t.ExpDate.substring(t.ExpDate.lastIndexOf("/") + 1, t.ExpDate.length()));

					if (matcher1.find() == true) {
						res = "exp date contains special character";
					} else if (month < 01 && month > 12 && year < 2015 && year > 2032) {
						res = "exp date is not in the range";
					} else {
						PreparedStatement preparestatement = connection
								.prepareStatement("UPDATE transaction Set ExpDate=? WHERE ID=?");
						preparestatement.setString(1, t.getExpDate());
						preparestatement.setInt(2, t.getID());
						preparestatement.execute();
						res = res + "\n" + "Expiry Month Updated";
					}

				}

			}

		} catch (SQLException e) {
			res=e.getMessage();
			log(Level.SEVERE, e.getLocalizedMessage());
			e.printStackTrace();
			return res;
		}
		// }
		return res;
	}

}
