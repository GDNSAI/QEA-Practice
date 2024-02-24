package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@class=\"ico-account\"]") WebElement accountHeadingLink;
	@FindBy(xpath = "//a[@class=\"ico-logout\"]") WebElement logOutLink;
	
	public boolean isMyAccountPageExists() {
		try {
			return accountHeadingLink.isDisplayed();
		}catch (Exception e) {
			return false;
					}
	}
	public void clickLogout() {
		logOutLink.click();
	}
	
}
