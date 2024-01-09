package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all Basic Configuration annotations of TestNG
 * @author Yash
 */
public class BaseClass 
{
	public ExeclFileUtility eUtil = new ExeclFileUtility();
	public JavaUtility jUtil = new JavaUtility(); 
	public SeleniumUtility sutil = new SeleniumUtility();
	public PropertyFileUtility putil = new PropertyFileUtility();
	
	public static WebDriver driver;

	@BeforeSuite(groups = { "SmokeSuite", "RegressionSuite" })
	public void bsConfig()
	{
			System.out.println("========== DB Connection Successful ===========");
	}

	@Parameters("browser")
	@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(String browser) throws IOException 
	{
	    String URL = putil.readDataFromPropertyFile("url");

	    if (browser.equals("Edge")) 
	    {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    } 
	    else if (browser.equals("Chrome")) 
	    {
	        WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	    }

	    sutil.maximizeWindow(driver);
	    sutil.addImplicitilyWait(driver);

	    driver.get(URL);
	    System.out.println("========== Browser Launched ==========");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp (USERNAME, PASSWORD);
		
		System.out.println("========= Login Successful ===========");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("========== logout successful ===========");
	}
	
	@AfterClass(alwaysRun = true)
	public void acconfig()
	{
		driver.quit();
		System.out.println("========== Browser closed ===========");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("========== DB Connection closed ==========");
	}
	
}






