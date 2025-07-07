package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void initReports() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReports/Report_" + timeStamp + ".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Environment", System.getProperty("environment", "QA"));
		extent.setSystemInfo("OS", System.getProperty("os.name"));
	}

	public static void flushReports() {
		if (extent != null) {
			extent.flush();
		}
	}
}
