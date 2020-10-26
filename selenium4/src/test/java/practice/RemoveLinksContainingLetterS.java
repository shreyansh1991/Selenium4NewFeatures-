package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Predicate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveLinksContainingLetterS {
	
public static void main(String[] args) {
	WebDriverManager.chromedriver().version("85.0.4183.87").setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.google.com/");
	driver.manage().window().maximize();
	Predicate<WebElement> predicateforNonEmptyLink=(l)->!l.getText().trim().isEmpty();
	Predicate<WebElement> predicateforNoS=(l)->!l.getText().trim().toLowerCase().contains("s");
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	allLinks.stream()
	.filter(predicateforNonEmptyLink.and(predicateforNoS))
	.forEach(link->System.out.println(link.getText()));
	
	
	
}
}

