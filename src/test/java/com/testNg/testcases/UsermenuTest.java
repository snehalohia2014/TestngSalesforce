package com.testNg.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testNg.base.BaseTest;
import com.testNg.log.Log;
import com.testNg.pages.LoginPage;
import com.testNg.pages.UsermenuPage;
import com.testNg.utilities.PropertiesFile;
import com.testNg.utilities.ScreenshotUtility;

public class UsermenuTest extends BaseTest {
	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	ScreenshotUtility screensht = new ScreenshotUtility();
	UsermenuPage usermenu;

	
	@BeforeMethod
	public void beformethod() {
		driver = getDriver();
		driver.manage().window().maximize();
		prop = new PropertiesFile();
		String url = prop.getProperty("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		String username = prop.getProperty("username");
		loginpage.enterintoUsername(username);
		String password = prop.getProperty("password");
		loginpage.enterintoPassword(password);
		loginpage.clickLogin();
		usermenu = new UsermenuPage(driver);
		usermenu.clickUserMenu();
		DOMConfigurator.configure("log4j.xml");
	}

	
	@Test
	public void userMenuDropdown() {
//		Testcase 6
		String myProfile = usermenu.getTextmyProfile();
		String mySettings = usermenu.getTextmySettings();
		String devConsole = usermenu.getTextdevConsole();
		String switchToLightning = usermenu.getTextswitchToLightning();
		String logout = usermenu.getTextlogout();

		if (myProfile.equals("My Profile") && mySettings.equals("My Settings") && devConsole.equals("Developer Console")
				&& switchToLightning.equals("Switch to Lightning Experience") && logout.equals("Logout")) {
			System.out.println("Pass!! All the user menu drop down options matched.");
		} else
			System.out.println("Fail");

	}

	
	@Test
	public void MyProfile() throws InterruptedException {
//		Testcase 7 
		Log.startTestCase("My Profile Testcase");
		usermenu.clickmyProfile();

//		edit last name
		usermenu.clickEditLink();
		usermenu.switchToEditFrame(driver);
		usermenu.clickAbout();
		usermenu.sendKeysLastName("lastname");
		usermenu.clicksaveAll();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

//		post
		usermenu.clickPost();
		usermenu.switchToPostFrame(driver);
		usermenu.sendKeyspostTextArea("Nothing is impossible. The word itself says 'I'm possible!");
		driver.switchTo().defaultContent();
		usermenu.clickshareButton();
		Thread.sleep(2000);

//		upload file
		usermenu.clickFile();
		usermenu.clickSalesforceFile();
		usermenu.switchTouploadFileFrame(driver);
		usermenu.clickAttach();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		usermenu.clickshareButton();
		Thread.sleep(2000);

//		add photo
		usermenu.mouseHoverToPhotoSection(driver);
		usermenu.clickuploadLink();
		usermenu.switchTophotoFrame(driver);
		usermenu.sendKeysChooseFile();
		usermenu.clickuploadButtonPanel();
		usermenu.clickphotoSave();
		Log.info("Successfully added photo");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
	}

	
	@Test
	public void MySettings() throws InterruptedException {
//		Testcase 8
		Log.startTestCase("My Settings Testcase");
		usermenu.clickMySettings();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		usermenu.clickPersonalTab();
		usermenu.clickLoginHistorytab();
		usermenu.clickDownloadLoginHistory();
		
//		displayAndlayoutTab
		usermenu.clickDisplayAndLayoutTab();
		usermenu.clickCustomizeTab();
		usermenu.selectCustomAppDropdown();
		usermenu.selectAvailableTabsDropdown();
		usermenu.clickAddButton();
		usermenu.clickSaveButton();
		
//		emailTab
		usermenu.clickEmailTab();
		usermenu.clickEmailSettingsTab();
		String name = prop.getProperty("name");
		usermenu.sendKeysEmailName(name);
		String emailAddress = prop.getProperty("email");
		usermenu.sendKeysEmailAddress(emailAddress);
		usermenu.clickBbcRadioButton();
		usermenu.clickSaveButton();
		Thread.sleep(2000);
		
//		calendarsAndRemindersTab
		usermenu.clickCalendarAndReminders();
		usermenu.clickActivityReminder();
		usermenu.clickOpenATestButton();
		Thread.sleep(2000);
	}

	
	@Test
	public void DeveloperConsole() {
//		Testcase 9
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		usermenu.clickDevConsole();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				System.out.println(handle);
			}
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	
	@Test
	public void logout() {
//		Testcase 10
		usermenu.clickLogout();
	}

	
	@AfterMethod
	public void teardown() {
		screensht.takescreenshot(driver);
		close();
	}

}
