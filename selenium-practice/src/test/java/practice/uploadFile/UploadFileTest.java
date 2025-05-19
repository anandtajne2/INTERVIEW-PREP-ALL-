package practice.uploadFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/upload/");

		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

//		uploadElement.click();
		uploadElement.sendKeys("D:\\face picture.jpg");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.findElement(By.id("submitbutton")).click();
	}

}
