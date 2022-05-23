package _a10_accessing_test_data_from_excel;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProviderTest {

	WebDriver driver =null;
	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(dataProvider = "testData1")
	public void testTitle(String username, String password) {
		System.out.println(username+" |"+password);
		
		driver.get("https://demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		String title = driver.getTitle();
		String actualTitle = "Guru99 Bank Manager HomePage";
		assertEquals(title, actualTitle);
		driver.quit();
		}

	@DataProvider(name = "testData1")
	public static Object[][] getData() throws IOException {
		String projectPath = System.getProperty("user.dir");
		Object data[][] = testData(projectPath+"/excel/data.xlsx", "Sheet1");
		return data;
	}

	public static Object[][] testData(String excelPath, String sheetName) throws IOException {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();

		Object data [][] = new Object[rowCount-1][colCount]; //Subtracting header row

		for (int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {

				String cellData =  excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j]=cellData;
			}
			System.out.println();
		}
		return data;
	}
}
