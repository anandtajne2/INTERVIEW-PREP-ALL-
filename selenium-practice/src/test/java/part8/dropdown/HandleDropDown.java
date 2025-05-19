package part8.dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(options);

//		driver.get("https://www.opencart.com/index.php");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
//
//		driver.findElement(By.xpath("//a[@class='btn btn-black navbar-btn']")).click();
//		WebElement drpCountry = driver.findElement(By.id("input-country"));
//
//		Select select = new Select(drpCountry);
//		select.selectByVisibleText("Denmark");

	}
}