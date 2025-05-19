package Part5.Navigations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com");
//		driver.get("https://www.amazon.in");
		
		driver.navigate().to("https://www.amazon.in");

		// navigate to back page
		driver.navigate().back(); // it navigates to snapdeal page
		// navigate to forward page
		driver.navigate().forward(); // it navigates to amazon.in page
		// refresh the page
		driver.navigate().refresh(); // it refresh the current page 
		
		driver.quit();
	}
}