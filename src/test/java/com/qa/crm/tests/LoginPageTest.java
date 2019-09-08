package com.qa.crm.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTest;
import com.qa.crm.generic.BasePage;
import com.qa.crm.listeners.CustomListener;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.pages.SignUpPage;
import com.qa.crm.util.TestUtil;

public class LoginPageTest extends BaseTest{
	
	LoginPage lp;
	HomePage hp;
	SignUpPage sp;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initializtion();
		lp = new LoginPage();
		hp = new HomePage();
		sp = new SignUpPage();
	}
	
	@Test(priority=1)
	public void verifyCRMLogoInLoginScreenTest(){
		boolean crmLogo= lp.isCRMLogoDisplayed();
		Assert.assertTrue(crmLogo, "CRM Logo is displayed");
	}
	
	@Test(priority=2)
	public void verifyLoginPageTitleTest(){
		String actTitle= lp.verifyLoginPageTitle();
		String expTitle= "CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test(priority=3)
	public void verifyToLoginToCRMPROApp(){
		hp= lp.loginToCRMApp(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.getTotalFrames();
		TestUtil.switchToFrameByName("mainpanel");
		boolean homeMenuOption= hp.isHomeOptionInMenuDisplayed();
		Assert.assertTrue(homeMenuOption, "Home menu option is displayed");
	}
	
	@Test(priority=4)
	public void verifySignUpLinkIsDisplayed(){
		boolean signupLink= lp.isSignUpLinkDisplayed();
		Assert.assertTrue(signupLink, "SignUp link is displayed");
	}
	
	@Test(priority=5)
	public void verifyToClickOnSignUpLink(){
		if(lp.isSignUpLinkDisplayed()){
			sp= lp.clickOnSignUpLink();
			boolean selectEditionText= sp.isSelectEditionTextDisplayed();
			Assert.assertTrue(selectEditionText, "Select Edition text is displayed");
		}else{
			Assert.fail("Select Edition Text is not displayed");
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		Reporter.log("Closed the browser");
	}
}
