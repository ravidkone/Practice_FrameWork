package com.practice.utility;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public static BrowserUtility oBrowserUtil=new BrowserUtility();
	public static CommonUtility oCommonUtil=new CommonUtility();
	public static Constants oConstant=new Constants();
	public static RestUtility oRestUtil=new RestUtility();
	public static WebDriver driver;
	Logger log=Logger.getLogger(getClass().getSimpleName());
	
	
	@BeforeSuite
	public void TriggerDependency() throws Exception {
		
		oCommonUtil.loadConfigProperty(System.getProperty("user.dir")+"/src/main/java/com/practice/properties/config.properties");
		oCommonUtil.loadLog4jProperty(System.getProperty("user.dir")+"/src/main/java/com/practice/properties/log4j.properties");

		if(System.getProperty("AutomationRunning").equalsIgnoreCase(Constants.AutomationWeb)) {
			log.info("Automation Running on"+System.getProperty("AutomationRunning"));
			oBrowserUtil.launchBrowser(System.getProperty("browser"));
		}
	}
	
	@AfterSuite
	public void closeBrowser() {
		if(System.getProperty("AutomationRunning").equalsIgnoreCase(Constants.AutomationWeb)) {
			driver.quit();
	}
	}
}
