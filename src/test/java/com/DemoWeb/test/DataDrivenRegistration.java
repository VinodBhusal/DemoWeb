package com.DemoWeb.test;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.DemoWeb.Utils.ExcelReader;

import models.Person;

public class DataDrivenRegistration extends BaseTest {

	@Test
	public void verifyUserisAbleToRegisterMultipleUrsers() throws IOException {
		HP.navigateToRegistration();
		
	
		List <Person>personList =ExcelReader.readData();
		for(Person person : personList) {
			RP.regiterMultipleUsers(person);
		}
	
	}
}
