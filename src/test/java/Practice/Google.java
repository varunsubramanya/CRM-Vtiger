package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {
	

@Test(retryAnalyzer = com.vtiger.genericUtility.RetryAnalyzer.class)
public void sumne() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String wh = driver.getWindowHandle();
		System.out.println(wh);
		Reporter.log("reporter"+" "+wh);
		Assert.fail();
		driver.close();
	}
}
