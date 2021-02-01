package practice;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectingCheckboxUsingStreamAPI {
public static void main(String[] args) {
	WebDriverManager.chromedriver().version("88.0.4324.96").setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
	AtomicInteger counter = new AtomicInteger();
	driver.findElements(By.xpath("//tbody/tr"))
    .stream()
    .peek(i->counter.incrementAndGet())
    .skip(1)
    .filter(webElement -> webElement.getText().contains("Male"))
    .map(e -> e.findElement(By.xpath("//tr["+counter+"]//input[@type='checkbox']")))
    .forEach(e->e.click());
    
}
}
