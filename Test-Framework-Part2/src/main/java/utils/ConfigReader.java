package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            // Get environment from system property or default to 'config'
            String environment = System.getProperty("environment", "qa");
            String configPath = "src/main/resources/" + environment + "-config.properties";
            
            properties = new Properties();
            FileInputStream input = new FileInputStream(configPath);
            properties.load(input);
            input.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}