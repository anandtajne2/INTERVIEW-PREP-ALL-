package java8.part4;

import java8.part3.IPrintable;

public class TestRunner {

	public static void main(String[] args) {

		// conventional way
		IPrintable iPrintable = new LogFileImpl();
		iPrintable.print();

		// anonymous inner class
		IPrintable iPrintable2 = new IPrintable() {

			@Override
			public void print() {
				System.out.println("from anonymus inner class");
			}
		};
		iPrintable2.print();
		
		// 2. using anonymous inner class
		new IPrintable() {
			
			@Override
			public void print() {
				System.out.println("from anonymus inner class");
				
			}
		};

		// functional programming
		// conditions to be match
		// 1. parameter of the abstract method and lambda expression should be match
		// 2. return type  of the abstract method and lambda expression should be match
		// 3. interface must have only one abstract method which should be not implemented 
		IPrintable iPrintable3 = () -> System.out.println("from anonymus inner class tesitng");
		iPrintable3.print();

	}

}
