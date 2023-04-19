package com.vtiger.POMLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUpPage {

	public OrgLookUpPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement orgNameTxtFeild;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement orgNamesearchBtn;
	
	@FindBy(id = "1")
	private WebElement orgName;

	public WebElement getsearchForOrgNameTxtFeild() {
		return orgNameTxtFeild;
	}

	public WebElement getSearchNowBtn() {
		return orgNamesearchBtn;
	}

	public WebElement getOrgName() {
		return orgName;
	}



}
