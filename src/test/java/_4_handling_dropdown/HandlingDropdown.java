package _4_handling_dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get("https://trytestingthis.netlify.app");
		driver.manage().window().maximize();

		/*
		
		//Method 1 - selecting drop-down options using it's value
		
		//selecting one option from drop down
		Select dropOptions = new Select(driver.findElement(By.id("option"))) ;
		dropOptions.selectByValue("option 1");
		//Thread.sleep(2000);

		//selecting multiple options from table
		Select multiOptions = new Select(driver.findElement(By.name("Optionwithcheck[]")));
		multiOptions.selectByValue("option 1");
		multiOptions.selectByValue("option 2");
		//Thread.sleep(2000);
		 
		*/
		
		//Method 2- Making the list of drop-down options
		
		Select dropOptions1 = new Select(driver.findElement(By.id("option"))) ;
		List<WebElement> allOptions = dropOptions1.getOptions();
		driver.findElement(By.id("option"));
		
		for(WebElement option : allOptions) {
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("option 2"))
				option.click();
			Thread.sleep(2000);
		}
		
		//selection and de-selecting multiple options
		Select multiOptions = new Select(driver.findElement(By.name("Optionwithcheck[]")));
		multiOptions.selectByValue("option 1");
		Thread.sleep(1000);
		multiOptions.selectByValue("option 2");
		Thread.sleep(1000);
		multiOptions.selectByValue("option 3");
		Thread.sleep(2000);
		
		multiOptions.deselectByValue("option 3");
		Thread.sleep(2000);
		multiOptions.deselectByValue("option 1");
		Thread.sleep(2000);
		
		driver.quit();
	}

}
