package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("testuser");
		loginPage.enterPassword("password123");
		loginPage.clickLogin();

		Assert.assertEquals(loginPage.getPageTitle(), "Swag Labs", "Login Successful!");
	}
}
