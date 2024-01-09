package Practice;

import java.io.IOException;
import genericUtilities.PropertyFileUtility;

public class GenericUtilitiesPractice 
{

	public static void main(String[] args) throws IOException 
	{
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("username"); 
		System.out.println(value);
	}

}
	