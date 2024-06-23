package com.DemoWeb.test;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class RegistrationTest extends BaseTest{
	
	@Test
	public void verifyUserIsAbleToSignUpWithValidCred() {
		Faker faker  = new Faker();
		String emailID = faker.internet().emailAddress();
		String password = faker.internet().password();
	
		HP.navigateToRegistration();
	LinkedHashMap<String, Object> actualAlertmsg = RP.validateRegistration(faker.name().firstName(), faker.name().lastName(), emailID,password,password);
		
    	Assert.assertEquals(actualAlertmsg.get("alertMsg"), "Your registration completed");
    	System.out.println(actualAlertmsg);
		Assert.assertEquals(actualAlertmsg.get("LoggedEmail"), emailID);
	   	System.out.println(emailID);
	   //	LogoutBtn
	  	Assert.assertEquals(actualAlertmsg.get("LogoutBtn"), true);
	   System.out.println(actualAlertmsg.get("LogoutBtn").toString());	
	}
	
	

}
