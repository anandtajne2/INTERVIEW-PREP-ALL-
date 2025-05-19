package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utils.ConfigReader;

public class SearchTest extends BaseTest {
	@Test
	public void testSearchFunctionality() {
		HomePage homePage = new HomePage(getDriver());

		getDriver().get(ConfigReader.getProperty("app.url"));

		homePage.searchFor("Selenium WebDriver");
		Assert.assertTrue(homePage.areSearchResultsDisplayed(), "Search results not displayed");
	}

	@Test
	public void testEmptySearch() {
		HomePage homePage = new HomePage(getDriver());
		
		getDriver().get(ConfigReader.getProperty("app.url"));

		homePage.searchFor("");
		Assert.assertTrue(homePage.isEmptySearchMessageDisplayed(), "Empty search message not displayed");
	}
}
