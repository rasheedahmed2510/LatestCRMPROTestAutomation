package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.qa.crm.base.BaseTest;
import com.qa.crm.util.TestUtil;

public class CompanyInfoAndProfilePage extends BaseTest {
	
	//Object Repository
	@FindBy(xpath="//input[@type='company_name']")
	private WebElement companyName;
	
	@FindBy(xpath="//input[@type='phone']")
	private WebElement companyPhone;
	
	@FindBy(xpath="//input[@type='fax']")
	private WebElement companyFax;
	
	@FindBy(xpath="//input[@type='website']")
	private WebElement companyWebsite;
	
	@FindBy(xpath="//input[@type='company_email']")
	private WebElement companyEmail;
	
	@FindBy(xpath="//input[@type='service']")
	private WebElement companyDescription;
	
	@FindBy(xpath="//input[@type='address']")
	private WebElement companyAddress;
	
	@FindBy(xpath="//input[@type='city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@type='state']")
	private WebElement state;
	
	@FindBy(xpath="//input[@type='postcode']")
	private WebElement postalCode;
	
	@FindBy(xpath="//select[@name='country']")
	private WebElement selectCountryDropdown;
	
	@FindBy(xpath="//input[@name='copy_address']")
	private WebElement billingAddressCheckbox;
	
	@FindBy(xpath="//button[text()='CONTINUE']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='company_name']")
	private WebElement tickIconForCompanyName;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='phone']")
	private WebElement tickIconForCompanyPhone;
	
	@FindBy(xpath="//i[@class='form-control-feedback glyphicon glyphicon-ok' and @data-bv-icon-for='company_email']")
	private WebElement tickIconForCompanyEmail;
	
	//Constructor
	public CompanyInfoAndProfilePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods
	public CompleteRegistrationORAddUserPage registerValidCompanyDetailsWithFreeEdition(String compName, String compPhone, String compFax, String compWebsite, String compEmail, String compDesc, String compAddress, String compCity,
		String compState, String compPostalCode, String selectCountry){
		
		companyName.sendKeys(compName);
		if(tickIconForCompanyName.isDisplayed()){
			Reporter.log("Company Name entered successfully in the Sign up page");
		}
		companyPhone.sendKeys(compPhone);
		if(tickIconForCompanyPhone.isDisplayed()){
			Reporter.log("Company Phone entered successfully in the Sign up page");
		}
		companyFax.sendKeys(compFax);
		companyWebsite.sendKeys(compWebsite);
		companyEmail.sendKeys(compEmail);
		if(tickIconForCompanyEmail.isDisplayed()){
			Reporter.log("Company Email entered successfully in the Sign up page");
		}
		companyDescription.sendKeys(compDesc);
		companyAddress.sendKeys(compAddress);
		city.sendKeys(compCity);
		state.sendKeys(compState);
		postalCode.sendKeys(compPostalCode);
		selectCountryDropdown.click();
		TestUtil.selectByVisibleTextFromDropdown(selectCountryDropdown, selectCountry);
		if(!billingAddressCheckbox.isSelected()){
			billingAddressCheckbox.click();
		}
		continueBtn.click();
		return new CompleteRegistrationORAddUserPage();
	}
	
}
