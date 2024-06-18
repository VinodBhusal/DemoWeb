package com.DemoWeb.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageActions

{
	WebDriver driver;
	WebDriverWait wait;

	public PageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickElement(WebElement element) {
		waitUntilDisplayed(element);
		waitUntilClickable(element);
		element.click();	}

	public void setTextBox(WebElement element, String value)
	{
		element.sendKeys(value);
	}

	@FindBy(css = ".newsletter-subscribe-button")
	protected WebElement SubscribeBtn;

	public List<String> ListOfWebElements(List<WebElement> list) {
		List<String> actualList = new ArrayList<String>();

		for (WebElement item : list) {

			actualList.add(item.getText().toLowerCase());

			// item.getText();
		}
		return actualList;
	}

	public void waitUntilClickable(WebElement element)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// driver.manage().timeouts()element.(Duration.ofSeconds(5));
		// driver.wait(12, 1);.wait(Duration.ofSeconds(0, 0));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public String getElementText(WebElement element) {
		waitUntilDisplayed(element);
		return element.getText();
	}

	public void waitUntilDisplayed(WebElement element)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// driver.manage().timeouts()element.(Duration.ofSeconds(5));
		// driver.wait(12, 1);.wait(Duration.ofSeconds(0, 0));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();

	}

	public void switchChildWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		String parentWindow = windowHandles.iterator().next();
		String childWindow = windowHandles.iterator().next();
		driver.switchTo().window(childWindow);
	}

	public void shortWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void switchToParentWindow() {

	}

	public List<String> getListofTextFromWebElements(List<WebElement> list) {
		List<String> actualList = new ArrayList<String>();
		for (WebElement item : list) {
			actualList.add(item.getText().toLowerCase());
		}
		return actualList;
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			Assert.fail("Element is not displayed");
		}
		return false;
	}

}
