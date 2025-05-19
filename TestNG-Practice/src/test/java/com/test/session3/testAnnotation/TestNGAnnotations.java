package com.test.session3.testAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("[before suite] before suite method");
	}

	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("[before test] before test method");
	}

	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("[before class] before class method");
	}

	@BeforeMethod
	public void setup() {
		System.out.println("[before method] setup method");
	}

	@Test
	public void testMethod1() {
		System.out.println("this is test method 1");
	}

	@Test
	public void testMethod2() {
		System.out.println("this is test method 2");
	}

	@Test
	public void testMethod3() {
		System.out.println("this is test method 3");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("[after method] tear down method");
	}

	@AfterClass
	public void afterClassMethod() {
		System.out.println("[after class] after class method");
	}

	@AfterTest
	public void afterTestMethod() {
		System.out.println("[after test] after test method");
	}

	
}