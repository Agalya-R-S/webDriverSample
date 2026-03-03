package TestScript;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HiddenElement {
  @Test
  public void BookStore() throws IOException 
  {
  Map<String,Object>  prefs= new HashMap();
	  
	  //Disable browser popup
	  prefs.put("credentials_enable_service", false);
	  prefs.put("profile.password_manager_enabled", false);
	  prefs.put("profile.password_manager_leak_detection",false);
	  
	  //ChromeOptions object - override default options
	  ChromeOptions options= new ChromeOptions();
	  options.setExperimentalOption("prefs", prefs);   
	  WebDriver driver= new ChromeDriver(options);
	  
	  driver.manage().window().maximize();
	  driver.get("https://automationbookstore.dev/");
	  
	  TakesScreenshot scr = (TakesScreenshot)driver;
	  File scrFile = scr.getScreenshotAs(OutputType.FILE);
	  String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
	  FileUtils.copyFile(scrFile, new File(path));
	  
	  WebElement ipUser = driver.findElement(By.id("searchBar"));
	  ipUser.sendKeys("Selenium");  
	  
	  
	  WebElement closeBtn = driver.findElement(By.cssSelector("a[title='Clear text']"));
	  System.out.println("Is Displayed ?"+closeBtn.isDisplayed());
	  
	/*  if(closeBtn.isDisplayed())
	  {
		  closeBtn.click();
	  }*/
	  
	  //WebElement bookIcon=driver.findElement(By.id("pid"));
	  
  }
}
