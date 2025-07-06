package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	public static WebDriver driver;
	public static Properties properties = new Properties();

	public static void initializeDriver() throws Exception {
		String env = System.getProperty("environment", "QA");
		FileInputStream fis = new FileInputStream("src/test/resources/configs/" + env + "config.properties");
		properties.load(fis);

		String browser = properties.getProperty("browser", "chrome");

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
//		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
