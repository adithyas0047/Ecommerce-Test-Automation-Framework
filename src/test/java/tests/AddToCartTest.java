package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class AddToCartTest extends BaseTest{
	@Test
	public void addProductToCartTest() {
		LoginPage login = new LoginPage(driver);
		login.login("standard_user", "secret_sauce");
		
		InventoryPage inventory = new InventoryPage(driver);
		Assert.assertTrue(inventory.checkInventoryPage(), "Product page not displayed"); // checking whether we are on product/inventory page.
		inventory.addProduct();
		inventory.goToCart();
		
		// check whether we are on cart page
		Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page not opened");
	}
}
