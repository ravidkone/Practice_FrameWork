package com.practice.appLauch;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apiTestWeather {
		String url="http://api.openweathermap.org/data/2.5/weather?";
		public Double API_Temp=32.1;

	@Test
	public void weather() throws Exception
	{
		RestAssured.baseURI=url;
		
		Response res= ufGet(url, generateParam_getAvailableRoomForCity_Recurring());
		System.out.println(res.getStatusCode());
		String temp=res.jsonPath().getString("main.temp");
		double t=273.15;
		double t1=Double.parseDouble(temp);
		API_Temp=t1-t; 
		System.out.println("temp is degree: "+API_Temp);

		res.prettyPrint();
		
	}
	
	public Response ufGet(String sURL, Map<String,String> parametersMap ) throws Exception{
		RestAssured.baseURI=sURL;
		Response res;
		if(parametersMap.isEmpty())
			res = RestAssured.given().get();
		else
			res = RestAssured.given().params(parametersMap).contentType("application/json").get();

		return res;
	}
	
    public HashMap<String, String> generateParam_getAvailableRoomForCity_Recurring() {
        HashMap<String, String> params = new HashMap<String, String>();
        
        params.put("q", "Kanpur");
        params.put("appid", "7fe67bf08c80ded756e598d6f8fedaea");
        return params;
    }
}
