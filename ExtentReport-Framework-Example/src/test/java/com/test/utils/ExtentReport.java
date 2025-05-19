package com.test.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	private static ExtentReport instance = new ExtentReport();
	private ExtentReports extent;
	private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	private ExtentReport() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-" + timeStamp + ".html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/" + reportName);

		try {
			sparkReporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	public static ExtentReport getInstance() {
		return instance;
	}

	public static void startTest(String testName, String description) {
		getInstance().test.set(getInstance().extent.createTest(testName, description));
	}

	public static ExtentTest getTest() {
		return getInstance().test.get();
	}

	public static void flushReport() {
		getInstance().extent.flush();
	}

	public static void addScreenshot(WebDriver driver) {
		String screenshotPath = captureScreenshot(driver);
		getTest().fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	private static String captureScreenshot(WebDriver driver) {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String screenshotName = "screenshot_" + timeStamp + ".png";
		String screenshotPath = "reports/screenshots/" + screenshotName;

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File(screenshotPath));
			return screenshotPath;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
