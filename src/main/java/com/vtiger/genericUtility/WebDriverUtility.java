package com.vtiger.genericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author varun
 *
 */
public class WebDriverUtility {

	/**
	 * Method for implicitly wait
	 * @param sec
	 * @return
	 */
	public Timeouts implicitlyWait(WebDriver driver, int sec) {
		Timeouts implicitllywait = driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		return implicitllywait;
	}

	/**
	 * Method for explicitly wait
	 * @param sec
	 * @param element
	 * @return
	 */
	public WebElement explicitlytWait(WebDriver driver, int TimeDuration,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,TimeDuration);
		WebElement explicitlywait = wait.until(ExpectedConditions.visibilityOf(element));
		return explicitlywait;
	}

	/**
	 * Method for custom wait 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<20) {
			try {
				element.click();
				break;
			}catch(Throwable e){
				Thread.sleep(1000);
				count++;
			}
		}
	}

	public void waitUntilAvailable(WebElement element) throws Throwable
	{
		int count = 0;
		while(count<20) {
			try {
				element.isEnabled();
				break;
			}catch(Throwable e){
				Thread.sleep(1000);
				count++;
			}
		}
	}


	/*	public  void customWaitBeforeAction(object condition) {
		int count=0;
		while (count<20) {
		try{
			condition;
		}
		catch (Exception e) {
			condition;
		}
		}
	}


	/**
	 * Method to switch control to other window  
	 * @param driver
	 * @param pageTitle
	 */
	public void switctToWindow(WebDriver driver,String pageTitle) throws InterruptedException {
		int count=0;
		while(count<10){try {
			Set<String> allwh = driver.getWindowHandles();
			Iterator<String> it=allwh.iterator();
			while(it.hasNext()) {
				String wh = it.next();
				String wh1 = driver.switchTo().window(wh).getTitle();
				if(wh1.contains(pageTitle)) {
					break;
				}
			}break;
		}

		catch(Exception e) {
			Thread.sleep(500);
		}
		count++;
		}
	}
	/**
	 * This methods enables user to handle drop-down using visible text
	 * @param element (xpath of element)
	 * @param i
	 * @return 
	 */
	public void select(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);

	}

	/**
	 * This methods enables user to handle drop-down by index
	 * @param element (xpath of element)
	 * @param option
	 */
	public void select(WebElement element, int i) {
		Select s = new Select(element);
		s.selectByIndex(i);

	}
	
	}

