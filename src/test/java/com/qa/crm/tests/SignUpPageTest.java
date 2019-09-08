package com.qa.crm.tests;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTest;
import com.qa.crm.pages.SignUpPage;

public class SignUpPageTest extends BaseTest {
	
	SignUpPage sp;
	
	@BeforeMethod
	public void preCondition(){
		initializtion();
		sp= new SignUpPage();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		Reporter.log("Closed the browser");
	}
	
}
