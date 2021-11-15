package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {
	public static void main(String[] args) throws IOException {
		  
	        String BROWSER = "chrome";
	        String URL = "http://localhost:8888/index.php?action=DetailView&module=Accounts&parenttab=Marketing&record=45&viewname=0&start=";
	        String USERNAME = "admin";
	        String PASSWORD = "manager";
	        
	        WebDriver driver =null;
	        WebDriverManager.chromedriver().setup();
	        
	        if(BROWSER.equals("chrome"))
	        {        
	             driver = new ChromeDriver();
	        }else if(BROWSER.equals("firefox")) {
	        	driver = new FirefoxDriver();
	        }else if(BROWSER.equals("ie")) {
	        	driver = new InternetExplorerDriver();
	        }
	        
	        driver.get(URL);
	        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	        driver.findElement(By.id("submitButton")).click();     
		}

}
