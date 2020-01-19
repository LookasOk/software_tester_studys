package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
	
	//Buttons
	@FindBy(id="button-cart")
	WebElement buttonAddToCart;

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickAddToCart() {
		buttonAddToCart.click();
	}
}
