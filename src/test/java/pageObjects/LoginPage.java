package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement urEmail;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement urPwd;
	@FindBy(xpath="//input[@value='Login']")
	WebElement lgn;
	
	public void entEmail(String email) {
		urEmail.sendKeys(email);
	}
	public void entPwd(String pwd) {
		urPwd.sendKeys(pwd);
	}
	public void clickLogin() {
		lgn.click();
	}
	
}
