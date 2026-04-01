package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver; // protected --> allows any class to extend BasePage class and driver instance directly, but keeps it hidden from unrelated classes.
	
	// POM Class Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver; // for navigating to URL
		PageFactory.initElements(driver, this); // used for @FindBy (initializes all web elements prior the method)
	}
	
	
}
