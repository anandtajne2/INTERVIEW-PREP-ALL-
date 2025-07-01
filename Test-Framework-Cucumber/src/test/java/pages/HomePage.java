package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

	@FindBy(className = "app_logo")
	private WebElement logo;

	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingCart;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isHomePageDisplayed() {
		return logo.isDisplayed() && shoppingCart.isDisplayed();
	}
}