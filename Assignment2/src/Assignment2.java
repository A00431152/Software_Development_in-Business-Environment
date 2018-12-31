import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class Assignment2 {

	public static void main(String[] args) {
		MySQLAccess dao = new MySQLAccess();
		
		try {
			Scanner reader = new Scanner(System.in);
			FileHandler handler = new FileHandler("capturedlogs.log", false);
			dao.logger.addHandler(handler);
			Connection connection = dao.setupConnection();
			
			dao.logger.log(Level.INFO,"Connection Successful");
			System.out.println(" The Program will follow the following  sequence \n 1.Insert \t 2.Select all \t "
			 		+ "3.Update\t 4.Selectas per ID \n 5.Insert(fail based on primary key)\t"
			 		+ " 6.Delete\t 7.Insert(success)");
			
			Transaction t = new Transaction();
			Collection<Transaction> trxns =new ArrayList<Transaction>();
		
			System.out.println("Insert Operation :Enter Information"); 
			 t = dao.userInput(connection,reader); 
			 dao.insertTrxns(connection, t);

			trxns = dao.getAllTransactions(connection);

			for (Transaction trxn : trxns) {
				System.out.println(trxn.toString());
			}
			
			System.out.println("Update Operation :Enter ID of the record to be updated ");
			t.ID = reader.nextInt();
           
			System.out.println("Enter Name: ");
			t.nameOnCard = reader.next();
			dao.updateTransaction(connection, t);
			
			System.out.println("Read Operation :All Records will be displayed");
			  trxns = dao.getAllTransactions(connection);

				for (Transaction trxn : trxns) {
					System.out.println(trxn.toString());
				}
			
			System.out.println("Read Operation :Enter ID of the record to be displayed");
			t.ID = reader.nextInt();
			t = dao.getTrxns(connection, t);
				System.out.println(t.toString());
			
				System.out.println("Insert Operation : Enter Information( to validate primary key violation");
				 t = dao.userInput(connection,reader); 
					dao.insertTrxns(connection, t);
					
			System.out.println("Delete Operation :Enter ID to be deleted: ");
			t.ID = reader.nextInt();
			dao.deleteTrxns(connection, t.ID);
			System.out.println("Delete Record Successful");
			
			System.out.println("Insert Operation :Enter Information");
			 t = dao.userInput(connection,reader); 
				dao.insertTrxns(connection, t);
			
				System.out.println("Read Operation :All Records will be displayed");
			Collection<Transaction> trxn1s = dao.getAllTransactions(connection);

			for (Transaction trxn : trxn1s) {
				System.out.println(trxn.toString());
			}

			reader.close();

			if (connection != null) {
				connection.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			dao.logger.log(Level.SEVERE, e.getMessage());

			e.printStackTrace();
		}
	}
	
	


}
