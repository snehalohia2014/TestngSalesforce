package com.testNg.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public void takescreenshot(WebDriver driver) {
		//Take screen shot object
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		
		//Store this object in a file object
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date current = new Date();
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(current);
		
		//path for storing a file
		String userDir = System.getProperty("user.dir");
		String fileseparator = System.getProperty("file.separator");
		String filepath = userDir + fileseparator + "screenshots" + fileseparator + "Salesforce"+timestamp+".jpeg";
		
		//Convert filepath to file object
		File destFile = new File(filepath);
		
		//copy src file into dest file
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
