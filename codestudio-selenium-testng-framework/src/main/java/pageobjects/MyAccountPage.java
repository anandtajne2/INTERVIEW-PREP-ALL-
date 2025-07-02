package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class MyAccountPage {

	// 1. create object of web driver
	WebDriver driver;

	// 2. create constructor of class with web driver parameter
	// using page factory to locate web elements
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 3. finding and write web page elements

	@FindBy(id = "email_create")
	WebElement createNewEmailId;

	@FindBy(id = "SubmitCreate")
	WebElement createAnAccount;

	// 4. write method for actions to perform on web page

	public void enterCreateNewEmailId(String newEmailId) {
//		createNewEmailId.sendKeys(newEmailId);
		Utils.sendKeys(driver, createNewEmailId, newEmailId);
	}

	public void clickToCreateNewEmail() {
//		createAnAccount.click();
		Utils.clickElement(driver, createAnAccount);
	}
}