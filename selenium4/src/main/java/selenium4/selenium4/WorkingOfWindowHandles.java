package selenium4.selenium4;
 
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
 
//import io.github.bonigarcia.wdm.WebDriverManager;
 
public class WorkingOfWindowHandles {
 
	public static void main(String[] args) throws InterruptedException {
 
		// Browser initialization
		/*
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + File.separator + "browser_exe" + File.separator +
		 * "chromedriver_latest.exe");
		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL+ "/MultipleWindows.html");
		// Clicking on Google
		driver.findElement(By.id("google")).click();
		Thread.sleep(4000);
		// Clicking on Facebook
		driver.findElement(By.id("facebook")).click();
		Thread.sleep(4000);
		// Clicking on Flipkart
		driver.findElement(By.id("flipkart")).click();
		Thread.sleep(4000);
		// Wait till we have total 4 windows
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(4));
		// Get all window handles
		Set<String> allHandles = driver.getWindowHandles();
		/*
		 * for (String s : allHandles) { driver.switchTo().window(s);
		 * System.out.println("Title is : " + driver.getTitle()); }
		 */
		Iterator < String > ite = allHandles.iterator();
	    int i = 1;
	    while (ite.hasNext() && i < 10) {
	        String popupHandle = ite.next().toString();
	        driver.switchTo().window(popupHandle);
	        System.out.println("Window title is : "+driver.getTitle());
	       // if (i == windowCount) break;
	        i++;
	    
	}

}
}
