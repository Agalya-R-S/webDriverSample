package TestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
public class ParmDay5 {
   
  WebDriver driver;
  
  @Test
//@Parameters("browser")
  public void setup(String brws)
  {
	  if(brws.equalsIgnoreCase("edge"))
	  {
		  driver=new EdgeDriver();
	  }
	  else if(brws.equalsIgnoreCase("chrome"))
	  {
		  driver=new ChromeDriver();
	  }
		  
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
  }  
}
