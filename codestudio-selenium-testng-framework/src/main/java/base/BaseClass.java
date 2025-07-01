package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	protected String baseUrl = readConfig.getProperty("baseUrl");
	protected String browser = readConfig.getProperty("browser");

	protected static WebDriver driver;
	protected static Logger logger;

	@BeforeClass
	public void setUp() {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		default:
			break;
		}
		// applying implicit wait 10 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// for logs
		logger = LogManager.getLogger("MyStoreV1");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}
}