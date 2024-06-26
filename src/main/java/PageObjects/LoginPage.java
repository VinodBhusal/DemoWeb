package PageObjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoWeb.Utils.PageActions;

public class LoginPage extends BasePage

{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='ico-login']")
	private WebElement LoginBtn;

	@FindBy(id = "Email")
	private WebElement username;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(css = ".button-1.login-button")
	private WebElement Submitbtn;

	@FindBy(xpath = "//*[@class='header-links']//*[@class='account']")
	private WebElement EmailLogin;

	@FindBy(xpath = "//*[@class='top-menu']/li/a")
	private List<WebElement> TopMenuItems;

	public void ClickOnloginBtn() {

		clickElement(LoginBtn);
	}

	public String Login(String emailID, String Password) {
		clickElement(username);
		setTextBox(username, emailID);
		setTextBox(password, Password);
		clickElement(Submitbtn);
		return emailID;
	}

	public String LoginEmailFetch() {
		return EmailLogin.getText();
	}

	public List<String> HeaderList() {
		/*
		 * // LinkedHashMap<String, Boolean> elementsMap = new LinkedHashMap<>() //
		 * Array<List> dfd = new Array<List> ();
		 * 
		 * List<String> actualHeaders = new ArrayList<String>();
		 * 
		 * for (WebElement item : TopMenuItems) {
		 * 
		 * actualHeaders.add(item.getText().toLowerCase());
		 * 
		 * // item.getText(); } System.out.println(actualHeaders); return actualHeaders;
		 */
		return ListOfWebElements(TopMenuItems);
	}

}
