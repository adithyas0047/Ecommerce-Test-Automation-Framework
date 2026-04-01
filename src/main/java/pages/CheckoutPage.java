package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class CheckoutPage extends BasePage{
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "first-name")
	private WebElement firstname;
	
	@FindBy(id = "last-name")
	private WebElement lastname;
	
	@FindBy(id = "postal-code")
	private WebElement postCode;
	
	@FindBy(id = "continue")
	private WebElement continueButton;
	
	@FindBy(className = "summary_info") 
	private WebElement overviewPage;
	
	@FindBy(id = "finish")
	private WebElement finishButton;
	
	@FindBy(className = "complete-header")
	private WebElement successMessage;
	
	public void enterDetails(String fn, String ln, String code) {
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		postCode.sendKeys(code);
		continueButton.click();
	}
	
	public boolean isOverviewPageDisplayed() {
		return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(overviewPage)).isDisplayed();
	}
	
	public void finishOrder() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(finishButton));
		finishButton.click();
	}
	
	public String getSuccessMessage() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText();
	}
}
