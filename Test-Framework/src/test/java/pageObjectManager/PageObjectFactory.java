package pageObjectManager;

import baseClass.BaseClass;
import pagesObjects.LoginPageObject;

public class PageObjectFactory {

	public static LoginPageObject loginPageObject;

	public static LoginPageObject getLoginPageObject() {
		return (loginPageObject != null) ? loginPageObject : new LoginPageObject(BaseClass.getDriver());
	}
}
