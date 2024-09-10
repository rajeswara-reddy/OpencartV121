package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistraionTest extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() {
		try {
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("** Clicked MyAccount Link **");
		
		hp.clickRegister();
		logger.info("** Clicked Register Link **");
		
		
		RegistrationPage rg=new RegistrationPage(driver);
		
		logger.info("*** Providing Customer Details ***");
		rg.setFirstName(randomString().toUpperCase());
		rg.setLastName(randomString().toUpperCase());
		rg.setEmail(randomString().toUpperCase()+"@gmail.com");
		rg.setTelephone(randomNumeric());
		String pwd=randomString()+"@"+randomNumeric();
		rg.setPassword(pwd);
		rg.setCpassword(pwd);
		rg.setPrivacy();
		rg.clickContinue();
		
		logger.info("*** Validating Expected Message ***");
		String msg=rg.getConfirmationmsg();
		
		if(msg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed..");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(msg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			Assert.fail();
			
		}
	}
	
	

}
