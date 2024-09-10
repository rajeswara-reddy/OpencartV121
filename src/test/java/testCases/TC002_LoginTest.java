package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("***** Staring TC002_LoginTest *****");
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lg=new LoginPage(driver);
		
		lg.entEmail(pr.getProperty("email"));
		lg.entPwd(pr.getProperty("password"));
		lg.clickLogin();
		
		MyAccountPage Macc=new MyAccountPage(driver);
		
		boolean myacctarget=Macc.isMyAccountDisplayed();
		//Assert.assertEquals(myacctarget, true, "Login Failed");
		Assert.assertTrue(myacctarget);
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished TC002_LogingTest *****");
	}
	

}
