package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.WebActions;


public class LoginPage extends WebActions{

	private WebDriver driver;
	
	//Page Factory
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[contains(text(), 'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(), 'signup')")
	WebElement signupBtn;
	
	@FindBy(xpath="//*[@id='top-header-menu']/div")
	WebElement crmLogo;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForLoginPageToLoad() {
		waitForElementVisibility(username);
		waitForElementVisibility(password);
	}
	
	public String validateLoginPageTitle() {
		waitForElementVisibility(username);
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		waitForElementVisibility(crmLogo);
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pword) {
		waitForLoginPageToLoad();
		enterText(username, uname);
		enterText(password, pword);
		waitForElementClickability(loginBtn);
		loginBtn.click();
		return new HomePage(driver);
	}
}
