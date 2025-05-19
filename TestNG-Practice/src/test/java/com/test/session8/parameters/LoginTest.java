package com.test.session8.parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

	
	  @Test
	    @Parameters({"username", "password"})
	    public void testLogin(String username, String password) {
	        System.out.println("Testing login with:");
	        System.out.println("Username: " + username);
	        System.out.println("Password: " + password);
	        // Your test implementation here
	    }
}
