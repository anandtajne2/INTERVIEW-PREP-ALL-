package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.utils.ExtentReport;

public class LoginPage {

	private WebDriver driver;

	@FindBy(id = "user-name")
	private WebElement usernameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
		ExtentReport.getTest().info("Entered username: " + username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
		ExtentReport.getTest().info("Entered password");
	}

	public void clickLogin() {
		loginButton.click();
		ExtentReport.getTest().info("Clicked login button");
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

}