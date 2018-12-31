
/**
 * Original source code from 
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * 
**/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;

public class MySQLAccess {
	 Logger logger = Logger.getAnonymousLogger();
	 

	public Connection setupConnection() throws Exception {

		Connection connection = null;
		try {
			
			
			// This will load the MySQL driver, each DB has its own driver
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB

			connection = DriverManager.getConnection("jdbc:mysql://dev.cs.smu.ca/b_shree?" 															
					+ "user=b_shree&password=A00431152" // Credentials
					+ "&useSSL=false" // b/c local host
					+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); // timezone

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage());
			throw e;
		} finally {

		}
		return connection;
	}

	public Collection<Transaction> getAllTransactions(Connection connection) {
		Statement statement = null;
		ResultSet resultSet = null;
		//Collection<Transaction> results = null;
		Collection<Transaction> results = new ArrayList<Transaction>();
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from b_shree.transaction");
			while (resultSet.next()) {
				// It is possible to get the columns via name
				// also possible to get the columns via the column number
				// which starts at 1
				// e.g. resultSet.getSTring(2);			
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
				
				
				results.add(trxn);
			}
			
			//results = createTrxns(resultSet);
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.INFO, e.getMessage());
			e.printStackTrace();
		} finally {
			statement = null;
			resultSet = null;
		}
		
		logger.log(Level.INFO, "read successfull");
		return results;
		
	}

	public Transaction getTrxns(Connection connection, Transaction t) throws SQLException {
		
		ResultSet resultSet = null;
		//Collection<Tran results = new ArrayList<Transaction>();
		Transaction trxn = new Transaction();
		try {
			// Statements allow to issue SQL queries to the database
			
			
			PreparedStatement	statement = connection.prepareStatement("select * from b_shree.transaction where ID = ?");
			statement.setInt(1,t.ID);
			resultSet=statement.executeQuery();
				// It is possible to get the columns via name
				// also possible to get the columns via the column number
				// which starts at 1
				// e.g. resultSet.getSTring(2);			
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

				return trxn;
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			 


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.INFO, e.getMessage());
			e.printStackTrace();
		} finally {
			
			resultSet = null;
		}
		
		logger.log(Level.INFO, "read successfull");
		return trxn;
	}
	
	public Boolean insertTrxns (Connection connection,Transaction t ) throws SQLException {
		PreparedStatement statement=connection.prepareStatement("INSERT INTO transaction (ID,NameOnCard,CardNumber,UnitPrice,Quantity,TotalPrice,ExpDate,CreatedOn,CreateBy,CardType)VALUES(?,?,?,?,?,?,?,?,?,?)");	
		 try{ 
			 statement.setInt(1,t.ID);
			 statement.setString(2,t.nameOnCard);
			 statement.setString(3, t.cardNumber);
			 statement.setDouble(4,t.Unitprice);
			 statement.setDouble(5,t.Quantity);
			 statement.setDouble(6, t.TotalPrice);
			 statement.setString(7, t.ExpDate);
			 statement.setString(8, t.sdate);
			
			 statement.setString(9, t.CreatedBy); 
			 statement.setString(10, t.CardType);
			 
			int rowsinserted = statement.executeUpdate();
			 
			if ( rowsinserted >0)
			{
			 logger.log(Level.INFO, "Insert successfull");
			 return true;
			}
			else { 
				logger.log(Level.INFO,"Insert not successful");
				return false;}
		 }
		 catch(SQLException e){
			 logger.log(Level.SEVERE, e.getLocalizedMessage());
			 e.printStackTrace();
		 }
		      return false;
	}

	
	public Boolean deleteTrxns (Connection connection,int ID) throws SQLException {
		PreparedStatement	statement=connection.prepareStatement("DELETE FROM  transaction  WHERE ID = ?");	
		 try{
			 statement.setInt(1,ID);
			int rowsdeleted=  statement.executeUpdate();
			if ( rowsdeleted >0)
			{
				 logger.log(Level.INFO, "delete successfull");
			 return true;
			}
			else { 
				logger.log(Level.INFO,"ID does'nt exist in database");
				return false;}
			 
		 }
		 catch(SQLException e){
			 logger.log(Level.SEVERE, e.getLocalizedMessage());
			 e.printStackTrace();
		 }
		      return false;
	}
	
	public Boolean updateTransaction (Connection connection,Transaction t) throws SQLException {
		PreparedStatement	statement=connection.prepareStatement("UPDATE  transaction SET NameOnCard =?  WHERE ID=?");		
		try{
			 
			 statement.setString(1,t.nameOnCard);
			 statement.setInt(2,t.ID);
			 int rowsupdated =statement.executeUpdate();
				if ( rowsupdated >0)
				{
				 logger.log(Level.INFO, "update successfull");
				 return true;
				}
				else { 
					logger.log(Level.INFO,"ID does'nt exist in database");
					return false;}
			 
		 }
		 catch(SQLException e){
			 logger.log(Level.SEVERE, e.getLocalizedMessage());
			 e.printStackTrace();
		 }
		      return false;
	}
	public Transaction userInput(Connection connection, Scanner reader) throws SQLException
	{   
		
			Transaction t = new Transaction();
			
			System.out.println("Enter ID :");
			t.ID = reader.nextInt();
			System.out.println("Enter Name: ");
			t.nameOnCard = reader.next();
			t.nameOnCard= Validate(t.nameOnCard, reader);
		
		
			System.out.println("Enter Unitprice ");
			t.Unitprice = reader.nextDouble();
			System.out.println("Enter Quantity: ");
			t.Quantity = reader.nextInt();
			System.out.println("Enter TotalPrice: ");
			t.TotalPrice = reader.nextDouble();

			
			t.CreatedBy = System.getProperty("user.name");
			System.out.println("Enter Exp Date in MM/yyyy format ");
			t.ExpDate = reader.next();
			t.ExpDate= Validate(t.ExpDate, reader);
			int fg = 0;
			while (fg == 0) {

				int month = Integer.parseInt(t.ExpDate.substring(0, t.ExpDate.lastIndexOf("/")));
				int year = Integer.parseInt(t.ExpDate.substring(t.ExpDate.lastIndexOf("/") + 1, t.ExpDate.length()));

				if (month > 00 && month <= 12 && year > 2015 && year < 2032) { // ExpDate = ExpDate;
					fg = 1;

				}

				else {
					System.out.println("invalid Date format , please enter date again");
					t.ExpDate = reader.next();
					t.ExpDate= Validate(t.ExpDate, reader);
				}
			}
			System.out.println("Enter Card Type: It should be  Masters, or American Express");
			t.CardType = reader.next();
			System.out.println("Enter Card Number: \t for Masters ,it should prefix 51-55 \n\t for VISA ,it should prefix 4 \n\t "
					+ "for American Express it should prefix 34 or 37\t");
			t.cardNumber = reader.next();
			t.cardNumber= Validate(t.cardNumber, reader);
			
			int isValid = 0;
			if (t.CardType.equalsIgnoreCase("Masters")) {
				while (isValid == 0) {
					if (t.cardNumber.startsWith("51") || t.cardNumber.startsWith("52") || t.cardNumber.startsWith("53")
							|| t.cardNumber.startsWith("54") || t.cardNumber.startsWith("55")) {
						if (t.cardNumber.length() == 16)
							isValid = 1;
					} else {
						System.out.println("card number doesnt start with valid sequence r \t or \t length is inappropriate \tEnter Card Number again:");
						t.cardNumber = reader.next();
						t.cardNumber= Validate(t.cardNumber, reader);
						
					}
				}
			}

			else if (t.CardType.equalsIgnoreCase("Visa")) {

				while (isValid == 0) {
					if (t.cardNumber.startsWith("4")) {
						if (t.cardNumber.length() == 16)
							isValid = 1;
					} else {
						System.out.println("card number doesnt start with valid sequence r \t or \t length is inappropriate \t Enter Card Number again:");
						t.cardNumber = reader.next();
						t.cardNumber= Validate(t.cardNumber, reader);
						
					}
				}

			} else if (t.CardType.equalsIgnoreCase("American Express")) {

				System.out.println("inside cardtype loop");
				while (isValid == 0) {
					if (t.cardNumber.startsWith("34") || t.cardNumber.startsWith("34")) {
						if (t.cardNumber.length() == 16)
							isValid = 1;
					} else {
						System.out.println("card number doesnt start with valid sequence r \t or \t length is inappropriate \t Enter Card Number again:");
						t.cardNumber = reader.next();
						t.cardNumber= Validate(t.cardNumber, reader);
						
					}
				}

			}

			if (isValid == 0) {
				System.out.println("card number doesnt start with valid sequence r \t or \t length is inappropriate \t Enter Card Number again:");
				t.cardNumber = reader.next();
				t.cardNumber= Validate(t.cardNumber, reader);
				
			}

			
			
		
		 return t;
	}
	
	public String Validate(String s,Scanner reader )
	{
		Pattern pattern = Pattern.compile("[; : ! @ # $ % ^ * + ? < >]");
		
			Matcher matcher = pattern.matcher(s);			
			while(matcher.find()) {
				
						System.out.println("Input  contains special character" + "enter again\n");
						s= reader.next(); 
						
						}
			
		    return s;
		
	}
	
}
