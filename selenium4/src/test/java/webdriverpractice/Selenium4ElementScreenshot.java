package webdriverpractice;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium4ElementScreenshot {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "browser_exe"
			+ File.separator + "chromedriver_latest.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true"); 
	WebDriver driver = new ChromeDriver();
	System.out.println("Driver => " + driver);
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	new WebDriverWait(driver, Duration.ofDays(1));
	
	WebElement googleSearchBox = driver.findElement(By.xpath("//a[text()='Gmail']"));
	
	// Take screenshot and store as a file format
	File src= ((TakesScreenshot)googleSearchBox).getScreenshotAs(OutputType.FILE);
	try {
	 // now copy the  screenshot to desired location using copyFile //method
	FileUtils.copyFile(src, new File("C:/selenium/error.png"));
	FileHandler.copy(src, new File("C:/selenium/error1.png"));
	}
	 catch (Exception e) {
	}
	System.out.println("DONE!");
}
}
