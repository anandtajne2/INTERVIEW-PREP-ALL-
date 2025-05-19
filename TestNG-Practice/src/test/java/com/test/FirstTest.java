package com.test;

import org.testng.annotations.Test;

// manual testing
// Test Suite (package)
// ---- Test Cases (Classes)
// ------- Test Steps (Test Methods -> @Test)
public class FirstTest {

	@Test(priority = 1)
	public void setup() {
		// test step for setup
		System.out.println("this is dmeo setup method");
	}

	@Test(priority = 2)
	public void login() {
		// test step for login
		System.out.println("this is dmeo login method");
	}

	@Test(priority = 3)
	public void close() {
		// test step for close
		System.out.println("this is dmeo close method");
	}

}