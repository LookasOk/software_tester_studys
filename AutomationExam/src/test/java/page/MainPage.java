package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
	WebDriverWait wait = new WebDriverWait(driver, 2);

	/* BUTTONS */
	@FindBy(xpath = "//a[contains(text(),'Desktops')]")
	private WebElement buttonDesktops;
	
	@FindBy(xpath = "//a[contains(text(),'MP3 Players')]")
	private WebElement buttonMp3Players;

	// only accessible after clicking "cart total"
	@FindBy(xpath = "//Button[@title='Remove']")
	private WebElement removeFromCart;

	@FindBy(id = "cart-total")
	private WebElement buttonCartTotal;
	
	@FindBy(xpath = "//div[@id='top-links']//a[@title='My Account']")
	private WebElement buttonMyAccount;
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement buttonAccountRegister;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void ClickButtonDesktops() {
		buttonDesktops.click();
	}

	public void ClickButtonCartTotal() {
		buttonCartTotal.click();
	}

	// only accessible after clicking "cart total"
	public void ClickRemoveFromCart() {
		removeFromCart.click();
	}

	public void WaitCartTotal() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart-total")));
	}

	public String CartTotalGetText() {
		return this.buttonCartTotal.getText();
	}
	
	public void ClicMyAccountButton() {
		this.buttonMyAccount.click();
	}
	
	public void ClicRegisterButton() {
		this.buttonAccountRegister.click();
	}
	
	public void ClickMp3PlayersButton() {
		buttonMp3Players.click();
	}

}
