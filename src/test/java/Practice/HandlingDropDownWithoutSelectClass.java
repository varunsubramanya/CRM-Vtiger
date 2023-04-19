package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingDropDownWithoutSelectClass {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.bstackdemo.com/");
		
		List<WebElement> options = driver.findElements(By.xpath("//select"));
		
		for(WebElement x:options) {
		System.out.println("alloptions " + x.getText());
		}
	driver.close();
	}
	

}
