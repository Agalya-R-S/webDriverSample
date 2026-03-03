package ParallelRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleThree3 {
	WebDriver driver;
  @Test
  public void method21() 
  {
	  driver = new ChromeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method21 Thread ID: " + id);
  }
  
  @Test
  public void method22()
  {
	  driver = new EdgeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method22 Thread ID: " + id);
  }
  
  
}
