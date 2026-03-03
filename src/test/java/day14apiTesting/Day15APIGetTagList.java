package day14apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Day15APIGetTagList
{
	@Test	
	public void allTagList()
	  {
		 //Get all tags in Article page.
		  RestAssured.baseURI = "https://conduit-realworld-example-app.fly.dev/";
		  //End Tag
		  Response repsonse = RestAssured.get("/api/tags");
		  int statusCode = repsonse.getStatusCode();
		  Assert.assertEquals(statusCode, 200);
		  Assert.assertEquals(repsonse.getContentType(), "application/json; charset=utf-8");
		  
		  //Get the body of the response - all Tags
		  ResponseBody  body=repsonse.getBody();
		  String bodyAsString = body.asString();
		  System.out.println(bodyAsString);
	  }
	
	@Test
	public void queryParameter()
	{
//		 RestAssured.baseURI = "https://petstore.swagger.io/#/";
////		  Response response = RestAssured.get("/pet/findByStatus");
//		
//		 RequestSpecification request=RestAssured.given();
//	//	 Response response = request.queryParam(null, null);
//		  
//	//	 String bodyAsString = response.asString();
//		 System.out.println(bodyAsString);
//		 Assert.assertEquals(bodyAsString.contains("avaialble"), true);
//		  
		  
	}
}
