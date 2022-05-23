package _9_exception_handling;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("automation step by step" +Keys.ENTER);

		try {	
			WebElement myLink = driver.findElement(By.partialLinkText("Hello..."));
			myLink.click();
		} catch (Exception e) {
			System.out.println("Element not found...");
			//e.printStackTrace();
			//e.toString();
			//e.getMessage();
		}
		finally {
			System.out.println("=====Successful=====");
			driver.quit();
		}	
	}
}
