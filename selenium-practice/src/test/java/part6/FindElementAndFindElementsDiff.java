package part6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementAndFindElementsDiff {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		// scenario 1 - using find element to store web element
		// findElement  -> return single web element
		WebElement searchBox = driver.findElement(By.id("small-searchterms"));
		searchBox.sendKeys("XYZ");
		
		// scenario 2 - locators is pointing to multiple web element
		// using find find element first 
		WebElement footerPageLinks =  driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(footerPageLinks.getText());
		
		// scenario 3 - web element not found it throws NoSuchElementException 
		//WebElement noElementFound = driver.findElement(By.xpath("//div[normalize-space()='login']"));
		
		/// findElements  -> return List of WebElements (multiple elements)
		// scenario 1 - select multiple and count the size 		
//		List<WebElement>  links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
//		System.out.println("number of elements captured : "+links.size());  // 22
		// scenario 3 - finding multiple elements text - using lopp 
//		for (WebElement webElement : links) {
//			System.out.println(" webElement name "+ webElement.getText());
//		}
		
		// scenario 2 - find elements finding only one element 
//		List<WebElement> logo = driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
//		System.out.println("logo size : "+logo.size());
		
		// scenario 4 - in find elements - web element not found it return zero it does not throw exception
		List<WebElement> elements = driver.findElements(By.xpath("//img[contains(title,'Electronics')]"));
		System.out.println("elements size : "+elements.size());
		
		
		
		driver.quit();
				
	}
}

//									findElement()						findElements()
// Single WebElement Present		Return Single Element				Returns Single Element		
// Multiple WebElements Present		Return First Element				Returns All Elements
// Element not present 				Throws - NoSuchElementException 	Does not throw any exception return zero elements
// Return Type						WebElement							List<WebElement>
// Access							Directly							Iterate the list of elements										