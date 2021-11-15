package com.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
/**
 * 
 * @author varun
 *
 */
public class FileUtility {
	WebDriver driver;
	/**
	 * Method to read from Property File
	 * @param key
	 * @return 
	 * @throws IOException
	 */
public String readValue(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./Data/vtiger.property");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}
}
