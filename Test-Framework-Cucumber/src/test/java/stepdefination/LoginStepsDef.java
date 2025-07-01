package stepdefination;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepsDef {

	private LoginPage loginPage;
	private HomePage homePage;

	@Before
	public void setup() {
		TestBase.initialize();
	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		TestBase.getDriver().get("https://www.saucedemo.com/");
		loginPage = new LoginPage();
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
	}

	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("I should be redirected to the home page")
	public void i_should_be_redirected_to_the_home_page() {
		homePage = new HomePage();
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

	@After
	public void tearDown() {
		TestBase.tearDown();
	}
}