package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractTest {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("http://akademijait.vtmc.lt/opencartone/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
