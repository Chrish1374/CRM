package com.crm.qa.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crm.qa.util.TestUtil;

public class WebActions {

	 protected WebDriver driver;
	
	public WebActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElementVisibility(WebElement beforeVisibilityElement)
			throws TimeoutException {
		try {
			WebElement afterVisibilityElement = null;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.ELEMENT_SEARCH_TIMEOUT));

			afterVisibilityElement = wait.until(ExpectedConditions.visibilityOf(beforeVisibilityElement));
			return afterVisibilityElement;
		} catch (TimeoutException tm) {
			throw new TimeoutException("Time Out Exception while waiting for the visibility of the web element:"
					+ beforeVisibilityElement + "\n", tm);
		}
	}
	
	public void enterText(WebElement element, String value) throws TimeoutException
	{
		waitForElementClickability(element);
		element.click();
		element.clear();
		element.sendKeys(value);	
	}
	
	public WebElement waitForElementClickability(WebElement locator)
			throws TimeoutException{
		try {
			WebElement element = null;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.ELEMENT_SEARCH_TIMEOUT));

			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(" Custom message Time Out Exception while waiting for the clickability of the element:"
					+ locator + "\n", tm);
		}
	}
	
	public void mouseHover(WebElement element){

			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			//LOGGER.info(Utilities.getCurrentThreadId() + "Mouse hovered on element with locator:" + element);
		
	}
	
	public Boolean waitForElementInVisibility( By locator)
			throws TimeoutException {
		try {
			Boolean element = true;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.ELEMENT_SEARCH_TIMEOUT));

			element = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					"Time Out Exception while waiting for the invisibility of the element using By class:"
					+ locator + "\n", tm);
		}
	}
	
	public WebElement waitForElementClickability(By locator){
		try {
			WebElement element = null;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.ELEMENT_SEARCH_TIMEOUT));

			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException( "Time Out Exception while waiting for the clickability of the element:"
					+ locator + "\n", tm);
		}
	}

}
