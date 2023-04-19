package com.vtiger.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.vtiger.genericUtility.ExcellUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

	@Test
	public void create(XmlTest xml) throws Throwable {
		WebDriverManager.chromedriver().setup();
		String USERNAME = xml.getParameter("username");
		String PASSWORD = xml.getParameter("password");
		String BROWSER = xml.getParameter("browser");
		ExcellUtility eu= new ExcellUtility();
		String DATA = eu.getExcelValue("TestData",1,2);
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")){
			//driver=new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(DATA);
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		//driver.close();
		
	}

}

