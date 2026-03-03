package TestScript;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Day8IRetryAnal
{
	public class MyRetry1 implements IRetryAnalyzer 
	{

		//IRetryAnalyzer - Interface
		//MyRetry = classname
		//retry - method name @Override 
		  private int retryCount = 0;
		  private static final int maxRetryCount = 3;

		  @Override
		  public boolean retry(ITestResult result)
		  {
			  if (result.getStatus() == ITestResult.FAILURE )
			  {
				  if (retryCount < maxRetryCount)
				  {
				      retryCount++;
				      return true;
				  }
			  }
		     return false;
		  }
		}
}
