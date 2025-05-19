package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private final WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchFor(String string) {
		// TODO Auto-generated method stub

	}

	public boolean areSearchResultsDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmptySearchMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
