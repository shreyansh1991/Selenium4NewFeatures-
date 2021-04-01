package webdriverpractice;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4NewWindow {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "browser_exe"
				+ File.separator + "chromedriver_latest.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true"); 
		WebDriver driver = new ChromeDriver();
		System.out.println("Driver => " + driver);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Selenium 4 features" + Keys.ENTER);
		String windowHandle = driver.getWindowHandle();
		System.out.println(" windowHandle ==>" + windowHandle);
		driver.switchTo().newWindow(WindowType.TAB);
		

		String windowHandle2 = driver.getWindowHandle();
		System.out.println(" windowHandle2 ==>" + windowHandle2);

		driver.get("https://www.facebook.com");
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("demo12345678");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		driver.switchTo().window(windowHandle);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("Java 8 features" + Keys.ENTER);
	}
}
