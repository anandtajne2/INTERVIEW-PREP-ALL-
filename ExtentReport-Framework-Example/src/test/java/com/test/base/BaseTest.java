package com.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.test.utils.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListener.class)
public abstract class BaseTest {

	protected WebDriver driver;
	protected ExtentReport extentReport = ExtentReport.getInstance();

	@BeforeMethod
	public void setUp() {
		// Initialize WebDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		extentReport.flushReport();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
