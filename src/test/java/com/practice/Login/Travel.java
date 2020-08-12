package com.practice.Login;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Travel {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//		driver.get("https://www.cleartrip.com/");
//		driver.findElement(By.xpath("(//input[@title='Any worldwide city or airport'])[1]")).sendKeys("Bengalu");
//		Thread.sleep(5000);
//		driver.switchTo().alert().dismiss();
//		driver.findElement(By.id("ui-id-4")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//input[@title='Any worldwide city or airport'])[2]")).sendKeys("mumba");
//		Thread.sleep(3000);
//		driver.findElement(By.id("ui-id-6")).click();
//
//		driver.findElement(By.id("DepartDate")).click();
//		driver.findElement(By.xpath("(//a[text()='30'])[2]")).click();
//		driver.findElement(By.id("SearchBtn")).click();
//		System.out.println("searching");
//
//		driver.findElement(By.xpath("//p[text()='Evening']")).click();
//		driver.findElement(By.xpath("(//button[text()='Book'])[1]")).click();

		driver.get("https://www.goibibo.com/");
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Bengaluru");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Bengaluru, India']")).click();
		System.out.println("Entered source");
		driver.findElement(By.id("gosuggest_inputDest")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Mumbai (BOM)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Mumbai, India']")).click();
		System.out.println("Entered Dest");
		driver.findElement(By.id("departureCalendar")).click();
		driver.findElement(By.id("fare_20200731")).click();
		driver.findElement(By.id("gi_search_btn")).click();

		driver.findElement(By.xpath("//span[text()='4pm - 9pm']")).click();

		List<WebElement> ListOfDuration = driver
				.findElements((By.xpath("//div[@class='ico15 fb txtCenter quicks padT5']")));
		System.out.println(ListOfDuration);
		for (int i = 0; i < ListOfDuration.size(); i++) {
			WebElement link = ListOfDuration.get(i);
			String t = link.getText();
			System.out.println(t);
		}
		driver.findElement(By.xpath("(//input[@value='BOOK'])[1]")).click();
	}

}
