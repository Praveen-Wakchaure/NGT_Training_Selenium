package _3_working_on_controls;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckboxesRadioButtonsDropdownsTableCalendar {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get("https://trytestingthis.netlify.app");
		driver.manage().window().maximize();
		
		//Text box input
		driver.findElement(By.id("fname")).sendKeys("Harry");
		//Thread.sleep(2000);
		driver.findElement(By.name("lname")).sendKeys("Potter");
		//Thread.sleep(2000);
		
		//checking radio button
		driver.findElement(By.id("male")).click();
		//Thread.sleep(2000);
		
		//selecting one option from drop down
		Select drpOptions = new Select(driver.findElement(By.id("option"))) ;
		drpOptions.selectByValue("option 1");
		//Thread.sleep(2000);
		
		//selecting multiple options from table
		Select multiOptions = new Select(driver.findElement(By.name("Optionwithcheck[]")));
		multiOptions.selectByValue("option 1");
		multiOptions.selectByValue("option 2");
		//Thread.sleep(2000);
		
		
		//checking check-box
		WebElement checkkBox = driver.findElement(By.name("option3"));
		checkkBox.click();
		//Thread.sleep(2000);
	
		//selecting data from data-list
		driver.findElement(By.xpath("//body/div[3]/div[2]/form[1]/fieldset[1]/input[9]")).sendKeys("Vanilla");
		Thread.sleep(2000);
		
		//selecting date from calendar
		WebElement dateBox = driver.findElement(By.id("day"));
		dateBox.sendKeys("18071998"); //dd-MM-yyyy
		Thread.sleep(4000);
		
		System.out.println("...Successful...");
		driver.quit();
	}
}
