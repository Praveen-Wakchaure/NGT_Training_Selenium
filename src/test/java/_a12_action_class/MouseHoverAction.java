package _a12_action_class;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		//driver.manage().window().maximize();
		
		WebElement boxA = driver.findElement(By.xpath("//li[contains(text(),'A')]"));
		WebElement boxC = driver.findElement(By.xpath("//li[contains(text(),'C')]"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(boxA);
		actions.clickAndHold();
		actions.moveToElement(boxC);
//		actions.contextClick(boxC);
//		actions.doubleClick(boxC);
		
		actions.build().perform();
		Thread.sleep(3000);
		
		driver.quit();
		System.out.println("===Successful===");
	}

}
