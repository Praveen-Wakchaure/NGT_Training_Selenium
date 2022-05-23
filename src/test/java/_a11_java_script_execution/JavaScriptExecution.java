package _a11_java_script_execution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecution {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		driver.get("http://google.com");
		driver.manage().window().maximize();
		
		//Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Get return value from script
		WebElement button = driver.findElement(By.name("btnI"));
		js.executeScript("arguments[0].click();", button);
		
		//Execute JS directly
		js.executeScript("console.log('Hello World...')");
		
		//driver.close();
		driver.quit();
		
	}
	


}
