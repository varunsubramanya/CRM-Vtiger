package com.vtiger.POMLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactListPage {
	
	public ContactListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactsBtn;

	public WebElement getCreateContactsBtn() {
		return createContactsBtn;
	}
	
}
