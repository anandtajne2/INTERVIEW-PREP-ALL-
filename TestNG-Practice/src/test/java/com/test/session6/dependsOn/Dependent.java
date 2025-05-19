package com.test.session6.dependsOn;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependent {

//	@Test(dependsOnMethods = { "openBrowser" })
	@Test(dependsOnMethods = { "openBrowser" }, alwaysRun = true)
	public void signIn() {
		System.out.println("sign in method executed");
	}

	@Test
	public void openBrowser() {
		System.out.println("open browser method executed");
		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = "signIn")
	public void logOut() {
		System.out.println("logout method executed");
	}

	@Test(dependsOnMethods = { "logOut", "openBrowser" })
	public void closeBrowser() {
		System.out.println("close browser method executed");
	}
}
