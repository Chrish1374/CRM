package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.base.WebActions;


public class ContactsPage extends WebActions{

	
	@FindBy(xpath = "//div[@class= 'ui header item mb5 light-black']/span")
	WebElement contactLable;
	
	@FindBy(xpath = "//tr/td/div[@class='ui fitted read-only checkbox']")
	WebElement contactCheckbox;
	
	@FindBy(xpath = "//i[@class='edit icon']")
	WebElement createBtn;
	
	public ContactsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactPage() {
		waitForElementVisibility(contactLable);
		return contactLable.isDisplayed();
	}
	
	public void selectContact() {
		waitForElementVisibility(contactCheckbox);
		waitForElementClickability(contactCheckbox);
		contactCheckbox.click();
	}
	
	public CreateNewContactPage clickOnCreate() {
		waitForElementClickability(createBtn);
		createBtn.click();
		return new CreateNewContactPage(driver);
	}
	
	public void moveMouseToCreate() {
		waitForElementClickability(createBtn);
		mouseHover(createBtn);
	}
	
	public void waitForContactPageToLoad() {
		
	}
}
