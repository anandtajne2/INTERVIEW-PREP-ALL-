package com.test.session8.parameters;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class UserTestFactory {

	   @Factory
	    public Object[] createInstances() {
	        return new Object[] {
	            new UserTest("admin", "admin123"),
	            new UserTest("guest", "guest123"),
	            new UserTest("tester", "test123")
	        };
	    }
}

class UserTest {
    private String username;
    private String password;
    
    public UserTest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Test
    public void testUserLogin() {
        System.out.println("Testing user: " + username);
        System.out.println("Testing passwrod : " + password);
    }
}