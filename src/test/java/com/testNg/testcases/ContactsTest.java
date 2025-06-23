package com.testNg.testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testNg.base.BaseTest;
import com.testNg.log.Log;
import com.testNg.pages.ContactsPage;
import com.testNg.pages.LoginPage;
import com.testNg.utilities.PropertiesFile;
import com.testNg.utilities.ScreenshotUtility;

public class ContactsTest extends BaseTest{

	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	ContactsPage contactspage;
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
		contactspage = new ContactsPage(driver);
		contactspage.clickContactsTab();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	public void createNewContact() {
//		Testcase 26
		Log.startTestCase("Create New Contact Testcase");
		contactspage.clickNewButton();
		contactspage.enterIntoLastname("contact_testng");
		contactspage.enterIntoCompanyname("ABCD_test");
		contactspage.clickCreateNewSaveButton();
		Log.info("Successfully created new contact");
		
	}
	
	@Test
	public void createNewContactView() {
//		Testcase 27
		contactspage.clickCreateNewViewLink();
		contactspage.enterIntoViewName("viewContact_testng");
		contactspage.enterIntoUniqueViewName("view_testng");
		contactspage.clickViewSaveButton();
	}
	
	@Test
	public void recentlyCreatedContact() {
//		Testcase 28
		contactspage.selectRecentlyCreated();
	}
	
	@Test
	public void myContacts() {
//		Testcase 29
		contactspage.selectMyContacts();
	}
	
	@Test
	public void viewContact() {
//		Testcase 30
		contactspage.clickContactName();
	}
	
	@Test
	public void errorMessageContacts() throws InterruptedException {
//		Testcase 31
		contactspage.clickCreateNewViewLink();
		Thread.sleep(2000);
		contactspage.enterIntoUniqueViewName("");
		contactspage.clickViewSaveButton();
		String errorMsg = contactspage.getTextErrorMessage();
		System.out.println(errorMsg);
	}
	
	@Test
	public void cancelContactViewButton() {
//		Testcase 32
		contactspage.clickCreateNewViewLink();
		contactspage.enterIntoViewName("viewContact_testng");
		contactspage.enterIntoUniqueViewName("testng");
		contactspage.clickCancelButton();	
	}
	
	@Test
	public void saveAndNewContactButton() {
//		Testcase 33
		contactspage.clickNewButton();
		contactspage.enterIntoLastname("Indian");
		contactspage.enterIntoCompanyname("Global");
		contactspage.clickSaveAndNewButton();	
	}
	
	@AfterMethod
	public void teardown() {
		screensht.takescreenshot(driver);
		close();
	}
}
