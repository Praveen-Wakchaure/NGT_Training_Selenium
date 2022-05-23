package _8_explicit_and_implicit_waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class ImplicitExplicitAndFluentWait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Implicit Wait 
		 * - Useful when there is some gap in loading time of the web page and web elements
		 * - default setting is 0 (disabled)
		 * - polling frequency - 500ms
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("automation step by step" +Keys.ENTER);

		/* Explicit wait
		 * - Useful when you need to wait until some condition is met
		 * - Make WebDriver to wait until a certain condition is true
		 * - polling frequency - 500ms
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement myLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Automation Step by Step: Never Stop Learning ...")));
		myLink.click();

		/* Fluent wait
		 * - Similar to Explicit wait i.e. wait for a certain duration until a condition is met
		 * - Polling frequency can change as per need 
		 * - Can ignore any exception such as 'NpSuchElement' exception
		 */
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		WebElement myLink2 = fluentWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selenium")));
		myLink2.click();

		System.out.println("=====Successful=====");
		driver.quit();
	}

}
