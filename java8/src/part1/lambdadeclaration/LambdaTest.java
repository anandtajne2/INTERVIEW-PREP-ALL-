package part1.lambdadeclaration;

public class LambdaTest {

	public static void main(String[] args) {

//		WebPage page = new WebPage() {
//			@Override
//			public void header(String value) {
//				System.out.println("hi " + value);
//			}
//		};

//		WebPage page = (name) -> {
//			System.out.println("hi " + name);
//		};
//
//		WebPage page2 = (name) -> System.out.println("hi " + name.toUpperCase());
//
//		WebPage page3 = (n) -> System.out.println("hi " + n.toLowerCase());

		WebPage page4 = (name, age) -> {
			System.out.println("hi " + name + " age -> " + age);
		};

//		WebPage page2 = new WebPage() {
//			@Override
//			public void header(String value) {
//				System.out.println("hello " + value);
//			}
//		};
//		page.header("google");
//		page2.header("facebook");
		page4.header("anand", 30);
	}
}