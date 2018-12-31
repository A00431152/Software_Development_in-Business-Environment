import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class DirWalker_f {

	private static int dirCount = 0;
	private static int fileCount = 0;
	private static int skippedRows = 0; // No of Exceptions occurred and rows skipped based on blank cell
	private static int validRows = 0; // Number of rows written in excel
	private static String folderDate = "";
	private static Logger logger = Logger.getAnonymousLogger();
	static long writeStartTime;
	static long writeEndTime;

	public void walk(String path, CSVPrinter csvPrinter) throws IOException {

		File root = new File(path);
		File[] list = root.listFiles();
		if (list == null)
			return;

		for (File f : list) {
			synchronized (this) {
				if (f.isDirectory()) {
					dirCount++;
					walk(f.getAbsolutePath(), csvPrinter);
				} else {
					fileCount++;
					csvParser(f, csvPrinter);
				}
			}
		}
	}

	public synchronized void csvParser(File f, CSVPrinter csv) {

		int cellIndex = 0;
		Reader in;

		try {

			in = new FileReader(f);
			String[] path1 = f.getAbsolutePath().toString().split(File.separator + File.separator);
			String year = path1[(path1.length) - 4];
			String month = path1[(path1.length) - 3];
			if (month.length() < 1)
				month = "0" + 1;
			String day = path1[(path1.length) - 2];
			if (day.length() < 1)
				day = "0" + 1;
			folderDate = year + "/" + month + "/" + day;
           
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			for (CSVRecord record : records) {
				if (record.getRecordNumber() == 1)
					continue;

				String fName = record.get(0);
				String lName = record.get(1);
				String strNum = record.get(2);
				String street = record.get(3);
				String city = record.get(4);
				String province = record.get(5);
				String postalCode = record.get(6);
				String country = record.get(7);
				String phoneno = record.get(8);
				String email = record.get(9);

				// Skipping rows if values in any of the cells in excel is blank
				if (fName.trim().equals("") || lName.trim().equals("") || strNum.equals("") || street.equals("")
						|| city.equals("") || province.equals("") || postalCode.equals("") || country.equals("")
						|| phoneno.equals("") || email.equals("")) {
					skippedRows = skippedRows + 1;
				} else {
                    synchronized(this) {
					Object[] dataArray = new String[] { fName, lName, strNum, street, city, province, postalCode,
							country, phoneno, email, folderDate };
					csv.printRecord(dataArray);

					cellIndex = 0;
					validRows++;
                   
				}}
			}

		} catch (ArrayIndexOutOfBoundsException ex1) {
			skippedRows++; // skipped rows for exceptions occurred
			logger.log(Level.SEVERE, ex1.getLocalizedMessage());
			ex1.printStackTrace();
		} catch (FileNotFoundException ex2) {
			skippedRows++;
			ex2.printStackTrace();
			logger.log(Level.SEVERE, ex2.getLocalizedMessage());
		} catch (IOException ex3) {
			skippedRows++;
			ex3.printStackTrace();
			logger.log(Level.SEVERE, ex3.getMessage());
		} catch (Exception ex4) {
			skippedRows++;
			logger.log(Level.SEVERE, ex4.getLocalizedMessage());
			ex4.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		DirWalker_f fw = new DirWalker_f();
		writeStartTime = System.currentTimeMillis();

		BufferedWriter writer = Files.newBufferedWriter(Paths.get("Assignment1.csv"));

		CSVPrinter csvPrinter = new CSVPrinter(writer,
				CSVFormat.DEFAULT.withHeader("First Name", "Last Name", "Street Number", "Street", "City", "Province",
						"Postal Code", "Country", "Phone Number", "Email Address", "Folder Date"));
		FileHandler handler = new FileHandler("capturedlogs.log", false);

		logger.addHandler(handler);

		fw.walk("C:\\Users\\chandan\\Documents\\GitHub\\Assignments\\Sample Data\\Sample Data", csvPrinter);
		csvPrinter.flush();
		csvPrinter.close();

		writeEndTime = System.currentTimeMillis();

		int totalRows = validRows + skippedRows;
		logger.log(Level.INFO, "Time taken to walk through and write - " + (writeEndTime - writeStartTime) + " ms");
		logger.log(Level.INFO, "\tTotal Directories - " + dirCount);
		logger.log(Level.INFO, "\tTotal files read -" + fileCount);
		logger.log(Level.INFO, "\tTotal number of rows  " + totalRows);
		logger.log(Level.INFO, "Valid Number of Rows Read  - " + validRows);
		logger.log(Level.INFO, " Skipped Number of  Rows(exceptions and blank cells)- " + skippedRows);

	}

}
