package com.test.session4.priority;

import org.testng.annotations.Test;

public class PriorityDemo {

	@Test(priority = 2)
	public void closeBrowser() {
		System.out.println("close browser");
	}

	@Test(priority = 0, description = "its a open browser method", groups = "demo")
	public void openBrowser() {
		System.out.println("open browser");
	}

//	@Test(priority = 1)
	@Test(enabled = false, description = "its open account method", groups = "demo")
	public void openAccount() {
		System.out.println("open account");
	}

}