package com.practice.appLauch;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	public Double UI_Temp=32.2;
	public boolean status;
	@Test
	public void lauchBrowser() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.ndtv.com/");
		System.out.println("browser lauched");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='No Thanks']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("h_sub_menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='WEATHER']")).click();
		
		driver.findElement(By.id("searchBox")).sendKeys("Kanpur");
		driver.findElement(By.id("searchBox")).clear();

		
//		List<WebElement> list=driver.findElements(By.xpath("//div[@class='message']/label"));
//		int s1=list.size();
//		
//		if(checkCity(list,driver)) {
//		System.out.println("Entered city available to checking weather details");
//		}
//		else {
//			System.out.println("Entered city not available, searching for default city");
//			driver.findElement(By.id("searchBox")).clear();
//			driver.findElement(By.id("searchBox")).sendKeys("Kanpur");
//			driver.findElement(By.id("Kanpur")).click();
//		}
//
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[text()='Kanpur']")).click();
//		Thread.sleep(3000);
//		String temp=driver.findElement(By.xpath("//span[@class='heading']//b[contains(text(),'Degrees')]")).getText();
//		
//	//	String temp=driver.findElement(By.xpath("//b[contains(text(),'Degrees')]//parent::span")).getText();
//		
//		System.out.println("temp is: "+temp);
//		String s=temp.replaceAll("\\D", "");
//		System.out.println("Degree: "+s);
//		
//		UI_Temp=Double.parseDouble(s);
//		System.out.println("temp in degree: "+UI_Temp);
//		System.out.println("*****************");
//		String intValue = temp.replaceAll("[^0-9]", "");
//		System.out.println("degree 2nd: "+intValue);
//		
//		driver.quit();
		
	}
	
	public boolean checkCity(List<WebElement> list, WebDriver driver) {
		for(WebElement ele: list) {
			String city=ele.getAttribute("for");
			System.out.println(city);
			if(ele.getAttribute("for").equals("Knetep")) {
				driver.findElement(By.id("searchBox")).click();
				driver.findElement(By.id("searchBox")).sendKeys("Kanpur");
				driver.findElement(By.id("Kanpur")).click();
				return true;
			}
			
		}
		
		return false;
	}

}
