package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok']")
	private WebElement tickIcon;
	
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
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		emailAddress.sendKeys(email);
		confirmEmailAddress.sendKeys(confirmEmail);
		username.sendKeys(un);
		password.sendKeys(pwd);
		tickIcon.click();
		submitBtn.click();
		return new CompanyInfoAndProfilePage();
	}
	
}
