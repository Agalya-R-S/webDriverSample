package TestScript;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Buttons {
	
	//Declare class level.
	WebDriver driver;
/*	@BeforeMethod
	public void setup()
	{
		  driver= new ChromeDriver();	  
		  driver.manage().window().maximize();
		  driver.get("https://testautomationpractice.blogspot.com/");
	}*/
	
	@BeforeTest
	public void setup()
	{
		  driver= new ChromeDriver();	  
		  driver.manage().window().maximize();
		  driver.get("https://testautomationpractice.blogspot.com/");
	}
	
  @Test(priority=2)
  public void rdoBtn() 
  {
	  Map<String,Object>  prefs= new HashMap();
	  
	  //Disable browser popup
	  prefs.put("credentials_enable_service", false);
	  prefs.put("profile.password_manager_enabled", false);
	  prefs.put("profile.password_manager_leak_detection",false);
	  
	  //ChromeOptions object - override default options
	  //ChromeOptions options= new ChromeOptions();
	  //options.setExperimentalOption("prefs", prefs);   
	  //WebDriver driver= new ChromeDriver(options);
	  
	  //driver.manage().window().maximize();
	  //driver.get("https://testautomationpractice.blogspot.com/");
	  
	  WebElement gender = driver.findElement(By.id("male"));
	  if(!gender.isSelected())
	  {
		  gender.click();
	  }
	  Assert.assertFalse(gender.isSelected());
  }
  
  @Test(priority=1)
  public void chkBox()
  {
	  // WebDriver driver= new ChromeDriver();	  
	  //driver.manage().window().maximize();
	 // driver.get("https://testautomationpractice.blogspot.com/");
	  WebElement sunday=driver.findElement(By.id("sunday"));
	  sunday.click();
	  Assert.assertTrue(sunday.isSelected());
	  //Assert.assertFalse(sunday.isSelected());
	  SoftAssert sftAssert= new SoftAssert();
	  sftAssert.assertFalse(sunday.isSelected());
	  
	  System.out.println("Value of Sunday :"+ sunday.getDomAttribute("value"));
	  System.out.println("Value of a property :"+ sunday.getDomProperty("tagName"));
	  if(sunday.isSelected())
	  {
		  sunday.click();
		  System.out.println("Sunday is selected");
	  }
	  sftAssert.assertFalse(sunday.isSelected());
	  sftAssert.assertAll();
	  
  }
  
  
@Test(alwaysRun=true,dependsOnMethods="rdoBtn")
  public void dropDown()
  {
	  Select sinSel = new Select(driver.findElement(By.id("country")));
	  sinSel.selectByVisibleText("India");
	  
	  Select mulSel = new Select(driver.findElement(By.id("animals")));
	  mulSel.selectByVisibleText("Cat");
	  mulSel.selectByIndex(1);
	  mulSel.selectByValue("deer");
	  //mulSel.getAllSelectedOptions();
  }
}
