package com.testNg.testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testNg.base.BaseTest;
import com.testNg.log.Log;
import com.testNg.pages.LeadsPage;
import com.testNg.pages.LoginPage;
import com.testNg.pages.UsermenuPage;
import com.testNg.utilities.PropertiesFile;
import com.testNg.utilities.ScreenshotUtility;

public class LeadsTest extends BaseTest {

	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	LeadsPage leadspage;
	ScreenshotUtility screensht = new ScreenshotUtility();

	@BeforeMethod
	public void beforeMethod() {
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
		leadspage = new LeadsPage(driver);
		leadspage.clickLeadsTab();
		DOMConfigurator.configure("log4j.xml");
	}

	@Test
	public void leadsTab() {
//		Testcase 21
		leadspage.clickLeadsTab();
	}

	@Test
	public void leadsDropdownText() {
//		Testcase 22
		leadspage.getLeadsDropdownText();
		UsermenuPage usermenupage = new UsermenuPage(driver);
		usermenupage.clickUserMenu();
		usermenupage.clickLogout();
	}

	@Test
	public void todaysLeads() {
//		Testcase 23
		leadspage.selectLeadsDropdown("My Unread Leads");
		UsermenuPage usermenupage = new UsermenuPage(driver);
		usermenupage.clickUserMenu();
		usermenupage.clickLogout();
		String username = prop.getProperty("username");
		loginpage.enterintoUsername(username);
		String password = prop.getProperty("password");
		loginpage.enterintoPassword(password);
		loginpage.clickLogin();
		leadspage.clickLeadsTab();
		leadspage.clickGoButton();
	}

	@Test
	public void todaysLeadsView() {
//		Testcase 24
		leadspage.selectLeadsDropdown("Today's Leads");
	}

	@Test
	public void newLead() {
//		Testcase 25
		Log.startTestCase("New Lead Testcase");
		leadspage.clickNewButton();
		leadspage.enterIntoLastname("ABCD_testingTestNg");
		leadspage.enterIntoCompany("ABCD");
		Log.info("Successfully created new lead");
		leadspage.clickSaveButton();
	}

	@AfterMethod
	public void teardown() {
		screensht.takescreenshot(driver);
		close();
	}
}
