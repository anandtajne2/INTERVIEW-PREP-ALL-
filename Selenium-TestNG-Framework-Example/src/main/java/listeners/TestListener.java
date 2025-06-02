package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.TestUtils;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
		WebDriver driver = ((base.BaseTest) currentClass).getDriver();
		String screenshotPath = TestUtils.takeScreenshot(driver, result.getName());
		System.out.println("Screenshot saved at: " + screenshotPath);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed: " + result.getName());
	}
}