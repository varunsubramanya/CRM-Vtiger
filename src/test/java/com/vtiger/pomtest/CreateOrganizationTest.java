package com.vtiger.pomtest;

import org.testng.annotations.Test;

import com.vtiger.POMLib.HomePage;
import com.vtiger.POMLib.OrganizationCreatePage;
import com.vtiger.POMLib.OrganizationInformationPage;
import com.vtiger.POMLib.OrganizationsListPage;
import com.vtiger.genericUtility.BaseClass;

public class CreateOrganizationTest extends BaseClass{

	@Test(groups = "SmokeTest")
	public void createOrganization() throws Throwable {	

		HomePage homePage=new HomePage(driver);
		homePage.getOrganizationBtn().click();

		OrganizationsListPage olp=new OrganizationsListPage(driver);
		olp.createOrgBtn().click();

		OrganizationCreatePage ocp=new OrganizationCreatePage(driver);
		String ORGNAME = eLib.getExcelValue("TestData", 1, 2)+jLib.getRandomNum(1000);
		ocp.getOrgNameFeild().sendKeys(ORGNAME);
		ocp.getSavebtn().click();
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);

		String OrgActual = oip.getOrgInfoTitle().getText().trim();
		if(OrgActual.contains(ORGNAME))
		{
			System.out.println(OrgActual + " ==> is craeted successfully");
		}
		else {
			System.out.println(OrgActual + " ==> is not craeted");
		}
	}
	
	@Test(groups ="RegressionTest")
	public void createOrganizationWithIndustry_Type() throws Throwable {
		HomePage homePage=new HomePage(driver);
		homePage.getOrganizationBtn().click();

		OrganizationsListPage olp=new OrganizationsListPage(driver);
		olp.createOrgBtn().click();

		OrganizationCreatePage ocp=new OrganizationCreatePage(driver);
		String ORGNAME = eLib.getExcelValue("TestData", 1, 2)+jLib.getRandomNum(1000);
		ocp.getOrgNameFeild().sendKeys(ORGNAME);
		wLib.select(ocp.getindustryDropDown(), 2);
		wLib.select(ocp.getTypeDropDown(), 3);
		ocp.getSavebtn().click();
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String OrgActual = oip.getOrgInfoTitle().getText().trim();
		if(OrgActual.contains(ORGNAME))
		{
			System.out.println(OrgActual + " ==> is craeted successfully");
		}
		else {
			System.out.println(OrgActual + " ==> is not craeted");
		}
	}
}
