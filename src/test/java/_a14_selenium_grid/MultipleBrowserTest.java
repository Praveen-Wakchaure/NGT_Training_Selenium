package _a14_selenium_grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowserTest {

	WebDriver driver;

	@Parameters("browserType")
	@Test
	public void invokeBrowser(String browserType) throws MalformedURLException
	{

		URL remoteURL = new URL("http://192.168.164.170:4455/wd/hub");

		if(browserType.equals("chrome"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();

			driver = new RemoteWebDriver(remoteURL, chromeOptions);
		}
		else if (browserType.equals("firefox"))
		{
			FirefoxOptions ffOption = new FirefoxOptions();
		
			driver = new RemoteWebDriver(remoteURL, ffOption);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("http://test.qatechhub.com");
		System.out.println(driver.getTitle());
		
		
		driver.quit();
	}

}
