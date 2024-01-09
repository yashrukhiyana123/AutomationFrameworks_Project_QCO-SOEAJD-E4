package ConatctsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
//import genericUtilities.Base_Class;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
 
public class CreateContactTest_ extends BaseClass
{
	
	@Test(groups = "SmokeSuite")
	public void createContactWithMandatoryInfo() throws IOException, InterruptedException
	{
		
		/* Read Test data from Excel File " */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
			
		// Step 4: Navigate to Contacts Link 
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
			
		// Step 5: Click on Create contact Look Up Image 
		ContactPage cp = new ContactPage (driver); 
		cp.clickOnCreateContactLookUpImg();
			
		// Step 6: Create contact with Mandatory details.	
		CreateNewContactPage cncp = new CreateNewContactPage(driver); 
		cncp.createNewContact(LASTNAME);
			
		// Step 8 Validate
		ContactInfoPage cip = new ContactInfoPage(driver); 
		String conHeader = cip.captureHeadertext(); 
		Assert.assertTrue(conHeader.contains(LASTNAME));
	}
}
