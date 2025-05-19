package com.test.session9.dataproviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest {
	@DataProvider(name = "searchTerms")
	public Object[][] provideSearchData() {
		return new Object[][] { { "laptop", 10 }, { "phone", 15 }, { "tablet", 8 } };
	}

	@Test(dataProvider = "searchTerms")
	public void testSearchFunctionality(String searchTerm, int expectedResults) {
		System.out.println("Searching for: " + searchTerm);
		System.out.println("Expected results: " + expectedResults);
		// Your test implementation here
	}
}
