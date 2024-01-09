package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of reusable methods related to Selenium tool
 * @author Yash
 */

public class SeleniumUtility 
{
	/**1
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{ 
		driver.manage().window().maximize();
	} 
		
	/**2
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{ 
		driver.manage().window().minimize();
	}
	
	/**3
	 * This method will minimize the window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver)
	{ 
		driver.manage().window().fullscreen();
	}
	
	/**4
	 * This method will wait for 10 seconds for all the web elements to Load
	 * @param driver
	 */
	public void addImplicitilyWait(WebDriver driver)
	{ 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	} 
	
	/**5
	 * This method will wait for 10 seconds for a particular web element to become visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**6
	 * This method will wait for 10 seconds for a particular web element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**7
	 * This method will handle dropdown By index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{ 
		Select sel = new Select(element); 
		sel.selectByIndex(index);
	}
	
	/**8
	 * This method will handle dropdown By value
	 * @param element
	 * @param value
	 */
	public void handleDropdown (WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**9
	 * This method will handle dropdown By visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**10
	 * This method will perform mouse Hovering action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element) 
	{
		Actions act = new Actions (driver);
		act.moveToElement(element).perform();
	}
	
	/**11
	 * This method will perform right click action on a web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction (WebDriver driver, WebElement element)
	{
		Actions act = new Actions (driver); 
		act.contextClick(element).perform();
	}
	
	/**12
	 * This method will perform double click action on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction (WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver); 
		act.doubleClick(element).perform();
	}
	
	/**13
	 * This method will perform drag and drop action.
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropAction (WebDriver driver, WebElement srcEle, WebElement dstEle)
	{
		Actions act = new Actions (driver);
		act.dragAndDrop(srcEle, dstEle).perform();
	}
	
	/**14
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollDownAction (WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("Window.scrollBy (0,500);", "");	//javascript snippet
	}
	
	/**15
	 * This method will scroll down for 500 units.
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,-500);", ""); // java script snippet
	}
	
	
	/**16
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) 
	{ 
		driver.switchTo().alert().accept();
	}
	
	/**17
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{ 
		driver.switchTo().alert().dismiss();
	}
	
	/**18
	 * This method will capture the text in alert popup and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) 
	{
		return driver.switchTo().alert().getText();
	}

	
	/**19
	 * This method will handle Frame By frame index
	 * @param driver
	 * @param frameIndex
	 */
	public void mandleframe (WebDriver driver, int frameIndex)
	{ 
		driver.switchTo().frame(frameIndex);
	}
	
	
	/**20
	 * This method will handle Frame By frame Name or ID
	 * @param driver
	 * @param frameNameID
	 */
	public void handleFrame(WebDriver driver, String frameNameID)
	{ 
		driver.switchTo().frame(frameNameID);
	}
	
	/**21
	 * This method will handle Frame By frame Element
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement)
	{ 
		driver.switchTo().frame(frameElement);
	}
	
	/**22
	 * This method will capture the screenshot and return the path to caller
	 * @param driver
	 * @param screenShotname
	 * @return
	 * @throws IOException 
	 */
	public String captureScreenShot (WebDriver driver, String screenShotname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);//temporary location
		File dst = new File(".\\Screenshots\\"+screenShotname+".png");//createContact-08-12-23-17-56.png
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();//d://mavenProjects/E4/Screenshots/create.png
		//attaching this screenshot to extent reports
	}
	
	/**23
	 * This method will switch the control to required window based on Title
	 * @param driver
	 * @param expPartialTitle
	 */
	public void handlewindows (WebDriver driver, String expPartialTitle) 
	{
		//Capture all window IDs 
		Set<String> allWinids = driver.getWindowHandles();
	
		//Navigate through each window ID 
		for(String winId:allWinids) 
		{
			//switch to each window ID and Capture the title 
			String actTitle = driver.switchTo().window(winId).getTitle();
	
			//Compare the window Titles 
			if(actTitle.contains(expPartialTitle))
			{
				break;
			}
		}
	}
	
	
}


