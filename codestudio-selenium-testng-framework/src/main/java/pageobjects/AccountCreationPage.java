package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class AccountCreationPage {

	WebDriver driver;

	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "uniform-id_gender2")
	WebElement titleMrs;

	@FindBy(id = "customer_firstname")
	WebElement firstname;

	@FindBy(id = "customer_lastname")
	WebElement lastname;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "days")
	WebElement days;

	@FindBy(id = "months")
	WebElement months;

	@FindBy(id = "years")
	WebElement years;

	@FindBy(id = "newsletter")
	WebElement newsletter;

	@FindBy(id = "submitAccount")
	WebElement register;

	public void selectTitle() {
		Utils.clickElement(driver, titleMrs);
	}

	public void enterFirsname(String firstnameText) {
		Utils.sendKeys(driver, firstname, firstnameText);
	}

	public void enterLastname(String lastnameText) {
		Utils.sendKeys(driver, lastname, lastnameText);
	}

	public void enterEmail(String emailText) {
		Utils.sendKeys(driver, email, emailText);
	}

	public void enterPassword(String passwordText) {
		Utils.sendKeys(driver, password, passwordText);
	}

	public void selectDay(String day) {
		Utils.selectByVisibleText(days, day);
	}

	public void selectMonth(String month) {
		Utils.selectByVisibleText(months, month);
	}

	public void selectYear(String year) {
		Utils.selectByVisibleText(years, year);
	}

	public void selectNewsLetter() {
		Utils.selectCheckbox(newsletter);
	}

	public void registerUser() {
		Utils.clickElement(driver, register);
	}
}