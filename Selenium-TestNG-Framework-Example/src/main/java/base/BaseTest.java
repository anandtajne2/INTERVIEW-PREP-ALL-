package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	protected ConfigReader config = new ConfigReader();

	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
//			System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
//			System.setProperty("webdriver.gecko.driver", config.getFirefoxDriverPath());
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
//			System.setProperty("webdriver.edge.driver", config.getEdgeDriverPath());
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser specified");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(config.getBaseUrl());
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}