package com.test.session9.dataproviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@Test(dataProvider = "TestData")
	public void testDataProiver(int num1, String num2) {
		System.out.println("data proivder output : " + num1 + " " + num2);
	}

	@Test(dataProvider = "TestDataForAddition")
	public void testDataProiverAddition(int num1, int num2) {
		int result = num1 + num2;
		System.out.println("data proivder addition output : " + result);
	}

	@DataProvider(name = "TestData")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { 2, "two" }, { 5, "five" }, { 8, "eight" } };
	}

	@DataProvider(name = "TestDataForAddition")
	public Object[][] dataProviderForAddition() {
		return new Object[][] { { 2, 2 }, { 5, 3 }, { 8, 1 } };
	}
}
