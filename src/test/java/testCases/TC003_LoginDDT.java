package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	public void verify_loginddt(String email, String pwd, String exp) {
		
		logger.info("***** Starting TC003_LoginDDT ***");
		try {
        HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lg=new LoginPage(driver);
		
		lg.entEmail(email);
		lg.entPwd(pwd);
		lg.clickLogin();
		
		MyAccountPage Macc=new MyAccountPage(driver);
		
		boolean myacctarget=Macc.isMyAccountDisplayed();
		//Assert.assertEquals(myacctarget, true, "Login Failed");
		Assert.assertTrue(myacctarget);
		
		if (exp.equalsIgnoreCase("valid")) {
			if(myacctarget==true) {
				Macc.clicklogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(myacctarget==true) {
				Macc.clicklogout();
				Assert.assertTrue(false);
			}
		}
		else {
			Assert.assertTrue(true);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC003_LoginDDT *****");
		
	}

}

