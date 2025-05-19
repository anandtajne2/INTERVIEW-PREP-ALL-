package com.test.session10.parallelTesting;

import org.testng.annotations.Test;

public class ParallelTestDemo {

	@Test
	public void method1() throws InterruptedException {
		System.out.println("this is method one");
		Thread.sleep(2000);
	}

	@Test
	public void method2() throws InterruptedException {
		System.out.println("this is method two");
		Thread.sleep(2000);
	}

}