package baseClass;

import org.openqa.selenium.WebDriver;

import driverManager.DriverController;

public class BaseClass extends DriverController {

	public static void initializeDriver() throws Exception {
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

	public void loadURL(String URL) {
		try {
			driver.manage().window().maximize();
			driver.get(URL);
		} catch (Exception e) {

		}
	}
}