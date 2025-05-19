package com.test.session9.dataproviders;

import org.testng.annotations.Test;

public class ExternalDataProviderTest {

	@Test(dataProvider = "productData", dataProviderClass = TestDataProvider.class)
    public void testProductDetails(String name, double price, String category) {
        System.out.println("Product: " + name + 
                         ", Price: $" + price + 
                         ", Category: " + category);
        // Your test implementation
    }
	
}