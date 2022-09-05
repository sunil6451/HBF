package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);

		LoginPage lp = new LoginPage(driver);

		lp.clearemail();
		lp.clearpass();

		lp.setUserName(username);
		logger.info("User provided"); // logger msg

		lp.setPassword(password);
		logger.info("Password provided");// logger msg

		lp.clickLogin();
		logger.info("Login in Clicked...");// logger msg
		Thread.sleep(3000);

		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
	
			Assert.assertTrue(true);
			
			
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed....taken screenshot");// logger msg

		}
		
		/*
		 * refreshpage(); lp.clickLogout(); logger.info("clicked Logout...");// logger
		 * msg Thread.sleep(3000);
		 */

	}

}
