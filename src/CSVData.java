import java.util.ArrayList;

/***
 * A class to read/write numerical CSV files and allow easy access of data
 * @author rohanrodrigues
 *
 */
public class CSVData {
	private String[] columnNames;
	private double[][]data;
	
	public static CSVData readCSVFile(String filename, int numLinesToIgnore, String[] columnNames) {
		CSVData data = CSVData.readCSVFile(filename, numLinesToIgnore, columnNames);
		return data;
	}
	
	
	/***
	 * Returns a new CSV data object for a file ignoring lines at the top.
	 * It uses the first row as the column names. All other data is stored as doubles.
	 * 
	 * @param filename - the file to read
	 * @param numLinesToIgnore - the number of lines at the top to ignore
	 * @return a CSVData object for that file
	 */
	public static CSVData readCSVData(String filename, int numLinesToIgnore) {
		CSVData data = CSVData.readCSVData(filename, numLinesToIgnore);
		return data;
	}
	
	public double[][] getData() {
		return this.data;
	}
	
	public String[] getColumnNames() {
		return this.columnNames;
	} 
	
	public static double[] getColumn(double[][] arr, int column) {
	/*	double[] specColumn = new double[arr.length];
		for (int i = column; i < arr.length; i += arr.length) {
			
		} */
		return null;
	}
	
	/***
	 * returns a row
	 * @param rowIndex - the index of the row to return
	 * @return the row we're returning
	 */
	public double[] getRow(int rowIndex) {
		return null;
	}
	
	/***
	 * returns a column
	 * @param columnIndex - the index of the column to return
	 * @return the column we're returning
	 */
	public double[] getColumn(int columnIndex) {
		return null;
		
	}
	
	/***
	 * returns a column
	 * @param name - the name of the column to return
	 * @return the column we're returning
	 */
	public double[] getColumn(String name) {
		return null;
		
	}
	
	/***
	 * returns a 2D array of the rows
	 * @param startIndex - the start index of the rows to return
	 * @param endIndex - the end index of the row to return
	 * @return the rows we're returning
	 */
	public double[][] getRows(int startIndex, int endIndex) {
		return null;
		
	}
	
	/***
	 * returns a 2D array of the rows
	 * @param rowsIndexes - the index of the rows to return
	 * @return the rows we're returning
	 */
	public double[][] getRows(int[] rowsIndexes) {
		return null;
	}
	
	/***
	 * returns a 2D array of the columns
	 * @param startIndex - the start index of the rows to return
	 * @param endIndex - the end index of the row to return
	 * @return the columns we're returning
	 */
	public double[] getColumns(int startIndex, int endIndex) {
		return null;
	}
	
	/***
	 * returns a 2D array of the columns
	 * @param colIndexes - the index of the rows to return
	 * @return the columns we're returning
	 */
	public double[] getColumns(int colIndexes) {
		return null;
	}
	
	/***
	 * returns a 2D array of the columns
	 * @param colIndexes - the name of the rows to return
	 * @return the columns we're returning
	 */
	public double[] getColumns(String[] colNames) {
		return null;
	}
	
	/***
	 * return void
	 * @param rowIndex - the index of the row to locate the index to place the value
	 * @param colIndex - the index of the column to locate the index to place the value
	 * @param newValue - the value to replace the value at the specified index
	 */
	public void setValue(int rowIndex, int colIndex, double newValue) {
		
	}
	
	/***
	 * return void
	 * @param rowIndex - the index of the row to locate the index to place the String
	 * @param colIndex - the index of the column to locate the index to place the String
	 * @param newValue - the name to insert at the specified index
	 */
	public void setColName(int rowIndex, int colIndex, String name) {
		
	}
	
	/***
	 * return void
	 * @param fileName - the file to save the CSVData to
	 */
	public void saveToFile(String fileName) {
		
	}
	
	
	
/*	public static double[] getRow(double[][] arr, int row) {
		
	}
	
	public static double[][] getRows(double[][] arr, int startRow, int endRow) {
		
	}
	
	public static double[][] getCols(double[][] arr, int startCol, int endCol) {
		
	}
	
	public static double[] getSpecificRow(int rowIndex) {
		double[]row = data[rowIndex];
		return row;
	}
	
	public static double[][] getCols(double[][]arr, int startCol, int endCol) {
		
	}
	
	public static void setColumn(double[][]arr, int columnIndex, double[] vals) {
		
	}
	
	public static void setRow(double[][]arr, int rowIndex, double[] vals) {
		
	} */
	
/*	public double[] getSpecificColumns(int columnIndex) {
		double[] column = data[columnIndex];
		return column;
	} */
	
}
