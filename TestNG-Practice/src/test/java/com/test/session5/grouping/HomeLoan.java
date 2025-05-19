package com.test.session5.grouping;

import org.testng.annotations.Test;

public class HomeLoan {

	@Test(groups = "SmokeTest")
	public void webLoginHomeLoan() {
		System.out.println("web login home loan");
	}

	@Test
	public void mobileLoginHomeLoan() {
		System.out.println("mobile login home loan");
	}

	@Test
	public void apiLoginHomeLoan() {
		System.out.println("API login home loan");
	}
}