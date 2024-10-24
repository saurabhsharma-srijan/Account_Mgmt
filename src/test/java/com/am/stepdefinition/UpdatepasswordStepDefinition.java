package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.am.pages.Updatepassword;
import com.am.util.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdatepasswordStepDefinition {
	WebDriver driver;
	Updatepassword updatepassword;
	private static final Logger LOGGER = Logger.getLogger(UpdatepasswordStepDefinition.class);

	public UpdatepasswordStepDefinition() {
		driver = TestBase.driver;
		updatepassword = new Updatepassword(driver);
	}

	@Then("User verify the labels in account access section")
	public void user_verify_the_labels_in_account_access_section() {
		try {
			updatepassword.verifyLabelsInAccountaccess();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}

	}

	@Then("User change valid password on account access section")
	public void user_change_valid_password_on_account_access_section() {
		try {
			updatepassword.verifyToChangeValidPassword();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify success message displayed after password update")
	public void user_verify_success_message_displayed_after_password_update() {
		try {
			updatepassword.verifySuccessMessageAfterPasswordUpdate();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);

		}

	}

	@Given("FE user login with email and old password")
	public void fe_user_login_with_email_and_old_password() {
		try {
			updatepassword.verifyLoginWithOldPassword();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("User should not able to login with old password")
	public void user_should_not_able_to_login_with_old_password() {
		try {
			updatepassword.verifyInvalidLoginAlertmessage();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Given("FE user login with email and new password")
	public void fe_user_login_with_email_and_new_password() {
		try {
			updatepassword.verifyLoginWithNewPassword();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("User should be able to login successfully with new password")
	public void user_should_be_able_to_login_successfully_with_new_password() {
		try {
			updatepassword.verifyAvtarIconAfterLogin();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("User updating back old password on account access section")
	public void user_updating_back_old_password_on_account_access_section() {
		try {
			updatepassword.verifyToUpdatingBackOldPassword();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}
}
