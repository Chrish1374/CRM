package com.crm.qa.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.base.WebActions;

public class CreateNewContactPage extends WebActions{

	

	@FindBy(name = "first_name")
	@CacheLookup
	WebElement nameTxt;
	
	@FindBy(name = "last_name")
	@CacheLookup
	WebElement lastTxt;
	
	@FindBy(xpath =  "//div[@name ='company']/input")
	WebElement companyTxt;
	
	@FindBy(xpath = "//i[@class='search icon clear']") 
	WebElement cmpClearBtn;
	
	@FindBy(xpath = "//button/i[@class='save icon']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//div[@name='company']/div[@class='visible menu transition']/div[@class='selected item addition' or @class='selected item']")
	WebElement cmpList;
	
	public CreateNewContactPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void slectCompanyFromList(String cmpName) {
		
		waitForElementVisibility(cmpList);
		waitForElementClickability(cmpList);
		cmpList.click();
		
	}
	
	public void createNewContact(String fName, String lName, String cmpName) throws InterruptedException {
		enterText(nameTxt, fName);
		enterText(lastTxt, lName);
		Thread.sleep(5000);
		enterText(companyTxt, cmpName);
		Thread.sleep(3000);
		slectCompanyFromList(cmpName);
		Thread.sleep(3000);
		waitForElementVisibility(cmpClearBtn);
		waitForElementClickability(cmpClearBtn);
		Thread.sleep(5000);
		waitForElementClickability(saveBtn);
		saveBtn.click();
		Thread.sleep(5000);
	}
}
