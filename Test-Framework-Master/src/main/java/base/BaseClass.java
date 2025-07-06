package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import manager.DriverController;

public class BaseClass extends DriverController {

	@BeforeClass
	public static void initializeDriver() {
		DriverController.initializeBrowser();
	}

	public static WebDriver getDriver() {
		return DriverController.driver;
	}

	public static String getProperty(String propertyKey) {
		return DriverController.properties.getProperty(propertyKey);
	}

	public static void refresh() {
		getDriver().navigate().refresh();
	}

	public static void back() {
		getDriver().navigate().back();
	}

	public static void forward() {
		getDriver().navigate().forward();
	}

	public void loadURL(String url) {
		getDriver().get(url);
	}

	@AfterClass
	public static void tearDown() {
		DriverController.closeBrowser();
	}
}