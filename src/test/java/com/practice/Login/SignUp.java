package com.practice.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://cai.tools.sap/");
		driver.findElement(By.xpath("//div[text()='OK']")).click();
		driver.findElement(By.xpath("//div[text()='Sign up']")).click();
		int size = driver.findElements(By.tagName("iframe")).size();
		// prints the total number of frames inside outer frame
		System.out.println("Total Frames --" + size);
		
		Thread.sleep(2000);
		driver.switchTo().frame("https://accounts.sap.com/ui/public/showRegisterForm?sourceUrl=https%3A%2F%2Fcai.tools.sap%2F&targetUrl=https%3A%2F%2Fcai.tools.sap%2Flogin%2FloggedIn&spName=https%3A%2F%2Fsapcai-community.authentication.eu10.hana.ondemand.com#https%3A%2F%2Fcai.tools.sap%2F");

	//	driver.switchTo().frame(0);
		Thread.sleep(3000);
	//	int size1 = driver.findElements(By.tagName("iframe")).size();
		// prints the total number of frames inside outer frame
	//	System.out.println("new Total Frames --" + size1);
	

		
		String text=driver.findElement(By.xpath("//h1[text()='Registration']")).getText();
		System.out.println("frame text is: "+text);
		
		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).sendKeys("ravi");
		driver.findElement(By.id("lastName")).sendKeys("kone");
		driver.findElement(By.id("mail")).sendKeys("ravidkone@gmail.com");
		
		
		driver.findElement(By.id("newPasswordInput-label")).click();
		System.out.println(driver.findElement(By.id("newPasswordInput-label")).isEnabled());

	//	System.out.println("after click");
		Thread.sleep(3000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='newPasswordInput']"))).click();
		
//		String inputText = "Test@1234";
//		WebElement myElement = driver.findElement(By.id("newPasswordInput-label"));
//		String js = "arguments[0].setAttribute('value','"+inputText+"')";
//		((JavascriptExecutor) driver).executeScript(js, myElement);
		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		Thread.sleep(5000);
//		jse.executeScript("document.getElementById('newPasswordInput-label').value='Test@1234';");
	//	jse.executeScript("document.getElementById('newPasswordInput-label').setAttribute('value','Test@1234')");

//		Thread.sleep(7000);
		driver.findElement(By.id("newPasswordInput")).sendKeys("Test@1234");
		driver.findElement(By.id("retypeNewPasswordInput")).sendKeys("Test@1234");
		driver.findElement(By.id("pdAccept")).click();
		driver.findElement(By.id("touAccept")).click();
		driver.findElement(By.id("sapStoreRegisterFormSubmit")).click();
		System.out.println("Submitted");
	}

}
