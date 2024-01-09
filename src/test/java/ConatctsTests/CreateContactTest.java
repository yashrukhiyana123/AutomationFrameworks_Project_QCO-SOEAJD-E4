package ConatctsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.ExeclFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;


public class CreateContactTest {

	//public static void main(String[] args) throws IOException, InterruptedException  
	
	@Test
	public void createContactWithMandatoryFields() throws IOException, InterruptedException
	{
		
		
		// Create Object of Required Utility Classes 
		PropertyFileUtility pUtil = new PropertyFileUtility(); 
		ExeclFileUtility eUtil = new ExeclFileUtility(); 
		SeleniumUtility sUtil = new SeleniumUtility();	

		/* Read Common Data from Property File */
		String URL = pUtil.readDataFromPropertyFile("url"); 
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		 
		/* Read Test Data From Excel File */ 
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);

		// Step 1: Launch the Base browser 
		WebDriver driver = new ChromeDriver(); 
		sUtil.maximizeWindow(driver); 
		sUtil.addImplicitilyWait(driver);

		// Step 2: Load the Application 
		driver.get(URL);

		// Step 3: Login to Application 
		LoginPage lp = new LoginPage(driver); 
		lp.loginToApp(USERNAME, PASSWORD);

		// Step 4: Click On Contacts Link 
		HomePage hp = new HomePage(driver); 
		hp.clickOnContactsLink();

		// Step 5: Click on Create Contact Look Image 
		ContactPage cp = new ContactPage(driver); 
		cp.clickOnCreateContactLookUpImg();

		// Step 6: Create new contact 
		CreateNewContactPage cncp = new CreateNewContactPage(driver); 
		cncp.createNewContact (LASTNAME);

		
		// Step 7: Validate 
		ContactInfoPage cip = new ContactInfoPage(driver); 
		String contactHeader = cip.captureHeadertext();
		if (contactHeader.contains(LASTNAME)) 
		{
			System.out.println(contactHeader); System.out.println("PASS");
		} 
		else 
		{ 
			System.out.println("FAIL");
		}

		// Step 8: Logout of App 
		hp.logoutOfApp(driver);

		// Step 9: Close the browser 
		driver.quit();
	}
}
