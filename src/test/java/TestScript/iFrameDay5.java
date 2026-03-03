package TestScript;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.devtools.idealized.Javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iFrameDay5 {
  @Test
  public void f() throws InterruptedException
  {
	  WebDriver driver=new ChromeDriver();
	 // Actions action=new Actions(driver);
	  //Below is applicable for all findElement() and findElements()
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  driver.get("https://jqueryui.com/autocomplete/");
	  
	  //Locate the iFrame and WebElement
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	  WebElement ipTag=driver.findElement(By.id("tags"));
	  ipTag.sendKeys("jav");
	//Unconditional Wait - Java method 
    //Thread.sleep(2000);
	  
	  //the value in the textbox is present in UI list
	  List<WebElement> items = driver.findElements(By.cssSelector("ul#ui-id-1 >li"));
	  System.out.println("Total matching items:"+items.size() );
	  for (WebElement item : items)
	  {
		  System.out.println(item.getText());
		  if(item.getText().equalsIgnoreCase("JavaScript"))
		  {
			  item.click();
			  break;
		  }
	  }
	  
	  //Try for other values
	    
  }
  
  @Test
  public void jScpt()
  {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  //To execute JavaScript
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(10,document.body.scrollHeight)");
	  String strTitle = (String)js.executeScript("return document.title");
	  System.out.println(strTitle);
	  
	  
  }
}
