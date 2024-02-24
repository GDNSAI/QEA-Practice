package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage{
	WebDriver driver;
	
	//passing driver to parent class BasePage
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	
	
	@FindBy(xpath = "//a[text()='Register']") WebElement registerLink;
	@FindBy(xpath = "//a[text()='Log in']") WebElement loginLink;
	

	
//	public void clickMyAccount() {
//		myAccountLink.click();
//	}
	
	public void clickRegisterLink() {
		registerLink.click();
	}
	public void clickLoginLink() {
		loginLink.click();
	}
}
