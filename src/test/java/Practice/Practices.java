package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Practices {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file/...");
		driver.switchTo().frame(0);
		driver.findElement(By.id("t2")).sendKeys("JSP");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("t1")).sendKeys("QSP");
		driver.close();
		
		
	}
}
