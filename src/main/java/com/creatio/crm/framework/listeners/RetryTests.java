package com.creatio.crm.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// All Classes and Common methods to testng listeners

public class RetryTests implements IRetryAnalyzer{

	int count = 0;
	int retryCount = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		
		// intentionally we are going to faile TestCase1 so that it runs two times atleast.
		if(!result.isSuccess()) {
			
			if(count < retryCount) {
				count++;
				return true;
			}
		}
		
		return false;
	}

	
	
	
}
