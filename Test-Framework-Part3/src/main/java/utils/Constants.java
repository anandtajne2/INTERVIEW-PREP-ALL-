package utils;

public interface Constants {
	public static final String QA_URL = DriverManager.properties.getProperty("url");
    public static final String BROWSER = DriverManager.properties.getProperty("browser");
    public static final String USERNAME = DriverManager.properties.getProperty("username");
    public static final String PASSWORD = DriverManager.properties.getProperty("password");
}