package _7_handlingwebtables_frames_dynamicelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		
		//Switching to frame
		driver.switchTo().frame("packageFrame");
		
		driver.findElement(By.className("interfaceName")).click();
		//Thread.sleep(3000);
		
		//Switching to default contain
		driver.switchTo().defaultContent();
		//Thread.sleep(3000);
		
		System.out.println("=====Successful======");
		driver.quit();
	}

}
