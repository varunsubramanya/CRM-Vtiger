package com.vtiger.POMLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsListPage {
	
	public OrganizationsListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgBtn;
	
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchForOrgNameTxtFeild;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchNowBtn;
	
	@FindBy(xpath = "//a[contains(text(),'')]")
	private WebElement organizationName;
	

	public WebElement createOrgBtn() {
		return createOrgBtn;
	}
	
	public WebElement getsearchForOrgNameTxtFeild() {
		return searchForOrgNameTxtFeild;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	public WebElement getOrganizationName() {
		return organizationName;
	}

	public void searchOrgName(String orgname) {
		getsearchForOrgNameTxtFeild().sendKeys(orgname);
						
	}

	
}
