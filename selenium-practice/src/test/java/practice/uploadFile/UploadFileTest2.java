package practice.uploadFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileTest2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/upload");

		// Locate the file input element
		WebElement fileInput = driver.findElement(By.id("file-upload"));

		// Specify the absolute path of the file to upload
		String filePath = "D:\\face picture.jpg"; // Replace with your file path

		// Send the file path to the input element
		fileInput.sendKeys(filePath);

		// Locate and click the upload button
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		uploadButton.click();

		// Verify the upload (e.g., check for a success message)
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
		String uploadedFileName = uploadedFiles.getText();

		if (uploadedFileName.equals("face picture.jpg")) { // change to your file name
			System.out.println("File uploaded successfully!");
		} else {
			System.out.println("File upload failed.");
		}
	}

}
