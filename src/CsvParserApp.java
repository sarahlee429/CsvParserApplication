/**
 * The CsvParserApp class implements an application that
 * simply displays data from a specified column to the standard output.
 */
class CsvParserApp {
  /**
   * Main method invoking parser
   * @param args[0] absolute file path of csv file
   * @param args[1] name of column to display
   */
	public static void main(String args []) {
		CsvParser.showColumn (args[0], args[1]);
	}
}
