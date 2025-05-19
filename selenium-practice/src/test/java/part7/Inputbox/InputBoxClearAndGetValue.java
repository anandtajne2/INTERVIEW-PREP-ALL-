package part7.Inputbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputBoxClearAndGetValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");

		WebElement emailInputBox = driver.findElement(By.id("Email"));
		emailInputBox.clear();
		emailInputBox.sendKeys("some@email.com");

		// selenium 4.27 getAttribute method is deprecated
		System.out.println("result from getAttribute() method : " + emailInputBox.getAttribute("value"));

		// using get text
		System.out.println("result from getText() method : " + emailInputBox.getText());
		// it takes the value using innerText - <input name="email" id="user"> email id
		// </ipnut>
		// e.g 1. getAttribute('name') -> email
		// e.g 2. getAttribute('user') -> user
		// e.g 3. getText() -> email id

		// Use getDomAttribute for static attributes like id, name, or href
//		System.out.println("result from getDomAttribute() method : "+emailInputBox.getDomAttribute("value"));

		// Use getDomProperty for dynamic properties like value or checked.
//		System.out.println("result from getDomProperty() method : " + emailInputBox.getDomProperty("value"));

		// getting inner text of button
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));

		System.out.println(button.getAttribute("type"));
		System.out.println(button.getAttribute("class"));
		System.out.println(button.getText());

		// getting header text
		String title = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
		System.out.println("page header title : " + title);

		driver.quit();
	}
}

// input text -> clear
// how to get typed text from input box 