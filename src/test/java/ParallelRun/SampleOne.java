package ParallelRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleOne 
{
	WebDriver driver;
  @Test
  public void method1() 
  {
	  driver = new ChromeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method1 Thread ID: " + id);
  }
  
  @Test
  public void method2()
  {
	  driver = new ChromeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method2 Thread ID: " + id);
  }
  
  @Test
  public void method3()
  {
	  driver = new ChromeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method3 Thread ID: " + id);
  }
}
