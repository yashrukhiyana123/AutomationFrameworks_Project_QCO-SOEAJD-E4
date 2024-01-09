package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser interface of TestNG
 * @author Yash
 * 
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{
	int count = 0;
	int retryCount = 3;
	
	public boolean retry(ITestResult result) // TODO Auto-generated method stub
	{
		// 0<3 1<3 2<3 3<3
		while(count<retryCount)
		{
			count++;	// 1 2 3
			
			return true; 	//retry //retry //retry
		}
		
		
		return false;	//stop
	}

}
