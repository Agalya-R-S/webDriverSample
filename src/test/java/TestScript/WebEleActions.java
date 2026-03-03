package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WebEleActions {
  @Test
  public void mouseAction() 
  {
	  
	  WebDriver driver= new ChromeDriver();	
	  Actions action=new Actions(driver);
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  WebElement drpDown =  driver.findElement(By.cssSelector("button.dropbtn"));
	  
	  action.scrollToElement(driver.findElement(By.xpath("//button[contains(text(),\"Copy Text\")]")));
	  action.moveToElement(drpDown).perform();
	  WebElement link = driver.findElement(By.linkText("Laptops"));
	  
	   
	  action.doubleClick(driver.findElement(By.xpath("//button[contains(text(),\"Copy Text\")]"))).perform();
	  WebElement fieldTwo=driver.findElement(By.id("field2"));
	  action.contextClick(fieldTwo).perform();
	  
	 //try for drag and drop
	  
	  
	  
  }
}
