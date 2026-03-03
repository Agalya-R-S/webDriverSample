package day14apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class FetchBookingTest 
{
  @Test
  public void getAllBookingIDs() 
  {
	  RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	  Response response = RestAssured.get("/booking");
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
	  Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
	  
	  ResponseBody body = response.getBody();
	  String bodyAsString = body.asString();
	  System.out.println("Body Response:!!!"+bodyAsString);  
	
  }
  
  @Test
  public void getBookingDetail()
  {
	  RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	  Response response = RestAssured.get("/booking/200");
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
	  Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
	  
	  ResponseBody body = response.getBody();
	  String bodyAsString = body.asString();
	  System.out.println("Body Response:!!!"+bodyAsString);  
	  
	  JsonPath jsonPathEvaluator = response.jsonPath();
	  String fname = jsonPathEvaluator.get("firstname");
	  Assert.assertEquals(fname, "John");
	  Assert.assertEquals(jsonPathEvaluator.get("additonalneeds"),"Breakfast");
	  
	  
  }
}
