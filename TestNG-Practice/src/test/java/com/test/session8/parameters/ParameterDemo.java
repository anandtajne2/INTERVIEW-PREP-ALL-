package com.test.session8.parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {

	@Test
	@Parameters({ "num1", "num2" })
	public void add(int num1, int num2) {
		int result = num1 + num2;
		System.out.println("sum of two numbers : " + result);
	}

}
