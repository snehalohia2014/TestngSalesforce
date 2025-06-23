package com.testNg.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
//call this by creating an instance of PropertiesFile and then calling the method
	
	FileInputStream fileinput;
	
	public String getProperty(String Key)  {
		
		String userDir = System.getProperty("user.dir");
		String fileseparator = System.getProperty("file.separator");
		String filepath = userDir + fileseparator + "properties" + fileseparator + "application.properties";
		
		try {
			fileinput = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fileinput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (String) prop.getProperty(Key);	
	}
}
