package com.testNg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.testNg.base.BasePage;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id='Contact_Tab']/a")
	WebElement contactsTab;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
	WebElement newButton;
	
	@FindBy(xpath = "//input[@id='name_lastcon2']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='con4']")
	WebElement companyName;
	
	@FindBy(xpath = "//*[@id='topButtonRow']/input[1]")
	WebElement createNewSaveButton;
	
	@FindBy(xpath = "//a[contains(text(),'Create New View')]")
	WebElement createNewViewLink;
	
	@FindBy(xpath = "//input[@id='fname']")
	WebElement viewname;
	
	@FindBy(xpath = "//input[@id='devname']")
	WebElement uniqueViewname;
	
	@FindBy(xpath = "//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]")
	WebElement viewSaveButton;
	
	@FindBy(xpath = "//select[@id='hotlist_mode']")
	WebElement recentDropdown;
	
	@FindBy(xpath = "//select[@id='fcf']")
	WebElement dropdownList;
	
	@FindBy(xpath = "//a[contains(text(),'test')]")
	WebElement contactName;
	
	@FindBy(xpath = "//div[@class='requiredInput']//div[@class='errorMsg']")
	WebElement errorMessage;
	
	@FindBy(xpath = "//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[2]")
	WebElement cancelButton;
	
	@FindBy(xpath = "//*[@id='topButtonRow']/input[2]")
	WebElement saveAndNewButton;
	
	public void clickContactsTab() {
		waitForElement(contactsTab, 10);
		contactsTab.click();
	}
	
	public void clickNewButton() {
		waitForElement(newButton, 10);
		newButton.click();
	}
	
	public void enterIntoLastname(String strLastname) {
		waitForElement(lastname, 10);
		lastname.sendKeys(strLastname);
	}
	
	public void enterIntoCompanyname(String strCompanyname) {
		waitForElement(companyName, 10);
		companyName.sendKeys(strCompanyname);
	}
	
	public void clickCreateNewSaveButton() {
		waitForElement(createNewSaveButton, 10);
		createNewSaveButton.click();
	}
	
	public void clickCreateNewViewLink() {
		waitForElement(createNewViewLink, 10);
		createNewViewLink.click();
	}
	
	public void enterIntoViewName(String strviewname) {
		waitForElement(viewname, 10);
		viewname.sendKeys(strviewname);
	}
	
	public void enterIntoUniqueViewName(String strUniqueViewname){
		uniqueViewname.click();
		uniqueViewname.clear();
		uniqueViewname.sendKeys(strUniqueViewname);
	}
	
	public void clickViewSaveButton() {
		viewSaveButton.click();
	}
	
	public void selectRecentlyCreated() {
		waitForElement(recentDropdown, 10);
		Select recent = new Select(recentDropdown);
		recent.selectByVisibleText("Recently Created");
	}

	public void selectMyContacts() {
		waitForElement(dropdownList, 10);
		Select list = new Select(dropdownList);
		list.selectByVisibleText("My Contacts");
	}
	
	public void clickContactName() {
		waitForElement(contactName, 10);
		contactName.click();
	}
	
	public String getTextErrorMessage() {
		waitForElement(errorMessage, 10);
		return errorMessage.getText();
	}
	
	public void clickCancelButton() {
		waitForElement(cancelButton, 10);
		cancelButton.click();
	}
	
	public void clickSaveAndNewButton() {
		waitForElement(saveAndNewButton, 10);
		saveAndNewButton.click();
	}
}
