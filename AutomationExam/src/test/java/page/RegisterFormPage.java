package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterFormPage extends AbstractPage {
	
	
	
	/* BUTTONS */
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement buttonContinue;
	
	public RegisterFormPage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickContinue() {
		this.buttonContinue.click();
	}
	
	public void ClickEditAccInfo() {
		driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).click();
	}
	
	public void FillFormWithRandomEmail() {
		Random r = new Random();
		String str = "";
		for (int i = 0; i < 6; i++) {
			str += (char) (r.nextInt(25) + 97);
		}
		driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Lukas");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Okas");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(str + "@qwer.com");
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("+370123456");
		driver.findElement(By.xpath("//input[@name='fax']")).sendKeys("+370123456");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Best IT solutions");
		driver.findElement(By.xpath("//input[@name='address_1']")).sendKeys("gatve 1-10");
		driver.findElement(By.xpath("//input[@name='address_2']")).sendKeys("gatve 1-11");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Vilnius");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("LT-01105");
		Select country = new Select(driver.findElement(By.id("input-country")));
		country.selectByValue("123");
		Select state = new Select(driver.findElement(By.id("input-zone")));
		state.selectByValue("1920");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

}
