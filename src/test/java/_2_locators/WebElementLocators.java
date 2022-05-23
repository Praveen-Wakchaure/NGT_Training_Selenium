package _2_locators;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementLocators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get("http://google.com");
		driver.manage().window().maximize();
		
		//By.name()
		driver.findElement(By.name("q")).sendKeys("guru 99");
		Thread.sleep(2000);
		
		//By.className()
		driver.findElement(By.className("gNO89b")).click();
		Thread.sleep(2000);
		
		//By.partialLinkText
		driver.findElement(By.partialLinkText("Meet Guru99 – Free Training")).click();
		Thread.sleep(2000);
		
		//By.xpath()
		driver.findElement(By.xpath("//input[@id='gsc-i-id1']")).sendKeys("Selenium");
		Thread.sleep(2000);
		
		//By.cssSelector()
		
		//By.id()
		
		//By.linkText()
		
		//By.tagName()

	}

}
