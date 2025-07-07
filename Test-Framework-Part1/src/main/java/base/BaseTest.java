package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utils.DriverManager;
import utils.ExtentReportManager;

public class BaseTest {
	@BeforeSuite
	public void setupReport() {
		ExtentReportManager.initReports();
	}

	@BeforeClass
	public void setupDriver() throws Exception {
		DriverManager.initializeDriver();
	}

	@AfterClass
	public void tearDown() {
		DriverManager.quitDriver();
	}

	@AfterSuite
	public void flushReport() {
		ExtentReportManager.flushReports();
	}
}
