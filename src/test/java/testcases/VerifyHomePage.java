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

public class VerifyHomePage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=BrowserFactory.getBrowser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
	}
	
	@Test
	public void testHomePage()
	{
		
    HomePage home = PageFactory.initElements(driver, HomePage.class);	
    
    String title=home.getApplicationTitle();
    
    Assert.assertTrue(title.contains("Travelodge"));
    
    	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}