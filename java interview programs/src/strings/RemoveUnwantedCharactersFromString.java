package strings;

public class RemoveUnwantedCharactersFromString {

	public static void main(String[] args) {
		String str = " Anand Tajne is Senior QA engineer ";

		// 1. using replaceAll method
		System.out.println("---------------- using replace all method ----------------");
		System.out.println("before remove unwanted characters : " + str);
		str = str.replaceAll(" ", "");
		System.out.println("after remove unwanted characters : " + str);

		// 2. using toCharArray method and compare characters
		System.out.println("---------------- using to char array method and compare characters ----------------");
		StringBuilder builder = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if (ch != ' ' && ch != '\t') {
				builder.append(ch);
			}
		}
		System.out.println(" result " + builder);
	}
}