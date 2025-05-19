package com.test.session5.grouping;

import org.testng.annotations.Test;

public class CarLoan {


	@Test(groups = "SmokeTest")
	public void webLoginCarLoan() {
		System.out.println("web login car loan");
	}

	@Test
	public void mobileLoginCarLoan() {
		System.out.println("mobile login car loan");
	}

	@Test
	public void apiLoginCarLoan() {
		System.out.println("API login car loan");
	}
}