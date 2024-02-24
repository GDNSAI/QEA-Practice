package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage {

	WebDriver driver;

	// passing driver to parent class BasePage
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//label[@class=\"forcheckbox\"]//preceding-sibling::input") WebElement genderLink;
	@FindBy(xpath = "//input[@id='FirstName']") WebElement firstNameLink;
	@FindBy(xpath = "//input[@id=\"LastName\"]") WebElement lastNameLink;
	@FindBy(xpath = "//select[@name=\"DateOfBirthDay\"]") WebElement dayLink;
	@FindBy(xpath = "//select[@name=\"DateOfBirthMonth\"]") WebElement monthLink;
	@FindBy(xpath = "//select[@name=\"DateOfBirthYear\"]") WebElement yearLink;
	@FindBy(xpath = "//input[@id='Email']") WebElement emailLink;
	@FindBy(xpath = "//input[@id=\"Company\"]") WebElement companyLink;
	@FindBy(xpath = "//input[@id='Password']") WebElement passwordLink;
	@FindBy(xpath = "//input[@id=\"ConfirmPassword\"]") WebElement confirmPasswordLink;
	@FindBy(xpath = "//input[@id=\"Newsletter\"]") WebElement checkBoxLink;
	@FindBy(xpath = "//button[@id='register-button']") WebElement registerButtonLink;
	@FindBy(xpath = "//div[@class=\"result\"]") WebElement confirmMsgLink;
	
	
	public void setGender() {
		genderLink.click();
	}
	
	public void setFirstName(String fname) {
	firstNameLink.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastNameLink.sendKeys(lname);
		}
	
	public void setEmail(String email) {
		emailLink.sendKeys(email);
		}
	
	public void clickDay(String i ) {
		Select drSelect=new Select(dayLink);
		drSelect.selectByVisibleText(i);
	}
	public void clickMonth(String i ) {
		Select drSelect=new Select(monthLink);
		drSelect.selectByVisibleText(i);
	}
	public void clickYear(String i ) {
		Select drSelect=new Select(yearLink);
		drSelect.selectByVisibleText(i);
	}
	public void setDayMonthYear(String day, String month,String Year) {
		clickDay(day);
		clickMonth(month);
		clickYear(Year);
	}
	
	public void setCompanyName(String cname) {
		companyLink.sendKeys(cname);
	}
	
	public void setPassword(String password) {
		passwordLink.sendKeys(password);
		}
	
	public void setConfirmPassword(String password) {
		confirmPasswordLink.sendKeys(password);
		}
	
	public void newsLetterCheckBoxLink() {
		checkBoxLink.click();
	}
	public void clickRegisterButton() {
		registerButtonLink.click();
	}
	
	
	
	public String getconfirmMsg() {
		try {
			return confirmMsgLink.getText();
		}catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	
}
