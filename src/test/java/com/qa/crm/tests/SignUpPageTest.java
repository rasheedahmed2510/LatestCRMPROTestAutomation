package com.qa.crm.tests;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTest;
import com.qa.crm.pages.CompanyInfoAndProfilePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.pages.SignUpPage;
import com.qa.crm.util.TestUtil;

public class SignUpPageTest extends BaseTest {
	
	LoginPage lp;
	SignUpPage sp;
	//CompanyInfoAndProfilePage cp;
	String sheetName= "RegisterValidUser";
	
	@BeforeMethod
	public void preCondition(){
		initializtion();
		lp = new LoginPage();
		sp= new SignUpPage();
	}
	
	@DataProvider
	public Object[][] getCRMPRORegisterUserTestData(){
		Object [][] data= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMPRORegisterUserTestData")
	public void validateRegisterNewUserWithFreeEditionTest(String firstName, String lastName, String emailAddr, String confirmEmailAddr, String username, String password,
			String companyName, String companyPhone, String companyFax, String companyWebsite, String companyEmail, String companyDescription,
			String companyAddress, String companyCity, String companyState, String companyPostalCode){
		if(lp.isSignUpLinkDisplayed()){
			sp = lp.clickOnSignUpLink();
			Reporter.log("Sign up link is displayed");
		}else{
			Reporter.log("Sign up link is not displayed");
		}
		sp.registerValidUserWithFreeEdition("Free Edition", firstName, lastName, emailAddr, confirmEmailAddr, username, password, companyName,
				companyPhone, companyFax, companyWebsite, companyEmail, companyDescription, companyAddress, companyCity, companyState,
				companyPostalCode, "United States of America");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		Reporter.log("Closed the browser");
	}
	
}
