package com.testNg.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.testNg.base.BasePage;

public class OpportunityPage extends BasePage{

	public OpportunityPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='Opportunities Tab']")
	WebElement opportunitiesTab;
	
	@FindBy(id = "fcf")
	WebElement opportunitiesDropdown;
	
	@FindBy(xpath = "//a[contains(text(),'Opportunity Pipeline')]")
	WebElement opportunityPipeline;
	
	@FindBy(xpath = "//a[contains(text(),'Stuck Opportunities')]")
	WebElement stuckOpportunities;
	
	@FindBy(xpath = "//select[@id='quarter_q']")
	WebElement intervalDropdown;
	
	@FindBy(xpath = "//select[@id='open']")
	WebElement includeDropdown;
	
	@FindBy(xpath = "//tbody/tr[3]/td[1]/input[1]")
	WebElement runReportButton;
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[3]/div[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	WebElement newButton;
	
	@FindBy(id = "opp3")
	WebElement opportunityName;
	
	@FindBy(id = "opp4")
	WebElement accountName;
	
	@FindBy(id = "opp9")
	WebElement closeDate;
	
	@FindBy(id = "opp11")
	WebElement stageDropdown;
	
	@FindBy(id = "opp12")
	WebElement probability;
	
	@FindBy(id = "opp6")
	WebElement leadSourceDropdown;
	
	@FindBy(xpath = "//*[@id='topButtonRow']/input[1]")
	WebElement topSaveButton;
	
	public void clickOpportunitiesTab() {
		waitForElement(opportunitiesTab, 10);
		opportunitiesTab.click();
	}
	
	public void getOpportunitiesDropdownText() {
		waitForElement(opportunitiesDropdown, 10);
		Select opportunities = new Select(opportunitiesDropdown);
		List <WebElement> list = opportunities.getOptions();
		for(WebElement option : list) {
			System.out.println(option.getText());
		}
	}
	
	public void clickOpportunityPipeline() {
		opportunityPipeline.click();
	}
	
	public void clickStuckOpportunities() {
		stuckOpportunities.click();
	}
	
	public void selectIntervalDropdown() {
		Select interval = new Select(intervalDropdown);
		interval.selectByVisibleText("Next FQ");
	}
	
	public void selectIncludeDropdown() {
		Select include = new Select(includeDropdown);
		include.selectByVisibleText("Open Opportunities");
	}
	
	public void clickRunReportButton() {
		runReportButton.click();
	}
	
	public void clickNewButton() {
		waitForElement(newButton, 10);
		newButton.click();
	}

	public void sendKeysToOpportunityName(String opportunity_name) {
		waitForElement(opportunityName, 10);
		opportunityName.sendKeys(opportunity_name);
	}

	public void sendKeysToAccountName(String account_name) {
		accountName.sendKeys(account_name);
	}

	public void sendKeysToCloseDate(String date) {
		closeDate.sendKeys(date);
	}

	public void selectStageDropdown() {
		Select stage = new Select(stageDropdown);
		stage.selectByIndex(2);;
	}

	public void sendKeysToProbability() {
		probability.sendKeys("0");
	}
	
	public void selectLeadSourceDropdown() {
		Select lead = new Select(leadSourceDropdown);
		lead.selectByIndex(2);
	}

	public void clickTopSaveButton() {
		waitForElement(topSaveButton, 10);
		topSaveButton.click();
	}
}
