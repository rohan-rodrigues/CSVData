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
		double[] specColumn = new double[arr.length];
		for (int i = column; i < arr.length; i += arr.length)
	}
	

	public double[] getRow(int rowIndex) {
		return null;
	}
	
	public double[] getColumn(int columnIndex) {
		return null;
		
	}
	public double[] getColumn(String name) {
		return null;
		
	}
	
	public double[][] getRows(int startIndex, int endIndex) {
		return null;
		
	}
	
	public double[][] getRows(int[] rowsIndexes) {
		return null;
	}
	
	public double[] getColumns(int startIndex, int endIndex) {
		return null;
	}
	
	public double[] getColumns(int colIndexes) {
		return null;
	}
	
	public double[] getColumns(String[] colNames) {
		return null;
	}
	
	public void setValue(int rowIndex, int colIndex, double newValue) {
		
	}
	
	public void setColName(int rowIndex, int colIndex, String name) {
		
	}
	
	
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
