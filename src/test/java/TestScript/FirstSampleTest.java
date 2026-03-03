package TestScript;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstSampleTest
{
  @Test
  public void loginTest() 
  {
	  //HashMap
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
	  //driver.get("https://the-internet.herokuapp.com/login");	
	  driver.navigate().to("https://the-internet.herokuapp.com/login");
	  
	  //Text Box
	  WebElement ipUser = driver.findElement(By.id("username"));
	  ipUser.sendKeys("tomsmith");
	  //Password TextBox
	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
	  //Button Click
	  //driver.findElement(By.className("radius")).click();
	  //driver.findElement(By.tagName("button")).click();
	  //driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
	  driver.findElement(By.className("radius")).submit();
	  driver.navigate().back();
	  System.out.println("Current URL : " + driver.getCurrentUrl());
	  System.out.println("Title:"+ driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "The Internet");
	  driver.navigate().forward();
	  
	  //input[ @type="password" and @name="password" ]
	  //(//form[@name="login"]//input)[1] -Index Xpath / chained Index
	  //table[@id='table1']
	  //table[@id='table1']//td[contains(text(),'Jason')]//following-sibling::td[2]
	  
	  
	  //HyperLink
	  //driver.findElement(By.linkText("Elemental Selenium")).click();
	  driver.findElement(By.partialLinkText("Selenium")).click();
	  
	  System.out.println("Code Change after PUSH to REMOTE");	  
	  
	  
	  
  }
}
