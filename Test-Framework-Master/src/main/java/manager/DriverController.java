package manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import constant.CommonConstant;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class DriverController {
	public static RemoteWebDriver driver = null;
	public static Properties properties;
	public static String parentHandle = "";
	public static boolean browser = false;
	public static String testcasename = null;

	public static void initializeBrowser() {
		try {
			loadProperty("dev");
			String browser = properties.getProperty("browser");

			if (properties.getProperty("executiontype").equalsIgnoreCase(CommonConstant.Local)) {
				initializeLocalBrowser(browser);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void initializeLocalBrowser(String browserName) {
		String os;
		try {
			os = System.getProperty("os.name");
			if (os.startsWith(CommonConstant.Windows)) {
				WebDriverManager.chromedriver().operatingSystem(OperatingSystem.WIN).setup();
			} else if (os.startsWith(CommonConstant.Linux)) {
				WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
			} else if (os.startsWith(CommonConstant.MAC)) {
				WebDriverManager.chromedriver().operatingSystem(OperatingSystem.MAC).setup();
			}
			switch (browserName) {
			case CommonConstant.Chrome:
				Map<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
//				chromePrefs.put("download.default_directory",downloadFilepath);
				chromePrefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incongnito");
				options.addArguments("--disable-notifications");
//				options.addArguments("disable-popup-blocking");
				options.addArguments("--remote-allow-origins=*");
				options.setExperimentalOption("prefs", chromePrefs);
				driver = new ChromeDriver(options);
				break;
			case CommonConstant.Firefox:
				driver = new FirefoxDriver();
				break;
			case CommonConstant.Edge:
				driver = new EdgeDriver();
				break;
			case CommonConstant.Safari:
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("BROWSER NOT FOUND!!");
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
//		driver.manage().window().maximize();
		if (System.getProperty("Environment", "dev").equalsIgnoreCase("dev")) {
			loadURL(properties.getProperty("devurl"));
		} else if (System.getProperty("Environment").equalsIgnoreCase("qa")) {
			loadURL(properties.getProperty("qaurl"));
		}
	}

	private static void loadURL(String url) {
		driver.get(url);
		String actualURL = driver.getCurrentUrl();
		System.out.println("URL is : " + actualURL);
//		for (String winHandle : driver.getWindowHandles()) {
//			parentHandle = winHandle;
//		}
	}

	public static void loadProperty(String env) throws IOException {
		String fileName = null;

		if (env.equalsIgnoreCase("DEV")) {
			fileName = Paths.get("src", "test", "resources", "config",
					System.getProperty("Environment", "dev") + "-config.properties").toString();
		} else if (env.equalsIgnoreCase("QA")) {
			fileName = Paths
					.get("src", "test", "resources", "config", System.getProperty("Environment") + "-config.properties")
					.toString();
		}

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			properties = new Properties();
			properties.load(fis);
			System.out.println(properties);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			fis.close();
		}
	}

	public static void closeBrowser() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}
}
