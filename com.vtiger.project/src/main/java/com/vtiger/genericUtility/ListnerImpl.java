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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImpl implements ITestListener{

	ExtentReports report;
	ExtentTest test;


	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");	

	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Object obj = result.getInstance();
		WebDriver driver=null;

		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
		} catch (IllegalArgumentException e) {
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
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");				
		test.log(Status.SKIP, result.getThrowable());


	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(new File(".\\ExtentReport\\report.html"));				
        htmlReport.config().setDocumentTitle("Extent Report");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setReportName("Functional Test");

		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("TestURL", "https://example.com");
		report.setSystemInfo("Platform", "Windows 10");
		report.setSystemInfo("Reporter Name", "Varun");


	}

	public void onFinish(ITestContext context) {
		report.flush();	

	}

}
