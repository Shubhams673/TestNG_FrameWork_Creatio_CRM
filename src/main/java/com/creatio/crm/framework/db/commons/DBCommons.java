package com.creatio.crm.framework.db.commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creatio.crm.framework.utilities.DBUtil;

// All Classes and Common methods related to databses for db connection

public class DBCommons {

	public static List<Map<String,String>> readData (String query) throws SQLException{
		
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		
		ResultSet dataSet = DBUtil.readDb(query); // Collect the raw data from db using query
		
		while(dataSet.next()) { // Starting from the 1st row, next method will return the result as true, if next row is available or false if no row exists
			
			Map<String,String> record = new HashMap<String,String>();
			for(int col = 1; col <= dataSet.getMetaData().getColumnCount(); col++) {
				String colName = dataSet.getMetaData().getColumnName(col);
				String colValue = dataSet.getString(col);
				record.put(colName, colValue);
			}
			data.add(record);	
		}
		
		
		return data;
	}
	
	
	
	
}
