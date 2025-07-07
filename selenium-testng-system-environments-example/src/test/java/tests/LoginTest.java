package tests;

import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void testLoginPageLoad() throws InterruptedException {
//		driver.get(baseUrl + "/login");
		driver.get(baseUrl);
		Thread.sleep(3000);
		System.out.println("Testing on: " + baseUrl);
		// Add assertions or login logic here
	}

}