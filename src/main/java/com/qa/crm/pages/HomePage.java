package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.BaseTest;

public class HomePage extends BaseTest {
	
	//Object Repository
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homeMenu;
	
	//Constructor
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods
	public boolean isHomeOptionInMenuDisplayed(){
		return homeMenu.isDisplayed();
	}

}
