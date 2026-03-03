package commonUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utility
{
	
	public static String getScreenshotPath(WebDriver driver)
	{
	 TakesScreenshot scr = (TakesScreenshot)driver;
	  File scrFile = scr.getScreenshotAs(OutputType.FILE);
	  String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
	  File desti=new File(path);
	  
	  try {	
		  
		 FileUtils.copyFile(scrFile, desti);
	  }
	  catch(IOException e)
	  {
		  e.printStackTrace();
		  
	  }
	  
	  return path;

	}

}
