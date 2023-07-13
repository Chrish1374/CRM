package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CreateNewContactTest extends TestBase{

	public CreateNewContactTest() {
		super();
	}
	
	LoginPage lg;
	HomePage hm;
	ContactsPage ct;
	CreateNewContactPage cct;
	
	@BeforeMethod
	public void setup() {
		lg = new LoginPage(driver);
		hm = lg.login(prop.getProperty("username"), prop.getProperty("password"));
		ct = hm.clickOnContacts();
		cct = ct.clickOnCreate();
	}
	
	@Test
	public void createContact() throws InterruptedException {
		cct.createNewContact("Jhon", "Tyson", "WebSite");
	}
	
	@DataProvider
	public Object[][] getUserDetails() {
		Object data[][] = TestUtil.getTestData("sheet1");
		return data;
	}
	
	@Test(dataProvider = "getUserDetails")
	public void createUser(String title, String fName, String lName, String cmpName) throws InterruptedException { 
		System.out.println(title+fName+lName+cmpName);
		cct.createNewContact(fName, lName, cmpName);
	}
}
