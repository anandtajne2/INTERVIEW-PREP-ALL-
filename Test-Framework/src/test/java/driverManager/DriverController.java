package driverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import constant.CommonConstant;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class DriverController {

	public static RemoteWebDriver driver = null;
	public static Properties properties;
	public static boolean browser = false;
	public static String parentHandle = "";
	public static String testcasename = null;

	public static void initializeBrowser() {
		try {
			browser = true;
//			loadProperty();
			loadProperty("dev");
			String strBrowserName = properties.getProperty("browser");

			if (properties.getProperty("executiontype").equalsIgnoreCase(CommonConstant.Local)) {
				clearfiles(CommonConstant.DownloadFilesFolderPath);
				initializeLocalBrowser(strBrowserName);
			} else if (properties.getProperty("executiontype").equalsIgnoreCase(CommonConstant.Remote)) {
//				initializeBrowserStack(strBrowserName);
			}

		} catch (Exception e) {

		}
	}

	private static void initializeLocalBrowser(String strBrowserName) throws Exception {
		String os;
		try {
			os = System.getProperty("os.name");
			if (os.startsWith(CommonConstant.Linux)) {
				WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
			} else if (os.startsWith(CommonConstant.MAC)) {
				WebDriverManager.chromedriver().operatingSystem(OperatingSystem.MAC).setup();
			} else if (os.startsWith(CommonConstant.Windows)) {
				WebDriverManager.chromedriver().operatingSystem(OperatingSystem.WIN).setup();
			}
			switch (strBrowserName) {
			case CommonConstant.Chrome:
				String downloadFilepath = CommonConstant.DownloadFilesFolderPath;

				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFilepath);
				chromePrefs.put("profile.default_content_setting_values.notifications", 2);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);

				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);

				driver = new ChromeDriver(cap);
				break;
			case CommonConstant.Firefox:
				driver = new FirefoxDriver();
				break;
			case CommonConstant.Edge:
				driver = new EdgeDriver();
				break;
			case CommonConstant.Safari:
				driver = new SafariDriver();
				break;
			default:
				break;
			}
			driver.manage().window().maximize();

			if (System.getProperty("Environment").equalsIgnoreCase("UAT")) {
				loadURL(properties.getProperty("url"));
			} else if (System.getProperty("Environment").equalsIgnoreCase("DEV")) {
				loadURL(properties.getProperty("devurl"));
			} else if (System.getProperty("Environment").equalsIgnoreCase("QA")) {
				loadURL(properties.getProperty("qaurl"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void initializeBrowserStack(String strBrowserName) {
		try {
			String userName = properties.getProperty("browserstackusername");
			String accessKey = properties.getProperty("browserstackaccessKey");

			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setPlatform(Platform.WINDOWS);
			capability.setBrowserName("chrome");
			capability.setVersion("94");
			capability.setCapability("browserstack.debug", "true");
			capability.setCapability("project", "Sec Lending");
			capability.setCapability("name", testcasename);

			URL browserStackUrl = new URL("https://" + userName + ":" + accessKey + "@hub.browserstack.com/wd/hub");

			driver = new RemoteWebDriver(browserStackUrl, capability);
			driver.manage().window().maximize();
			driver.setFileDetector(new LocalFileDetector());

			if (System.getProperty("Environment").equalsIgnoreCase("UAT")) {
				loadURL(properties.getProperty("url"));
			} else if (System.getProperty("Environment").equalsIgnoreCase("DEV")) {
				loadURL(properties.getProperty("devurl"));
			} else if (System.getProperty("Environment").equalsIgnoreCase("QA")) {
				loadURL(properties.getProperty("qaurl"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void loadURL(String URL) {
		try {
			driver.get(URL);
			String actualURL = driver.getCurrentUrl();
			System.out.println("URL is " + actualURL);
			for (String winHandle : driver.getWindowHandles()) {
				parentHandle = winHandle;
			}
		} catch (Exception e) {

		}
	}

//	public static void loadProperty() throws IOException {
	public static void loadProperty(String env) throws IOException {

		String fileName = null;

//		if (System.getProperty("Environment").equalsIgnoreCase("UAT")) {
		if (env.equalsIgnoreCase("UAT")) {
			fileName = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "java" + File.separator + "config" + File.separator
					+ System.getProperty("Environment") + "config.properties";
		}
//		else if (System.getProperty("Environment").equalsIgnoreCase("DEV")) {
		else if (env.equalsIgnoreCase("DEV")) {
			fileName = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "java" + File.separator + "config" + File.separator
//					+ System.getProperty("Environment") + "config.properties";
					+ env + "config.properties";
		}
//		else if (System.getProperty("Environment").equalsIgnoreCase("QA")) {
		else if (env.equalsIgnoreCase("QA")) {
			fileName = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "java" + File.separator + "config" + File.separator
					+ System.getProperty("Environment") + "config.properties";
		}

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			fis.close();
		}
	}

	public static void clearfiles(String Location) throws IOException {

		try {
			Files.walk(Paths.get(Location)).filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
		} catch (IOException e) {
			File creation = new File(Location);
			creation.mkdir();
		}
	}

	public static void closeBrowser() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		driver = null;
	}

}
