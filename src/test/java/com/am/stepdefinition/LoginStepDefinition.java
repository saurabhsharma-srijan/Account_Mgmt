package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import com.am.pages.Login;
import com.am.util.TestBase;
import io.cucumber.java.en.*;

public class LoginStepDefinition {
	WebDriver driver;
	public Login login;
	private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class);

	public LoginStepDefinition() {
		driver = TestBase.driver;
		login = new Login(driver);
	}

	@Given("User validate login application")
	public void user_validate_login_application() {
		try {
			login.enters_username();
			login.enters_pswd();
			login.selectsignIn();
			login.selectloginbutton();
			login.verifyAvtarIcon();
			System.out.println("login the application successfully");
			System.out.println("test passed for user_validate_login_application");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("User navigate to Homepage")
	public void user_navigate_to_homepage() {
		try {
			login.verifyAvtarIcon();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}
}