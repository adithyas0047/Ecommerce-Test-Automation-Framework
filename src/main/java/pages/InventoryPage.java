package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class InventoryPage extends BasePage{
	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='Products']")
	private WebElement title;
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addBackpack;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement cart;
	
	public boolean checkInventoryPage() {
		return title.isDisplayed();
	}
	
	public void addProduct() {
		addBackpack.click();
	}
	
	public void goToCart() {
		cart.click();
	}
}
