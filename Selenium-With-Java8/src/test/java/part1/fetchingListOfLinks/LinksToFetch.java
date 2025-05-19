package part1.fetchingListOfLinks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksToFetch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");

//		List<WebElement> links = driver.findElements(By.xpath("//a"));
//		List<String> linkText = new ArrayList<>();
//
//		for (int i = 0; i < links.size(); i++) {
//			String temp = links.get(i).getText();
//			if (!temp.isBlank()) {
//				linkText.add(temp);
//			}
//		}
//
//		System.out.println("--------- links size --------" + links.size());
//
//		for (int i = 0; i < linkText.size(); i++) {
//			System.out.println(linkText.get(i));
//		}
//
//		System.out.println("------------- after removing duplicates ---------------");

//		Set<String> removeDuplicates = new HashSet<>();
//		List<String> listAfterRemovingDuplicates = new ArrayList<>(new HashSet<String>(linkText));
//		Collections.sort(listAfterRemovingDuplicates);
//		System.out.println("--------- listAfterRemovingDuplicates size --------" + listAfterRemovingDuplicates.size());
//		System.out.println("--------- duplicate link remove count  --------"
//				+ (links.size() - listAfterRemovingDuplicates.size()));
//		for (int i = 0; i < listAfterRemovingDuplicates.size(); i++) {
//			if (listAfterRemovingDuplicates.get(i).startsWith("C")
//					|| listAfterRemovingDuplicates.get(i).startsWith("D")) {
//				System.out.println(listAfterRemovingDuplicates.get(i));
//			}
//		}

		// using java 8 features

		driver.findElements(By.xpath("//a")).stream()
			.map(e -> e.getText())
			.filter(s -> !s.isBlank())
			.distinct()
			.sorted()
			.filter(s -> s.startsWith("C") || s.startsWith("D"))
			.forEach(System.out::println);

		driver.close();

	}
}
