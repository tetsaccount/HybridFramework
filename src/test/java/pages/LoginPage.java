package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[@id='triggerLoginPopOver']") WebElement loginlink;
	
    @FindBy(xpath="//input[@name='email']") WebElement emailidTextbox;
	
	@FindBy(xpath="//input[@name='password']") WebElement passwordTextbox;
	
	@FindBy(xpath="//button[text()='Login']") WebElement loginButton;

	@FindBy(xpath="//span[@class='userName'][text()='suresh']") WebElement loggedinuser;
	
	@FindBy(xpath="//a[text()='Logout']") WebElement logoutOption;
	
public void clickonLoginlink()
{
	loginlink.click();
}

public void loginApplication(String username, String password)
{
	emailidTextbox.sendKeys(username);
	
	passwordTextbox.sendKeys(password);
	
	loginButton.click();
	
}

public void loggedinUserName()
{
	
	String ele=loggedinuser.getText();
	
	Assert.assertEquals(ele, "","Logout option is not displayed");
	
}

}