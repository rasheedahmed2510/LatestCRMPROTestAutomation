package com.qa.crm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.crm.base.BaseTest;

public class LoginPage extends BaseTest{
	
	//Object Repository
	@FindBy(xpath="//a[@class='navbar-brand']/img")
	private WebElement crmLogo;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	private WebElement signupLink;
	
	//Constructor
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods
	public boolean isCRMLogoDisplayed(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage loginToCRMApp(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.submit();
		return new HomePage();
	}
	
	public String verifyLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean isSignUpLinkDisplayed(){
		return signupLink.isDisplayed();
	}
	
	public SignUpPage clickOnSignUpLink(){
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signupLink);
		//signupLink.click();
		return new SignUpPage();
	}
	
}
