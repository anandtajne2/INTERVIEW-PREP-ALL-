package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import manager.PageObjectManager;

public class LoginTest extends BaseTest {
	@Test
	public void testLogin() {
		PageObjectManager pom = new PageObjectManager(utils.DriverManager.getDriver());
		pom.getLoginPage().enterUsername("standard_user").enterPassword("secret_sauce").clickLogin();
	}
}
