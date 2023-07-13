package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	
	LoginPage lg;
	
	@BeforeMethod
	public void setup() {
		lg = new LoginPage(driver);
	}
	
	
	@Test
	public void LoginTest() {
		String tileString= lg.validateLoginPageTitle();
		AssertJUnit.assertEquals(tileString, "Cogmento CRM");
	}
	
	@Test
	public void crmLogoImage() {
		AssertJUnit.assertTrue(lg.validateCRMImage());
	}
	
	@Test
	public void loginTest() {
		lg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

}
