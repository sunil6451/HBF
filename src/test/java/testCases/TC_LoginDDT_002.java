package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass
{
	
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
	
	
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String psd) throws InterruptedException, IOException {
		
		driver.get(baseURL);
		driver.manage().window().maximize(); 
		
		
		LoginPage lp = new LoginPage(driver);
		
		
		lp.clearemail();
		lp.clearpass();
		
		
		
		lp.setUserName(user);
		logger.info("User provided"); //logger msg
		
		
		lp.setPassword(psd);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		// prod validation 
		//if (driver.getTitle().equals("Free and open-source eCommerce platform. ASP.NET Core based shopping cart. - nopCommerce")) {
		
			// qa URL validation
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			
			
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
		} else {
			//captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");//logger msg
			
		}

	}
		
	

	
}
