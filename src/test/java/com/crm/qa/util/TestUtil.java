package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.relevantcodes.extentreports.LogStatus;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIME = 20;
	public static long IMPLICIT_WAIT = 10;
	public static long ELEMENT_SEARCH_TIMEOUT = 20;
	public static String DATA_SHEET_PATHString = "/src/test/java/com/crm/qa/"
			+ "testdata/testData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static LogStatus PASS = LogStatus.PASS;
	public static LogStatus FAIL = LogStatus.FAIL;
	public static LogStatus SKIP = LogStatus.SKIP;
	public static LogStatus INFO = LogStatus.INFO;
	
	
	public static Object[][] getTestData(String shName){
		
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir")+ DATA_SHEET_PATHString);
			
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fileInputStream);
			
		}catch (InvalidFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sheet = book.getSheet(shName);
		Object [][] result = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				result[i][k] = sheet.getRow(i+1).getCell(k).toString();
				System.out.println("cell value : "+result[i][k]);
			}
		}
		return result;
		
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		// TODO Auto-generated method stub
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
