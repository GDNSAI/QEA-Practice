package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;


//Base cLass Methods are Reusable
public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"regression","master"})
	public void verifyAccountRegistration() {
		
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try {
			HomePage homePage = new HomePage(driver);
//			homePage.clickMyAccount();
			homePage.clickRegisterLink();
			logger.info("Click on clickRegisterLink");
			logger.info("Entering customer");
			AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
			accountRegistrationPage.setGender();
			accountRegistrationPage.setFirstName(randomeString(5));
			accountRegistrationPage.setLastName(randomeString(3));
			accountRegistrationPage.setDayMonthYear("10", "March", "2000");
			accountRegistrationPage.setEmail(randomeString(7) + "@gmail.com");
			accountRegistrationPage.setCompanyName(randomeString(8));
			String password=randomeAlphabeticNumber(5, 4);
			accountRegistrationPage.setPassword(password);
			accountRegistrationPage.setConfirmPassword(password);
			accountRegistrationPage.clickRegisterButton();
			String msg=accountRegistrationPage.getconfirmMsg();
			System.out.println(msg);
			if(msg.equals("Your registration completed")) {
				logger.info("Success message matched");
				Assert.assertTrue(true);
			}else {
				Assert.fail();
				logger.info("Success message did not matched");
			}
			
			logger.info("*** Finishing TC_001_AccountRegistrationTest ***");
			
		}
		catch (Exception e) {
			logger.error("TC_001_AccountRegistrationTest Failed...");
			Assert.fail();
		}
		

	}

}
