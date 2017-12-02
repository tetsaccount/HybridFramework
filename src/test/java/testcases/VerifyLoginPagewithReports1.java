package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPagewithReports1 {
	
	WebDriver driver;
	
	ExtentReports report;
	
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		report= new ExtentReports("./Reports/LoginpageReports.html",true);
		
		logger = report.startTest("Verify Loginpage","This page will verify loggedinusername");
		
		driver=BrowserFactory.getBrowser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Application is up and running");
		
		driver.manage().deleteAllCookies();
		
		logger.log(LogStatus.INFO, "deleted all cookies");
	}
	
	@Test
	public void testHomePage()
	{
		
    HomePage home = PageFactory.initElements(driver, HomePage.class);	
    
    String title=home.getApplicationTitle();
    
    Assert.assertTrue(title.contains("Travelodge"));
    
    logger.log(LogStatus.PASS, "homepage loaded and verified");
    
    LoginPage login=PageFactory.initElements(driver, LoginPage.class);
    
    login.clickonLoginlink();
    
    logger.log(LogStatus.INFO, "Clicked on Login");
    
    login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
    
    logger.log(LogStatus.INFO, "logging into the application");
    
    login.loggedinUserName();
    
    logger.log(LogStatus.PASS, "loggedinusername");
    
    	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		
		report.flush();
	
	}

}