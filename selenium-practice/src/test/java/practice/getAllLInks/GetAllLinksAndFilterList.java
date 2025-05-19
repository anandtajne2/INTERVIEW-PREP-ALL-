package practice.getAllLInks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllLinksAndFilterList {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.snapdeal.com/");

//		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
//		System.out.println("------------------ allLinks size ------------------ " + allLinks.size());
//
//		List<String> allLinkText = new ArrayList<>();
//
//		for (WebElement link : allLinks) {
//			String linkText = link.getText();
//			if (!linkText.isBlank()) {
//				System.out.println(linkText);
//				allLinkText.add(linkText);
//			}
//		}
//
//		System.out.println("------------------ allLinkText size ------------------ " + allLinkText.size());
////
//		// remove duplicate link text filter
//		Set<String> nonDuplicatelInkText = new HashSet<>(allLinkText);
////
//		System.out.println(
//				"------------------ nonDuplicatelInkText size ------------------ " + nonDuplicatelInkText.size());
////
//		for (String linkName : nonDuplicatelInkText) {
//			if (linkName.startsWith("C") || linkName.startsWith("D")) {
//				System.out.println(linkName);
//			}
//		}
		
		// using java 8 steam feature
		
		driver.findElements(By.xpath("//a"))
		.stream()
		.map( m -> m.getText())
		.filter( f -> !f.isBlank())
		.distinct()
		.filter(s -> s.startsWith("C") || s.startsWith("D"))
		.forEach(System.out::println);

		driver.quit();

	}

}
