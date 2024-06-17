package com.DemoWeb.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DemoWeb.Utils.UniqueGenerator;






public class HomePageTestCases extends BaseTest {

	
	  // Verify user is able to view "Enter Email" Validation on CLicking Subscribe
	  //without Email
	  
	  @Test public void VerifyUserIsAbleToViewTheValidationPostEnteringBlank()throws InterruptedException 
	  { 
	  LP.ClickOnloginBtn(); LP.Login();
	  HP.ClickSubscribeBtn(); Thread.sleep(1000);
	  Assert.assertEquals(HP.GetEmailError(), "Enter valid email"); 
	  }
	 
	

	// Validate Getting Thank you message
	@Test(dataProvider ="getData")
	public void VerifyGettingThankMessageAfterSubscription(String emailVal) throws InterruptedException 
	{
		LP.ClickOnloginBtn();
		LP.Login();
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
	
}
