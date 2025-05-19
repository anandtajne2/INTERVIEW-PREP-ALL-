package part3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {

		WebDriver driver;

		// chrome driver system driver path setting
//		String currentPath = System.getProperty("user.dir");
//		String chromerDriverPath = File.separator + "drivers" + File.separator + "chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", currentPath + chromerDriverPath);

//		System.out.println(currentPath + chromerDriverPath);

		// using web driver manager class
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getPageSource());

		// edge browser setting
//		String edgeDriverPath = File.separator + "drivers" + File.separator + "msedgedriver.exe";
//		System.setProperty("webdriver.chrome.driver", currentPath + edgeDriverPath);

		// using web driver manager
//		WebDriverManager.firefoxdriver().setup();
//
//		driver = new FirefoxDriver();
//		driver.get("https://www.google.com/");

		// using web driver manager
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
//		driver.get("https://www.google.com/");

		// firefox browser setting
//		String firefoxDriverPath = File.separator + "drivers" + File.separator + "geckodriver.exe";
//		System.setProperty("webdriver.chrome.driver", currentPath + firefoxDriverPath);

//		driver = new FirefoxDriver();
//		driver.get("https://www.google.com/");

		driver.quit();
	}

}