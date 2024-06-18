package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoWeb.Utils.PageActions;

public class  BasePage extends PageActions {


	WebDriver driver;

	public BasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='top-menu']/li/a")
	protected List<WebElement> headerItems;
	
	@FindBy(xpath = "//a[@class='ico-register']")
	protected WebElement register;
}
