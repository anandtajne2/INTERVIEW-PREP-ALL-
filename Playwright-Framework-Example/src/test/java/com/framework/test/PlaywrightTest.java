package com.framework.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Unit test for simple App.
 */
public class PlaywrightTest {

	static Playwright playwright;
	static Browser browser;

	@BeforeAll
	static void setup() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	}

	@AfterAll
	static void tearDown() {
		browser.close();
		playwright.close();
	}

	@Test
	void testGoogleSearch() {
		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		page.navigate("https://www.google.com");
		page.locator("textarea[name='q']").fill("Playwright Java");
		page.keyboard().press("Enter");

		page.waitForSelector("text=Playwright");
		Assertions.assertTrue(page.title().contains("Playwright Java"));
	}

}
