package Practice;

import java.io.IOException;

import genericUtilities.ExeclFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;


public class GenericUtilitiesPracticeExcel 
{

	public static void main(String[] args) throws IOException
	{
		
		PropertyFileUtility pUtil = new PropertyFileUtility(); 
		String value = pUtil.readDataFromPropertyFile("username"); 
		System.out.println(value);
		
		ExeclFileUtility eUtil = new ExeclFileUtility(); 
		String data = eUtil.readDataFromExcel("Contacts", 1, 1);
		System.out.println(data);
		
		JavaUtility jUtil = new JavaUtility(); 
		System.out.println(jUtil.getSystemDate());

	}
}
