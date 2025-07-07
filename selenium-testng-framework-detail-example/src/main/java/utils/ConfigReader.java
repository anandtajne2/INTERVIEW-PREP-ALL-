package utils;

import constants.Constants;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	static {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getBrowser() {
		return prop.getProperty("browser");
	}

	public static String getBaseUrl() {
		return prop.getProperty("baseUrl");
	}

	public static String getUsername() {
		return prop.getProperty("username");
	}

	public static String getPassword() {
		return prop.getProperty("password");
	}
}