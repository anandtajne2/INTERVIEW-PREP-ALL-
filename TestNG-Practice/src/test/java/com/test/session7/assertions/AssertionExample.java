package com.test.session7.assertions;

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

public class AssertionExample {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.out.println("setup method execution");
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setAcceptInsecureCerts(true);

		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
	}

	@Test
	public void verifyPageTitle() {
		String expectedPageTitle = "Google";
//		String expectedPageTitle = "Google Test";
		String actualPageTitle = driver.getTitle();

		Assert.assertEquals(actualPageTitle, expectedPageTitle, "page title does not match");
	}

	@Test
	public void verifyGoogleImage() {
		WebElement googleImage = driver.findElement(By.xpath("//div[@class='k1zIA rSk4se']"));

		// verify image is displayed or not
		Assert.assertTrue(googleImage.isDisplayed(), "image does not display");

		// verify image should not be display
//		Assert.assertFalse(googleImage.isDisplayed(), "image is being displayed");
	}

	@AfterClass
	public void tearDown() {
		System.out.println("tear down method execution");
		if (driver != null) {
			driver.close();
		}
	}

}