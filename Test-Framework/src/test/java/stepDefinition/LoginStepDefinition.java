package stepDefinition;

import baseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjectManager.PageObjectFactory;

public class LoginStepDefinition extends BaseClass {

	@Given("launch browser")
	public void launch_browser() throws Exception {
		initializeDriver();
		PageObjectFactory.getLoginPageObject().loginwithDrivehubApplication(getDriver());
	}
	
	@When("navigate to login page")
	public void navigate_to_login_page() throws Exception {
//		initializeDriver();
//		PageObjectFactory.getLoginPageObject().loginwithDrivehubApplication();
	}
}