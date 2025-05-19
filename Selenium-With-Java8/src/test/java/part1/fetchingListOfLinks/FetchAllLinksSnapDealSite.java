package part1.fetchingListOfLinks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchAllLinksSnapDealSite {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.snapdeal.com/");

//		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
//
//		List<String> linkNames = new ArrayList<>();
//
//		for (int i = 0; i < allLinks.size(); i++) {
//			String linkName = allLinks.get(i).getText();
//			if (!linkName.isBlank()) {
//				System.out.println(linkName);
//				linkNames.add(linkName);
//			}
//		}
//
//		System.out.println("link names size : " + linkNames.size());
//
//		List<String> nonDuplicateLinks = new ArrayList<>(new HashSet<>(linkNames));
//		System.out.println("--------------- non repeated link names ----------------");
//		for (int i = 0; i < nonDuplicateLinks.size(); i++) {
//			if (nonDuplicateLinks.get(i).startsWith("C") || nonDuplicateLinks.get(i).startsWith("D")) {
//				System.out.println(nonDuplicateLinks.get(i));
//			}
//		}
//		System.out.println("nonDuplicateLinks size : " + nonDuplicateLinks.size());
		
		// using java 8 stream feature 
		
		driver.findElements(By.xpath("//a")).stream()
		.map(m -> m.getText())
		.filter(s -> !s.isBlank())
		.distinct()
		.sorted()
		.filter(s -> s.startsWith("C") || s.startsWith("D"))
		.forEach(System.out::println);

		driver.quit();
	}
}
