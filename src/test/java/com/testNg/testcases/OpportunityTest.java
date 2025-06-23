package com.testNg.testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testNg.base.BaseTest;
import com.testNg.log.Log;
import com.testNg.pages.LoginPage;
import com.testNg.pages.OpportunityPage;
import com.testNg.utilities.PropertiesFile;
import com.testNg.utilities.ScreenshotUtility;

public class OpportunityTest extends BaseTest {

	WebDriver driver;
	PropertiesFile prop;
	LoginPage loginpage;
	OpportunityPage opportunitypage;
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
		opportunitypage = new OpportunityPage(driver);
		opportunitypage.clickOpportunitiesTab();
		DOMConfigurator.configure("log4j.xml");
		
	}

	
	@Test
	public void opportunitiesDropdown() {
//		Testcase 16
		opportunitypage.getOpportunitiesDropdownText();
	}

	
	@Test
	public void newOpportunity() {
//		Testcase 17
		Log.startTestCase("New Opportunity Testcase");
		opportunitypage.clickNewButton();
		opportunitypage.sendKeysToOpportunityName("testngOpportunity");
		opportunitypage.sendKeysToAccountName("ABCD_test1");
		opportunitypage.sendKeysToCloseDate("04/25/2024");
		opportunitypage.selectStageDropdown();
		opportunitypage.sendKeysToProbability();
		opportunitypage.selectLeadSourceDropdown();
		opportunitypage.clickTopSaveButton();
		Log.info("Successfully created new opportunity");
	}

	@Test
	public void opportunityPipelineReport() {
//		Testcase 18
		opportunitypage.clickOpportunityPipeline();
	}

	
	@Test
	public void stuckOpportunityReport() {
//		Testcase 19
		opportunitypage.clickStuckOpportunities();
	}

	
	@Test
	public void opportunitySummaryReport() {
//		Testcase 20
		opportunitypage.selectIntervalDropdown();
		opportunitypage.selectIncludeDropdown();
		opportunitypage.clickRunReportButton();
	}

	
	@AfterMethod
	public void teardown() {
		screensht.takescreenshot(driver);
		close();
	}
}
