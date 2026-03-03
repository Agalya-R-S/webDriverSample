package TestScript;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Day6Resour {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
  @Test
  @BeforeTest
  public void setup() throws IOException
  {
	  String path = System.getProperty("user.dir")+
			  "//src//test//resources//configFiles//config.properties";
	  FileInputStream fin=new FileInputStream(new File(path));
	  prop=new Properties();
	  prop.load(fin);
	  String strBrowser = prop.getProperty("browser");
	  System.out.println(strBrowser);
	  if(strBrowser.equalsIgnoreCase("chrome"))
	  {
		  driver=new ChromeDriver();
	  }
	  else if(strBrowser.equalsIgnoreCase("edge"))
	  {
		  driver=new EdgeDriver();
	  }
	  
	  wait=new WebDriverWait(driver,Duration.ofSeconds(18));
	  driver.manage().window().maximize();
	  driver.get(prop.getProperty("url"));
	  
	  
	 	  
  }
  
/*  @Test
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
  }*/
   
}
