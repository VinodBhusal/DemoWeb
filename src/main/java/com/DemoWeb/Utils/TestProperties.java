package com.DemoWeb.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import freemarker.template.utility.Constants;

public class TestProperties {
	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Vinod Bhusal\\Downloads\\DemoWebb\\DemoWebb\\src\\main\\resources\\Configuartion\\config.properties");
		prop.load(fis);
		return prop;
	}

}
