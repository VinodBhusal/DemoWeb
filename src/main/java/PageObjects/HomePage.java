package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage

{
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".newsletter-result-block")
	protected WebElement EnterValidEmail;

	@FindBy(xpath = "//div[@class='newsletter-email']//input[@id='newsletter-email']")
	protected WebElement NewsLetterEmailInput;

	@FindBy(xpath = "//*[@class='ico-register']")
	protected WebElement registerBtn;

	@FindBy(id = "small-searchterms")
	protected WebElement searchBar;

	@FindBy(css = ".search-box-button")
	protected WebElement searchBtn;

	@FindBy(css = ".product-title")
	private List<WebElement> products;

	public void ClickSubscribeBtn() {
		clickElement(SubscribeBtn);
	}

	public String NewsLetterThankYouMessage(String emailVal) throws InterruptedException {
		clickElement(NewsLetterEmailInput);
		setTextBox(NewsLetterEmailInput, emailVal);
		clickElement(SubscribeBtn);
		Thread.sleep(2000);
		return EnterValidEmail.getText();

	}

	public String GetEmailError() {
		return EnterValidEmail.getText();
	}

	public void navigateToRegistration() {
		clickElement(registerBtn);
	}

	public String searchProduct(String SearchVal) {
		setTextBox(searchBar, SearchVal);
		clickElement(searchBtn);
		return SearchVal;
	}

	public List<WebElement> listOfItems() {
		return products;
	}

}
