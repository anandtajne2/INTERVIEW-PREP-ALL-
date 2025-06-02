package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;

public class BaseTest {
	public WebDriver driver;
	public static ExtentTest test;

	@BeforeSuite
	public void setUpSuite() {
		ExtentManager.createInstance();
	}

	@BeforeMethod
	public void setUp(Method method) {
		test = ExtentManager.createTest(method.getName());

//		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-blink-features=AutomationControlled");
//		options.addArguments(
//				"--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
//		options.setAcceptInsecureCerts(true); // Accept insecure (self-signed, expired) certificates
//		options.addArguments("--ignore-certificate-errors"); // Ignore certificate errors
		options.addArguments("--remote-allow-origins=*"); // Critical for Chrome 111+
		options.addArguments("--disable-web-sockets"); // Try disabling WS
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test passed");
		} else {
			test.skip("Test skipped");
		}

		if (driver != null) {
			driver.quit();
		}
	}

	@AfterSuite
	public void tearDownSuite() {
		ExtentManager.endReport();
	}
}