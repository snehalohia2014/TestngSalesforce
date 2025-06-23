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
import com.testNg.pages.RandomScenariosPage;
import com.testNg.utilities.PropertiesFile;
import com.testNg.utilities.ScreenshotUtility;

public class RandomScenariosTest extends BaseTest{

	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	RandomScenariosPage randomscenariospage;
	ScreenshotUtility screensht = new ScreenshotUtility();
	
	@BeforeMethod
	public void beforeMethod() {
		driver = getDriver();
		driver.manage().window().maximize();
		prop = new PropertiesFile();
		String url = prop.getProperty("url");
		driver.get(url);
		String username = prop.getProperty("username");
		loginpage = new LoginPage(driver);
		loginpage.enterintoUsername(username);
		String password = prop.getProperty("password");
		loginpage.enterintoPassword(password);
		loginpage.clickLogin();
		DOMConfigurator.configure("log4j.xml");
		randomscenariospage = new RandomScenariosPage(driver);
		randomscenariospage.clickHomeTab();
	}
	
	@Test
	public void verifyFirstLastName() {
//		Testcase 34
		String name = randomscenariospage.getTextFirstLastName();
		if(name.equals("first ABCD")) {
			System.out.println(name +" : Test pass!!");
		}else {
			System.out.println("Fail");
		}
	}
	
	@Test
	public void editProfile() {
//		Testcase 35
		Log.startTestCase("Edit Profile Testcase");
		randomscenariospage.clickHomeTab();
		randomscenariospage.clickFirstLastNameLink();
		randomscenariospage.clickEditIcon();
		randomscenariospage.switchToEditFrame(driver);
		randomscenariospage.clickAboutTab();
		randomscenariospage.enterIntoLastName("ABCD");
		randomscenariospage.clickSaveAllButton();
		Log.info("Successfully edited lastname");
		driver.switchTo().defaultContent();
		String userName = randomscenariospage.getTextusermenuTab();
		if(userName.equals("first ABCD")) {
			System.out.println( userName +" : Test Pass!!");
		}else {
			System.out.println("Fail.");
		}
	}
	
	@Test
	public void verifyTab() {
//		Testcase 36
		randomscenariospage.clickCustomizeTab();
		randomscenariospage.clickCustomizeMyTabsButton();
		randomscenariospage.selectSelectedTabs();
		randomscenariospage.clickRemoveButton();
		randomscenariospage.clickBottomSaveButton();
		randomscenariospage.clickUsermenuTab();
		randomscenariospage.clickLogout();
		String username = prop.getProperty("username");
		loginpage.enterintoUsername(username);
		String password = prop.getProperty("password");
		loginpage.enterintoPassword(password);
		loginpage.clickLogin();
	}
	
	@Test
	public void calendar() {
//		Testcase 37
		randomscenariospage.clickCurrDateLink();
		randomscenariospage.clickTime8pmLink();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		randomscenariospage.clickSubjectComboIcon();
		randomscenariospage.switchToChildWindow(driver, parentWindow);
		randomscenariospage.clickOtherFromComboBox();
		randomscenariospage.switchToParentWindow(driver, parentWindow);
		randomscenariospage.clickEndTimeField();
		randomscenariospage.clickTimePicker9PMFromDropdown();
		randomscenariospage.clickBottomSaveButton();
	}
	
	@Test
	public void weeklyRecurrence() {
//		Testcase 38
		randomscenariospage.clickCurrDateLink();
		randomscenariospage.clickTime4pmLink();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		randomscenariospage.clickSubjectComboIcon();
		randomscenariospage.switchToChildWindow(driver, parentWindow);
		randomscenariospage.clickOtherFromComboBox();
		randomscenariospage.switchToParentWindow(driver, parentWindow);
		randomscenariospage.clickEndTimeField();
		randomscenariospage.clickTimePicker7PMFromDropdown();
		randomscenariospage.clickRecurrenceCheckbox();
		randomscenariospage.clickWeeklyRadiobutton();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		randomscenariospage.sendKeysToRecurrenceEndDate();
		randomscenariospage.clickTopSaveButton();
		randomscenariospage.clickMonthViewIcon(driver);
	
	}
	
	
	@AfterMethod
	public void teardown() {
		screensht.takescreenshot(driver);
		close();
	}
}
