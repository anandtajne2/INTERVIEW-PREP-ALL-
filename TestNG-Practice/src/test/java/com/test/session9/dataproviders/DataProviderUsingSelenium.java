package com.test.session9.dataproviders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderUsingSelenium {

	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setup(@Optional("chrome") String browserName) {
		System.out.println("setup method execution");
		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.setAcceptInsecureCerts(true);

			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://www.saucedemo.com/v1/index.html");
	}

	@Test(dataProvider = "usersData")
	public void verifyLogin(String username) {
		WebElement usernameField = driver.findElement(By.id("user-name"));
		WebElement passwordField = driver.findElement(By.id("password"));

		usernameField.sendKeys(username);
		passwordField.sendKeys("secret_sauce");

		// click on login
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// wait for the page to load after login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bm-burger-button']")));

		// click on the menu button
		WebElement menuButton = driver.findElement(By.xpath("//div[@class='bm-burger-button']"));
		menuButton.click();

		// click on logout button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
		WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
		logoutButton.click();

		// verify successful logout (optional)
		wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/index.html"));
		System.out.println("successfully logout");
	}

	@DataProvider(name = "usersData")
	public Object[][] userProviders() {
		return new Object[][] { { "standard_user" }, { "locked_out_user" } };
	}

	@AfterClass
	public void tearDown() {
		System.out.println("tear down method execution");
		if (driver != null) {
			driver.close();
		}
	}
}
