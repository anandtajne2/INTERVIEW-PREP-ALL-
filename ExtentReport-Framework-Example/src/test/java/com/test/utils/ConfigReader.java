package com.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;

	static {
		try {
			String filePath = "src/test/resources/config.properties";
			FileInputStream input = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
