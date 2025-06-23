package com.testNg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testNg.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "Login")
	WebElement login;

	@FindBy(id = "phone_number")
	WebElement phonenumber;

	@FindBy(xpath = "//div[@id='error']")
	WebElement errorMessageElement;
	
	@FindBy(id = "rememberUn")
	WebElement rememberMe;
	
	@FindBy(id = "userNavLabel")
	WebElement userNav;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(id = "idcard-identity")
	WebElement userNameText;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot')]")
	WebElement ForgotPassword;
	
	@FindBy(id = "un")
	WebElement ForgotPasswordUsername;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	public void enterintoUsername(String strusername) {
		waitForElement(username, 10);
		username.sendKeys(strusername);
	}

	public void enterintoPassword(String strpassword) {
		password.sendKeys(strpassword);

	}

	public void clickLogin() {
		login.click();
	}

	public void enterintoPhonenumber() {
		phonenumber.sendKeys("123123123");
	}
	
	public String getErrorMessage() {
		return errorMessageElement.getText();
	}
	
	public void clickRememberMe() {
		rememberMe.click();
	}
	
	public void clickUserMenu() {
		waitForElement(userNav, 10);
		userNav.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public String getuserNameText() {
		waitForElement(userNameText, 10);
		return userNameText.getText();
	}
	
	public void clickForgotPassword() {
		ForgotPassword.click();
	}
	
	public void enterForgotPasswordUsername(String strusername) {
		waitForElement(ForgotPasswordUsername, 10);
		ForgotPasswordUsername.sendKeys(strusername);
	}
	
	public void clickcontinueButton() {
		waitForElement(continueButton, 10);
		continueButton.click();
	}
	
}
