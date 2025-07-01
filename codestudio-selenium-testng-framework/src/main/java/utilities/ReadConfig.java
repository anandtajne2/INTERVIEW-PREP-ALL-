package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.InvalidArgumentException;

public class ReadConfig {

	Properties properties;
	String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "configuration" + File.separator + "config.properties";

	public ReadConfig() {
		properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(path);
			properties.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidArgumentException("invalid path for config file");
		}
	}

	public String getProperty(String key) {
		String value = properties.getProperty(key);
		if (value != null) {
			return value;
		} else {
			throw new InvalidArgumentException("invalid value for config properties file");
		}
	}
}