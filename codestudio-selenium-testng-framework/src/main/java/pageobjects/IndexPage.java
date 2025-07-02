package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class IndexPage {

	// 1. create object of webdriver
	WebDriver driver;

	// 2. create constructor of class with webdriver parameter
	// using page factory to locate web elements
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 3. finding and write web page elements

	@FindBy(linkText = "Sign in")
	WebElement signIn;

	// 4. write method for actions to perform on web page

	public void clickOnSignIn() {
//		signIn.click();
		Utils.clickElement(driver, signIn);
	}
}