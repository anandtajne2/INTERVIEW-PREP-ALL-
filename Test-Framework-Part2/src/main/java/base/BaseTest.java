package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import drivers.DriverController;
import listeners.TestListener;
import managers.ReportManager;

@Listeners(TestListener.class)
public class BaseTest {
	@BeforeSuite
	public void setupSuite() {
		ReportManager.initializeReport();
	}

	@BeforeClass
	public void setupTest() {
		DriverController.initializeDriver();
	}

	@AfterClass
	public void tearDownTest(ITestResult result) {
		DriverController.captureScreenshot(result);
		DriverController.quitDriver();
	}

	@AfterSuite
	public void tearDownSuite() {
		ReportManager.flushReport();
	}
}
