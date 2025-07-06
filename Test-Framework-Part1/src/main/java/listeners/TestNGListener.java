package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ExtentReportManager;

public class TestNGListener implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportManager.test = ExtentReportManager.extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.test.pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.test.fail(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
}
