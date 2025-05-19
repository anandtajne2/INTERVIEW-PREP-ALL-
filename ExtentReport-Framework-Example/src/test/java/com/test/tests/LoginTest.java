package com.test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.base.BaseTest;
import com.test.pages.LoginPage;
import com.test.utils.ConfigReader;

public class LoginTest extends BaseTest {
	@Test(description = "Verify successful login with valid credentials")
	public void testSuccessfulLogin() {
		LoginPage loginPage = new LoginPage(getDriver());

		getDriver().get(ConfigReader.getProperty("app.url"));

		loginPage.login(ConfigReader.getProperty("valid.username"), ConfigReader.getProperty("valid.password"));

		// Add assertions or page transitions as needed
		Assert.assertTrue(getDriver().getCurrentUrl().contains("inventory"));
	}

	@Test(description = "Verify login fails with invalid credentials")
	public void testInvalidLogin() {
		LoginPage loginPage = new LoginPage(getDriver());

		getDriver().get(ConfigReader.getProperty("app.url"));

		loginPage.login(ConfigReader.getProperty("invalid.username"), ConfigReader.getProperty("invalid.password"));

		String errorMessage = loginPage.getErrorMessage();
		Assert.assertTrue(errorMessage.contains("Epic sadface: Sorry, this user has been locked out."));
//		Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
	}
}
