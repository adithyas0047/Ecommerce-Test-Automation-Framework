package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest{
	@Test
	public void completeCheckoutTest() {
		LoginPage login = new LoginPage(driver);
		login.login("standard_user", "secret_sauce");
		
		InventoryPage inventory = new InventoryPage(driver);
		Assert.assertTrue(inventory.checkInventoryPage(), "Product page not displayed");
		inventory.addProduct();
		inventory.goToCart();
		
		CartPage cart = new CartPage(driver);
		cart.clickCheckout();
		
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.enterDetails("Adithya", "S", "1001");
		Assert.assertTrue(checkout.isOverviewPageDisplayed(), "Checkout overview page not displayed");
		checkout.finishOrder();
		Assert.assertEquals(checkout.getSuccessMessage(), "Thank you for your order!");
	}
}	
