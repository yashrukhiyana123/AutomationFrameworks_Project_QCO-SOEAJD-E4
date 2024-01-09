package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consits of reusable methods related to excel file
 * @author Yash
 */

public class ExeclFileUtility 
{
	/**
	 * This method will read data from given excel file and return the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData_1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
}
