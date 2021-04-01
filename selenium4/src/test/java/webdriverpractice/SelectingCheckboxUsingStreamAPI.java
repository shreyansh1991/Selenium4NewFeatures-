package webdriverpractice;

import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectingCheckboxUsingStreamAPI {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
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
