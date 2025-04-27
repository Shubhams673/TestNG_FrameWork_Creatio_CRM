package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements{
	
/*/* Just for an Example to problem created :	
	
	public void verifyCookiesPageIsDisplayed() {

		(cookiesHeader);
			
	}
	
*/
	
	// We need to call the methods of classes into Test class. that requires, Object creation everytime.
	// Even after, object creation. Methods and Elements do not know in which window browser they are needed.
	// PageFactory.initElements(driver, new ClassName());  ==> This is required to be called at every method
	// In addition to the PageFactory initElements(), we need to pass the WebElement driver as the driver element to get called up at every method.
	
	// To reduce that effort of calling mutliple times driver method WebElement at every method.
	// We come up with the creation of CONSTRUCTOR, and paramterized it with driver.
	
	public CookiesPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	
	
	public void verifyCookiesPopUpisDisplayed() {
		//PageFactory.initElements(driver, new CookiesPageSteps());
		
		waitForElement(cookiesHeader, 30);
		log("pass", "Cookies Pop-Up is Displayed Successfully.");
			
	}
	
	public void verifyCookiesPopUpContent(String expContent) {
		
		//PageFactory.initElements(driver, new CookiesPageSteps());

		String actContent = getElementText(cookiesContent);
		Assert.assertEquals(actContent, expContent);
		log("pass", "Cookies Pop-Up Content is Displayed as expected");
		log("info", actContent);
		
	}
	
	
	public void verifyCookiesPopUpLogos() {
		
		Assert.assertTrue(isElementDisplayed(creatioLogo));
		log("pass", "Creatio Logo is Displayed Successfully in the Cookies Pop-Up.");
		addScreenshot(creatioLogo, "CreationLogo");
		
		Assert.assertTrue(isElementDisplayed(cookiebotLogo));
		log("pass", "Cookie-Bots Logo is Displayed Successfully in the Cookies Pop-Up.");
		addScreenshot(cookiebotLogo, "CreationBotLogo");

		
	}
	
	
	public void verifyCookiesPopUpSelectionButtons() {
		
		Assert.assertTrue(isElementDisplayed(allowAllBtn));
		log("pass", "Allow All Cookies Selection Button is Successfully added in the Cookies Pop-Up");
		
		Assert.assertTrue(isElementDisplayed(allowSelectionBtn));
		log("pass", "Allow Selected Cookies Button is Successfully added in the Cookies Pop-Up");
		
		Assert.assertTrue(isElementDisplayed(denyBtn));
		log("pass", "Deny Cookies Button is Successfully added in the Cookies Pop-Up");
		
		
	}

	
	public void verifyCookiesPopUpSwitchButtons() {
		
		Assert.assertTrue(isElementDisplayed(necessarySwitchtn));
		log("pass", "Necessary Cookies Selection Switch-Button is Successfully added in the Cookies Pop-Up");
		
		Assert.assertTrue(isElementDisplayed(preferencesSwitchBtn));
		log("pass", "Cookies Preferences Switch-Button is Successfully added in the Cookies Pop-Up");
		
		Assert.assertTrue(isElementDisplayed(statisticsSwitchBtn));
		log("pass", "Cookies Statistics Switch-Button is Successfully added in the Cookies Pop-Up");
		
		Assert.assertTrue(isElementDisplayed(marketingSwitchBtn));
		log("pass", "Cookies Marketing Switch-Button is Successfully added in the Cookies Pop-Up");
		
		
	}
	
	
	public void selectTheCookiesOption(String option) {
		
		if(option.equalsIgnoreCase("AllowAll")) {
			
			click(allowAllBtn);
			
		} else if(option.equalsIgnoreCase("AllowSelection")) {
			
				click(allowSelectionBtn);
				
		} else if(option.equalsIgnoreCase("Deny")) {
			
				click(denyBtn);
		}
		log("pass", "Clicked on the " +option+ " button in the Cookies Pop-Up");
		
	}
	
	
	public void verifyCookiesPopUpIsClosed() {
		
		waitForElementDisappeared(cookiesHeader, 30);
		log("pass", "Cookies Pop-Up is Closed Successfully.");
		
	}

	
	public void clickOnShowDetailsLink() {
		click(showDetailsLink);
		log("pass","Cliked on Show Details Link");
	}

	public void verifyCookiesPopUpExpandedView() {
		waitForElement(cookiePopUpExpandedDetails, 10);
		log("pass","Cookies pop-up is Expanded successfully");
	}
	
	
	

}
