package com.DemoWeb.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import models.Person;

public class ExcelReader {
	@Test
	public static  List<Person> readData() throws IOException {

		List<Person> personList = new ArrayList<Person>();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Vinod Bhusal\\Downloads\\DemoWebb\\DemoWebb\\src\\test\\resources\\testData\\registration.xlsx");

		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();

		System.out.println(lastRow);

		for (int rowIndex = 1; rowIndex <= lastRow; rowIndex++) {

			Row row = sheet.getRow(rowIndex);

			String firstName = row.getCell(0).getStringCellValue();
			String lastName = row.getCell(1).getStringCellValue();
			String Email = row.getCell(2).getStringCellValue();
			String Password = row.getCell(3).getStringCellValue();
			String ConfirmPassword = row.getCell(4).getStringCellValue();
			System.out.println(firstName + "  " + lastName + "  " + Email + "  " + Password + "  " + ConfirmPassword);

			Person person = new Person(firstName, lastName, Email, Password, ConfirmPassword);
			personList.add(person);
			
		}
		System.out.println(personList);	return personList;
	}

}
