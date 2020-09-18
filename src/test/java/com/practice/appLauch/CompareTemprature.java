package com.practice.appLauch;

import java.util.LinkedList;

import org.testng.annotations.Test;

public class CompareTemprature {
	
	Browser ui=new Browser();
	apiTestWeather api=new apiTestWeather();
	
	@Test
	public void test() {
	String res=compare(ui.UI_Temp, api.API_Temp);
	System.out.println("result is:"+res);
	}
	
	public static String compare(Double t1,Double t2) {
		System.out.println("UI Temp: "+t1);
		System.out.println("API Temp: "+t2);
		System.out.println("value is: "+Double.compare(t1, t2));
		if(Double.compare(t1, t2)==0||Double.compare(t1, t2)<-0.9||Double.compare(t1, t2)>0.9) {
			return "Pass";
		}else {
			return "Fail";
		}
		
 	}
	
}


//class comp{
//	Browser ui=new Browser();
//	apiTestWeather api=new apiTestWeather();
//	public void test() {
//	LinkedList<CityTemprature> list=new LinkedList<CityTemprature>();
//	list.add(new CityTemprature("UI Kanapur",30.3));
//	list.add(new CityTemprature("API Kanapur",32.2));
//	
//
//	}	
//}
//
// class CityTemprature implements Comparable<CityTemprature>{
//	 String name;
//	 Double Temp;
//	 
//	 public CityTemprature(String cityName,Double temp) {
//		 this.name=cityName;
//		 this.Temp=temp;
//	 }
//
//	public int compareTo(CityTemprature arg0) {
//		// TODO Auto-generated method stub
//		return (int) (this.Temp-arg0.Temp);
//	}
//	
//}