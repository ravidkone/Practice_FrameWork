package com.practice.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sap {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver=new FirefoxDriver();
		
		
		
		driver.manage().window().maximize();
		
		driver.get("https://cai.tools.sap/");
		String title=driver.getTitle();
		System.out.println("title of the page is:"+title);
		driver.findElement(By.xpath("//div[text()='OK']")).click();
		driver.findElement(By.xpath("//div[text()='Sign up']")).click();
		System.out.println("clicked on sign up");
		Thread.sleep(5000);
		
		driver.switchTo().frame("https://accounts.sap.com/ui/public/showRegisterForm?sourceUrl=https%3A%2F%2Fcai.tools.sap%2F&targetUrl=https%3A%2F%2Fcai.tools.sap%2Flogin%2FloggedIn&spName=https%3A%2F%2Fsapcai-community.authentication.eu10.hana.ondemand.com#https%3A%2F%2Fcai.tools.sap%2F");
	//	driver.switchTo().frame(0);
		System.out.println("moved to frame");

		Thread.sleep(5000);
	//	System.out.println("iframe is is:" +driver.findElement(By.tagName("iframe")).getAttribute("id"));

	//System.out.println("iframe is is:" +driver.findElement(By.id("IDS_UI_Window")).getAttribute("id"));
		
		WebDriverWait	wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Registration']")));
		
		String popUpText=driver.findElement(By.xpath("//h1[contains(text(),'Registration')]")).getText();
		System.out.println("pop up text is: "+popUpText);
		
//		WebElement ele=driver.findElement(By.xpath("//h1[text()='Registration']"));
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		
//		String text=(String)js.executeScript("return.arguments[0].text", ele);
//		System.out.println("pop up text is: "+text);

		int x=driver.findElement(By.xpath("//h1[text()='Registration']")).getLocation().getX();
		System.out.println("location is: "+x);
		driver.findElement(By.xpath("//input[@id='firstName' and @name='firstName']")).sendKeys("ravi");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@alt='Close']")).click();

	}

}
