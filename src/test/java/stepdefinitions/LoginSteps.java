package stepdefinitions;

import org.openqa.selenium.By;



import base.BaseClass;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.Login;

public class LoginSteps extends BaseClass {

	Login LoginPageObj = new Login();

	@Given("user is on Login Page")
	public void user_is_on_Login_Page() {


	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password(){
		LoginPageObj.enterUserName(prop.getProperty("username"));
		LoginPageObj.enterPassword(prop.getProperty("password"));
		LoginPageObj.clickLoginButton();


	}
	@Then("user should able to log in successfully")
	public void user_should_able_to_log_in_successfully(){

		boolean islogovisible = driver.findElement(By.className("app_logo")).isDisplayed();
		String Title = driver.findElement(By.className("app_logo")).getText();
		Assert.assertTrue(islogovisible);

		System.out.println(Title);
		System.out.println("Entered valid Credential");


	}
	@When("user enters invalid username and password")
	public void user_enters_invalid_username_and_password(){
		LoginPageObj.enterUserName(prop.getProperty("WrongUsername"));
		LoginPageObj.enterPassword(prop.getProperty("WrongPassword"));
		LoginPageObj.clickLoginButton();
		System.out.println("Entered Invalid Credential");

	}
	@Then("error must be displayed")
	public void error_must_be_displayed(){
		String message = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
		

		boolean ErrorMessageDisplayed = LoginPageObj.isErrorMessageDisplayed();
		
	
		Assert.assertTrue(ErrorMessageDisplayed);

		System.out.println("Error Message Displayed succcessfully" +" Which is"+message);



	}



}

