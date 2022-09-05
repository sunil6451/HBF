package testCases;



import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		
		refreshpage();
		driver.get(baseURL);
		
		refreshpage();
		
		LoginPage lp=new LoginPage(driver);
		
		refreshpage();
		
		lp.clearemail();
		lp.clearpass();
		
		
		
		lp.setUserName(username);
		logger.info("User name is provided");
		
		lp.setPassword(password);
		logger.info("password is provided");
		
		lp.clickLogin();
		
		logger.info("providing customer details....");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		refreshpage();
		
		
		addcust.clickOnAddnew();
		
		String email = randomestring() + "@test.com";
		addcust.setEmail(email);
				
		addcust.setPassword("test123");
		
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		addcust.setCustomerRoles("Guest");
		
		addcust.setManagerOfVendor("Vendor 2");
		
		addcust.setGender("Male");
		
		addcust.setFirstName("Tester");
		addcust.setLastName("QA");
		
		addcust.setDob("7/05/1995"); // Format: D/MM/YYY
		
		addcust.setCompanyName("Testcompany");
		addcust.setAdminContent("This is for testing.........");
		
		addcust.clickOnSave();
		
		
		
		logger.info("validation started....");
				
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		/*
		 * lp.clickLogout(); logger.info("clicked Logout...");// logger msg
		 * Thread.sleep(3000);
		 */
		
		
				
	}

	
	
	
	
}
