package com.testNg.testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testNg.base.BaseTest;
import com.testNg.log.Log;
import com.testNg.pages.LoginPage;
import com.testNg.utilities.PropertiesFile;
import com.testNg.utilities.ScreenshotUtility;

public class LoginTest extends BaseTest{

	WebDriver driver;
	LoginPage loginpage;
	PropertiesFile prop;
	ScreenshotUtility screen = new ScreenshotUtility();
	
	@BeforeMethod
	public void beformethod() {
		driver = getDriver();
		prop = new PropertiesFile();
		String url = prop.getProperty("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		DOMConfigurator.configure("log4j.xml");
	}
	
	
	@Test
	public void login() {
//		Testcase 2
		Log.startTestCase("Login Testcase");
		String username = prop.getProperty("username");
		loginpage.enterintoUsername(username);
		Log.info("Successfully entered the username");
		String password = prop.getProperty("password");
		loginpage.enterintoPassword(password);
		loginpage.clickLogin();
	}
	
	@Test
	public void noPassword() {
//		Testcase 1
		String username = prop.getProperty("username");
		loginpage.enterintoUsername(username);
		loginpage.enterintoPassword("");
		loginpage.clickLogin();
		String errormessage = loginpage.getErrorMessage();
		
		String expectedErrorMessage = "Please enter your password.";

		if (!errormessage.equals(expectedErrorMessage)) {
		    throw new AssertionError("Error message mismatch! Expected: " + expectedErrorMessage + ", Actual: " + errormessage);
		}
	}
	
	@Test
	public void checkRememberMe() {
//		Testcase 3
		String username = prop.getProperty("username");
		loginpage.enterintoUsername(username);
		String password = prop.getProperty("password");
		loginpage.enterintoPassword(password);
		loginpage.clickRememberMe();
		loginpage.clickLogin();
		loginpage.clickUserMenu();
		loginpage.clickLogout();
		String savedUsername = loginpage.getuserNameText();
		if (!savedUsername.equals(username)) {
		    throw new AssertionError("Error message mismatch! Expected: " + username + ", Actual: " + savedUsername);
		}
	}
	
	@Test
	public void forgotPassword() {
//		Testcase 4
		String username = prop.getProperty("username");
		loginpage.clickForgotPassword();
		loginpage.enterForgotPasswordUsername(username);
		loginpage.clickcontinueButton();
	}
	
	@Test
	public void invalidLogin() {
//		Testcase 5
		loginpage.enterintoUsername("123");
		loginpage.enterintoPassword("22131");
		loginpage.clickLogin();
		String errormessage = loginpage.getErrorMessage();
		System.out.println(errormessage);
		String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

		if (!errormessage.equals(expectedErrorMessage)) {
			throw new AssertionError(
					"Error message mismatch! Expected: " + expectedErrorMessage + ", Actual: " + errormessage);
		}

	}
	
	@AfterMethod
	public void teardown() {
		screen.takescreenshot(driver);
		close();
	}
}
