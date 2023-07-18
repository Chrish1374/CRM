package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

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
		Assert.assertEquals(tileString, "Cogmento CRM");
	}
	
		public void crmLogoImage() {
		Assert.assertTrue(lg.validateCRMImage());
	}
	
		public void loginTest() {
		lg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

}
