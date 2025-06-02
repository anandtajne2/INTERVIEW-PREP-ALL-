package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;

	public ConfigReader() {
		properties = new Properties();
		try {
			String configProp = "src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "config.properties";
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");

			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBaseUrl() {
		return properties.getProperty("base.url");
	}

	public String getChromeDriverPath() {
		return properties.getProperty("chrome.driver.path");
	}

	// Add other getters as needed
}