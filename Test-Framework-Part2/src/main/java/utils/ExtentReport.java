package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	private static ExtentReports extent;

	public static ExtentReports getReportInstance() {
		if (extent == null) {
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String reportName = "Test-Report-" + timestamp + ".html";

			ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/" + reportName);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle("Automation Report");
			htmlReporter.config().setReportName("Test Execution Report");

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			// System information
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Environment", System.getProperty("environment", "config"));
			extent.setSystemInfo("User", System.getProperty("user.name"));
		}
		return extent;
	}
}