package _6_commonly_used_commands;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		driver.get("http://google.com");
		String originalWindow = driver.getWindowHandle();
		//driver.navigate().to("https://automationstepbystep.com");
		
		//get URL
		System.out.println("Current URL is: "+driver.getCurrentUrl());
		
		//get Title
		System.out.println("Title of the URL is: "+driver.getTitle());
		
		//Window Management
		  driver.manage().window().maximize();
		//Thread.sleep(3000);
		//driver.manage().window().minimize();
		//driver.manage().window().fullscreen();
		
		/*
		 
		//Navigations
		driver.navigate().back();
		//Thread.sleep(2000);
		driver.navigate().forward();
		//Thread.sleep(2000);
		driver.navigate().refresh();
		//Thread.sleep(2000);
		*/
		
		
		/*
	
		//Switching Windows
		driver.switchTo().window(originalWindow);
		
		//open new window and switch to the window
		driver.switchTo().newWindow(WindowType.WINDOW);
		//Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.TAB);
		//Thread.sleep(2000);
		 
		*/
		
		//getting window size and Setting size
		Dimension size = driver.manage().window().getSize();
		System.out.println("Window Width is: "+size.getWidth());
		System.out.println("Window Height is: "+size.getHeight());
		
		//driver.manage().window().setSize(new Dimension(800, 800));
		//Thread.sleep(3000);
		
		//Taking screenshot of whole page
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("./screenshot/image1.png"));
		
		//Taking screenshot of web element
		
		WebElement element = driver.findElement(By.className("lnXdpd"));
		File srcfile1 = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile1, new File("./screenshot/image2.png"));
		
		
		driver.quit();
	}

}
