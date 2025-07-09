package pageObjectManager;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import pages.LoginPage;

public class PageObjectFactory {
	public static LoginPage loginPage;
	public static WebDriver driver;

	public static LoginPage getLoginPage() {
		return (loginPage != null) ? loginPage : new LoginPage(BaseClass.getDriver());
	}
}
