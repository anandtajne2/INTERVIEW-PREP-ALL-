package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

	@Test
	public void testSuccessfulLogin() {
		test.log(Status.INFO, "Starting successful login test");

		driver.get("https://www.saucedemo.com/");
		test.log(Status.INFO, "Navigated to login page");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		test.log(Status.INFO, "Entered credentials");

		driver.findElement(By.id("login-button")).click();
		test.log(Status.INFO, "Clicked login button");

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
		test.log(Status.PASS, "Login successful, redirected to inventory page");
	}

	@Test
	public void testFailedLogin() {
		test.log(Status.INFO, "Starting failed login test");

		driver.get("https://www.saucedemo.com/");
		test.log(Status.INFO, "Navigated to login page");

		driver.findElement(By.id("user-name")).sendKeys("invalid_user");
		driver.findElement(By.id("password")).sendKeys("wrong_password");
		test.log(Status.INFO, "Entered invalid credentials");

		driver.findElement(By.id("login-button")).click();
		test.log(Status.INFO, "Clicked login button");

		String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
		Assert.assertTrue(errorMessage.contains("Username and password do not match"));
		test.log(Status.PASS, "Correct error message displayed");
	}
}