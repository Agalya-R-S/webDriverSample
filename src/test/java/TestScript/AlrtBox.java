package TestScript;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlrtBox {
  @Test(groups="sanityTest")
  public void f()
  {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  WebElement smpAlt = driver.findElement(By.id("alertBtn"));
	  smpAlt.click();
	  
	  /*Alert alert = driver.switchTo().alert();
	  System.out.println("Text On simple alert box: "+ alert.getText());
	  Assert.assertEquals(alert.getText(),"I am an alert box!");
	  alert.accept(); */
	  
	  /*WebElement confirm = driver.findElement(By.id("confirmBtn"));
	  confirm.click();
	  Alert alert1 = driver.switchTo().alert();
	  System.out.println("Text On confirm alert box: "+ alert1.getText());
	  Assert.assertEquals(alert1.getText(),"Press a button!");
	  alert1.dismiss(); */
	  
	  //try for Confirm Alert and validate the text is expected
	 // WebElement pmpt = driver.findElement(By.id("promptBtn"));
	//  pmpt.click();
	 // Alert alert2 = driver.switchTo().alert();
	 // System.out.println("Text On promt alert box: "+ alert2.getText());
	 // Assert.assertEquals(alert2.getText(),"Press a button!");
	 // alert2.dismiss();
	  
  }
  
  @Test(groups="smokeTest")
  public void swtchWindow()
  {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  //Parent Window
	  String parenWin = driver.getWindowHandle();
	  System.out.println(parenWin);
	  //driver.findElement(By.xpath("//button[contains(text),'New Tab']")).click();
	  //pending to locate the element - chekc on it
	  	  
	  //Window Handles
	  Set<String> wins=driver.getWindowHandles();
	  System.out.println("Total Windows :"+wins.size());
	  System.out.println("Title of Parent Window "+driver.getTitle());
	  
	  //Dealing with Child Window
	  for (String win: wins)
	  {
		  System.out.println(win);
		  	if(!win.equalsIgnoreCase(parenWin))
		  	{
		  		//Switch to Child Window
		  		driver.switchTo().window(win);
		  		System.out.println("Child Window :" +driver.getTitle() );
		  		driver.close();
		  	}
	  }
	  
	  //Switch to Parent Window
	  driver.switchTo().window(parenWin);
	  driver.findElement(By.id("alertBtn")).click();
	  driver.quit();	  
  }
   
}
