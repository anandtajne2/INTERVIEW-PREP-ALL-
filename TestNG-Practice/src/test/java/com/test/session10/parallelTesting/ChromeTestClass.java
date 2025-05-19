package com.test.session10.parallelTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTestClass {

	WebDriver driver;

	@Test
	public void chromeTest() {
		System.out.println("thread id : " + Thread.currentThread().threadId());
		System.out.println("this is chrome browser test");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com");

		System.out.println("web page title is : " + driver.getTitle());

		driver.quit();
	}

}
