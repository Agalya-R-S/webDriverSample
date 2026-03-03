package TestScript;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class fileUpld {
  @Test
  public void upld()
  {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/upload");
	  
	  WebElement chse = driver.findElement(By.id("file-upload"));
	  String path=System.getProperty("user.dir")+"/Screenshots/"+"1770792615868.png";
	  chse.sendKeys(path);	 
	  driver.findElement(By.id("file-submit")).click();
	  
	  //check the file is correct
	  
  }
  @Test
  public void dwnld()
  {
	 // ChromeOptions options = new ChromeOptions();
	 // Map<String,Object> prefs = new HashMap<String,Object>();
	//  prefs.put(download.prompt_for_download",false);"
	//  options.setExperimentalOption("prefs",prefs);
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/download");
	  
	  WebElement fle=driver.findElement(By.linkText("test-file.txt"));
	  fle.click();
	  
  }
}
