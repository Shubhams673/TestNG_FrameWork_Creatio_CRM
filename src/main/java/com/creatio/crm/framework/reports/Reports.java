package com.creatio.crm.framework.reports;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

// All Classes and Common methods related to html reports to prepare test results

public class Reports {
	
	
	// This class will have all the common methods related to test result reports
	
		public static ExtentHtmlReporter html = null; 
		public static ExtentReports extent = null;
		public static ExtentTest logger = null;
		
		
		// method to setup report
		@BeforeSuite(alwaysRun=true)
		public void setupReport() {
			html = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/AutomationTestReport.html");
			extent = new ExtentReports();
			extent.attachReporter(html); 
			
		}
		
		// Method to start the printing process for specific test case
		public void startReporting(String testcaseName) {
			logger = extent.createTest(testcaseName);
			logger.info("Test Execution Started for the Test Method :"+testcaseName);
		}
		
		// Method to stop printing process
		public void stopReporting() {
			
			logger.info("Test Execution Stopped for the Tests Method :");
			extent.flush();
		}


}
