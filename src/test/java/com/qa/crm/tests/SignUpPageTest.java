package com.qa.crm.tests;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTest;
import com.qa.crm.pages.CompanyInfoAndProfilePage;
import com.qa.crm.pages.CompleteRegistrationORAddUserPage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.pages.SignUpPage;
import com.qa.crm.util.TestUtil;

public class SignUpPageTest extends BaseTest {
	
	LoginPage lp;
	SignUpPage sp;
	CompanyInfoAndProfilePage cp;
	String sheetName= "RegisterValidUser";
	
	@BeforeMethod
	public void preCondition(){
		initializtion();
		lp = new LoginPage();
		sp= new SignUpPage();
		cp = new CompanyInfoAndProfilePage();
	}
	
	@DataProvider
	public Object[][] getCRMPRORegisterUserTestData(){
		Object [][] data= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMPRORegisterUserTestData")
	public void validateRegisterNewUserWithFreeEditionTest(String firstName, String lastName, String emailAddr, String confirmEmailAddr, String username, String password){
		if(lp.isSignUpLinkDisplayed()){
			sp = lp.clickOnSignUpLink();
			Reporter.log("Sign up link is displayed");
		}else{
			Reporter.log("Sign up link is not displayed");
		}
		cp= sp.registerValidUserWithFreeEdition("Free Edition", firstName, lastName, emailAddr, confirmEmailAddr, username, password);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		Reporter.log("Closed the browser");
	}
	
}
