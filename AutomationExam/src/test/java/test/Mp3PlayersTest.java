package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.MainPage;
import page.Mp3PlayerPage;

public class Mp3PlayersTest extends AbstractTest {
	MainPage mainPage = new MainPage(driver);
	Mp3PlayerPage mp3page = new Mp3PlayerPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, 3);

	@Test
	public void Mp3Test() throws InterruptedException, IOException {
		List<String> data = TestData.getTestData("src/test/resources/testData.txt");

		mainPage.ClickMp3PlayersButton();

		for (String string : data) {
			if (driver.findElements(By.linkText(string)).size() != 0) {
				assertTrue(driver.findElement(By.linkText(string)).isDisplayed());
				mp3page.ClickSpecificProduct(string);
				mp3page.ClickAddToWishList();
				/*  Assert that message is shown that you must login to add to wishlist */
				assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]"))).isDisplayed());
				Thread.sleep(1000);
				mp3page.ClickAddToCart();
				/*  Assert that message is shown that you have succesfully added to cart */
				Thread.sleep(1000);
				assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]"))).isDisplayed());
				assertFalse(mp3page.buttonCartTotal.getText().equals("0 item(s) - $0.00"));
				
				mainPage.ClickMp3PlayersButton();
			} else {
				System.out.println(string + " does not exist");
			}

		}
	}

}
