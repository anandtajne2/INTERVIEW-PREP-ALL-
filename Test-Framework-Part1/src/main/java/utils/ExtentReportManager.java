package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	public static ExtentReports extent;
    public static ExtentTest test;

    public static void initReports() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/ExtentReport.html");
        extent.attachReporter(spark);
    }

    public static void flushReports() {
        extent.flush();
    }
}