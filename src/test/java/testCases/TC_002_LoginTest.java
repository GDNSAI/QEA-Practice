package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"sanity","master"})
	public void verifyLogin() {
		try{
			logger.info("*** starting TC_002_LoginTest ***");
			logger.debug("Capturing application debug logs");
			
			HomePage home=new HomePage(driver);
			home.clickLoginLink();
			logger.info("clicked on Login Link");
			
			LoginPage lp=new LoginPage(driver);
			logger.info("Entering valid email and password");
			lp.setEmailLink(p.getProperty("email"));
			lp.setPasswordLink(p.getProperty("password"));
			lp.clickLoginButton();
			logger.info("clicked on login button");
			
			MyAccountPage map=new MyAccountPage(driver);
			
			if(map.isMyAccountPageExists()) {
				Assert.assertTrue(true);
				logger.info("Login Successful");
				map.clickLogout();
				logger.info("Logout Successful");
			}else {
				Assert.fail();
				logger.info("Login Failed");
			}
		}
		catch (Exception e) {
			logger.info("*** Finishing TC_002_LoginTest ***");
		}
		
		
		
		
		
	}
	
}
