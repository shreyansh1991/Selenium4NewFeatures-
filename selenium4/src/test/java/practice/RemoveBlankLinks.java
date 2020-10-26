package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Predicate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveBlankLinks {
public static void main(String[] args) {
	WebDriverManager.chromedriver().version("85.0.4183.87").setup();
	WebDriver driver = new ChromeDriver();
	// Create an object 'action'
	driver.get("http://www.google.com/");
	driver.manage().window().maximize();
	Predicate<WebElement> predicate=(l)->!l.getText().trim().isEmpty();
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	//allLinks.removeIf(predicate);
	allLinks.stream()
	.filter(predicate)
	.forEach(link->System.out.println(link.getText()));
	
	
	
}
}
