package com.qa.crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.crm.base.BaseTest;

public class TestUtil extends BaseTest{
	
	public static String RegisterUser_SheetPath="C:\\Users\\inrahmed\\git\\LatestCRMPROTestAutomation"
			+ "\\src\\main\\java\\com\\qa\\crm\\testdata\\CRMPRORegisterUser.xlsx";
	
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
	
	public static void selectByVisibleTextFromDropdown(WebElement element, String text){
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
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
	
	//Get data from excel sheet
		public static Object[][] getTestData(String sheetName){
			File file = new File(RegisterUser_SheetPath);
			//String testDataFilePath= file.getAbsolutePath();
			try {
				FileInputStream fis= new FileInputStream(file);
				Workbook wb= WorkbookFactory.create(fis);
				Sheet sh= wb.getSheet(sheetName);
				Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
				for(int i=0; i<sh.getLastRowNum(); i++){
					for(int k=0; k<sh.getRow(0).getLastCellNum(); k++){
						data[i][k]= sh.getRow(i+1).getCell(k).toString();
					}
				}
				return data;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		//Get test data based on row wise
		public void getRowWiseTestData(String sheetName, int row, int col) throws InvalidFormatException, IOException{
			File file= new File(RegisterUser_SheetPath);
			FileInputStream fis = new FileInputStream(file);
			Workbook wb= WorkbookFactory.create(fis);
			int sheetCount= wb.getNumberOfSheets();
			System.out.println("Workbook has "+sheetCount+" sheets");
			Sheet sh= wb.getSheet(sheetName);
			
			DataFormatter dataFormatter= new DataFormatter();
			System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
			Iterator<Row> rowIterator= sh.rowIterator();
			while(rowIterator.hasNext()){
				Row row1=rowIterator.next();
				//iterate over cols
				Iterator<Cell> cellIterator= row1.cellIterator();
				while(cellIterator.hasNext()){
					Cell cell= cellIterator.next();
					String cellValue= dataFormatter.formatCellValue(cell);
				}
				System.out.println();
			}
		}
		
		public WebElement findElementByLocator(By locator){
			return driver.findElement(locator);
		}
		
		public List<WebElement> findElementsByLocator(By locator){
			return driver.findElements(locator);
		}
}
