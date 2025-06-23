package com.testNg.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.testNg.base.BasePage;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Leads')]")
	WebElement leadsTab;
	
	@FindBy(id = "fcf")
	WebElement leadsDropdown;
	
	@FindBy(xpath = "//input[@value=' Go! ']")
	WebElement goButton;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
	WebElement newButton;
	
	@FindBy(xpath = "//input[@id='name_lastlea2']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='lea3']")
	WebElement company;
	
	@FindBy(xpath = "//*[@id='topButtonRow']/input[1]")
	WebElement saveButton;
	
	public void clickLeadsTab() {
		waitForElement(leadsTab, 10);
		leadsTab.click();
	}

	public void getLeadsDropdownText() {
		waitForElement(leadsDropdown, 10);
		Select leads = new Select(leadsDropdown);
		List <WebElement> list = leads.getOptions();
		for(WebElement options : list) {
			System.out.println(options.getText());
		}
	}
	
	public void selectLeadsDropdown(String leadOption) {
		waitForElement(leadsDropdown, 10);
		Select leads = new Select(leadsDropdown);
		leads.selectByVisibleText(leadOption);
	}
	
	public void clickGoButton() {
		waitForElement(goButton, 10);
		goButton.click();
	}
	
	public void clickNewButton() {
		waitForElement(newButton, 10);
		newButton.click();
	}
	
	public void enterIntoLastname(String lastName) {
		waitForElement(lastname, 10);
		lastname.sendKeys(lastName);
	}
	
	public void enterIntoCompany(String strCompany) {
		waitForElement(company, 10);
		company.sendKeys(strCompany);
	}
	
	public void clickSaveButton() {
		waitForElement(saveButton, 10);
		saveButton.click();
	}
}
