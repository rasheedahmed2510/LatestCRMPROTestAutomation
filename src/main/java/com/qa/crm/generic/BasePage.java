package com.qa.crm.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage implements AutoConstants{
	
	public WebDriver driver= null;
	
	public BasePage(WebDriver driver){
		this.driver= driver;
	}
	
	//To verify the page title
	public String verifyPageTitle(String eTitle){
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching: "+eTitle);
			return eTitle;
		} catch (Exception e) {
			Reporter.log("Title is not matching. Expected title is: "+ eTitle);
			Reporter.log("Actual title is: "+ driver.getTitle());
			Assert.fail();
		}
		return eTitle;
	}
	
	//To verify the element
	public void verifyElement(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present..", true);
		} catch(Exception e){
			Reporter.log("Element is not present..", false);
			Assert.fail();
		}
		
	}
}
