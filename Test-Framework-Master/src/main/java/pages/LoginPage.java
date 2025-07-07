package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='user-name']")
	private WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@type='submit']") // button[@type='submit']
	private WebElement LoginButton;

	public void loginApplication() throws InterruptedException {
		enterUserName(BaseClass.getProperty("username"));
		enterPassWord(BaseClass.getProperty("password"));
		clickLoginButton();
		Thread.sleep(3000);
	}

	private void clickLoginButton() {
		LoginButton.click();
	}

	private void enterPassWord(String password) {
		Password.sendKeys(password);
	}

	private void enterUserName(String username) {
		userName.sendKeys(username);
	}

}