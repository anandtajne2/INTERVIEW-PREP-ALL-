package com.test.session8.parameters;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ConfigTest {
	@Test
    @Parameters({"browser", "timeout"})
    public void testConfig(
        @Optional("chrome") String browser,
        @Optional("10") int timeout) {
        
        System.out.println("Running test on: " + browser);
        System.out.println("Timeout set to: " + timeout + " seconds");
        // Your test implementation here
    }
}
