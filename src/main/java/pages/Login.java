 package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import base.BaseClass;

public class Login extends BaseClass{
	
	public Login() {
		initPageFactory(this);
	}
	
	@FindBy(id="user-name") 
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	@FindBy(xpath ="//div[@class='error-message-container error']")
	WebElement errormessage;

	public void enterUserName(String user) {
		username.sendKeys(user);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickLoginButton() {
		loginbutton.click();
	}
	
	public boolean isErrorMessageDisplayed() {
		return errormessage.isDisplayed();
		
		
	}
	
}
