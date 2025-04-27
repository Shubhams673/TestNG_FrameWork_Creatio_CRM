package com.creatio.crm.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.web.commons.WebCommons;

//All Classes and Common methods to testng listeners


public class TestListener extends Reports implements ITestListener {

	
/*	// Normal methods of ITestListener interface are introduced into Listeners
	public void onTestStart(ITestResult result) {
		
			System.out.println("Test Execution is Started for Test Case : " +result.getMethod().getMethodName());
	
	
	}

	public void onTestSuccess(ITestResult result) {

			System.out.println("Test Execution is successful : " +result.getMethod().getMethodName());
	
	
	}


	public void onTestFailure(ITestResult result) {
		
	
			System.out.println("Test Execution is Failed..!! for Test Case" +result.getMethod().getMethodName());
			System.out.println("Test Execution is Failed...! due to Error" + result.getThrowable().getLocalizedMessage());
	
	
	
	}
	
*/

	
	// Modified w.r.t Loogers used in Reports.
	
	public void onTestStart(ITestResult result) {
		
		String testmethodName = result.getMethod().getMethodName();
		
		startReporting(testmethodName);  // Called from Reports class
	
	}

	public void onTestSuccess(ITestResult result) {

		String testmethodName = result.getMethod().getMethodName();
		
		logger.pass("The Test Execution is Successful for test case : " + testmethodName);
	
		stopReporting(); // Called from Reports class
	}


	public void onTestFailure(ITestResult result) {
	
		String testmethodName = result.getMethod().getMethodName();
		
		logger.fail("The Test Execution is Failed for test case : " + testmethodName);
		logger.fail("The Test Execution is Failed due to Error : " + testmethodName);
		
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeWindowScreenshot(new BasePage().getDriver(),testmethodName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stopReporting(); // Called from Reports class
	
	}

	
	
	public void onTestSkip(ITestResult result) {
		
		String testmethodName = result.getMethod().getMethodName();
		
		logger.skip("The Test Execution is Skipped for test case : " + testmethodName);
		logger.skip("The Test Execution is Skipped due to Error : " + testmethodName);
		
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeWindowScreenshot(new BasePage().getDriver(),testmethodName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stopReporting(); // Called from Reports class
	
	}

	
	
}
