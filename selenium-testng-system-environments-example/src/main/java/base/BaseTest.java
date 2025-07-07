package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	protected String baseUrl;

	@BeforeClass
	public void setup() {
		String env = System.getProperty("Environment", "DEV").toUpperCase();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		switch (env) {
		case "DEV":
//			baseUrl = "https://dev.example.com";
			baseUrl = "http://www.automationpractice.pl/";
			break;
		case "QA":
//			baseUrl = "https://qa.example.com";
			baseUrl = "https://www.google.com/";
			break;
		case "STAGING":
//			baseUrl = "https://staging.example.com";
			baseUrl = "https://in.search.yahoo.com/";
			break;
		case "PRODUCTION":
			baseUrl = "https://www.bing.com/";
			break;
		default:
			System.out.println("ENVIRONMENT NOT FOUND");
			break;
		}
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}