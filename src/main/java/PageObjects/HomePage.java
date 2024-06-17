package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoWeb.Utils.PageActions;



public class HomePage extends PageActions

{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".newsletter-result-block")
	protected WebElement EnterValidEmail;
	
	@FindBy(xpath = "//div[@class='newsletter-email']//input[@id='newsletter-email']")
	protected WebElement NewsLetterEmailInput;
	

	public void ClickSubscribeBtn() {
		clickElement(SubscribeBtn);
	}
	
	
	public String NewsLetterThankYouMessage(String emailVal) throws InterruptedException
	{
		clickElement(NewsLetterEmailInput);
		setTextBox(NewsLetterEmailInput , emailVal);
		clickElement(SubscribeBtn);
		Thread.sleep(2000);
		return EnterValidEmail.getText();
		
		
	}
	public String GetEmailError()
	{
		return EnterValidEmail.getText();
	}
	
	
}
