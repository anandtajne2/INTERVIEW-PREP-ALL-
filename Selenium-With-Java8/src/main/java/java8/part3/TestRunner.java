package java8.part3;

public class TestRunner {

	// Anonymous Inner class
	public static void main(String[] args) {
		IPrintable iPrintable = new IPrintable() {
			@Override
			public void print() {
				System.out.println("from anonymous inner class");

			}
		};

		IPrintable iPrintable2 = new IPrintable() {
			@Override
			public void print() {
				System.out.println("from anonymous inner class test");

			}
		};
		iPrintable.print();
		iPrintable2.print();
	}
}