package strings;

public class RemoveSpaceFromString {

	public static void main(String[] args) {
		String str = "^&^&*^ Anand Tajne &*(&(*$099e8r98237";

		// 1. using replaceAll method

		System.out.println("before remove unwanted characters : " + str);
		str = str.replaceAll("[^A-Za-z ]", "");
		System.out.println("after remove unwanted characters : " + str);

	}
}