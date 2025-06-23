package com.testNg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.testNg.base.BasePage;

public class UsermenuPage extends BasePage{

	public UsermenuPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "userNavButton")
	WebElement userMenu;
	
	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement myProfile;
	
	@FindBy(xpath = "//a[contains(text(),'My Settings')]")
	WebElement mySettings;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/a[3]")
	WebElement devConsole;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/a[4]")
	WebElement switchToLightning;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/a[5]")
	WebElement logout;
	
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	WebElement editLink;
	
	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	WebElement editFrame;
	
	@FindBy(xpath = "//a[contains(text(),'About')]")
	WebElement about;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@value='Save All']")
	WebElement saveAll;
	
	@FindBy(xpath = "//a[@title='Post']")
	WebElement post;
	
	@FindBy(xpath = "//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	WebElement postFrame;
	
	@FindBy(xpath = "//body")
	WebElement postTextArea;
	
	@FindBy(xpath = "//input[@id='publishersharebutton']")
	WebElement shareButton;
	
	@FindBy(xpath = "//a[@title='File']")
	WebElement fileButton;
	
	@FindBy(xpath = "//a[contains(text(),'Select a file from Salesforce')]")
	WebElement existingfile;
	
	@FindBy(xpath = "//iframe[@id='chatterFindExistingContentContentId']")
	WebElement uploadFileFrame;
	
	@FindBy(xpath = "//span[contains(text(),'Attach')]")
	WebElement attach;
	
	@FindBy(xpath = "//div[@id='photoSection']")
	WebElement photoSection;
	
	@FindBy(xpath = "//a[@id='uploadLink']")
	WebElement uploadLink;
	
	@FindBy(xpath = "//iframe[@id='uploadPhotoContentId']")
	WebElement photoFrame;
	
	@FindBy(xpath = "//input[@class='fileInput']")
	WebElement chooseFileButton;
	
	@FindBy(xpath = "//div[@class='uploadButtonPanel']/input[2]")
	WebElement uploadButtonPanel;
	
	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	WebElement photoSave;
	
	@FindBy(id = "PersonalInfo_font")
	WebElement personalTab;
	
	@FindBy(id = "LoginHistory_font")
	WebElement loginHistorytab;
	
	@FindBy(xpath = "//a[contains(text(),'Download login history')]")
	WebElement downloadLoginHistory;
	
	@FindBy(id = "DisplayAndLayout_font")
	WebElement displayAndLayoutTab;
	
	@FindBy(id = "CustomizeTabs_font")
	WebElement customizeTab;
	
	@FindBy(id = "p4")
	WebElement customAppDropdown;
	
	@FindBy(id = "duel_select_0")
	WebElement availableTabsDropdown;
	
	@FindBy(id = "duel_select_0_right")
	WebElement addButton;
	
	@FindBy(xpath = "//input[@title='Save']")
	WebElement saveButton;
	
	@FindBy(id = "EmailSetup_font")
	WebElement emailTab;
	
	@FindBy(id = "EmailSettings_font")
	WebElement emailSettingsTab;
	
	@FindBy(id = "sender_name")
	WebElement emailName;
	
	@FindBy(id = "sender_email")
	WebElement emailAddress;
	
	@FindBy(id = "auto_bcc1")
	WebElement bbcRadioButton;
	
	@FindBy(id = "CalendarAndReminders_font")
	WebElement calendarsAndRemindersTab;
	
	@FindBy(id = "Reminders_font")
	WebElement activityReminder;
	
	@FindBy(id = "testbtn")
	WebElement openATestButton;
	
	
	public void clickUserMenu() {
		waitForElement(userMenu, 15);
		userMenu.click();
	}

	public String getTextmyProfile() {
		return myProfile.getText();
	}
	
	public String getTextmySettings() {
		return mySettings.getText();
	}
	
	public String getTextdevConsole() {
		return devConsole.getText();
	}
	
	public String getTextswitchToLightning() {
		return switchToLightning.getText();
	}
	
	public String getTextlogout() {
		return logout.getText();
	}
	
	public void clickmyProfile() {
		waitForElement(myProfile, 15);
		myProfile.click();
	}
	
	public void clickDevConsole() {
		waitForElement(devConsole, 15);
		devConsole.click();
	}
	
	public void clickEditLink() {
		waitForElement(editLink, 10);
		editLink.click();
	}
	
	public void switchToEditFrame(WebDriver driver) {
		waitForElement(editFrame, 10);
		driver.switchTo().frame(editFrame);
	}
	
	public void clickAbout() {
		about.click();
	}
	
	public void sendKeysLastName(String strlastname) {
		waitForElement(lastName, 10);
		lastName.clear();
		lastName.sendKeys(strlastname);
	}
	
	public void clicksaveAll() {
		saveAll.click();
	}
	
	public void clickPost() {
		waitForElement(post, 10);
		post.click();
	}
	
	public void switchToPostFrame(WebDriver driver) {
		waitForElement(postFrame, 10);
		driver.switchTo().frame(postFrame);
	}
	
	public void sendKeyspostTextArea(String text) {
		postTextArea.sendKeys(text);
	}
	
	public void clickshareButton() {
		waitForElement(shareButton, 10);
		shareButton.click();
	}
	
	public void clickFile() {
		waitForElement(fileButton, 10);
		fileButton.click();
	}
	
	public void clickSalesforceFile() {
		waitForElement(existingfile, 10);
		existingfile.click();
	}
	
	public void switchTouploadFileFrame(WebDriver driver) {
		waitForElement(uploadFileFrame, 10);
		driver.switchTo().frame(uploadFileFrame);
	}
	
	public void clickAttach() {
		waitForElement(attach, 15);
		attach.click();
	}
	
	public void mouseHoverToPhotoSection(WebDriver driver) {
		waitForElement(photoSection, 10);
		Actions action = new Actions(driver);
		action.moveToElement(photoSection).build().perform();
	}
	
	public void clickuploadLink() {
		waitForElement(uploadLink, 15);
		uploadLink.click();
	}
	
	public void switchTophotoFrame(WebDriver driver) {
		waitForElement(photoFrame, 10);
		driver.switchTo().frame(photoFrame);
	}

	public void sendKeysChooseFile() {
		waitForElement(chooseFileButton, 10);
		chooseFileButton.sendKeys("/Users/sneha/Desktop/golden_gate.jpeg");
	}
	
	public void clickuploadButtonPanel() {
		waitForElement(uploadButtonPanel, 15);
		uploadButtonPanel.click();
	}
	
	public void clickphotoSave() {
		waitForElement(photoSave, 15);
		photoSave.click();
	}
	
	public void clickMySettings() {
		waitForElement(mySettings, 10);
		mySettings.click();
	}
	
	public void clickPersonalTab() {
		waitForElement(personalTab, 15);
		personalTab.click();
	}
	
	public void clickLoginHistorytab() {
		waitForElement(loginHistorytab, 15);
		loginHistorytab.click();
	}
	
	public void clickDownloadLoginHistory() {
		waitForElement(downloadLoginHistory, 15);
		downloadLoginHistory.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public void clickDisplayAndLayoutTab() {
		displayAndLayoutTab.click();
	}
	
	public void clickCustomizeTab() {
		customizeTab.click();
	}
	
	public void selectCustomAppDropdown() {
		Select customApp = new Select(customAppDropdown);
		customApp.selectByVisibleText("Salesforce Chatter");
	}
	
	public void selectAvailableTabsDropdown() {
		Select availableTabs = new Select(availableTabsDropdown);
		availableTabs.selectByVisibleText("Reports");
	}
	
	public void clickAddButton() {
		addButton.click();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void clickEmailTab() {
		emailTab.click();
	}
	
	public void clickEmailSettingsTab() {
		emailSettingsTab.click();
	}
	
	public void sendKeysEmailName(String strEmailName) {
		emailName.clear();
		emailName.sendKeys(strEmailName);	
	}
	
	public void sendKeysEmailAddress(String strEmailAddress) {
		emailAddress.clear();
		emailAddress.sendKeys(strEmailAddress);	
	}
	
	public void clickBbcRadioButton() {
		bbcRadioButton.click();
	}
	
	public void clickCalendarAndReminders() {
		waitForElement(calendarsAndRemindersTab, 15);
		calendarsAndRemindersTab.click();
	}
	
	public void clickActivityReminder() {
		activityReminder.click();
	}
	
	public void clickOpenATestButton() {
		waitForElement(openATestButton, 15);
		openATestButton.click();
	}
	
}
