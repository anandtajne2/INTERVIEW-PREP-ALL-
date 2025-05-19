package com.test.session11.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(ListenerDemo.class)
public class TestClass {

//	@BeforeMethod
//	public void beforeMethod() {
//		System.out.println("before Method");
//	}

	@Test
	public void testMethod1() {
		System.out.println("executing test method 1");
	}

	@Test
	public void testMethod2() {
		System.out.println("executing test method 2");
//		Assert.fail();
	}

	@Test
	public void testMethod3() {
		System.out.println("executing test method 3");
		Assert.fail();
	}

//	@AfterMethod
//	public void afterMethod() {
//		System.out.println("After Method");
//	}

}
