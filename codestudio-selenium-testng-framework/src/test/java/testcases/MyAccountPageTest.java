package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.AccountCreationPage;
import pageobjects.IndexPage;
import pageobjects.MyAccountPage;

public class MyAccountPageTest extends BaseClass {

	IndexPage indexPage;
	MyAccountPage myAccountPage;
	AccountCreationPage accountCreationPage;

	@Test(description = "open url and click on sign in button")
	public void verifyRegistrationLogin() throws InterruptedException {
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
		Thread.sleep(2000);

		accountCreationPage = new AccountCreationPage(driver);
		accountCreationPage.selectTitle();
		accountCreationPage.enterFirsname("Priya");
		accountCreationPage.enterLastname("Sharma");
		accountCreationPage.enterEmail("new_cs123@gmail.com");
		accountCreationPage.enterPassword("testing@123");
		accountCreationPage.selectDay("10  ");
		accountCreationPage.selectMonth("September ");
		accountCreationPage.selectYear("2018  ");
		accountCreationPage.selectNewsLetter();
		
		Thread.sleep(2000);

	}

}