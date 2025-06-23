package com.testNg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.testNg.base.BasePage;

public class CreateAccountPages extends BasePage{

	public CreateAccountPages(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='Accounts Tab']")
	WebElement accountsTab;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeTab;
	
	@FindBy(id = "createNewLabel")
	WebElement createNewAccount;
	
	@FindBy(xpath = "//div[@id='createNewMenu']/a[3]")
	WebElement accountOption;
	
	@FindBy(xpath = "//input[@id='acc2']")
	WebElement accountName;
	
	@FindBy(xpath = "//select[@id='acc6']")
	WebElement typeDropDown;
	
	@FindBy(xpath = "//select[@id='00Nbm0000009h2Z']")
	WebElement priorityDropDown;
	
	@FindBy(xpath = "//td[@id='topButtonRow']/input[1]")
	WebElement topSave;
	
	@FindBy(xpath = "//a[contains(text(),'Create New View')]")
	WebElement createNewView;

	@FindBy(id = "fname")
	WebElement viewName;
	
	@FindBy(id = "devname")
	WebElement uniqueName;
	
	@FindBy(xpath = "//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]")
	WebElement createNewViewSaveButton;
	
	@FindBy(id = "fcf")
	WebElement viewDropdown;
	
	@FindBy(xpath = "//span[@class='fFooter']/a[1]")
	WebElement edit;
	
	@FindBy(id = "fcol1")
	WebElement fieldDropdown;
	
	@FindBy(id = "fop1")
	WebElement operatorDropdown;
	
	@FindBy(id = "fval1")
	WebElement value;
	
	@FindBy(id = "colselector_select_0")
	WebElement selectAvailableFieldsDropdown;
	
	@FindBy(id = "colselector_select_0_right")
	WebElement addButton;
	
	@FindBy(xpath = "//a[contains(text(),'Merge Accounts')]")
	WebElement mergeAccountLink;
	
	@FindBy(id = "srch")
	WebElement searchTextArea;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[4]/input[2]")
	WebElement findAccountsButton;
	
	@FindBy(id ="cid0")
	WebElement cb1;
	
	@FindBy(id ="cid1")
	WebElement cb2;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
	WebElement nextButton;
	
	@FindBy(xpath = "//div[@class='pbTopButtons']/input[2]")
	WebElement mergeButton;
	
	@FindBy(xpath = "//a[contains(text(),'Accounts with last activity')]")
	WebElement accountsWithLastActivityLink;
	
	@FindBy(id ="ext-gen20")
	WebElement dateField;
	
	@FindBy(xpath = "//div[contains(text(),'Created Date')]")
	WebElement createdDate;
	
	@FindBy(id ="ext-gen152")
	WebElement fromDateField;
	
	@FindBy(xpath = "//button[contains(text(),'Today')]")
	WebElement fromDateTodayButton;
	
	@FindBy(id ="ext-gen154")
	WebElement toDateField;
	
	@FindBy(xpath = "//button[@id='ext-gen296']")
	WebElement toDateTodayButton;
	
	@FindBy(id = "ext-gen49")
	WebElement saveButton;
	
	@FindBy(id = "saveReportDlg_reportNameField")
	WebElement reportName;
	
	@FindBy(id = "saveReportDlg_DeveloperName")
	WebElement reportUniqueName;
	
	@FindBy(id = "ext-gen318")
	WebElement saveAndRunButton;
	
	public void clickAccounts() {
		waitForElement(accountsTab, 10);
		accountsTab.click();
	}
	
	public void clickHomeTab() {
		waitForElement(homeTab, 10);
		homeTab.click();
	}
	
	public void clickCreateNewAccount() {
		createNewAccount.click();
	}
	
	public void clickAccountOption() {
		accountOption.click();
	}
	
	public void enterIntoAccountName(String strname) {
		waitForElement(accountName, 10);
		accountName.sendKeys(strname);
	}
	
	public void selectTypeDropDown() {
		Select type = new Select(typeDropDown);
		type.selectByVisibleText("Technology Partner");
	}
	
