package com.vtiger.POMLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement contactInfoTitle;

	public WebElement getcontactInfoTitle() {
		return contactInfoTitle;
	}	
}
