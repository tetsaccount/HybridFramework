package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=BrowserFactory.getBrowser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void testHomePage()
	{
		
    HomePage home = PageFactory.initElements(driver, HomePage.class);	
    
    String title=home.getApplicationTitle();
    
    Assert.assertTrue(title.contains("Travelodge"));
    
    LoginPage login=PageFactory.initElements(driver, LoginPage.class);
    
    login.clickonLoginlink();
    
    login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
    
    login.loggedinUserName();
    
    	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}