import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

class CsvParser {
	private final static String columnDelim = ",";
	private final static String fileDNE = "Input file does not exist";
	private final static String columnDNE = "Column does not exist.";
	private final static String generalErr = "Unexpected error has occurred.";

    /**
	 * Displays data from specified column
     * 
	 * @param filePath the absolute path of csv file
	 * @param colName the column name containing data to display
	 */
	static void showColumn(String filePath, String colName) {
		try {
			String line = "";
			int colNum = -1;
			boolean isHeader = true;  //first line
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			//parse csv by line and extract only info for given column index
			while ((line = br.readLine()) != null) {
				String[] cols = line.split(columnDelim);

				//only calculate column index once for first line
				if (isHeader) {
					colNum = findColumnIndex(cols, colName);
					
					//The column looking for does not exist
					if (colNum < 0) {
						throw new IndexOutOfBoundsException();
					}
					isHeader = false;
					continue;
				}
				//display data
				System.out.println(cols[colNum]);
			}
		} catch (IOException e) {
			System.out.println(fileDNE);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(columnDNE);
		} catch (Exception e) {
			System.out.println(generalErr);
		}
	}
	
	//Finds the column number that contains data to display
	private static int findColumnIndex(String [] columns, String colName) {
		for (int i = 0; i < columns.length; i++) {
			if (columns[i].replaceAll("\\s+","").equalsIgnoreCase(colName.replaceAll("\\s+",""))) {
				return i;
			}
		}
		return -1;
	}
}
