package webdriverpractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollTillTheBottom {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	Actions actions=new Actions(driver);
	actions.sendKeys(Keys.ESCAPE).perform();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	try {
	    long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
	    	System.out.println("Last Height - "+ lastHeight);
	    while (true) {
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(2000);

	        long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
	        if (newHeight == lastHeight) {
	            break;
	        }
	        lastHeight = newHeight;
	    }
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
}
}
