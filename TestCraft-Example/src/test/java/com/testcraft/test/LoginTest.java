package com.testcraft.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testcraft.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;
	LoginPage loginPage;

	@BeforeClass
	public void setUp() {
		// Make sure ChromeDriver is in your system PATH or set its path explicitly
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		loginPage = new LoginPage(driver);
	}

	@Test
	public void testSuccessfulLogin() {
		loginPage.login("standard_user", "secret_sauce");

		String currentUrl = driver.getCurrentUrl();
		assertEquals("https://www.saucedemo.com/v1/inventory.html", currentUrl);

		String titleText = driver.findElement(By.className("product_label")).getText();
		assertEquals("Products", titleText);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
