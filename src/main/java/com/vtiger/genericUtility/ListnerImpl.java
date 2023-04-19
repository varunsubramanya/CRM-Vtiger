package com.vtiger.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImpl implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Object obj = result.getInstance();
		WebDriver driver=null;
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/"+methodName+".PNG");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {

	}

}
