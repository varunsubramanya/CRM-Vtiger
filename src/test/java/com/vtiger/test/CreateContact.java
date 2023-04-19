package com.vtiger.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.vtiger.genericUtility.ExcellUtility;
import com.vtiger.genericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	@Test
	public void CreateContactTest(XmlTest xml) throws Throwable {
		WebDriverManager.chromedriver().setup();
	/*	String USERNAME = xml.getParameter("username");
		String PASSWORD = xml.getParameter("password");
		String BROWSER = xml.getParameter("browser");

		//	Random r=new Random();
		//	int RandomInt = r.nextInt(1000);*/

		JavaUtility ju= new JavaUtility();
		int RandomInt = ju.getRandomNum(1000);

		ExcellUtility eu= new ExcellUtility();
		String DATA = eu.getExcelValue("TestData",1,2) +"_"+RandomInt;
		WebDriver driver=new ChromeDriver();
	/*	if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")){
			//driver=new FirefoxDriver();
		}*/

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("coding");
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		if(text.contains("Organization Information")) {
			System.out.println("Organization is created");
		}
		else {
			System.out.println("Organization not created");
		}

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Contacts']")));
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("vinay1");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ms1");
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		String pwh = driver.getWindowHandle();
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it=allwh.iterator();
		while(it.hasNext()) {
			String wh = it.next();
			driver.switchTo().window(wh);
			if(wh.contains("Accounts&action")) {
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(DATA);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+DATA+"')]")).click();
		driver.switchTo().window(pwh);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//driver.close();
	}
}
