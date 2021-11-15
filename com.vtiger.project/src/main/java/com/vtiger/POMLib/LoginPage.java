package com.vtiger.POMLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement userpassword;
	
	@FindBy(id="submitButton")
	private WebElement submit;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getUserpassword() {
		return userpassword;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public void signIn(String username,String password) throws IOException {
		getUsername().sendKeys(username);
		getUserpassword().sendKeys(password);
		
	}
	
	
	
}
