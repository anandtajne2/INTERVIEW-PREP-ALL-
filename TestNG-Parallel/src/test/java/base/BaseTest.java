package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReport;

@Listeners(TestListener.class)
public abstract class BaseTest {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	protected ExtentReport extentReport = ExtentReport.getInstance();

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
		default:
			throw new IllegalArgumentException("Invalid browser specified: " + browser);
		}
		getDriver().manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove(); // Important for ThreadLocal cleanup
		}
	}

	public WebDriver getDriver() {
		return driver.get();
	}
}