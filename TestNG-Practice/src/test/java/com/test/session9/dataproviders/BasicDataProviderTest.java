package com.test.session9.dataproviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicDataProviderTest {

	@DataProvider(name = "loginCredentials")
	public Object[][] provideLoginData() {
		return new Object[][] {
			{"user1@gmail.com", "password1"},
            {"user2@yahoo.com", "password2"},
            {"user3@outlook.com", "password3"}
		};
	}
	
	 @Test(dataProvider = "loginCredentials")
	    public void testLogin(String username, String password) {
	        System.out.println("Testing login with username: " + username + 
	                          " and password: " + password);
	        // Your login test implementation
	    }
	
	 // data provider with mixed data types 
	 
	  @DataProvider(name = "userData")
	    public Object[][] provideUserData() {
	        return new Object[][] {
	            {"John Doe", 28, true},    // String, int, boolean
	            {"Alice Smith", 35, false},
	            {"Bob Johnson", 42, true}
	        };
	    }
	    
	    @Test(dataProvider = "userData")
	    public void testUserProfile(String name, int age, boolean isPremium) {
	        System.out.println("Testing user: " + name + ", Age: " + age + 
	                         ", Premium: " + isPremium);
	        // Your test implementation
	    }
	    
	    // user define class data - student
	    
	    @DataProvider(name = "studentData")
	    public Object[][] studentRecords() {
	        return new Object[][] {
	            {"student 1", new Student(1, "Anand")},    // String, int, boolean
	            {"student 2", new Student(2, "Devansh")},
	            {"student 3", new Student(3, "Aditya")}
	        };
	    }
	    
	    @Test(dataProvider = "studentData")
	    public void testStudentData(String name, Student student) {
	        System.out.println("student user: " + name + ", roll no: " + student.getRollNo() + 
	                         ", name : " + student.getStudentName());
	        // Your test implementation
	    }
	    
}