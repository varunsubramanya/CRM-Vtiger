package com.vtiger.pomtest;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.POMLib.ContactInformationPage;
import com.vtiger.POMLib.ContactListPage;
import com.vtiger.POMLib.CreateContactPage;
import com.vtiger.POMLib.HomePage;
import com.vtiger.POMLib.OrganizationCreatePage;
import com.vtiger.POMLib.OrganizationsListPage;
import com.vtiger.genericUtility.BaseClass;
@Listeners(com.vtiger.genericUtility.ListnerImpl.class)
public class CreateContactTest extends BaseClass {
	HomePage homePage=new HomePage(driver);
	
	@Test(groups = "SmokeTest")
	public void createContact() throws Throwable {


		/*step 1 : open contact list page and click on create contact on button*/
		HomePage homePage=new HomePage(driver);
		homePage.getContactsBtn().click();
		ContactListPage contactLstPage=new ContactListPage(driver);
		contactLstPage.getCreateContactsBtn().click();
		
		/*step 2 : create contact using first name, last name test data*/

		String FIRSTNAME = eLib.getExcelValue("TestData",5 , 2);
		String LASTNAME = eLib.getExcelValue("TestData",5 , 3);
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.getFirstNameTxtFeild().sendKeys(FIRSTNAME);
		ccp.getLastNameTxtFeild().sendKeys(LASTNAME);
		ccp.getSaveBtn().click();
		ContactInformationPage cip=new ContactInformationPage(driver);
		String NameActual = cip.getcontactInfoTitle().getText().trim();
		if(NameActual.contains(LASTNAME+" "+FIRSTNAME))
		{
			System.out.println(NameActual + " ==> is created successfully");
		}
		else {
			System.out.println(NameActual + " ==> is not created");
		}
	}

	@Test(groups = "RegressionTest")
	public void createContactWithOrgName() throws Throwable {

		/*step 1 : open organization list page*/

		HomePage homePage=new HomePage(driver);
		homePage.getOrganizationBtn().click();

		/*step 2 : create organization using org name test data & save*/

		OrganizationsListPage olp= new OrganizationsListPage(driver);
		olp.createOrgBtn().click();
		OrganizationCreatePage ocp=new OrganizationCreatePage(driver);
		String ORGNAME = eLib.getExcelValue("TestData",1 , 2)+jLib.getRandomNum(1000);
		ocp.getOrgNameFeild().sendKeys(ORGNAME);
		ocp.getSavebtn().click();

		/*step 3 : open contact list page and click on create contact on button*/

		wLib.waitAndClick(homePage.getContactsBtn());
		ContactListPage contactLstPage=new ContactListPage(driver);
		contactLstPage.getCreateContactsBtn().click();

		/*step 4 : create contact using first name, last name with org name lookup page test data*/

		String FIRSTNAME = eLib.getExcelValue("TestData",5 , 2);
		String LASTNAME = eLib.getExcelValue("TestData",5 , 3);
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.getFirstNameTxtFeild().sendKeys(FIRSTNAME);
		ccp.getLastNameTxtFeild().sendKeys(LASTNAME);
		ccp.getOrgLookupBtn().click();

		/*step 6 : switch to lookup page and select org name*/

		wLib.switctToWindow(driver, ccp.getCreateContactPageTitle());

		olp.searchOrgName(ORGNAME);
		olp.getSearchNowBtn().click();
		wLib.waitAndClick(driver.findElement(By.xpath("//a[.='"+ ORGNAME +"']")));	//custom wait 

		/*step 6 : switch to parent page and save*/

		wLib.switctToWindow(driver, ccp.getCreateContactPageTitle());
		ccp.getSaveBtn().click();

		/*step 7 : verify */

		ContactInformationPage cip=new ContactInformationPage(driver);
		String NameActual = cip.getcontactInfoTitle().getText().trim();
		if(NameActual.contains(LASTNAME+" "+FIRSTNAME))
		{
			System.out.println(NameActual + " ==> is created successfully");
		}
		else {
			System.out.println(NameActual + " ==> is not created");
		}
	}
	
	/*@Test(groups = "UnitRegressionTest")
	public void organization() {
		System.out.println("unit regression done");
	}*/
}
