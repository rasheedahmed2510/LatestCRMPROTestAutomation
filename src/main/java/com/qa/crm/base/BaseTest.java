package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.crm.generic.AutoConstants;

public class BaseTest implements AutoConstants {
	
	public static WebDriver driver;
	public static Properties prop;
	FileInputStream fis;
	
	public BaseTest(){
		prop= new Properties();
		try {
			/*fis= new FileInputStream("C:\\Users\\Rashid\\workspace\\CRMPROWebAppAutomation"
					+ "\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");*/
			fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static{
		System.setProperty(chromeKey, chromeValue);
		System.setProperty(firefoxKey, firefoxValue);
	}
	
	public static void initializtion(){	
		//Fetch the browser and based on the browser value invoke the respective browser
		String browser= prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			driver= new ChromeDriver();
			Reporter.log("Chrome browser invoked");
		}else if(browser.equalsIgnoreCase("firefox")){
			driver= new FirefoxDriver();
			Reporter.log("Firefox browser invoked");
		}else{
			Reporter.log("No browser defined in the config file OR Check the browser name");
		}
		//Maximize the window, define the timeout, page load timeout and delete all the cookies
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//Input the URL into the browser
		driver.get(prop.getProperty("url"));
	}

}
