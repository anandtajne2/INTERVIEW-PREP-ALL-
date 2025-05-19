package com.test.session6.dependsOn;

import org.testng.annotations.Test;

public class DependsOnGroup {

	@Test(groups = "sanity1")
	public void groupTest1() {
		System.out.println("group test 1");
	}

	@Test(groups = "sanity1")
	public void groupTest2() {
		System.out.println("group test 2");
	}

	@Test(groups = "sanity1")
	public void groupTest3() {
		System.out.println("group test 3");
	}

	@Test(dependsOnGroups = "sanity1")
	public void testMethod() {
		System.out.println("test method");
	}
}
