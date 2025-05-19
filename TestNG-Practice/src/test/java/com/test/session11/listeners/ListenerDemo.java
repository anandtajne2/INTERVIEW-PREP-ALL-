package com.test.session11.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// Listener Demo class is a test listener to monitor the events of text execution 

public class ListenerDemo implements ITestListener {

	// this method invokes when the test class is instantiated
	// and before executing any test method
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
	}

	// this method invokes - when all the test methods run
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}

	// Invoked each time before a test will be invoked.
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
	}

	// Invoked each time a test fails.
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
	}

	// invokes every time a test case is passed
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}
}