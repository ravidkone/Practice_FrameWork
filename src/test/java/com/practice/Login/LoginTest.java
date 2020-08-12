package com.practice.Login;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.practice.listner.custListner;
import com.practice.pom.LoginPage.LoginFBPage;
import com.practice.utility.TestBase;

@Listeners(custListner.class)
public class LoginTest extends TestBase{
	Logger log=Logger.getLogger(getClass().getSimpleName());
	LoginFBPage fb;
	
	public void setUp() {
	 fb=new LoginFBPage(driver);
	}
	
	@Test
	public void LoginFBTest() {
		System.out.println("Loggining In");
		log.info("User Triggered");
	}
	
	@Test
	public void ScreenShot() {
		Assert.assertEquals(true, false);
		log.info("User Triggered");
	}
	

}
