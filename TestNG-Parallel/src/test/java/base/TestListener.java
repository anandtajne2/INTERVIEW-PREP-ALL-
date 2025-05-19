package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import utils.ExtentReport;

public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReport.getTest().log(Status.FAIL, "Test failed");
		ExtentReport.getTest().fail(result.getThrowable());

		// Add screenshot to report
		BaseTest baseTest = (BaseTest) result.getInstance();
		ExtentReport.addScreenshot(baseTest.getDriver());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReport.getTest().log(Status.SKIP, "Test skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.flushReport();
	}

}