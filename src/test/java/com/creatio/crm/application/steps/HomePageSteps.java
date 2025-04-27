package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements{
	
	
	// We need to call the methods of classes into Test class. that requires, Object creation everytime.
		// Even after, object creation. Methods and Elements do not know in which window browser they are needed.
		// PageFactory.initElements(driver, new ClassName());  ==> This is required to be called at every method
		// In addition to the PageFactory initElements(), we need to pass the WebElement driver as the driver element to get called up at every method.
		
		// To reduce that effort of calling mutliple times driver method WebElement at every method.
		// We come up with the creation of CONSTRUCTOR, and paramterized it with driver.
		
		public HomePageSteps(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}
		
		
		public void verifyLoginIsSuccessful() {
			waitForElement(homePageHeaderLink,60);
			log("pass","Application Login is Successful");
		}
		
		public void verifySignUpIsSuccessful() {
			waitForElement(homePageHeaderLink,120);
			log("pass","Application Sign Up is Successful");
		}

		
		
}
