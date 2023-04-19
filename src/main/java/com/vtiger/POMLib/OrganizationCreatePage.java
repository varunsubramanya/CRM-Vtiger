package com.vtiger.POMLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage {
	
	public OrganizationCreatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement OrgNameFeild;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//select[contains(@name,'industry')]")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getOrgNameFeild() {
		return OrgNameFeild;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getindustryDropDown() {
		return industryDropDown;
	}
		
}
