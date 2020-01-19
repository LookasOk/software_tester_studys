package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.MainPage;
import page.RegisterFormPage;

public class CreateAccoountTest extends AbstractTest {
	MainPage mainPage = new MainPage(driver);
	RegisterFormPage regPage = new RegisterFormPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, 5);

	@Test
	public void createAccountTest() throws InterruptedException {
		mainPage.ClicMyAccountButton();
		mainPage.ClicRegisterButton();
		regPage.FillFormWithRandomEmail();

		assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("content")),
				"Your Account Has Been Created!")));

		//Thread.sleep(5000);

		regPage.ClickContinue();
		regPage.ClickEditAccInfo();

		//Thread.sleep(5000);

		assertTrue(driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value").equalsIgnoreCase("Lukas"));
		assertTrue(driver.findElement(By.xpath("//input[@name='lastname']")).getAttribute("value").equalsIgnoreCase("Okas"));
		assertTrue(driver.findElement(By.xpath("//input[@name='telephone']")).getAttribute("value").equalsIgnoreCase("+370123456"));

		//Thread.sleep(3000);
	}

}
