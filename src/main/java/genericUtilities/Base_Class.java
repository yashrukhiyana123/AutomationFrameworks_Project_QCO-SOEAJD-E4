package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations. AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations. AfterSuite;
import org.testng.annotations. BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all basic Configuration Annotations of TestNG
 * @author Yash
 */
public class Base_Class 
{
		public ExeclFileUtility eUtil = new ExeclFileUtility();
		public JavaUtility jUtil = new JavaUtility();
		public PropertyFileUtility pUtil = new PropertyFileUtility();
		public SeleniumUtility sUtil = new SeleniumUtility();

		public WebDriver driver;
		
		@BeforeSuite(groups = "SmokeSuite")
		public void bsConfig()
		{
			System.out.println("======== DB Connection Successfull =========");	
		}
		
		@BeforeClass(alwaysRun = true)
		public void bcConfig() throws IOException
		{
			String URL = pUtil.readDataFromPropertyFile("url");

			driver = new ChromeDriver();

			sUtil.maximizeWindow(driver);
			sUtil.addImplicitilyWait(driver);

			driver.get(URL);
		
			System.out.println("======== Browser launch Successfull =========");
		}
		
		@BeforeMethod(alwaysRun = true)
		public void bmConfig() throws IOException
		{
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			
			LoginPage lp = new LoginPage(driver); 
			lp.loginToApp (USERNAME, PASSWORD);
			
			System.out.println("======== Login to App Successfull ==-------");
		}
		
		@AfterMethod(alwaysRun = true)
		public void amConfig() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.logoutOfApp(driver);
			
			System.out.println("======== Logout of App Successfull =--------");
		}
		
		@AfterClass(alwaysRun = true)
		public void acconfig()
		{
			driver.quit();
			
			System.out.println("======== Browser closure Successfull =========");
		}

		@AfterSuite(alwaysRun = true)	
		public void asConfig()
		{
		
			System.out.println("======== DB closure Successfull =========");
		}

		
	}


