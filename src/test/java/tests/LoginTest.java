package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	@Test
	public void validateLogin() {
		LoginPage login = new LoginPage(driver);
		login.login("standard_user", "secret_sauce");
		
		InventoryPage inventory = new InventoryPage(driver);
		Assert.assertTrue(inventory.checkInventoryPage(), "Login Failed!");
	}
	
	@Test
	public void invalidLoginTest() {
		LoginPage login = new LoginPage(driver);
		login.login("asdfa", "asdfa");
		
		Assert.assertTrue(login.getErrorMessage().contains("Epic sadface: Username and password do not match any user in this service"));
	}
}
