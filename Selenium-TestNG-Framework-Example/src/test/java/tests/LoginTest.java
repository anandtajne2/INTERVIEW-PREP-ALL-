package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(description = "Verify successful login with valid credentials")
	public void testSuccessfulLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();

		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isProductsHeaderDisplayed(), "Login failed");
	}

	@Test(description = "Verify login fails with invalid credentials")
	public void testInvalidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("invalid_user");
		loginPage.enterPassword("wrong_password");
		loginPage.clickLogin();

		Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
	}
}