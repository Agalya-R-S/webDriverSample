package TestScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Test

public class Day7LoginPage 
{
	WebDriver driver;	
	ChromeOptions options;
	//Map<String,Object>  prefs= new HashMap();
	  
	  
	@Test(dataProvider="loginTest")
	//This annotation says from where input arguments for the methods are coming
	public void login(String usr,String usrPwd)
		{
				driver = new ChromeDriver();
				driver.get("https://www.saucedemo.com/");
				
				//Locating element by ID and passing value to Webpage 
				//WebElement usrId = driver.findElement(By.id("user-name"));
				//usrId.sendKeys("standard_user");
				
				//Getting value from LoginTest Data Provider and passing to Webpage
				//usrId.sendKeys(usr);
				
				//Calling the Excel Obj method and sending values to the element
				WebElement usrId = driver.findElement(By.id(readObjPath("username")));
				usrId.sendKeys(usr);
				
				//Locating element by ID and passing value to Webpage 
				//WebElement pwd = driver.findElement(By.id("password"));
				//pwd.sendKeys("secret_sauce");
				
				//Getting value from LoginTest Data Provider and passing to Webpage
				//pwd.sendKeys(usrPwd);
				
				//Calling the Excel Obj method and sending values to the element
				WebElement pwd = driver.findElement(By.id(readObjPath("password")));
				pwd.sendKeys(usrPwd);
				
				//Click on Login Button
				//Locating element by ID
				//driver.findElement(By.id("login-button")).click();
				
				//Calling the Excel Obj method and sending values to the element
				WebElement btnClick = driver.findElement(By.id(readObjPath("loginBtn")));
				btnClick.click();
				
				
				//Locating element by CSSSelector
				//WebElement header = driver.findElement(By.cssSelector("span.title"));
				//Calling the Excel Obj method and sending values to the element
				WebElement header = driver.findElement(By.cssSelector(readObjPath("headerMsg")));
				
				//Checking the page load is correct
				Assert.assertTrue(header.isDisplayed());
		}
	
	@DataProvider(name="loginTest")
	//above is telling the data provider name to login page
	public Object[][] getData() throws CsvValidationException, IOException
	{
		//Opening and reading CSV file 
		String path=System.getProperty("user.dir")+"//src//test//resources//TestData//loginData.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		
		//Declaring String Array and ArrayList
		String rec[];
		ArrayList<Object> dataList = new ArrayList<Object>();
		
		//Reading each line from CSV file till the condition meets NULL record in CSV File
		while(( rec = reader.readNext()) != null)
		{
			Object record[]= { rec[0],rec[1]};
			dataList.add(record);
		}
		
		reader.close();
		return dataList.toArray(new Object[dataList.size()][]);		
	
	}
	
	public String readObjPath(String objName){
		
		//Object Repository from excel
		//Receiving Object name in Excel as input and returning the value of ObjPAth from excel	
		
		//objPath - excel value
		String objPath="";
		String path=System.getProperty("user.dir")+"//src//test//resources//TestData//objRep.xlsx";		
		FileInputStream fin;
		XSSFWorkbook workbook=null;	
		
		try{
			fin = new FileInputStream(path);
			workbook = new XSSFWorkbook(fin);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//Accessing the sheet1 tab from Excel
		XSSFSheet loginSheet = workbook.getSheet("loginPage");	
		
		//Getting total rows with data
		int numRows = 	loginSheet.getLastRowNum();
		
		//Going thru each row based on input value for this method and getting column value		
		for(int i=1;i <= numRows; i++ )
		{
			XSSFRow row = loginSheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName))
			{
				objPath = row.getCell(1).getStringCellValue();
				System.out.println("Values:"+objPath);
			}
		}
		
		//Returning the Object Path from excel to method
		return objPath;
	}
}
