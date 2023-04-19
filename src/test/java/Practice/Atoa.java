package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Atoa {
//	private static Logger  log = LoggerFactory.getLogger(Atoa.class);
	WebDriver driver;
	
	public void explicitlyWait(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	@BeforeMethod
	public void init() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	/*Method to verify merchant name and amount in payment page*/
	@Test
	public void verifyMerchantNameAndTransactionAmount() {
		
		driver.get("https://devapp.atoa.me/payment-qr?paymentRequest=X0160bI51ahBgvwVEb4kEUygHAXVRpptnBrhVPdbPkvX/sslR2I1eaLvLzN36SsqMwD1HreZ63xssw1tejqbC5fbkrOmJjSvZnWgbF3pa3gc76zDCr3Wb8mvgck+TAv/vKeQ+fNxILq3LHdnMGtp6jIvPAzy9iMidmAFzAaR6LchWaKPyUCdb8SOlPSCLJBNQwS6UJmzFlobDxkFjnZTi+sBGuPwx+dFMR5oy9RamvCCEtfzAqRJx/Maiu1rSRWzZApXlYlUukHJu2m2tViQfnXhWgvvtqNT1c/a3Yf92m7DgsK8CCFwn/nUPdyDef58U9ypkF/HZXpHi3Zo4+leRg==&source=LINK");
		String amount = driver.findElement(By.xpath("//span[@id='total-amount']")).getText();
		String merchantName = driver.findElement(By.xpath("//p[@class='pay_to_name']")).getText();
		
		Assert.assertEquals(amount,"£26.00", "Transaction amount is wrong in payment page");
		Assert.assertEquals( merchantName,"Paying Siddhesh pvt ltd", "Merchant name is wrong in payment page");
		System.out.println(merchantName+" and actual transaction amount is "+amount);
		
	}

	
	
	
	
	/*Click on continue with this device*/
	@Test
	public void addTipPage() {
		String proceedButtonText;
		String[] buttonText;
		
		/*click on 'continue on this device' button*/
		driver.get("https://devapp.atoa.me/payment-qr?paymentRequest=X0160bI51ahBgvwVEb4kEUygHAXVRpptnBrhVPdbPkvX/sslR2I1eaLvLzN36SsqMwD1HreZ63xssw1tejqbC5fbkrOmJjSvZnWgbF3pa3gc76zDCr3Wb8mvgck+TAv/vKeQ+fNxILq3LHdnMGtp6jIvPAzy9iMidmAFzAaR6LchWaKPyUCdb8SOlPSCLJBNQwS6UJmzFlobDxkFjnZTi+sBGuPwx+dFMR5oy9RamvCCEtfzAqRJx/Maiu1rSRWzZApXlYlUukHJu2m2tViQfnXhWgvvtqNT1c/a3Yf92m7DgsK8CCFwn/nUPdyDef58U9ypkF/HZXpHi3Zo4+leRg==&source=LINK");
		driver.findElement(By.xpath("//button[@class='btn continue-btn']")).click();
		
		/*Verify amount and merchant name in add tip page*/
		String amount = driver.findElement(By.xpath("//span[@class='form-input rq-form-element']")).getText();
		String merchantName = driver.findElement(By.xpath("//p[@class='pay_to_name']")).getText();
		Assert.assertEquals(amount,"£26.00", "Transaction amount is wrong in payment page");
		Assert.assertEquals( merchantName,"Paying Siddhesh pvt ltd", "Merchant name is wrong in payment page");
		System.out.println("Transaction amount in add tip page is "+amount+" and merchant name is "+merchantName);
		
		/*Fetching text from proceed with button before adding tip and verify the button text*/
		proceedButtonText = driver.findElement(By.xpath("//button[@id='select-bank-cta']")).getText();
		Assert.assertEquals(proceedButtonText, "Proceed without Tip", "Expected 'Proceed without Tip'");
		System.out.println("verified the button text before adding tip and text is "+proceedButtonText);
		
		/*Adding tip*/
		WebElement tipOption = driver.findElement(By.xpath("//div[@class='tip-option-chip']/p[text()='£1']"));
		tipOption.click();
		
		/*Fetching text from proceed with button after adding tip*/
		proceedButtonText = driver.findElement(By.xpath("//button[@id='select-bank-cta']")).getText();
		buttonText = proceedButtonText.split(" ");
		String amountInButton = buttonText[buttonText.length-1].replace("£", "");
		
		/*verifying sum of actual + tip amount in proceed with button*/
		Assert.assertEquals(Double.parseDouble(amount.replace("£", ""))+Double.parseDouble(tipOption.getText().replace("£", "")), Double.parseDouble(amountInButton));
		System.out.println("Text in proceedButton after adding tip is "+proceedButtonText);
		
	}
	
	
	
	@Test
	public void paymentPage() {
		
		
		/*click on 'continue on this device' button*/
		driver.get("https://devapp.atoa.me/payment-qr?paymentRequest=X0160bI51ahBgvwVEb4kEUygHAXVRpptnBrhVPdbPkvX/sslR2I1eaLvLzN36SsqMwD1HreZ63xssw1tejqbC5fbkrOmJjSvZnWgbF3pa3gc76zDCr3Wb8mvgck+TAv/vKeQ+fNxILq3LHdnMGtp6jIvPAzy9iMidmAFzAaR6LchWaKPyUCdb8SOlPSCLJBNQwS6UJmzFlobDxkFjnZTi+sBGuPwx+dFMR5oy9RamvCCEtfzAqRJx/Maiu1rSRWzZApXlYlUukHJu2m2tViQfnXhWgvvtqNT1c/a3Yf92m7DgsK8CCFwn/nUPdyDef58U9ypkF/HZXpHi3Zo4+leRg==&source=LINK");
		driver.findElement(By.xpath("//button[@class='btn continue-btn']")).click();
		
		/*Adding tip in add tip page and click on proceed button*/
		WebElement tipOption = driver.findElement(By.xpath("//div[@class='tip-option-chip']/p[text()='£1']"));
		tipOption.click();
		WebElement proceedButton = driver.findElement(By.xpath("//button[@id='select-bank-cta']"));
		proceedButton.click();
		String[] buttonText = proceedButton.getText().split(" ");
		String amountInButton = buttonText[buttonText.length-1];
		
		
		/*Verify amount and merchant name in payment page*/
		String amount = driver.findElement(By.xpath("//span[@id='total-amount']")).getText();
		String merchantName = driver.findElement(By.xpath("//p[@class='pay_to_name']")).getText();
		Assert.assertEquals(amount,amountInButton, "Transaction amount is wrong in payment page");
		Assert.assertEquals( merchantName,"Paying Siddhesh pvt ltd", "Merchant name is wrong in payment page");
		System.out.println("Transaction amount in payment page is "+amount+" and merchant name is "+merchantName);
		
		/*Verify tip amount in payment page*/
		String tipAmount = driver.findElement(By.xpath("//p[@class='tip-txt']")).getText();
		 String[] tipArray = tipAmount.split(" ");
		Assert.assertEquals(tipArray[tipArray.length-1], "£1.00");
		
		/*Click on view all and fetch list of banks*/
		driver.findElement(By.linkText("View all")).click();
		List<WebElement> listOfBanks = driver.findElements(By.xpath("//li[contains(@id,'bank-list-item')]"));
		System.out.println("List of available banks are : ");
		for(WebElement x:listOfBanks) {	
			System.out.println(x.getText());
		}
		driver.findElement(By.xpath("//div[@class=\"appbar-leading\"]")).click();
		
		WebElement goToBankButton;
		/*Click on AIB bank*/
		driver.findElement(By.xpath("//img[@alt='AIB']")).click();
		goToBankButton = driver.findElement(By.xpath("//button[@id='select-bank-cta']"));
		Assert.assertFalse(goToBankButton.isEnabled(), "Button should be disabled");
		
		driver.findElement(By.xpath("//div[@class='b-input']")).click();
		goToBankButton = driver.findElement(By.xpath("//button[@id='select-bank-cta']"));
		explicitlyWait(goToBankButton);
		Assert.assertTrue(goToBankButton.isEnabled(), "Button should be enabled");
		goToBankButton.click();
		
		
	}
	
	@Test
	public void bankPage() throws InterruptedException{
		
		/*click on 'continue on this device' button*/
		driver.get("https://devapp.atoa.me/payment-qr?paymentRequest=X0160bI51ahBgvwVEb4kEUygHAXVRpptnBrhVPdbPkvX/sslR2I1eaLvLzN36SsqMwD1HreZ63xssw1tejqbC5fbkrOmJjSvZnWgbF3pa3gc76zDCr3Wb8mvgck+TAv/vKeQ+fNxILq3LHdnMGtp6jIvPAzy9iMidmAFzAaR6LchWaKPyUCdb8SOlPSCLJBNQwS6UJmzFlobDxkFjnZTi+sBGuPwx+dFMR5oy9RamvCCEtfzAqRJx/Maiu1rSRWzZApXlYlUukHJu2m2tViQfnXhWgvvtqNT1c/a3Yf92m7DgsK8CCFwn/nUPdyDef58U9ypkF/HZXpHi3Zo4+leRg==&source=LINK");
		driver.findElement(By.xpath("//button[@class='btn continue-btn']")).click();
		
		/*Adding tip in add tip page and click on proceed button*/
		WebElement tipOption = driver.findElement(By.xpath("//div[@class='tip-option-chip']/p[text()='£1']"));
		tipOption.click();
		WebElement proceedButton = driver.findElement(By.xpath("//button[@id='select-bank-cta']"));
		explicitlyWait(proceedButton);
		proceedButton.click();
		String[] buttonText = proceedButton.getText().split(" ");
		String amountInButton = buttonText[buttonText.length-1];
		
		WebElement goToBankButton;
		/*Click on AIB bank*/
		driver.findElement(By.xpath("//img[@alt='AIB']")).click();
		driver.findElement(By.xpath("//div[@class='b-input']")).click();
		goToBankButton = driver.findElement(By.xpath("//button[@id='select-bank-cta']"));
		explicitlyWait(goToBankButton);
		/*Click on go to bank button*/
		goToBankButton.click();
		
		/*Verify total transaction amount and tip amount*/
		explicitlyWait(driver.findElement(By.xpath("//div[@class='amount-text']")));
		 WebElement amount = driver.findElement(By.xpath("//div[@class='amount-text']"));
		
		Assert.assertEquals(amount.getText(),amountInButton, "Transaction amount is wrong in payment page");
		
		String tipAmount = driver.findElement(By.xpath("//p[@class='tip-txt']")).getText();
		 String[] tipArray = tipAmount.split(" ");
		Assert.assertEquals(tipArray[tipArray.length-1], "£1.00");
		
		/*Verifying merchant name*/
		String merchantName = driver.findElement(By.xpath("//td[contains(text(),'Merchant')]/../td[2]")).getText();
		Assert.assertEquals(merchantName, "Siddhesh pvt ltd", "Merchant name is different");
		
		/*Verifying reference is not null*/
		String Reference = driver.findElement(By.xpath("//td[contains(text(),'Reference')]/../td[2]")).getText();
		Assert.assertNotNull(Reference, "Reference should not be null");
		
		/*Fetching payment date and time*/
		String transactionDateTime = driver.findElement(By.xpath("//div[@class='payment_status_wrapper']/div/p")).getText();
		System.out.println("Data and time of current transaction is "+transactionDateTime);
		
		/*verify on cash back banner is present*/
		WebElement cashBackBanner = driver.findElement(By.xpath("//div[@class='cashback-banner']"));
		Assert.assertTrue(cashBackBanner.isDisplayed(), "cash back banner should be present");
		
		/*click on banner*/
		cashBackBanner.click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("12345698778");
		driver.findElement(By.xpath("//div[@class='b-input']")).click();
		WebElement claimButton = driver.findElement(By.xpath("//button[@class='btn-small']"));
		explicitlyWait(claimButton);
		claimButton.click();
		
		/*Enter OTP*/
		 List<WebElement> otp = driver.findElements(By.xpath("//input[@type='tel']"));
		int count=1;
		 for(WebElement x:otp) {
			x.sendKeys(String.valueOf(count));
			Thread.sleep(500);
			count++;
		}
		/*click on verify button*/
		 driver.findElement(By.xpath("//button[@class='btn-small']")).click();
		 
		 /*verify cashback banner is available*/
		 WebElement rewardBanner = driver.findElement(By.xpath("//div[@class='banner-wrapper']"));
		 Assert.assertTrue(rewardBanner.isDisplayed(), "reward banner not displayed");
		 String rewardString = driver.findElement(By.xpath("//div[@class='banner-wrapper']/div/h3")).getText();
		 
		 System.out.println(rewardString);
	
	}
	
	
	
	}
	
