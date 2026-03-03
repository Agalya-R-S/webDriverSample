package ParallelRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleTwo {
	WebDriver driver;
  @Test
  public void method11() 
  {
	  driver = new ChromeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method11 Thread ID: " + id);
  }
  
  @Test
  public void method12()
  {
	  driver = new EdgeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method12 Thread ID: " + id);
  }
  
  @Test
  public void method13()
  {
	  driver = new ChromeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method13 Thread ID: " + id);
  }
  
  @Test
  public void method14()
  {
	  driver = new ChromeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method14 Thread ID: " + id);
  }
  
  @Test
  public void method15()
  {
	  driver = new ChromeDriver();
	  long id =  Thread.currentThread().getId();
	  System.out.println("Method15 Thread ID: " + id);
  }
}
