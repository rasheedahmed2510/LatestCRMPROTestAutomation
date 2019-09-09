package com.qa.crm.tests;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTest;
import com.qa.crm.pages.CompanyInfoAndProfilePage;
import com.qa.crm.pages.SignUpPage;
import com.qa.crm.util.TestUtil;

public class SignUpPageTest extends BaseTest {
	
	SignUpPage sp;
	CompanyInfoAndProfilePage cp;
	String sheetName= "RegisterValidUser";
	
	@BeforeMethod
	public void preCondition(){
		initializtion();
		sp= new SignUpPage();
	}
	
	@DataProvider
	public Object[][] getCRMPRORegisterUserTestData(){
		Object [][] data= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMPRORegisterUserTestData")
	public void validateRegisterNewUserWithFreeEditionTest(String firstName, String lastName, String emailAddr, String confirmEmailAddr, String username, String password){
		cp= sp.registerValidUserWithFreeEdition("Free Edition", firstName, lastName, emailAddr, confirmEmailAddr, username, password);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		Reporter.log("Closed the browser");
	}
	
}
