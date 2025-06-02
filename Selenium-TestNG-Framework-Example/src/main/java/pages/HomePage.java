package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;

public class HomePage extends BaseTest {

	private WebDriver driver;

	@FindBy(xpath = "//span[@class='title']")
	private WebElement productPageHeader;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isProductsHeaderDisplayed() {

		return driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
	}

}