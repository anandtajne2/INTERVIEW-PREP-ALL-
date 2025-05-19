package com.test.session10.parallelTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxTestClass {

	WebDriver driver;

	@Test
	public void firefoxTest() {
		System.out.println("thread id : " + Thread.currentThread().threadId());
		System.out.println("this is firefox browser test");

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		driver.get("https://www.google.com");

		System.out.println("web page title is : " + driver.getTitle());

		driver.quit();
	}

}
