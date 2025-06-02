package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TestUtils {
	public static String takeScreenshot(WebDriver driver, String screenshotName) {
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + ".png";
			FileUtils.copyFile(source, new File(path));
			return path;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}