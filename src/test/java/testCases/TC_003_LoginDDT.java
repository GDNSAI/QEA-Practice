package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	//from DataProviders "LoginData" data are coming and we are mentioning the name of the class by dataProviderClass = DataProviders.class 
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	
	public void verifyLoginDDT(String email, String password, String expectedResult) {

		logger.info("*** Starting TC_003_LoginDDT ***");
		try {
			logger.debug("Capturing application debug logs");

			HomePage home = new HomePage(driver);
			home.clickLoginLink();
			logger.info("clicked on Login Link");

			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password");
			lp.setEmailLink(email);
			lp.setPasswordLink(password);
			lp.clickLoginButton();
			logger.info("clicked on login button");

			MyAccountPage map = new MyAccountPage(driver);

			boolean targetPage = map.isMyAccountPageExists();

			if (expectedResult.equalsIgnoreCase("Valid")) {

				if (targetPage) {
					map.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (expectedResult.equalsIgnoreCase("Invalid")) {

				if (targetPage) {
					map.clickLogout();
					Assert.assertTrue(false);//invalid data should not logout
				} else {
					Assert.assertTrue(true);
				}
			}
			logger.info("*** Finished TC_003_LoginDDT ***");
		}catch (Exception e) {
			logger.info("*** Failed TC_003_LoginDDT ***");
			Assert.fail();
			
		}
		

	}

}
