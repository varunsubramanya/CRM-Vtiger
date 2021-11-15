package com.vtiger.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author varun
 *
 */
public class JavaUtility {

	/**
	 * Method to generate Random number
	 * @param range
	 * @return RandomNumber within given range
	 */
	public int getRandomNum(int range) {
		Random r=new Random();
		int randumNum = r.nextInt(range);
		return randumNum;
	}

	/**
	 * Method to get system date and time
	 * @return systemDateTime
	 */
	public String getSystemDateTime() {
		Date date =new Date();
		String systemDateTime = date.toString();
		return systemDateTime;
	}
}