package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.qa.crm.base.BaseTest;
import com.qa.crm.util.TestUtil;

public class SignUpPage extends BaseTest {
	
	//Object Repository
	@FindBy(xpath="//div[text()='Select edition above']")
	private WebElement selectEditionText;
	
	@FindBy(xpath="//select[@name='payment_plan_id']")
	private WebElement selectEditionDropdown;
	
	@FindBy(xpath="//input[@name='first_name']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@name='email_confirm']")
	private WebElement confirmEmailAddress;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='passwordconfirm']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement termsAndConditionsCheckbox;
	
	@FindBy(xpath="//div[@class='myButton']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='payment_plan_id']")
	private WebElement tickIconForPaymentPlan;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='first_name']")
	private WebElement tickIconForFirstName;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='surname']")
	private WebElement tickIconForLastName;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='email']")
	private WebElement tickIconForEmail;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='email_confirm']")
	private WebElement tickIconForConfirmEmail;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='username']")
	private WebElement tickIconForUsername;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='password']")
	private WebElement tickIconForPassword;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='passwordconfirm']")
	private WebElement tickIconForConfirmPassword;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='agreeTerms']")
	private WebElement tickIconForTermsAndConditions;
	
	//Constructor
	public SignUpPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	public boolean isSelectEditionTextDisplayed(){
		return selectEditionText.isDisplayed();
	}
	
	public CompanyInfoAndProfilePage registerValidUserWithFreeEdition(String editionVal, String fn, String ln, String email, String confirmEmail, String un, String pwd){

		selectEditionDropdown.click();
		TestUtil.selectByVisibleTextFromDropdown(selectEditionDropdown, editionVal);
		if(tickIconForPaymentPlan.isDisplayed()){
			Reporter.log("Free Edition selected successfully in the Sign up page");
		}
		firstName.sendKeys(fn);
		if(tickIconForFirstName.isDisplayed()){
			Reporter.log("First Name entered successfully in the Sign up page");
		}
		lastName.sendKeys(ln);
		if(tickIconForLastName.isDisplayed()){
			Reporter.log("Last Name entered successfully in the Sign up page");
		}
		emailAddress.sendKeys(email);
		if(tickIconForEmail.isDisplayed()){
			Reporter.log("Email entered successfully in the Sign up page");
		}
		confirmEmailAddress.sendKeys(confirmEmail);
		if(tickIconForConfirmEmail.isDisplayed()){
			Reporter.log("Confirm Email entered successfully in the Sign up page");
		}
		username.sendKeys(un);
		if(tickIconForUsername.isDisplayed()){
			Reporter.log("First Name entered successfully in the Sign up page");
		}
		password.sendKeys(pwd);
		if(tickIconForPassword.isDisplayed()){
			Reporter.log("Password entered successfully in the Sign up page");
		}
		confirmPassword.sendKeys(pwd);
		if(tickIconForConfirmPassword.isDisplayed()){
			Reporter.log("Confirm Password entered successfully in the Sign up page");
		}
		if(!termsAndConditionsCheckbox.isSelected()){
			termsAndConditionsCheckbox.click();
			if(tickIconForTermsAndConditions.isDisplayed()){
				Reporter.log("Terms and Conditions checkbox is selected in the Sign up page");
			}
		}
		submitBtn.click();
		
		return new CompanyInfoAndProfilePage();
	
	}
	
}
