package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import manager.PageObjectManager;
import utils.DriverManager;

public class LoginTest extends BaseTest {

	PageObjectManager pom;
	
	@Test
	public void testLogin() throws InterruptedException{
		pom = new PageObjectManager(DriverManager.getDriver());
		pom.getLoginPage().login("standard_user", "secret_sauce");
	}
}