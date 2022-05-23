package _7_handlingwebtables_frames_dynamicelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicElement {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		
		//1. Absolute Path method
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[5]/a[1]/img[1]")).click();
//		Thread.sleep(3000);
		
		//2.Use Relative XPath using contains or starts with text
//		driver.findElement(By.xpath("//body/div[1]/section[1]/div[2]/div[1]/div[1]/div[5]/a[1]/img[1]")).click();
//		Thread.sleep(3000);
		
		//3.Identify by index
		driver.findElement(By.id("rb_slide_8080")).click();
		Thread.sleep(3000);
		
		System.out.println("=====Successful=====");
		driver.quit();
		
	}

}
