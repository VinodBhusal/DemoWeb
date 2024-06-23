package com.DemoWeb.test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DemoWeb.Utils.TestProperties;
import com.DemoWeb.Utils.UniqueGenerator;






public class HomePageTestCases extends BaseTest {

	
	  // Verify user is able to view "Enter Email" Validation on CLicking Subscribe
	  //without Email
	  
	  @Test public void VerifyUserIsAbleToViewTheValidationPostEnteringBlank()throws InterruptedException, IOException 
	  { Properties  prop =TestProperties.getProperties(); 
	  LP.ClickOnloginBtn(); LP.Login(prop.getProperty("email"),prop.getProperty("password"));
	  HP.ClickSubscribeBtn(); Thread.sleep(1000);
	  Assert.assertEquals(HP.GetEmailError(), "Enter valid email"); 
	  }
	 
	

	// Validate Getting Thank you message
	@Test(dataProvider ="getData")
	public void VerifyGettingThankMessageAfterSubscription(String emailVal) throws InterruptedException, IOException 
	{
		Properties  prop =TestProperties.getProperties();
		LP.ClickOnloginBtn();
		LP.Login(prop.getProperty("email"),prop.getProperty("password"));
		String ActualText = HP.NewsLetterThankYouMessage(emailVal);
		Thread.sleep(2000);	
		Assert.assertEquals(ActualText, "Thank you for signing up! A verification email has been sent. We appreciate your interest.");
	}

	
	@DataProvider
	public String[][] getData()
	{
		String [][] data = new String [3][1];
		data[0][0] = UniqueGenerator.getRandomNumber() + "@yopmail.com";
		data[1][0] = UniqueGenerator.getRandomNumber() + "@gmail.com";
		data[2][0] = UniqueGenerator.getRandomNumber() + "@hotstar.com";
		
		
		return data;
	}
	@Test
	public void verifyCorrectSearchedProductsDisplayed() throws IOException {
		Properties  prop =TestProperties.getProperties();
		String itemSearched =HP.searchProduct(prop.getProperty("Search").toLowerCase());

		
		List<WebElement> products = HP.listOfItems();
		
		
		for (WebElement item : products ) {
			String ItemText =item.getText().toLowerCase();
			
			System.out.println(ItemText);
			
			Assert.assertTrue(ItemText.contains(itemSearched), ItemText);
			
		}
	}
	

	
}
