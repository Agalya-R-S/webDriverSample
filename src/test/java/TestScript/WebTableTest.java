package TestScript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {
  @Test (groups="smokeTest")
  public void getAllValues() 
  {
	  	WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://the-internet.herokuapp.com/tables");
		  
		  //Get the list of element from a row(TR) based on text
		  List<WebElement> items = driver.findElements(By.xpath("//table[@id='table1']//td[contains(text(),'Frank')]//following-sibling::td"));
		  //table[@id='table1']//td[contains(text(),'Doe')]//following-sibling::td[1]
		  //table[@id='table1']//descendant::td
		  //div[@id="content"]//descendant::table
		  
		  //div.form-group - CSS selector
		  //input#name
		  //textarea#textarea
		  //input[placeholder="Enter Phone"]
		  //input[placeholder^='Enter'] - starts with
		  //input[placeholder$='Name'] - ends with
		  //input[placeholder*="Name"] - contains
		  //div#PageList2 ul li:nth-child(1)
		  //div#PageList2 ul li:last-child
		  //div#PageList2 ul li:first-child
		  		  
		  
		  //No of columns(TD) in a row 
		  System.out.println(items.size());
		  
		  //Printing each columns from the row.
		  for(WebElement item: items )
		  {
			  System.out.println(item.getText());
		  }
	  	
	  	
	  	
  }
}
