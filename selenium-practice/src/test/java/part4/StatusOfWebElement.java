package part4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {

	public static void main(String[] args) {
		WebDriver driver;
		// using web driver manager class
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register");
		WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("is displayed status : " + searchStore.isDisplayed());
		System.out.println("is enabled status : " + searchStore.isEnabled());
		
		// check for radio button is selected or not 
		WebElement gender = driver.findElement(By.id("gender-male"));
		System.out.println("gender is selected : "+gender.isSelected());
		gender.click();
		System.out.println("gender is selected : "+gender.isSelected());
		
		driver.quit();

	}

}
