package com.creatio.crm.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.creatio.crm.framework.reports.Reports;

// All Classes and Common methods related to browsers

public class BasePage extends Reports {
	
	// This class will have all the common methods related to Browser Confgiuratios, to initalize the TestScripts.
	
	private static WebDriver driver = null;
	
	
	
	
	@BeforeMethod(alwaysRun=true)
	@Parameters(value="browser")
	
	// Method to Launch the browser based on the browser name coming from Test Runner file
	public void setUpBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("FireFox")) {
			
			driver = new FirefoxDriver();
			
		} else if(browserName.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
			
		} else if(browserName.equalsIgnoreCase("Safari")) {
			
			driver = new SafariDriver();
			
		} else {
			
			Assert.fail("Invalid Browser Name");
		}
		
		
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
	}
	
	
	
	@AfterMethod(alwaysRun=true)
	
	// Method to tear down or close the browser window.
	public void tearDown() {
		
		//driver.close();
		
		driver.quit();
		
	}

	
	
	// Within the class the private driver can be used
	// To access the driver outside the classes, we need to have encapsulation used. 
	// Creating the method with public and returning the driver to get it accessibility.
	
	// Method to share browser session (driver) details with outher classes.
	public WebDriver getDriver() {
		return driver;
	}
	
	// Method to modify browser session (driver) details from all other classes.
	public void setDriver(WebDriver newDriver) {
		driver = newDriver;
	}
	
	
}
