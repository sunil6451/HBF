package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@type='email']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	
	@FindBy(xpath="(//*[@class ='navigation-top-menu-label navigation-top-menu-label-arrow'])[6]")
	@CacheLookup
	WebElement myaccountspan;
	
	
	
	@FindBy(xpath="//*[contains(text(),'Logout')]")
	@CacheLookup
	WebElement lnkLogout;
	
	
	@FindBy(xpath=("//*[@type='email']"))
	@CacheLookup
	WebElement txtemailclear;
	
	
	@FindBy(xpath=("//*[@name='Password']"))
	@CacheLookup
	WebElement txtpassclear;
	
	
	
	public void setUserName(String uname)
	{
		txtEmail.sendKeys(uname);
	}
		
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
		
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
	public void clearemail()
	{
		txtemailclear.clear();
	}
	
	
	public void clearpass()
	{
		txtpassclear.clear();
	}
	
	
	
	public void clickLogout() throws InterruptedException
	
	{	
		/*
		 * ldriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 * myaccountspan.click(); 
		 */
		Thread.sleep(5000);
		  lnkLogout.click(); 
		  Thread.sleep(5000);
		
	}
	
	
}
