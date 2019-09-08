package com.qa.crm.util;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.crm.base.BaseTest;

public class TestUtil extends BaseTest{
	
	//Switch to frame generic methods
	public static void switchToFrameByName(String name){
		driver.switchTo().frame(name);
	}
	
	public static void switchToFrameById(int id){
		driver.switchTo().frame(id);
	}
	
	public static void switchToFrameByWebElement(WebElement element){
		driver.switchTo().frame(element);
	}
	
	public static void getTotalFrames(){
		Set<String> frameHandles=driver.getWindowHandles();
		System.out.println("Total no: of Frames values: "+frameHandles);
	}
	
	public static void getFrame(){
		String frameHandle=driver.getWindowHandle();
		System.out.println("Frame value: "+frameHandle);
	}
	
	
	//Select value from dropdown
	public static void selectByValueFromDropdown(WebElement element, String val){
		Select sel= new Select(element);
		sel.selectByValue(val);
	}
	
	public static void selectByIndexFromDropdown(WebElement element, int index){
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectByVisibleTextFromDropdown(WebElement element, String val){
		Select sel= new Select(element);
		sel.selectByVisibleText(val);
	}
	
	public static void deselectByVisibleTextFromDropdown(WebElement element, String val){
		Select sel= new Select(element);
		sel.deselectByVisibleText(val);
	}
	
	public static void deselectByIndexFromDropdown(WebElement element, int index){
		Select sel= new Select(element);
		sel.deselectByIndex(index);
	}
	
	public static void deselectByValueFromDropdown(WebElement element, String val){
		Select sel= new Select(element);
		sel.deselectByValue(val);
	}
	
	public static void deselectAllValuesFromDropdown(WebElement element){
		Select sel= new Select(element);
		sel.deselectAll();
	}
	
	public static boolean isMultipleSelectDropdown(WebElement element){
		Select sel= new Select(element);
		return sel.isMultiple();
	}
	
	public static WebElement getFirstSelectedOptionFromDropdown(WebElement element){
		Select sel= new Select(element);
		WebElement firstSelectedOption= sel.getFirstSelectedOption();
		return firstSelectedOption;
	}
	
	public static String getAllSelectedOptionsFromDropdown(WebElement element){
		Select sel= new Select(element);
		List<WebElement> getAllSelOptions= sel.getAllSelectedOptions();
		for(WebElement getOptions: getAllSelOptions){
			String allSelOptions= getOptions.getText();
			return allSelOptions;
		}
		return null;
	}
}
