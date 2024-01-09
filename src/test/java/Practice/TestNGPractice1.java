package Practice;

import org.testng.annotations. Test;

public class TestNGPractice1 
{
	@Test
	public void createCustomer()
	{
		System.out.println("Create");
	}
	
	@Test
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test(invocationCount = 3)
	public void deleteCustomer()
	{
		System.out.println("delete");
	}
}
