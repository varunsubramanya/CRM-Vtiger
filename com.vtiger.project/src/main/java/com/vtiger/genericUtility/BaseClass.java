package com.vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.POMLib.HomePage;
import com.vtiger.POMLib.LoginPage;

public class BaseClass {
	
	public ExcellUtility eLib=new ExcellUtility();
	public WebDriver driver;
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	
	@BeforeSuite(groups = {"SmokeTest","RegressionTest","UnitRegressionTest"})
	public void configBS(){
		System.out.println("Establish db connection");
		
	}
	//@Parameters(value="BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest","UnitRegressionTest"})
	public void configBC() throws Throwable {
		String BROWSER = fLib.readValue("browser");
		if(BROWSER.equals("chrome"))
		{    
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(fLib.readValue("url"));
		wLib.implicitlyWait(driver, 10);
		
	}
	
	
	@BeforeMethod(groups = {"SmokeTest","RegressionTest","UnitRegressionTest"})
	public void configBM() throws Throwable {
		LoginPage lp=new LoginPage(driver);
		lp.getUsername().sendKeys(fLib.readValue("username"));
		lp.getUserpassword().sendKeys(fLib.readValue("password"));
		lp.getSubmit().click();
	}

	
	@AfterMethod(groups = {"SmokeTest","RegressionTest","UnitRegressionTest"})
	public void configAM() {
		HomePage homePage=new HomePage(driver);
		homePage.getAdminBtn().click();
		homePage.getSignOut().click();
	}
	
	@AfterClass(groups = {"SmokeTest","RegressionTest","UnitRegressionTest"})
	public void configAC() {
		driver.close();
	}
	
	@AfterSuite(groups = {"SmokeTest","RegressionTest","UnitRegressionTest"})
	public void configAS() {
		System.out.println("Disconnect from db");;
	}
		
}
