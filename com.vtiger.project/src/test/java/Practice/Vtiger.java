package Practice;

import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vtiger.genericUtility.ExcellUtility;
import com.vtiger.genericUtility.FileUtility;
import com.vtiger.genericUtility.JavaUtility;
import com.vtiger.genericUtility.WebDriverUtility;

public class Vtiger {

	public static void main(String[] args) throws Exception {
		ExcellUtility eLib=new ExcellUtility();
		WebDriver driver=null;
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

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

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		List<WebElement> allCheckBox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));

		/*for(int i=1;i<allCheckBox.size();i++) {
			allCheckBox.get(i).click();
		}
		
		for(int i=1;i<allCheckBox.size();i++) {
			allCheckBox.get(1).click();
		}
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[1]/input")).click();
		allCheckBox.get(allCheckBox.size()-1).click();

		List<WebElement> text = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for(int i=1;i<text.size();i++) {
		
		System.out.println(text.get(i).getText());
		}
		*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("BTM_QSP");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		try{driver.findElement(By.xpath("//a[.='Organizations']")).click();}
		catch (Exception e) {
			driver.findElement(By.xpath("//a[.='Organizations']")).click();
		}
		
		List<WebElement> text1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for(int i=1;i<text1.size();i++) {
		String actual = text1.get(i).getText();
		if(actual.contains("BTM_QSP")) {
			driver.findElement(By.xpath("//a[.='guigu']/../../td[8]/a[2]")).click();
			driver.switchTo().alert().accept();
			}
		}
		}
	}
