package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.IndexPage;
import pageobjects.MyAccountPage;

public class MyAccountPageTest extends BaseClass {

	IndexPage indexPage;
	MyAccountPage myAccountPage;

	@Test(description = "open url and click on sign in button")
	public void verifyRegistrationLogin() {
		// open url
		driver.get(baseUrl);
		logger.info("url opened");

		indexPage = new IndexPage(driver);
		indexPage.clickOnSignIn();
		logger.info("click on sign in button");
		
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.enterCreateNewEmailId("new_cs123@gmail.com");
		logger.info("enter new email id");
		myAccountPage.clickToCreateNewEmail();
		logger.info("click to verify new email");
	}

}