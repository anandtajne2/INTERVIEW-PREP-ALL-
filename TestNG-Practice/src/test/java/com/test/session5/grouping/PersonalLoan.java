package com.test.session5.grouping;

import org.testng.annotations.Test;

public class PersonalLoan {

	@Test(groups = "SmokeTest")
	public void webLoginPersonalLoan() {
		System.out.println("web login personal loan");
	}

	@Test
	public void mobileLoginPersonalLoan() {
		System.out.println("mobile login personal loan");
	}

	@Test
	public void apiLoginPersonalLoan() {
		System.out.println("API login personal loan");
	}
}