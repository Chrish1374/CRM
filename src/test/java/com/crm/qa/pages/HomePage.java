package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.base.WebActions;

public class HomePage extends WebActions{

	@FindBy(xpath="//span[@class='user-display']")
	WebElement displayName;
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contactsLink;
	
	@FindBy(xpath="//i[@class='money icon']")
	WebElement dealsLink;
	
	@FindBy(xpath="//i[@class='tasks icon']")
	WebElement tasksLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		waitForElementVisibility(displayName);
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() {
		waitForElementClickability(contactsLink);
		contactsLink.click();
		return new ContactsPage(driver);
	}
	
	public DealsPage clickOnDeals() {
		waitForElementClickability(dealsLink);
		dealsLink.click();
		return new DealsPage(driver);
	}
	
	public String getUserName() {
		waitForElementVisibility(displayName);
		return displayName.getText();
	}
}
