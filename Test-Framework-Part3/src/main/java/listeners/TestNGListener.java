package listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.DriverManager;
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
		try {
			File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			String screenshotPath = "screenshots/" + result.getMethod().getMethodName() + ".png";
			Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
			ExtentReportManager.test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
}
