package com.creatio.crm.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

// All Classes and Common methods related todifferent utilities like db

public class DBUtil {

	public static ResultSet readDb(String query) throws SQLException {
		ResultSet dataSet = null;
		Properties prop = PropUtil.readData("Config.properties");
		String db_url = prop.getProperty("db_url");
		String user = prop.getProperty("db_user");
		String pass = prop.getProperty("db_pass");
		
		Connection connection = DriverManager.getConnection(db_url, user,pass);
		dataSet = connection.createStatement().executeQuery(query);
		
		
		
		return dataSet;

	}

	
	public static List<Map<String,String>> readData (String query) throws SQLException{
		
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		
		ResultSet dataSet = readDb(query); // Collect the raw data from db using query
		
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
