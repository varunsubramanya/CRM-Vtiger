package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
@Listeners(com.vtiger.genericUtility.ListnerImpl.class)
public class ClearTrip {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.xpath("//h4[.='From']/../div/div/div//input[@placeholder=\"Any worldwide city or airport\"]")).click();
		driver.findElement(By.xpath("//p[.='Mumbai, IN - Chatrapati Shivaji Airport (BOM)']")).click();
		driver.findElement(By.xpath("//h4[.='To']/../div/div/div//input[@placeholder=\"Any worldwide city or airport\"]")).click();
		driver.findElement(By.xpath("//p[.='Goa, IN - Dabolim Airport (GOI)']")).click();
		Assert.fail();
		driver.close();
}
}