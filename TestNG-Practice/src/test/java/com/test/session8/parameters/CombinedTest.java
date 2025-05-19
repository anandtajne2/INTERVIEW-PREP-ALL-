package com.test.session8.parameters;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CombinedTest {

private String environment;
    
    @Parameters({"env"})
    @BeforeClass
    public void setup(@Optional("dev") String env) {
        this.environment = env;
        System.out.println("Running tests in environment: " + environment);
    }
    
    @DataProvider(name = "userRoles")
    public Object[][] provideRoles() {
        return new Object[][] {
            {"admin"},
            {"editor"},
            {"viewer"}
        };
    }
    
    @Test(dataProvider = "userRoles")
    public void testRoleAccess(String role) {
        System.out.println("Testing role '" + role + "' in " + environment);
        // Your test implementation here
    }
	
}
