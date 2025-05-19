package strings;

public class ReverseString {

	public static void main(String[] args) {
//	Q #1) Write a Java Program to reverse a string using String inbuilt function.
		System.out.println("------------- using string builder reverse method --------------");
		String str = "Automation";
		StringBuilder builder = new StringBuilder();
		builder.append(str);
		builder = builder.reverse();
		System.out.println(builder);

//  Q #2) Write a Java Program to reverse a string without using String inbuilt function reverse().		
		System.out.println("------------- using string toCharArray method --------------");
		String string = "Anand Tajne";
		char[] array = string.toCharArray();
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i]);
		}

		// using result string
		System.out.println();
		System.out.println("------------- using string toCharArray method --------------");
		String str1 = "Anand Tajne";
		String result = "";
		char[] chArr = str1.toCharArray();
		for (int i = chArr.length - 1; i >= 0; i--) {
			result += chArr[i];
		}
		System.out.println(result);
	}

}
