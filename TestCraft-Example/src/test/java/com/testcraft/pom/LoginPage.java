package com.testcraft.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	By usernameInput = By.cssSelector("[data-test='username']");
	By passwordInput = By.cssSelector("[data-test='password']");
	By loginButton = By.id("login-button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String username, String password) {
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();
	}
}
