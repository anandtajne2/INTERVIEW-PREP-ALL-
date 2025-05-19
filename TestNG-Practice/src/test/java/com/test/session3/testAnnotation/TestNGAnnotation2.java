package com.test.session3.testAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotation2 {

//	@BeforeTest
//	public void beforeTestMethod() {
//		System.out.println("[before test] before test method");
//	}

	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("[before class] before class method");
	}

	@BeforeMethod
	public void setup() {
		System.out.println("[before method] setup method");
	}

	@Test
	public void testMethod4() {
		System.out.println("this is test method 4");
	}

	@Test
	public void testMethod5() {
		System.out.println("this is test method 5");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("[after method] tear down method");
	}

	@AfterClass
	public void afterClassMethod() {
		System.out.println("[after class] after class method");
	}

//	@AfterTest
//	public void afterTestMethod() {
//		System.out.println("[after test] after test method");
//	}

	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("[after suite] after suite method");
	}
}
