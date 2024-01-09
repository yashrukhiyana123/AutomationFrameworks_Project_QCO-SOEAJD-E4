package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	// declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactLookUpImg;

	// initialization
	public ContactPage(WebDriver driver) 
	{ 
		PageFactory.initElements (driver, this);
	}
	
	// Utilization
	public WebElement getCreateContactLookUpImg() 
	{
		return CreateContactLookUpImg;
	}

	 //Business Library
	
	/**
	 * This method will click on create contact look up Image
	 */
	 public void clickOnCreateContactLookUpImg()
	 {
		 CreateContactLookUpImg.click();
	 }
}
