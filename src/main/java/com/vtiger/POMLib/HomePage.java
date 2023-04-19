package com.vtiger.POMLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[.='Organizations'])[1]")
	private WebElement organizationBtn;

	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement contactsBtn;

	@FindBy(xpath = "//img [@src='themes/softed/images/user.PNG']")
	private WebElement AdminBtn;

	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOut;

	public WebElement getOrganizationBtn() {
		return organizationBtn;
	}

	public WebElement getContactsBtn() {
		return contactsBtn;
	}

	public WebElement getAdminBtn() {
		return AdminBtn;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	

}
