package com.practice.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class CommonUtility extends TestBase{

	FileInputStream fis;
	Properties prop=new Properties();
	
	public void loadConfigProperty(String sConfigPath) throws Exception {
		FileInputStream fis=new FileInputStream(sConfigPath);
		prop.load(fis);
		System.getProperties().putAll(prop);
	}
	public void loadLog4jProperty(String sLog4jPath) throws Exception {
		FileInputStream fis=new FileInputStream(sLog4jPath);
		prop.load(fis);
	//	System.getProperties().putAll(prop);
	}
}
