package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenarioe_1 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		/*Read Common Data From Property File(CommonData.properties)*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		/*Read Test Data From Excel File*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData_1.xlsx");
		Workbook wb = WorkbookFactory.create(fise); 
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		// Step 1: Launch the Base browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Step 2: Load the Application 
		driver.get(URL);
		Thread.sleep(2000);

		// Step 3: Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME); 
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);

		// Step 4: Click On Contacts Link 
		driver.findElement(By.linkText("Contacts")).click();

		// Step 5: Click on Create Contact Look Image 
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 6: Create new contact 
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 7: Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// Step 8: Validate 
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if (contactHeader.contains(LASTNAME))
		{ 
			System.out.println(contactHeader); 
			System.out.println("PASS");
		}
		else
		{ 
			System.out.println("FAIL");
		}

		// Step 9: Logout of App 
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver); 
		act.moveToElement(ele).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		
		//Step 10: Close the browser 
		driver.quit();

	}

}
