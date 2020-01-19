package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DesktopsPage extends AbstractPage {
	
	

	public DesktopsPage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickSpecificProduct(String product) {
		driver.findElement(By.xpath("//img[@title='" + product +"']")).click();
	}
	
	public void addToCartSpecificProduct(String product) {
		driver.findElement(By.xpath("//div[contains(@class, 'product-thumb') " + "and contains(.//h4, '" + product
				+ "')]//button[contains(.//span, 'Add to Cart')]")).click();
	}

}
