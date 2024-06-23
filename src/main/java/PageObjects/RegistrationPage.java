package PageObjects;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoWeb.Utils.UniqueGenerator;

import models.Person;



public class RegistrationPage extends BasePage

{
	WebDriver driver;
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="gender-male")
	private WebElement maleCheckBox;
	
	@FindBy(id="FirstName")
	private WebElement firstNameInput;
	
	@FindBy(id="LastName")
	private WebElement lastNameInput;
	
	@FindBy(id="Email")
	private WebElement emailInput;
	
	@FindBy(id="Password")
	private WebElement passwordInput;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordInput;
	
	@FindBy(id="register-button")
	private WebElement registerBtn;
	
	@FindBy(css="[class='result']")
	private WebElement alertMsg;
	
	@FindBy(css=".header-links .account")
	private WebElement LoggedEmail;
	
	@FindBy(css=".ico-logout")
	private WebElement LogoutBtn;

	public LinkedHashMap<String, Object> validateRegistration(String fname, String lname, String emailId, String passwordValue, String confirmPassValue) {
		LinkedHashMap<String, Object> map= new LinkedHashMap<>();
		setTextBox(firstNameInput , fname);
		setTextBox(lastNameInput ,lname);
		setTextBox(emailInput , emailId);
		setTextBox(passwordInput , passwordValue);
		setTextBox(confirmPasswordInput , confirmPassValue);
		clickElement(registerBtn);
		map.put("alertMsg", getElementText(alertMsg));
        map.put("LoggedEmail",  getElementText(LoggedEmail));
        map.put("LogoutBtn",  isElementDisplayed(LogoutBtn));
		return map;
		
	}
public void regiterMultipleUsers(Person person) {
	setTextBox(firstNameInput , person.firstName);
	setTextBox(lastNameInput ,person.lastName);
	setTextBox(emailInput , person.email + UniqueGenerator.getRandomNumber()+"@yopmail.com");
	setTextBox(passwordInput , person.password);
	setTextBox(confirmPasswordInput , person.confirmPassword);
	clickElement(registerBtn);
	
	clickElement(LogoutBtn);
	clickElement(register);
	
	
}

}

