package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjectManager.PageObjectFactory;

public class LoginTest extends BaseClass {

//	LoginPage loginPage;
	PageObjectFactory factory;

	@Test
	public void loginTest() throws InterruptedException {
//		loginPage = new LoginPage(getDriver());
//		System.out.println(loginPage);
//		loginPage.loginApplication();
		factory = new PageObjectFactory(getDriver());
		PageObjectFactory.getLoginPage().loginApplication();
	}

}
