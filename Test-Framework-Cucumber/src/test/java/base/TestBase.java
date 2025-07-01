package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class TestBase {

	protected static WebDriver driver;

	// Initialize the driver
	public static void initialize() {
//		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		WebDriverManager.chromedriver().operatingSystem(OperatingSystem.WIN).setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Initialize PageFactory elements
	public <T> T initPage(Class<T> pageClass) {
		return PageFactory.initElements(driver, pageClass);
	}

	// Close the driver
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	// Get the driver instance
	public static WebDriver getDriver() {
		return driver;
	}
}