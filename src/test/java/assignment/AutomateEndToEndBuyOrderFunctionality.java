package assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomateEndToEndBuyOrderFunctionality {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

		//1. Open link http://automationpractice.com/index.php

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		//Thread.sleep(2000);

		//2. Login to the web-site.

		driver.findElement(By.className("login")).click();
		//Thread.sleep(2000);

		//Move your cursor over Women's link.
		Actions action = new Actions(driver);
		WebElement womenLink = driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]"));
		action.moveToElement(womenLink).perform();
		Thread.sleep(1000);

		//4. Click on sub menu 'T-shirts'.

		driver.findElement(By.linkText("T-shirts")).click();
		//Thread.sleep(1000);

		//5. Mouse hover on the second product displayed.
		WebElement product = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
		action.moveToElement(product).perform();
		//Thread.sleep(2000);

		//6. 'More' button will be displayed, click on 'More' button.
		driver.findElement(By.linkText("More")).click();
		//Thread.sleep(1000);

		//7. Increase quantity to 2.

		//driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[2]/p[1]/a[2]/span[1]/i[1]")).click();
		driver.findElement(By.className("icon-plus")).click();
		//WebElement quantity = driver.findElement(By.id("quantity_wanted"));
		//		quantity.clear();
		//		quantity.sendKeys("2");
		//Thread.sleep(2000);

		//8. Select size 'L'
		WebElement size = driver.findElement(By.id("group_1"));
		Select selectObj = new Select(size);
	    selectObj.selectByValue("3");
	    //Thread.sleep(2000);
	    
	    //9. Select colour.
	    driver.findElement(By.id("color_14")).click();
	    //Thread.sleep(2000);
	    
	    //10. Click 'Add to Cart' button.
	    driver.findElement(By.id("add_to_cart")).click();
	    //Thread.sleep(2000);
	    
	    //11. Click 'Proceed to checkout' button.
	    
	    WebElement checkout = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]"));
	    checkout.click();
	    //Thread.sleep(2000);
	    WebElement checkout2 = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]"));
	    checkout2.click();
	    Thread.sleep(3000);

	    System.out.println("======== Automation Successful ========");
		driver.close();
	}

}
