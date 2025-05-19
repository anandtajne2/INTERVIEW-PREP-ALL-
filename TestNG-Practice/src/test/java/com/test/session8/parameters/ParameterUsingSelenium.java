package com.test.session8.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterUsingSelenium {

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
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			options.setAcceptInsecureCerts(true);

			driver = new FirefoxDriver(options);
		}
		driver.get("https://www.google.com");
	}

	@Test
	public void verifyPageTitle() {
		System.out.println("verifyPageTitle method execution");
		String expectedPageTitle = "Google";
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "page title does not match");
	}

	@Test
	public void verifyGoogleImage() {
		System.out.println("verifyGoogleImage method execution");
		WebElement googleImage = driver.findElement(By.xpath("//div[@class='k1zIA rSk4se']"));
		// verify image should not be display
		Assert.assertTrue(googleImage.isDisplayed(), "image is being displayed");
	}

	@AfterClass
	public void tearDown() {
		System.out.println("tear down method execution");
		if (driver != null) {
			driver.close();
		}
	}
}
