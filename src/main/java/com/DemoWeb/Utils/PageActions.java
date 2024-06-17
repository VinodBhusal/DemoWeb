package com.DemoWeb.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions

{
	WebDriver driver;

	public void clickElement(WebElement element) {
		waitUntilVisible(element);
		waitUntilClickable(element);
		element.click();
	}

	public void setTextBox(WebElement element, String value) {
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

	public void waitUntilVisible(WebElement element)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// driver.manage().timeouts()element.(Duration.ofSeconds(5));
		// driver.wait(12, 1);.wait(Duration.ofSeconds(0, 0));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}

}
