package pages;

import drivers.DriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
	private final WebDriver driver;
	private final WebDriverWait wait;

	// Locators
	private final By usernameField = By.id("user-name");
	private final By passwordField = By.id("password");
	private final By loginButton = By.id("login-button");

	public LoginPage() {
		this.driver = DriverController.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
		return this;
	}

	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
}