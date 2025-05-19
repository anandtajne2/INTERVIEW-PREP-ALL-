package java8.part6;

import java8.part3.IPrintable;

public class TestLambdaExp {

	public static void main(String[] args) {

		// functional programming
		// conditions to be match
		// 1. parameter of the abstract method and lambda expression should be match
		// 2. return type of the abstract method and lambda expression should be match
		// 3. interface must have only one abstract method which should be not
		// implemented

//		IPrintable iPrintable = (firstName, lastName) -> {
//			System.out.println("user fullname " + firstName + " " + lastName);
//		};

//		iPrintable.print("Anand", "Tajne");

		// method have no parameter but return string
//		IPrintable iPrintable = () -> "hello lambda";
//		System.out.println(iPrintable.print());

//		// method have one parameter and return value string
//		IPrintable iPrintable = (text) -> text.toLowerCase();
//		System.out.println(iPrintable.print("TEXT"));

		// method have string parameter and return boolean value
		IPrintable iPrintable = text -> {
			return text.length() > 0;
		};

	}

}
