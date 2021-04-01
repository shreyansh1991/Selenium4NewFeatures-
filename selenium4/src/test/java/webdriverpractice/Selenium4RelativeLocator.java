package webdriverpractice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Selenium4RelativeLocator {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "browser_exe"
			+ File.separator + "chromedriver_latest.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true"); 
	WebDriver driver = new ChromeDriver();
	System.out.println("Driver => " + driver);
	driver.manage().window().maximize();
	driver.get("https://www.orangehrm.com/");
	
	WebElement element = driver.findElement(By.xpath("//a[text()='Contact Sales']"));
	WebElement ele = driver.findElement(RelativeLocator.withTagName("li").toRightOf(element));
	ele.click();
	System.out.println(driver.getTitle());
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
