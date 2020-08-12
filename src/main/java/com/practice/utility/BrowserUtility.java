package com.practice.utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility extends TestBase{
Logger log=Logger.getLogger(getClass().getSimpleName());
	
	@BeforeClass
	public void launchBrowser(String browser) {
		if(browser.equalsIgnoreCase(System.getProperty("browser"))) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase(System.getProperty("browser"))) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			log.info("Browser is not defined in config file");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(System.getProperty("url"));
		
	}
	
	public void takeShot(String getMethodName) throws IOException {
	File scrShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File(System.getProperty("user.dir")+"/ScreenShotFolder/"+getMethodName+"_"+".jpg");
	System.out.println("output path is:" +dest);
	//FileUtils.copyFile(scrShot, new File(System.getProperty("user.dir")+"/ScreenShotFolder"+getMethodName+"_"+".jpg"));
	FileUtils.copyFile(scrShot, dest);
	}


}
