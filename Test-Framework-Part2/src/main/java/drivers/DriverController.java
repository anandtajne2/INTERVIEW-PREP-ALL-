package drivers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;
import managers.ReportManager;
import utils.ConfigReader;

public class DriverController {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initializeDriver() {
		String browser = ConfigReader.getProperty("browser");
		WebDriver webDriver;

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			webDriver = ThreadGuard.protect(new ChromeDriver(options));
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver = ThreadGuard.protect(new FirefoxDriver());
			break;
		default:
			throw new RuntimeException("Unsupported browser: " + browser);
		}

		webDriver.manage().window().maximize();
		webDriver.get(ConfigReader.getProperty("baseUrl"));
		driver.set(webDriver);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

	public static String captureScreenshot() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
	}

	public static void captureScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshot = captureScreenshot();
//			TestListener.getTest().fail("Test Failed",
//					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
			ReportManager.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		}
	}
}
