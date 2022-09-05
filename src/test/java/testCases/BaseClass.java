package testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig Read = new ReadConfig();

	public String baseURL=Read.getApplicationURL();
	public String username=Read.getUseremail();
	public String password=Read.getPassword();
	public static WebDriver driver;
	public  WebDriverWait w;
	
	public static Logger logger; //Added logger
	
	
	@BeforeClass
	public void setup() throws InterruptedException 
		{
		logger = Logger.getLogger("eCommerce"); //Added logger
		PropertyConfigurator.configure("properties//Log4j.properties");//Added logger
		
		
		  System.setProperty("webdriver.chrome.driver", Read.getChromePath());
		   driver = new ChromeDriver();
		   Thread.sleep(4000);
		   logger.info("Browser launched....."); //logger msg
		 
		/*
		 * System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
		 * "//Drivers/chromedriver.exe" ); driver=new ChromeDriver();
		 */		
		   
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		
	
		}
				
		  @AfterClass public void tearDown() throws InterruptedException {
			 
		  
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
			driver.close();
		  logger.info("Browser closed....."); //logger msg
		  
		  
		  }
		 
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		logger.info("screenshot taken...."); //logger msg
	}
	
	
		public static  String randomestring() {
		
		String generatedString1 = RandomStringUtils.randomAlphanumeric(5);
		return (generatedString1);
	}


	

		public void refreshpage() {
			
			driver.navigate().refresh();
			logger.info("page refreshed ... "); //logger msg
		}
		
	


}


/*
 * @Parameters("browser")
 * 
 * @BeforeClass public void setup(String br) { 
 * logger =	 * Logger.getLogger("eCommerce"); //Added logger
 * PropertyConfigurator.configure("properties//Log4j.properties");//Added logger
 * 
 * System.setProperty("webdriver.chrome.driver", Read.getChromePath()); driver =
 * new ChromeDriver();
 * 
 * 
 * if (br.equals("firefox")) { // Firefox Browser
 * System.setProperty("webdriver.gecko.driver",Read.getFirefoxPath()); driver =
 * new FirefoxDriver(); }
 * 
 * else if (br.equals("chrome")) { // opens the browser
 * System.setProperty("webdriver.chrome.driver", Read.getChromePath()); driver =
 * new ChromeDriver(); }
 * 
 * else if (br.equals("ie")) { // opens the browser
 * System.setProperty("webdriver.ie.driver", Read.getIEPath()); driver = new
 * EdgeDriver(); }
 * 
 * 
 * // Global implicit Wait driver.manage().timeouts().implicitlyWait(30,
 * TimeUnit.SECONDS); }
 */

