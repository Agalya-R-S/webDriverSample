package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iFrame {
  @Test
  public void f() 
  {
	  WebDriver driver=new ChromeDriver();
	  Actions action=new Actions(driver);
	  driver.manage().window().maximize();
	  driver.get("https://jqueryui.com/tooltip/");
	  action.scrollByAmount(10,900).perform();
	  
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	  WebElement ipAge=driver.findElement(By.id("age"));
	  //Tooltip 
	  action.moveToElement(ipAge).perform();
	  
	  String altTxt = driver.findElement(By.cssSelector("#ui-id-1")).getText();
	  //tooltip hover. uanble to find the ID1. check on this.
	  Assert.assertEquals(altTxt, "We ask for your age only for statistical purposes.");
	  
	  //moving between frames
	  //driver.switchTo().parentFrame();
	  driver.switchTo().defaultContent();
	  
	  String strTxt=driver.findElement(By.cssSelector("div.demo-description")).getText();
	  System.out.println(strTxt);
	  
  }
}
