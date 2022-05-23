package _5_handling_alerts_popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsAndPopups {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//JS alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("Alert text is: "+alert.getText());
		alert.accept();
		Thread.sleep(2000);
		
		if(driver.getPageSource().contains("You successfully clicked an alert"))
			System.out.println("You successfully clicked an alert");
		
		System.out.println("========================================================");
		
		//JS confirm
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Alert text is: "+alert1.getText());
		Thread.sleep(2000);
		alert1.dismiss();
		Thread.sleep(2000);
		
		if(driver.getPageSource().contains("You clicked: Cancel"))
			System.out.println("You clicked: Cancel");
		
		System.out.println("========================================================"); 
		
		//JS Pop-up
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Alert popUp = driver.switchTo().alert();
		popUp.sendKeys("okay");
		Thread.sleep(2000);
		popUp.accept();
		Thread.sleep(2000);
		
		if(driver.getPageSource().contains("You entered: okay"))
			System.out.println("You entered: okay");
		
		System.out.println("======= Successful =======");
		driver.quit();
	}

}
