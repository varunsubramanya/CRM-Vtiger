import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver;
@BeforeMethod
public void userLogin() {
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
	driver.findElement(By.id("submitButton")).click();
}
}
@AfterMethod
public void userLogout() {
	driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
}
