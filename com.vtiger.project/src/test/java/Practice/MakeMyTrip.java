package Practice;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.get("https://www.makemytrip.com/");
			//Thread.sleep(5000);
		
			driver.findElement(By.xpath("//Li[@data-cy=\"account\"]")).click();
			driver.findElement(By.xpath("//label[@for=\"fromCity\"]")).click();
			driver.findElement(By.xpath("//p[.='Bangalore, India']")).click();
			driver.findElement(By.xpath("//label[@for=\"toCity\"]")).click();
			try{driver.findElement(By.xpath("//p[.='Goa, India']")).click();}
			catch(Exception e){
				driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
				driver.findElement(By.xpath("//p[.='Goa, India']")).click();
			}
			driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			driver.findElement(By.xpath("//div[@aria-label='Thu Jan 13 2022']")).click();
			
			/*Date date = new Date();
			String systemDateTime = date.toString();
			String[] today = systemDateTime.split(" ");
			String day = today[0];
			String month = today[1];
			String DaTe = today[2];
			String year = today[5];
			String conCatDate=day+" "+month+" "+DaTe+" "+year;
			System.out.println(conCatDate);
			driver.findElement(By.xpath("//div[@aria-label='"+conCatDate+"']")).click();*/
			
			driver.findElement(By.xpath("//a[.='Search']")).click();	
			
			
			
			
			//driver.findElement(By.xpath("//span[@class=\"bgProperties icon20 overlayCrossIcon\"]")).click();
			java.util.List<WebElement> flights = driver.findElements(By.xpath("//div/div/span[@class=\"boldFont blackText airlineName\"]"));		
			java.util.List<WebElement> time = driver.findElements(By.xpath("//span[@class=\"boldFont blackText airlineName\"]/../../../div[2]/label/div/div/div[@class=\"flightTimeSection flexOne timeInfoLeft\"]/div/p/span"));
			for(int i=0;i<flights.size();i++) {
				String flightnames = flights.get(i).getText();
				String flighttime = time.get(i).getText();
				System.out.println("flightname="+flightnames+" departuretime="+flighttime);
			}
		}
	}


