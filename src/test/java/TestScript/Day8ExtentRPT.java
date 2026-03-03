package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import TestScript.Day8IRetryAnal.MyRetry1;
import commonUtils.utility;

//Day8
public class Day8ExtentRPT {
	
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
			
	@BeforeMethod
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://the-internet.herokuapp.com/upload");
	}
	
	@BeforeTest
	public void setupExtent()
	{
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
		
	}
	
  @Test
  public void upld()
  {
	  extentTest = extentReports.createTest("File Upload");
	  
	  driver.get("https://the-internet.herokuapp.com/upload");
	  WebElement chse = driver.findElement(By.id("file-upload"));
	  String path=System.getProperty("user.dir")+"/Screenshots/"+"1770792615868.png";
	  chse.sendKeys(path);	 
	  driver.findElement(By.id("file-submit")).click();  
	 		  
  }
  
  @Test(retryAnalyzer=MyRetry1.class)
  public void dwnld() 
  {
 	  extentTest = extentReports.createTest("File Download");
 	  driver.get("https://the-internet.herokuapp.com/download");
	  WebElement fle=driver.findElement(By.linkText("test-file.txt"));
	  fle.click();
	  
  }
  
  @AfterMethod
  public void tearDown(ITestResult result)
  {
	  if(result.getStatus() == result.FAILURE)
	  {
		  extentTest.log(Status.FAIL,result.getThrowable().getMessage());
		  String path=utility.getScreenshotPath(driver);
		  
		  extentTest.fail( MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	  }
  }
  
  
  @AfterTest
  //To clear the report after all methods are executed
  public void finishExtent()
  {
	  extentReports.flush();
  }
  
}
