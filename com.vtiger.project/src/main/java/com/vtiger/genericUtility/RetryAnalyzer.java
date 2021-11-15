package com.vtiger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This 
 * @author varun
 *
 */
public class RetryAnalyzer implements IRetryAnalyzer{
	/**
	 * 
	 */
	int count=0;
	public boolean retry(ITestResult result) {
		
		while(count<4){
			count++;
			return true;
		}
		return false;
	}

}
