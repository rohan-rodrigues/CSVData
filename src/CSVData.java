import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * A class to read/write numerical CSV files and allow easy access of data
 * 
 * @author rohanrodrigues
 *
 */
public class CSVData {
	private String[] columnNames;
	private double[][] data;
	private String filePathToCSV;
	private int numRows;

	public CSVData(String filepath, String[] columnNames, int startRow) {
		this.filePathToCSV = filepath;

		String dataString = readFileAsString(filepath);
		String[] lines = dataString.split("\n");

		// number of data points
		int n = lines.length - startRow;
		this.numRows = n;
		int numColumns = columnNames.length;

		// create storage for column names
		this.columnNames = columnNames;

		// create storage for data
		this.data = new double[n][numColumns];
		for (int i = 0; i < lines.length - startRow; i++) {
			String line = lines[startRow + i];
			String[] coords = line.split(",");
			for (int j = 0; j < numColumns; j++) {
				if (coords[j].endsWith("#"))
					coords[j] = coords[j].substring(0, coords[j].length() - 1);
				double val = Double.parseDouble(coords[j]);
				data[i][j] = val;
			}
		}
	}

	private String readFileAsString(String filepath) {
		StringBuilder output = new StringBuilder();
		try (Scanner scanner = new Scanner(new File(filepath))) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				output.append(line + System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

	public static CSVData readCSVFile(String filename, int numLinesToIgnore, String[] columnNames) {
		CSVData data = CSVData.readCSVFile(filename, numLinesToIgnore, columnNames);
		return data;
	}

	/***
	 * Returns a new CSV data object for a file ignoring lines at the top. It
	 * uses the first row as the column names. All other data is stored as
	 * doubles.
	 * 
	 * @param filename
	 *            - the file to read
	 * @param numLinesToIgnore
	 *            - the number of lines at the top to ignore
	 * @return a CSVData object for that file
	 */
	public static CSVData readCSVData(String filename, int numLinesToIgnore) {
		CSVData data = CSVData.readCSVData(filename, numLinesToIgnore);
		return data;
	}

	/***
	 * Returns the data of the CSV data
	 * 
	 * @return the data of the CSV data
	 */
	public double[][] getData() {
		return this.data;
	}

	/***
	 * Returns the column names of the CSV data
	 * 
	 * @return the column names of the CSV data
	 */
	public String[] getColumnNames() {
		return this.columnNames;
	}

	/***
	 * returns a row
	 * 
	 * @param rowIndex
	 *            - the index of the row to return
	 * @return the row we're returning
	 */
	public double[] getRow(int rowIndex) {
		double[] row = data[rowIndex];
		return row;
	}

	/***
	 * returns a column
	 * 
	 * @param columnIndex
	 *            - the index of the column to return
	 * @return the column we're returning
	 */
	public double[] getColumn(int columnIndex) {
		double[] column = new double[data.length];
		for (int j = 0; j < data[0].length; j++) {
			column[j] = data[j][columnIndex];
		}

		return column;
	}

	/***
	 * returns a column
	 * 
	 * @param name
	 *            - the name of the column to return
	 * @return the column we're returning
	 */
	public double[] getColumn(String name) {
		double[] column = new double[data.length];
		for (int i = 0; i < data[0].length; i++) {
			if (columnNames[i] == name) {
				column = getColumn(i);
				return column;
			}
		}
		return column;
	}

	/***
	 * returns a 2D array of the rows
	 * 
	 * @param startIndex
	 *            - the start index of the rows to return
	 * @param endIndex
	 *            - the end index of the row to return
	 * @return the rows we're returning
	 */
	public double[][] getRows(int startIndex, int endIndex) {
		double[][] rows = new double[endIndex - startIndex][data[0].length];
		for (int i = startIndex; i <= endIndex; i++) {
			double[] row = getRow(i);
			rows[i] = row;
		}
		return rows;
	}

	/***
	 * returns a 2D array of the rows
	 * 
	 * @param rowsIndexes
	 *            - the index of the rows to return
	 * @return the rows we're returning
	 */
	public double[][] getRows(int[] rowsIndexes) {
		double[][] rows = new double[rowsIndexes.length][data[0].length];

		for (int j = 0; j < rowsIndexes.length; j++) {
			for (int i = 0; i < data.length; i++) {
				if (i == rowsIndexes[j]) {
					double[] row = getRow(i);
					rows[i] = row;
				}
			}
		}
		return rows;
	}
	
	/***
	 * Returns the given number of rows starting from the given index.
	 * @param startIndex - the index to start looking for the rows
	 * @param numRows - the number of rows to look for
	 * @return the given number of rows starting from the given index. 
	 */
	public double[][] getNRows(int startIndex, int numRows) {
		double[][] rows = new double[numRows][data[0].length];
		rows = getRows(startIndex, numRows+startIndex);
		return rows;
	}

	/***
	 * returns a 2D array of the columns
	 * 
	 * @param startIndex
	 *            - the start index of the rows to return
	 * @param endIndex
	 *            - the end index of the row to return
	 * @return the columns we're returning
	 */
	public double[][] getColumns(int startIndex, int endIndex) {
		double[][] cols = new double[data.length][endIndex - startIndex];
		for (int i = startIndex; i <= endIndex; i++) {
			double[] col = getColumn(i);
			cols[i - startIndex] = col;
		}
		return cols;
	}

	/***
	 * returns a 2D array of the columns
	 * 
	 * @param colIndexes
	 *            - the indexes of the rows to return
	 * @return the columns we're returning
	 */
	public double[][] getColumns(int[] colIndexes) {
		double[][] cols = new double[data.length][colIndexes.length];

		for (int j = 0; j < colIndexes.length; j++) {
			for (int i = 0; i < data[0].length; i++) {
				if (i == colIndexes[j]) {
					double[] col = getColumn(i);
					cols[i] = col;
				}
			}
		}
		return cols;
	}

	/***
	 * returns a 2D array of the columns
	 * 
	 * @param colIndexes
	 *            - the name of the rows to return
	 * @return the columns we're returning
	 */
	public double[][] getColumns(String[] colNames) {
		double[][] cols = new double[data.length][colNames.length];

		for (int j = 0; j < colNames.length; j++) {
			for (int i = 0; i < columnNames.length; i++) {
				if (columnNames[i] == colNames[j]) {
					double[] col = getColumn(i);
					cols[i] = col;
				}
			}
		}
		return cols;
	}

	/***
	 * return void
	 * 
	 * @param rowIndex
	 *            - the index of the row to locate the index to place the value
	 * @param colIndex
	 *            - the index of the column to locate the index to place the
	 *            value
	 * @param newValue
	 *            - the value to replace the value at the specified index
	 */
	public void setValue(int rowIndex, int colIndex, double newValue) {
		data[rowIndex][colIndex] = newValue;
	}

	/***
	 * return void
	 * 
	 * @param colIndex
	 *            - the index of the column to locate the index to place the
	 *            String
	 * @param newValue
	 *            - the name to insert at the specified index
	 */
	public void setColName(int colIndex, String name) {
		columnNames[colIndex] = name;
	}

	/***
	 * return void
	 * 
	 * @param fileName
	 *            - the file to save the CSVData to
	 */
	public void saveToFile(String fileName) {
		File outFile = new File(fileName);

		try (BufferedWriter write = new BufferedWriter(new FileWriter(outFile))) {
			write.write(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
