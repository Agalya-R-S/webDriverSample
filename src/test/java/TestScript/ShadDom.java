package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadDom {
  @Test
  public void f() 
  {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  WebElement shadowHost=driver.findElement(By.id("shadow_host"));
	  SearchContext cont = shadowHost.getShadowRoot();
	  cont.findElement(By.cssSelector("input[type='text']")).sendKeys("ShadowInput");
	  //driver.findElement(By.cssSelector("input[type='text']")).sendKeys("ShadowInput");
	  //check the difference between above two  lines and understand
	  		
	  
  }
}
