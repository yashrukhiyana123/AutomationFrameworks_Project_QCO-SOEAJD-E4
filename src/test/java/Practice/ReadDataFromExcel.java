package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel
{
	public static void main(String[] args) throws IOException 
	{
		//Step 1: Open the document in Java readable Format 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		//Step 2: Create a workbook 
		Workbook wb = WorkbookFactory.create(fis);

		//Step 3: Navigate to required sheet 
		Sheet sh = wb.getSheet("Contacts");


		//Step 4: Navigate to required Row 
		Row rw = sh.getRow(1);

		//Step 5: Navigate to required Cell 
		Cell cl = rw.getCell(2);

		//Step 6: Capture the Data inside the cell 
		String value = cl.getStringCellValue(); 
		System.out.println(value); 

		//Step 7: Close the workbook 
		wb.close();
	}
}
