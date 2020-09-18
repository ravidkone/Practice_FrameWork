package com.practice.appLauch;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileApp {
	
	@Test
	public void lauchMobile() throws MalformedURLException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "2d3bbb1c");
		cap.setCapability("appPackage", "com.cowrksconnect");
		cap.setCapability("appActivity", "com.cowrksconnect.MainActivity");
		
		//cap.setCapability(MobileCapabilityType.APP,new File(System.getProperty("user.dir") + "/apk/app-staging.apk").getAbsolutePath());

		
		AppiumDriver<WebElement> driver=new AppiumDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		System.out.println("app launched");
	}

}
