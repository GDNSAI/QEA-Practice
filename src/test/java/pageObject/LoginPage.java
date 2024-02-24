package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy (xpath = "//input[@id=\"Email\"]") WebElement emailLink;
	@FindBy (xpath = "//input[@id=\"Password\"]") WebElement passwordLink;
	@FindBy (xpath = "//button[@class=\"button-1 login-button\"]") WebElement buttonLink;
	
	public void setEmailLink(String email) {
		emailLink.sendKeys(email);
	}
	public void setPasswordLink(String pass) {
		passwordLink.sendKeys(pass);
	}
	public void clickLoginButton() {
		buttonLink.click();
	}

}
