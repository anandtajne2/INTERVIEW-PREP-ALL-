package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static Properties properties = new Properties();

	public static void initializeDriver() throws IOException {
		loadProperty();
		String browser = properties.getProperty("browser");
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("mac")) {
			WebDriverManager.chromedriver().operatingSystem(OperatingSystem.MAC).setup();
		} else if (os.contains("win")) {
			WebDriverManager.chromedriver().operatingSystem(OperatingSystem.WIN).setup();
		}

		switch (browser) {
		case "chrome":

			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			options.setExperimentalOption("prefs", prefs);
//			options.addArguments("--start-maximized");
			options.addArguments("--incongnito");
			options.addArguments("--remote-allow-origins=*");
			driver.set(new ChromeDriver(options));
		default:
			System.out.println("no browser is found!!");
			break;
		}

		getDriver().get(properties.getProperty("url"));
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}
	}

	public static void loadProperty() throws IOException {
		String env = System.getProperty("environment", "QA").toUpperCase();
		String path = Paths.get("src", "test", "resources", "configs", env + "config.properties").toString();
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
		fis.close();
	}
}
