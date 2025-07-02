package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class Utils extends BaseClass {

	// Send keys to element with wait
	public static void sendKeys(WebDriver driver, WebElement element, String text) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println("Failed to send keys to element: " + e.getMessage());
		}
	}

	// Click element with wait
	public static void clickElement(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			logger.info("click on button");
		} catch (Exception e) {
			System.out.println("Failed to click element: " + e.getMessage());
		}
	}

	// Select dropdown by visible text
	public static void selectByVisibleText(WebElement dropdown, String text) {
		try {
//			dropdown.click();
			Select select = new Select(dropdown);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println("Failed to select dropdown: " + e.getMessage());
		}
	}

	public static void selectCheckbox(WebElement checkbox) {
		if (checkbox != null && !checkbox.isSelected()) {
			checkbox.click();
		}
	}

	// Generic wait for visibility
	public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Element not visible: " + e.getMessage());
			return null;
		}
	}
}