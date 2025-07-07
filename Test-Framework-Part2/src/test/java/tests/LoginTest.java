package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import managers.PageObjectManager;
import managers.ReportManager;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
    private final PageObjectManager pages = new PageObjectManager();
    
    @Test
    public void testSuccessfulLogin() {
        pages.getLoginPage()
            .enterUsername(ConfigReader.getProperty("validUsername"))
            .enterPassword(ConfigReader.getProperty("validPassword"))
            .clickLogin();
        
        // Add assertions here
        ReportManager.getTest().pass("Login successful");
    }
}
