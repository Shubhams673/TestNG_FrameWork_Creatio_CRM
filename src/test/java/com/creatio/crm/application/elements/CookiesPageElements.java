package com.creatio.crm.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class CookiesPageElements extends WebCommons{

/*  Just for an Example to problem created :	
	
/*	// Here, the normal storing proccess of WebElements will create issue when intializing the object of classes to call the methods.
 *  // So, @FindBy(xpath="")  ==> Annotations are used sparately like a method for WebElements to store
	// If the page elements itself is not present on the UI, Then the Testcase will always fail. Due to the storage of Elements.
	// while creating their classes object, JVM creates separate memory allocation to all methods and all values.
	// driver is eliminated, so that their is no hard storage.
	 
	public WebElement cookiesHeader = driver.findElement(By.xpath("//div[@id='CybotCookiebotDialogBodyContentTitle']"));
	
	public WebElement cookiesContent = driver.findElement(By.xpath("//div[@id='CybotCookiebotDialogBodyContentText']"));
//*
	
	
	// Page-Factory methods to use these FindBy annotations to resolve the problem.
	
	@FindBy(xpath="//div[@id='CybotCookiebotDialogBodyContentTitle']")
	public WebElement cookiesHeader;
	
	@FindBy(xpath="//div[@id='CybotCookiebotDialogBodyContentText']")
	public WebElement cookiesContent;

*/

	@FindBy(xpath="//div[@id='CybotCookiebotDialogBodyContentTitle']")
	public WebElement cookiesHeader;
	
	@FindBy(xpath="//div[@id='CybotCookiebotDialogBodyContentText']")
	public WebElement cookiesContent;
	
	@FindBy(xpath="//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")
	public WebElement allowAllBtn;

	@FindBy(xpath="//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowallSelection']")
	public WebElement allowSelectionBtn;
	
	@FindBy(xpath="//button[@id='CybotCookiebotDialogBodyButtonDecline']")
	public WebElement denyBtn;
	
	@FindBy(xpath="//input[@id='CybotCookiebotDialogBodyLevelButtonNecessary']")
	public WebElement necessarySwitchtn;

	@FindBy(xpath="//input[@id='CybotCookiebotDialogBodyLevelButtonPreferences']")
	public WebElement preferencesSwitchBtn;

	@FindBy(xpath="//input[@id='CybotCookiebotDialogBodyLevelButtonStatistics']")
	public WebElement statisticsSwitchBtn;
	
	@FindBy(xpath="//input[@id='CybotCookiebotDialogBodyLevelButtonMarketing']")
	public WebElement marketingSwitchBtn;
	
	@FindBy(xpath="//a[@id='CybotCookiebotDialogBodyEdgeMoreDetailsLink']")
	public WebElement showDetailsLink;

	@FindBy(xpath="//img[@id='CybotCookiebotDialogPoweredbyImage']")
	public WebElement creatioLogo;
	
	@FindBy(xpath="//a[@id='CybotCookiebotDialogPoweredbyCybot']")
	public WebElement cookiebotLogo;
	
	@FindBy(xpath="//a[@id='CybotCookiebotDialogNavDetails']")
	public WebElement cookiePopUpExpandedDetails;
		
	
	


	
	


	

}
