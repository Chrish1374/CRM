package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends TestBase{

	public ContactPageTest() {
		super();
	}
	
	LoginPage lg;
	HomePage hm;
	ContactsPage ct;
	
	@BeforeMethod
	public void setup() {
		lg = new LoginPage(driver);
		hm = lg.login(prop.getProperty("username"), prop.getProperty("password"));
		ct = hm.clickOnContacts();		
	}
	
	@Test
	public void verifyContactPage() {
		AssertJUnit.assertTrue(ct.verifyContactPage());
	}
	
	@Test
	public void verifySelectContact() {
		AssertJUnit.assertTrue(ct.verifyContactPage());
		ct.moveMouseToCreate();
		ct.selectContact();
	}
	
}
