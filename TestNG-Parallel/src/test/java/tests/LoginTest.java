package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
	@Test
	public void testSuccessfulLogin() {
		LoginPage loginPage = new LoginPage(getDriver());

		getDriver().get(ConfigReader.getProperty("app.url"));

		loginPage.login(ConfigReader.getProperty("valid.username"), ConfigReader.getProperty("valid.password"));

		Assert.assertTrue(getDriver().getCurrentUrl().contains("dashboard"), "Login was not successful");
	}

	@Test
	public void testInvalidLogin() {
		LoginPage loginPage = new LoginPage(getDriver());

		getDriver().get(ConfigReader.getProperty("app.url"));

		loginPage.login(ConfigReader.getProperty("invalid.username"), ConfigReader.getProperty("invalid.password"));

		String errorMessage = loginPage.getErrorMessage();
		Assert.assertTrue(errorMessage.contains("Invalid credentials"),
				"Error message not displayed for invalid login");
	}
}
