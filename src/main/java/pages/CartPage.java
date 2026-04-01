package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CartPage extends BasePage{
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "checkout")
	private WebElement checkout;
	
	public void clickCheckout() {
		checkout.click();
	}
}


