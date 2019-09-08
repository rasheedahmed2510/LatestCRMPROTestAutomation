package com.qa.crm.generic;

public interface AutoConstants {
	
	String chromeKey= "webdriver.chrome.driver";
	String chromeValue= "./drivers/chromedriver.exe";
	String firefoxKey= "webdriver.gecko.driver";
	String firefoxValue= "./drivers/geckodriver.exe";
	static long IMPLICIT_WAIT= 20;
	static long PAGELOAD_TIMEOUT= 20;
	static long EXPLICIT_WAIT= 20;
	String destFilePathForScreenshot= "./screenshots/";
	
	
}
