package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.crm.base.BaseTest;

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
	
	
	
	//Constructor
	public SignUpPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	public boolean isSelectEditionTextDisplayed(){
		return selectEditionText.isDisplayed();
	}
	
	
	
}
