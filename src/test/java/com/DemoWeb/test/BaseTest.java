package com.DemoWeb.test;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.DemoWeb.Utils.TestProperties;

import PageObjects.HomePage;
import PageObjects.LoginPage;




public class BaseTest {
	WebDriver driver;

	@BeforeMethod 
	 public void initialiseDriver() throws IOException { 
	  // @Parameters({"BrowserName"}) 
  Properties  prop =TestProperties.getProperties(); 
  String browserName =prop.getProperty("browserName"); 
		
  String env= prop.getProperty("Envrionment");
  String URL=prop.getProperty(env);
  System.out.println("Executing in : "+env);
	  if (browserName.equalsIgnoreCase("chrome")) { 
	   driver = new ChromeDriver(); 
	 
	  } else if (browserName.equalsIgnoreCase("edge")) { 
	   driver = new EdgeDriver(); 
	  } 
	 
	  else if (browserName.equalsIgnoreCase("firefox")) { 
	   driver = new FirefoxDriver(); 
	  } else { 
	   System.out.println("Not a valid browser"); 
	  } 
	 
	  driver.manage().window().maximize(); 
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
	  // driver.get(URL); 
	  driver.get(URL); 
	 
	  initPages(); 
	 }

	public LoginPage LP;
	public HomePage HP;

	public void initPages() {

		LP = new LoginPage(driver);
		HP = new HomePage(driver);
		
		
		
	
		

	}
}
