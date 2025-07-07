package managers;

import pages.ContactUsPage;
import pages.LoginPage;

public class PageObjectManager {
	private LoginPage loginPage;
	private ContactUsPage contactPage;

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

	public ContactUsPage getContactPage() {
		if (contactPage == null) {
			contactPage = new ContactUsPage();
		}
		return contactPage;
	}
}