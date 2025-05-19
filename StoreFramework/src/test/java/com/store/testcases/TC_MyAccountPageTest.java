package com.store.testcases;

import org.testng.annotations.Test;

import com.store.pageobject.AccountCreationDetails;
import com.store.pageobject.IndexPage;
import com.store.pageobject.MyAccountPage;

public class TC_MyAccountPageTest extends BaseClass {

	@Test()
	public void verifyRegistrationAndLogin() {

		logger.info("***************TestCase Verify Registration and Login starts*****************");

		IndexPage pg = new IndexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		MyAccountPage myAcpg = new MyAccountPage(driver);
		myAcpg.enterCreateEmailAddress("cs9233@gmail.com");
		logger.info("Email address entered in create account section.");

		myAcpg.clickSubmitCreate();

		logger.info("clicked on create an account button");

		AccountCreationDetails accCreationPg = new AccountCreationDetails(driver);

		accCreationPg.selectTitleMrs();
		accCreationPg.enterCustomerFirstName("Prachi");
		accCreationPg.enterCustomerLastName("Gupta");
		accCreationPg.enterPassword("cs923");
		accCreationPg.enterAddressFirstName("Prachi");
		accCreationPg.enterAddressLastName("Gupta");
		accCreationPg.enterAddress("18/8 worli road");

		accCreationPg.enterCity("Mumbai");
		accCreationPg.selectState("Alabama");

		accCreationPg.enterPostcode("00000");
		accCreationPg.selectCountry("United States");
		accCreationPg.enterMobilePhone("9891778192");
		accCreationPg.enterAlias("Home");

		logger.info("entered user details on account creation page.");

//		accCreationPg.clickOnRegister();
		logger.info("clicked on Register button");
//
//		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
//		String userName = regUser.getUserName();
//
//		Assert.assertEquals("Prachi Gupta", userName);

		logger.info("***************TestCase Verify Registration and Login ends*****************");

	}

}