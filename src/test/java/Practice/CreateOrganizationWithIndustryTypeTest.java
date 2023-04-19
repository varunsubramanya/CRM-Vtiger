package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.vtiger.POMLib.HomePage;
import com.vtiger.POMLib.LoginPage;
import com.vtiger.POMLib.OrganizationCreatePage;
import com.vtiger.POMLib.OrganizationInformationPage;
import com.vtiger.POMLib.OrganizationsListPage;
import com.vtiger.genericUtility.ExcellUtility;
import com.vtiger.genericUtility.FileUtility;
import com.vtiger.genericUtility.JavaUtility;
import com.vtiger.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryTypeTest {

	@Test
	public void createOrganizationCreateOrganizationWithIndustryType() throws Throwable {	

		WebDriver driver =null;
		WebDriverManager.chromedriver().setup();
		FileUtility fLib=new FileUtility();
		String BROWSER = fLib.readValue("browser");
		ExcellUtility eLib=new ExcellUtility();
		if(BROWSER.equals("chrome"))
		{        
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		driver.manage().window().maximize();
		driver.get(fLib.readValue("url"));
		wLib.implicitlyWait(driver, 10);

		LoginPage lp=new LoginPage(driver);
		lp.getUsername().sendKeys(fLib.readValue("username"));
		lp.getUserpassword().sendKeys(fLib.readValue("password"));
		lp.getSubmit().click();

		HomePage hp=new HomePage(driver);
		hp.getOrganizationBtn().click();

		OrganizationsListPage olp=new OrganizationsListPage(driver);
		olp.createOrgBtn().click();

		OrganizationCreatePage ocp=new OrganizationCreatePage(driver);
		String ORGNAME = eLib.getExcelValue("TestData",1 , 3)+jLib.getRandomNum(1000);
		ocp.getOrgNameFeild().sendKeys(ORGNAME);
		
		wLib.select(ocp.getindustryDropDown(), eLib.getExcelValue("TestData",1 , 3));
		wLib.select(ocp.getTypeDropDown(), eLib.getExcelValue("TestData",1 , 4));
		ocp.getSavebtn().click();	
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String OrgActual = oip.getOrgInfoTitle().getText().trim();
		if(OrgActual.contains(ORGNAME))
		{
			System.out.println(OrgActual + " ==> is craeted successfully");
		}
		else {
			System.out.println(OrgActual + " ==> is not successfully");
		}
		
		String indActual = oip.getNewIndustryName().getText().trim();
		if(indActual.contains(eLib.getExcelValue("TestData",1 , 3)))
		{
			System.out.println(indActual + " ==> is craeted successfully");
		}
		else {
			System.out.println(indActual + " ==> is not successfully");
		}
		
		String typeActual = oip.getNewTypeName().getText().trim();
		if(typeActual.contains(eLib.getExcelValue("TestData",1 , 4)))
		{
			System.out.println(typeActual + " ==> is craeted successfully");
		}
		else {
			System.out.println(typeActual + " ==> is not successfully");
		}
		
		wLib.waitAndClick(hp.getAdminBtn());
		hp.getSignOut().click();
	}
}
