package excercise2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {

	public String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;

//	@BeforeTest
	@BeforeClass
	public void setup() {
		System.out.println("Before Test Execute");

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // open browser in maximized mode
		options.addArguments("--incognito"); // open browser in incognito mode
		options.addArguments("--disable-popup-blocking");
		options.setAcceptInsecureCerts(true); // Accept insecure certificates

		driver = new ChromeDriver(options);

		driver.get(baseURL);
		// adding implicite waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@Test(priority = 1)
	public void loginWithInvalidCredentials() throws InterruptedException {
		// find username
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("invaliduser");
		// find password input field
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("invalidPasswordadmin123");
		// click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String msg_expected = "Invalid credentials";

		String msg_actual = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"))
				.getText();
		Assert.assertTrue(msg_actual.contains(msg_expected));
		Assert.assertEquals(msg_expected, msg_actual);
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void loginTestWithValidCredentials() {
		// find username
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

		// find password input field
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		// click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// verify if the login was successfully by checking the page title or specific
		// web element
		String pageTitle = driver.getTitle();
//		if (pageTitle.equals("OrangeHRM")) {
//			System.out.println("Login Successfully");
//		} else {
//			System.out.println("Login Failed");
//		}

		// to failed test case using assert to verify page text
//		Assert.assertEquals("OrangeHRMABC", pageTitle);

		// using assert to verify page title
		Assert.assertEquals("OrangeHRM", pageTitle);
	}

	@Test(priority = 3)
	public void addEmployee() {
		// click on PIM 
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
		// find add employee and click on add employee option 
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		// enter first name 
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("anand");
		
		// enter last name 
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("tajne");
		
		// click on save button 
//		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}

	public void logOut() throws InterruptedException {
		System.out.println("user logout");
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//ul[@role='menu']//child::li//a[contains(text(),'Logout')]")).click();

		// creating xpath using a tag
		List<WebElement> elementList = driver.findElements(By.xpath("//a[@class='oxd-userdropdown-link']"));
		for (WebElement element : elementList) {
			if (element.getText().equalsIgnoreCase("Logout")) {
				element.click();
			}
		}

//		Thread.sleep(2000);
	}

//	@AfterTest
	@AfterClass
	public void tearDown() throws InterruptedException {

		System.out.println("After Test Execute");

		Thread.sleep(3000);
		logOut();
		driver.close();
		driver.quit();
	}

}
