package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestCase {

	@Test
	public void testMethod1() {
		System.out.println("this is test method 1");
		// failed the test case on purpose
		Assert.assertEquals(1, 2);
	}

	@Test
	public void testMethod2() {
		System.out.println("this is test method 2");
	}

	@Test
	public void testMethod3() {
		System.out.println("this is test method 3");
	}
}