package com.test.session9.dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	 @DataProvider(name = "productData")
	    public static Object[][] getProductData() {
	        return new Object[][] {
	            {"Laptop", 999.99, "Electronics"},
	            {"T-Shirt", 19.99, "Apparel"},
	            {"Book", 12.50, "Books"}
	        };
	    }
}