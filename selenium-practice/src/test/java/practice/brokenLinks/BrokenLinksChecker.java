package practice.brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksChecker {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.demoblaze.com/");

		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links found: " + listOfLinks.size());
		for (WebElement link : listOfLinks) {
			String url = link.getDomAttribute("href");

			if (url != null && !url.isEmpty()) {
				checkBrokenLink(url);
			} else {
				System.out.println("Skipping empty or null link.");
			}
		}
		// Close the browser
		driver.quit();
	}

	public static void checkBrokenLink(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.connect();
			int responseCode = connection.getResponseCode();
			if (responseCode >= 400) {
				System.out.println(url + " - ❌ Broken Link (Status: " + responseCode + ")");
			} else {
				System.out.println(url + " - ✅ Valid Link (Status: " + responseCode + ")");
			}
			connection.disconnect();
		} catch (IOException e) {
			System.out.println(url + " - ❌ Error Checking Link: " + e.getMessage());
		}
	}
}
