package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mp3PlayerPage extends AbstractPage {

	
	//Buttons
	@FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
	public WebElement buttonAddToCart;
	
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div/div[2]/div[1]/button[1]")
	public WebElement buttonAddToWishList;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/button")
	public WebElement buttonCartTotal;
	
	public Mp3PlayerPage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickSpecificProduct(String product) {
		driver.findElement(By.linkText(product)).click();
	}
	
	public void ClickAddToWishList() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();
	}
	
	public void ClickAddToCart() {
		buttonAddToCart.click();
	}
	
}
