package practice.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");

		// Click the button that triggers the alert
//		driver.findElement(By.id("alertButton")).click();
//
//		// Switch to the alert
//		Alert alert = driver.switchTo().alert();
//
//		Thread.sleep(2000);
//		alert.accept();
//		Thread.sleep(1000);
//
//		driver.findElement(By.id("confirmButton")).click();
//		Alert alert2 = driver.switchTo().alert();
//		Thread.sleep(2000);
//		alert2.dismiss();
//		Thread.sleep(1000);

		driver.findElement(By.id("promtButton")).click();
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("alert text" + alert3.getText());
		alert3.sendKeys("hello");
		alert3.accept();
//		System.out.println("alert input get text : " + alert3.getText());
		Thread.sleep(1000);

		driver.quit();
	}

}