	public void selectPriorityDropDown() {
		Select priority = new Select(priorityDropDown);
		priority.selectByVisibleText("High");
	}
	
	public void clickTopSave() {
		waitForElement(topSave, 10);
		topSave.click();
	}
	
	public void clickCreateNewView() {
		waitForElement(createNewView, 10);
		createNewView.click();
	}
	
	public void enterIntoViewName(String viewname) {
		waitForElement(viewName, 10);
		viewName.sendKeys(viewname);
	}
	
	public void enterIntoUniqueName() {
		waitForElement(uniqueName, 10);
		uniqueName.sendKeys("testingNg");
	}
	public void clickCreateNewViewSaveButton() {
		waitForElement(createNewViewSaveButton, 10);
		createNewViewSaveButton.click();
	}
	
	public void selectViewDropdown() {
		waitForElement(viewDropdown, 10);
		Select view = new Select(viewDropdown);
		view.selectByVisibleText("editView_test");;
	}
	
	public void clickEdit() {
		waitForElement(edit, 10);
		edit.click();
	}
	
	public void selectFieldDropdown() {
		waitForElement(fieldDropdown, 10);
		Select field = new Select(fieldDropdown);
		field.selectByVisibleText("Account Name");
	}
	
	public void selectOperatorDropdown() {
		Select operator = new Select(operatorDropdown);
		operator.selectByVisibleText("contains");
	}
	
	public void sendKeysValue() {
		value.sendKeys("a");
	}
	
	public void selectAvailableFieldsDropdown() {
		waitForElement(selectAvailableFieldsDropdown, 10);
		Select selectField = new Select(selectAvailableFieldsDropdown);
		selectField.selectByVisibleText("Last Activity");
	}
	
	public void clickAddButton() {
		addButton.click();
	}
	
	public void clickMergeAccountLink() {
		waitForElement(mergeAccountLink, 10);
		mergeAccountLink.click();
	}
	
	public void sendKeysToSearchTextArea(String accountName) {
		waitForElement(searchTextArea, 10);
		searchTextArea.sendKeys(accountName);
	}
	
	public void clickFindAccountsButton() {
		waitForElement(findAccountsButton, 10);
		findAccountsButton.click();
	}
	
	public void clickCb1() {
		waitForElement(cb1, 10);
		if(cb1.isSelected()) {
			System.out.println("Checkbox is already selected");
		}
		else {
			cb1.click();
		}
	}
	
	public void clickCb2() {
		waitForElement(cb2, 10);
		if(cb2.isSelected()) {
			System.out.println("Checkbox is already selected");
		}
		else {
			cb2.click();
		}
	}
	
	public void clickNextButton() {
		nextButton.click();
	}
	
	public void clickMergeButton() {
		waitForElement(mergeButton, 10);
		mergeButton.click();
	}
	
	public void clickAccountsWithLastActivityLink() {
		waitForElement(accountsWithLastActivityLink, 10);
		accountsWithLastActivityLink.click();
	}
	
	public void clickDateField() {
		waitForElement(dateField, 10);
		dateField.click();
	}
	
	public void clickCreatedDate() {
		waitForElement(createdDate, 10);
		createdDate.click();
	}
	
	public void clickFromDateField() {
		waitForElement(fromDateField, 10);
		fromDateField.click();
	}
	public void clickFromDateTodayButton() {
		waitForElement(fromDateTodayButton, 10);
		fromDateTodayButton.click();
	}
	
	public void clickToDateField() {
		waitForElement(toDateField, 10);
		toDateField.click();
	}
	public void clickToDateTodayButton() {
		waitForElement(toDateTodayButton, 10);
		toDateTodayButton.click();
	}
	
	public void clickSaveButton() {
		waitForElement(saveButton, 10);
		saveButton.click();
	}
	
	public void sendKeysToReportName(String report_name) {
		waitForElement(reportName, 10);
		reportName.sendKeys(report_name);
	}
	
	public void clickReportUniqueName() {
		reportUniqueName.click();
	}
	
	public void clickSaveAndRunButton() {
		waitForElement(saveAndRunButton, 10);
		saveAndRunButton.click();
	}
}
