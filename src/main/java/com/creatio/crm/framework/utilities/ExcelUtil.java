package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// All Classes and Common methods related to different utilities like excel files

public class ExcelUtil {


	
	
	public static List<Map<String, String>> readData(String fileName, String sheetName) {

		List<Map<String, String>> data = new ArrayList<Map<String, String>>();

		// Read the file
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/TestData/" + fileName);
		
			// Load the file into excel related class
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			// Read the Sheet by providing sheetname
			XSSFSheet sh = wb.getSheet(sheetName);
			
			// Get the total rows and columns having the data only.
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalCols = sh.getRow(0).getPhysicalNumberOfCells();
			
		
			// Create Loops and load all the data into list of map.
			
			// Start reading the data from second row(r=1) till the last.
			for(int r = 1; r < totalRows; r++) {
				
				// Create map for each row and load the data
				Map<String,String> rowData = new HashMap<String,String>();
				
				// Start reading the each column from first column (c=0) to last column.
				for(int c = 0; c < totalCols; c++) {
					
					String key = sh.getRow(0).getCell(c).getStringCellValue(); // To get the column name every time as a key
					String value = sh.getRow(r).getCell(c).getStringCellValue(); // To get the value of each row's column as values
					rowData.put(key, value);
					
				}
				
				data.add(rowData);
				
			}
			
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}


	
	
	
	
	
//
	// Methods to store the data and read it using 2-D array
	public static String[][] readExcelData(String fileName, String SheetName){
		
		String[][] data = null;
		
		
		// Read the file
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/TestData/" + fileName);
		
		// Load the data into Excel related classes
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
		// Read the sheet by providing the sheetname
			XSSFSheet sh = wb.getSheet(SheetName);
			
		// Get the total rows & columns having the data only.
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalCols = sh.getRow(0).getPhysicalNumberOfCells();
		
		
		
			
			// Initialize the 2-D Array with its length	
			data = new String[totalRows][totalCols]; 
			
			// Store the data in 2-D Array
			for(int r = 0; r < totalRows; r++) {
				
				for(int c = 0; c < totalCols; c++) {
					
					data[r][c] = sh.getRow(r).getCell(c).getStringCellValue();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

		
		// Read the sheet by providing the sheetname
		
		// Get the total rows & columns having the data only.
		
		
		
		
		
		
		return data;
		
	}
	
//	
	
	
	
	
	
}
