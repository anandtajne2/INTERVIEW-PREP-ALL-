package com.test.session9.dataproviders;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContextAwareDataProviderTest {

	 @DataProvider(name = "contextData")
	    public Object[][] provideData(ITestContext context) {
	        String testName = context.getName();
	        
	        if("testAdminFeatures".equals(testName)) {
	            return new Object[][] {
	                {"admin", "full_access"},
	                {"superuser", "partial_access"}
	            };
	        } else {
	            return new Object[][] {
	                {"guest", "read_only"},
	                {"analyst", "read_write"}
	            };
	        }
	    }
	    
	    @Test(dataProvider = "contextData", testName = "testAdminFeatures")
	    public void testAdminFeatures(String role, String accessLevel) {
	        System.out.println("Testing admin feature with role: " + role + 
	                         ", Access: " + accessLevel);
	    }
	    
	    @Test(dataProvider = "contextData")
	    public void testRegularFeatures(String role, String accessLevel) {
	        System.out.println("Testing regular feature with role: " + role + 
	                         ", Access: " + accessLevel);
	    }
}
