package com.practice.appLauch;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TriggerApi {
	
	 String sHost="http://api.openweathermap.org/data/2.5/weather?";
	
  @Test
  public void userProfile() {
	
	 String sURI="q=Kanpur&appid=7fe67bf08c80ded756e598d6f8fedaea";
	  
	  RestAssured.baseURI=sHost+sURI;
	//  RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather?q=Kanpur&appid=7fe67bf08c80ded756e598d6f8fedaea";
	 System.out.println("URL is: "+sHost+sURI);
	  
	Response res=RestAssured.given().contentType("application/json").get();
	
System.out.println("status code is: "+	res.getStatusCode());
res.prettyPrint();
//System.out.println("Status is: "+res.jsonPath().getString("status"));
//System.out.println("Employee Name: "+res.jsonPath().getString("data.employee_name"));
  }
	 
//	 @Test
//	 public void postCall() {
//		 String sURI="/create";
//		  
//		  RestAssured.baseURI=sHost+sURI;
//		  System.out.println("URL is: "+sHost+sURI);
//		  Response res1=RestAssured.given().body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}").contentType("Application/json").post();
//		  System.out.println("status code is: "+	res1.getStatusCode());
//		  res1.prettyPrint();
//	 }
}
