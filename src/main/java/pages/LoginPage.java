package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage { // inheriting BasePage
	public LoginPage(WebDriver driver) {
		super(driver); // calling constructor of BasePage (PageFactory.initElement is trigger here)
	}
	
	@FindBy(id = "user-name")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	@FindBy(xpath = "//h3[@data-test = 'error']")
	private WebElement errorMessage;
	
	public void login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
