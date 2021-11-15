package com.vtiger.POMLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement newOrgInfoTitle;
	
	@FindBy(xpath = "//td[.='Industry']/following-sibling::td/span")
	private WebElement newIndustryName;
	
	@FindBy(xpath = "//td[.='Type']/following-sibling::td/span")
	private WebElement newTypeName;
	
	public WebElement getOrgInfoTitle() {
		return newOrgInfoTitle;
	}

	public WebElement getNewIndustryName() {
		return newIndustryName;
	}

	public WebElement getNewTypeName() {
		return newTypeName;
	}	

}
