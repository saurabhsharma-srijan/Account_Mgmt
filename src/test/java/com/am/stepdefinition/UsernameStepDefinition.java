package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.am.pages.Username;
import com.am.util.TestBase;

import io.cucumber.java.en.Then;

public class UsernameStepDefinition {
	WebDriver driver;
	Username username;
	private static final Logger LOGGER = Logger.getLogger(UsernameStepDefinition.class);

	public UsernameStepDefinition() {
		driver = TestBase.driver;
		username = new Username(driver);
	}

	@Then("user verify Username available on Account details page")
	public void user_verify_username_available_on_account_details_page() {
		try {
			username.verifyUsernameOnAccountdetail();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}
}
