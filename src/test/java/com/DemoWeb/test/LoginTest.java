package com.DemoWeb.test;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	// Verify user is able to click Login Button
	@Test
	public void login() {
		LP.ClickOnloginBtn();
	}

	// Verify user is able to login successfully &able to view email id post login
	@Test(priority = 2)
	public void VerifyUserIsAbleToLoginAndViewTheLoginEmailPostLogin() {
		LP.ClickOnloginBtn();
		String actualEmail = LP.Login();
		String expectedEmail = LP.LoginEmailFetch();
		// Assert.assertEquals(expectedEmail, "obsqura24@gmail.com");

		Assert.assertEquals(actualEmail, expectedEmail, "Email is displayed");
	}

	// verify user is getting all validation on login
	@Test(priority = 3)
	public void VerifyValidationOnLogin() {
	}

	@Test
	public void verifyHeaderList() {

		// new ArrayList<>(List.("BOOKS", "OMPUTERS", "ELECTRONICS", "APPAREL & SHOES",
		// "DIGITAL DOWNLOADS", "JEWELRY", "GIFT CARDS"));
	List<String>expectedHeaders = new ArrayList<>(Arrays.asList("BOoKS", "COMPUTERS","JEWELRY", "ELECTROnICS","APPAREL & SHOES", "DIGITAL DOWNLOADS",  "GIFT CARDS"));
		//expectedHeaders.toString().toLowerCase();
		expectedHeaders.replaceAll(String :: toLowerCase);
		List<String> actualHeaders = LP.HeaderList();
		System.out.println("Actual" +actualHeaders);
		System.out.println("Expected" +expectedHeaders);
		
		Collections.sort(actualHeaders);
		Collections.sort(expectedHeaders);
		Assert.assertEquals(actualHeaders, expectedHeaders);

	}
}
