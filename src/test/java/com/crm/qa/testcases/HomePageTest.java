package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	public HomePageTest() {
		super();
	}
	
	LoginPage lg;
	HomePage hm;
	
	@BeforeMethod
	public void setup() {
		lg = new LoginPage(driver);
		lg.login(prop.getProperty("username"), prop.getProperty("password"));
		hm = new HomePage(driver);
	}
	
	@Test(priority = 2)
	public void verifyHomePage() {
		String title = hm.verifyTitle();
		AssertJUnit.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 1)
	public void clickOnContacts() {
		AssertJUnit.assertEquals(hm.getUserName(), prop.getProperty("diaplayName"));
		hm.clickOnContacts();
		
	}
	
}
