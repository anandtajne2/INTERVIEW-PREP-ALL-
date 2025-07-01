package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 

    public void loginwithDrivehubApplication(WebDriver driver) throws InterruptedException {
//        enterUserName(BaseClass.getProperty("drivehub_username"));
//        enterPassWord(BaseClass.getProperty("drivehub_password"));
//        clickLoginButton();
    	driver.get("");
    }

}