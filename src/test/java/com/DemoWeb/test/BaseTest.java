package com.DemoWeb.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Vinod;



public class BaseTest {
	WebDriver driver;

	@BeforeMethod 
	 public void initialiseDriver() throws IOException { 
	  // @Parameters({"BrowserName"}) 
//	  Properties  prop =TestProperties.getProperties(); 
//	  String browser =prop.getProperty("browserName"); 
		
		String browser = "chrome";
	  if (browser.equalsIgnoreCase("chrome")) { 
	   driver = new ChromeDriver(); 
	 
	  } else if (browser.equalsIgnoreCase("edge")) { 
	   driver = new EdgeDriver(); 
	  } 
	 
	  else if (browser.equalsIgnoreCase("firefox")) { 
	   driver = new FirefoxDriver(); 
	  } else { 
	   System.out.println("Not a valid browser"); 
	  } 
	 
	  driver.manage().window().maximize(); 
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
	  // driver.get(URL); 
	  driver.get("https://demowebshop.tricentis.com/"); 
	 
	  initPages(); 
	 }

	public LoginPage LP;
	public HomePage HP;

	public void initPages() {

		LP = new LoginPage(driver);
		HP = new HomePage(driver);
		
		
		
	
		

	}
}
