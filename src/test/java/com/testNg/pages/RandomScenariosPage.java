package com.testNg.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.testNg.base.BasePage;

public class RandomScenariosPage extends BasePage{

	public RandomScenariosPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeTab;
	
	@FindBy(xpath = "//*[@id='ptBody']/div/div[2]/span[1]/h1/a")
	WebElement firstLastName;
	
	@FindBy(xpath = "//*[@id='ptBody']/div/div[2]/span[1]/h1/a")
	WebElement firstLastNameLink;
	
	@FindBy(xpath = "//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a")
	WebElement editIcon;
	
	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	WebElement editFrame;
	
	@FindBy(xpath = "//a[contains(text(),'About')]")
	WebElement aboutTab;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//*[@id='TabPanel']/div/div[2]/form/div/input[1]")
	WebElement saveAllButton;
	
	@FindBy(xpath = "//span[@id='userNavLabel']")
	WebElement usermenuTab;
	
	@FindBy(xpath = "//*[@id='AllTab_Tab']/a")
	WebElement customizeTab;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
	WebElement customizeMyTabsButton;
	
	@FindBy(xpath = "//select[@id='duel_select_1']")
	WebElement SelectedTabs;
	
	@FindBy(xpath = "//a[@id='duel_select_0_left']")
	WebElement removeButton;
	
	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement bottomSaveButton;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath = "//span[@class='pageDescription']/a")
	WebElement currDateLink;
	
	@FindBy(xpath = "//a[contains(text(),'8:00 PM')]")
	WebElement time8pmLink;
	
	@FindBy(xpath = "//tbody/tr[2]/td[2]/div[1]/a[1]")
	WebElement subjectComboIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Other')]")
	WebElement otherFromComboBox;
	
	@FindBy(xpath = "//input[@id='EndDateTime_time']")
	WebElement endTimeField;
	
	@FindBy(xpath = "//div[@id='timePickerItem_42']")
	WebElement timePicker9PMdropdown;
	
	@FindBy(xpath = "//a[contains(text(),'4:00 PM')]")
	WebElement time4pmLink;
	
	@FindBy(xpath = "//div[@id='timePickerItem_38']")
	WebElement timePicker7PMdropdown;
	
	@FindBy(xpath = "//input[@id='IsRecurrence']")
	WebElement recurrenceCheckbox;
	
	@FindBy(xpath = "//*[@id='rectypeftw']")
	WebElement weeklyRadiobutton;
	
	@FindBy(xpath = "//input[@id='RecurrenceEndDateOnly']")
	WebElement recurrenceEndDate;
	
	@FindBy(xpath = "//span[@class='dwmIcons']/a[3]")
	WebElement monthViewIcon;
	
	@FindBy(xpath = "//td[@id='topButtonRow']/input[1]")
	WebElement topSaveButton;
	
	public void clickHomeTab() {
		waitForElement(homeTab, 10);
		homeTab.click();
	}
	
	public String getTextFirstLastName() {
		waitForElement(firstLastName, 10);
		String name = firstLastName.getText();
		return name;
	}
	
	public void clickFirstLastNameLink() {
		waitForElement(firstLastNameLink, 10);
		firstLastNameLink.click();
	}
	
	public void clickEditIcon() {
		waitForElement(editIcon, 10);
		editIcon.click();
	}
	
	public void switchToEditFrame(WebDriver driver) {
		waitForElement(editFrame, 10);
		driver.switchTo().frame(editFrame);
	}
	
	public void clickAboutTab() {
		waitForElement(aboutTab, 10);
		aboutTab.click();
	}
	
	public void enterIntoLastName(String last_name) {
		waitForElement(lastName, 10);
		lastName.click();
		lastName.clear();
		lastName.sendKeys(last_name);
	}
	
	public void clickSaveAllButton() {
		saveAllButton.click();
	}
	
	public String getTextusermenuTab() {
		waitForElement(usermenuTab, 10);
		String name = usermenuTab.getText();
		return name;
	}
	
	public void clickCustomizeTab() {
		waitForElement(customizeTab, 10);
		customizeTab.click();
	}
	
	public void clickCustomizeMyTabsButton() {
		waitForElement(customizeMyTabsButton, 10);
		customizeMyTabsButton.click();
	}
	
	public void selectSelectedTabs() {
		waitForElement(SelectedTabs, 10);
		Select tab = new Select(SelectedTabs);
		tab.selectByIndex(2);
	}
	
	public void clickRemoveButton() {
		removeButton.click();
	}
	
	public void clickBottomSaveButton() {
		bottomSaveButton.click();
	}
	
	public void clickUsermenuTab() {
		waitForElement(usermenuTab, 10);
		usermenuTab.click();
	}
	
	public void clickLogout() {
		waitForElement(logout, 10);
		logout.click();
	}
	
	public void clickCurrDateLink() {
		waitForElement(currDateLink, 10);
		currDateLink.click();
	}
	
	public void clickTime8pmLink() {
		waitForElement(time8pmLink, 10);
		time8pmLink.click();
	}
	
	public void clickSubjectComboIcon() {
		waitForElement(subjectComboIcon, 10);
		subjectComboIcon.click();
	}
	
	public void switchToParentWindow(WebDriver driver, String parentWindow) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.switchTo().window(parentWindow);
	}
	
	public void switchToChildWindow(WebDriver driver, String parentWindow) {
		for(String handle : driver.getWindowHandles()) {
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				System.out.println(handle);
			}
		}
	}
	
	public void clickOtherFromComboBox() {
		waitForElement(otherFromComboBox, 10);
		otherFromComboBox.click();
	}
	
	public void clickEndTimeField() {
		waitForElement(endTimeField, 10);
		endTimeField.click();
	}
	
	public void clickTimePicker9PMFromDropdown() {
		waitForElement(timePicker9PMdropdown, 10);
		timePicker9PMdropdown.click();
	}
	
	public void clickTime4pmLink() {
		waitForElement(time4pmLink, 10);
		time4pmLink.click();
	}
	
	public void clickTimePicker7PMFromDropdown() {
		waitForElement(timePicker7PMdropdown, 10);
		timePicker7PMdropdown.click();
	}
	
	public void clickRecurrenceCheckbox() {
		waitForElement(recurrenceCheckbox, 10);
		recurrenceCheckbox.click();
	}
	
	public void clickWeeklyRadiobutton() {
		waitForElement(weeklyRadiobutton, 10);
		weeklyRadiobutton.click();
	}
	
	public void sendKeysToRecurrenceEndDate() {
		waitForElement(recurrenceEndDate, 10);
		recurrenceEndDate.sendKeys("04/4/2025");
	}
	
	public void clickMonthViewIcon(WebDriver driver) {
		waitForElement(monthViewIcon, 10);
		Actions action = new Actions(driver);
		action.doubleClick(monthViewIcon).build().perform();
	}
	
	public void clickTopSaveButton() {
		waitForElement(topSaveButton, 10);
		topSaveButton.click();
	}
}
