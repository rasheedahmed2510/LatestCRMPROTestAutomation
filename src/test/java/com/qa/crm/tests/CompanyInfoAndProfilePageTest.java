package com.qa.crm.tests;

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

public class CompanyInfoAndProfilePageTest extends BaseTest {

	CompanyInfoAndProfilePage cp;
	CompleteRegistrationORAddUserPage cr;
	String sheetName= "RegisterCompanyDetails";
	
	@BeforeMethod
	public void preCondition(){
		initializtion();
		cp = new CompanyInfoAndProfilePage();
		cr = new CompleteRegistrationORAddUserPage();
	}
	
	@DataProvider
	public Object[][] getCRMPRORegisterCompanyTestData(){
		Object [][] registerCompanyData=TestUtil.getTestData(sheetName);
		return registerCompanyData;
	}
	
	@Test(dataProvider="getCRMPRORegisterCompanyTestData")
	public void validateRegisterValidCompanyDetailsWithFreeEditionTest(String companyName, String companyPhone, String companyFax, String companyWebsite, String companyEmail, String companyDescription,
			String companyAddress, String companyCity, String companyState, String companyPostalCode){
		
		cr= cp.registerValidCompanyDetailsWithFreeEdition(companyName, companyPhone, companyFax, companyWebsite, companyEmail, companyDescription, 
				companyAddress, companyCity, companyState, companyPostalCode, "United States of America");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
