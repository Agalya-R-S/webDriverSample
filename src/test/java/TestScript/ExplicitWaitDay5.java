package TestScript;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ExplicitWaitDay5 {
  @Test
  public void f()
  {
	  WebDriver driver=new ChromeDriver();
//	  Actions action=new Actions(driver);
	  driver.manage().window().maximize();
	  driver.get("http://uitestingplayground.com/ajax");
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(18));
	  
	  
	  //Locating WebElement
	  WebElement btnAjax=driver.findElement(By.id("ajaxButton"));
	  btnAjax.click();
	  
	  //Waiting till the expected value is present
	  wait.until(ExpectedConditions.textToBePresentInElement
			  (driver.findElement(By.cssSelector("div#content")),"Data loaded with AJAX get request."));
	  
	  String strTxt=driver.findElement(By.cssSelector("div#content")).getText();
	  Assert.assertEquals(strTxt,"Data loaded with AJAX get request.");
	  System.out.println(strTxt);
  }
  
 
}
