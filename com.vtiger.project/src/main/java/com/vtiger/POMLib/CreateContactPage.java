package com.vtiger.POMLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement FirstNameTxtFeild;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastNameTxtFeild;

	@FindBy(xpath = "//img[@title='Select']" )
	private WebElement OrgLookupBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	private String createContactPageTitle = "Accounts&action";
	
	public WebElement getFirstNameTxtFeild() {
		return FirstNameTxtFeild;
	}

	public WebElement getLastNameTxtFeild() {
		return LastNameTxtFeild;
	}

	public WebElement getOrgLookupBtn() {
		return OrgLookupBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public String getCreateContactPageTitle() {
		return createContactPageTitle;
	}
	
	
}
