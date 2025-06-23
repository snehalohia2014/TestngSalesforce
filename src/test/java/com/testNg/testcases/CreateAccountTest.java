package com.testNg.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testNg.base.BaseTest;
import com.testNg.log.Log;
import com.testNg.pages.CreateAccountPages;
import com.testNg.pages.LoginPage;
import com.testNg.utilities.PropertiesFile;
import com.testNg.utilities.ScreenshotUtility;

public class CreateAccountTest extends BaseTest{
	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	CreateAccountPages createAccountPage;
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
		createAccountPage = new CreateAccountPages(driver);
		createAccountPage.clickAccounts();
		DOMConfigurator.configure("log4j.xml");
	}

	
	@Test
	public void createNewAccount() {
//		Testcase 11
		Log.startTestCase("Create New Account Testcase");
		createAccount("ABCD_1234");
	}
	
	private void createAccount(String accountName) {
		createAccountPage.clickCreateNewAccount();
		createAccountPage.clickAccountOption();
		createAccountPage.enterIntoAccountName(accountName);
		createAccountPage.selectTypeDropDown();
		createAccountPage.selectPriorityDropDown();
		createAccountPage.clickTopSave();
	}
	
	@Test
	public void createNewView() {
//		Testcase 12
		createAccountPage.clickCreateNewView();
		createAccountPage.enterIntoViewName("testingNg");
		createAccountPage.enterIntoUniqueName();
		createAccountPage.clickCreateNewViewSaveButton();
	}
	
	
	@Test
	public void editView() {
//		Testcase 13
		createAccountPage.selectViewDropdown();
		createAccountPage.clickEdit();
		createAccountPage.enterIntoViewName("edit_test");
		createAccountPage.selectFieldDropdown();
		createAccountPage.selectOperatorDropdown();
		createAccountPage.sendKeysValue();
		createAccountPage.selectAvailableFieldsDropdown();
		createAccountPage.clickAddButton();
		createAccountPage.clickCreateNewViewSaveButton();
	}
	
	
	@Test
	public void mergeAccounts() {
//		Testcase 14
		createAccount("testng_1");
		createAccount("testng_2");
		createAccountPage.clickHomeTab();
		createAccountPage.clickAccounts();
		createAccountPage.clickMergeAccountLink();
		createAccountPage.sendKeysToSearchTextArea("ABCD");
		createAccountPage.clickFindAccountsButton();
		createAccountPage.clickCb1();
		createAccountPage.clickCb2();
		createAccountPage.clickNextButton();
		createAccountPage.clickMergeButton();
		String windowAlertText = driver.switchTo().alert().getText();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		System.out.println(windowAlertText);

	}
	
	@Test
	public void createNewReport() {
//		Testcase 15
		createAccountPage.clickAccountsWithLastActivityLink();
		createAccountPage.clickDateField();
		createAccountPage.clickCreatedDate();
		createAccountPage.clickFromDateField();
		createAccountPage.clickFromDateTodayButton();
		createAccountPage.clickToDateField();
		createAccountPage.clickToDateTodayButton();
		createAccountPage.clickSaveButton();
		createAccountPage.sendKeysToReportName("testngReport");
		createAccountPage.clickReportUniqueName();
		createAccountPage.clickSaveAndRunButton();
	}
	
	
	@AfterMethod
	public void teardown() {
		screensht.takescreenshot(driver);
		close();
	}
}

