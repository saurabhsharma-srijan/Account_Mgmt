package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.am.pages.Personalinformation;
import com.am.util.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalinformationStepDefinition {
	WebDriver driver;
	Personalinformation personalinformation;
	private static final Logger LOGGER = Logger.getLogger(PersonalinformationStepDefinition.class);

	public PersonalinformationStepDefinition() {
		driver = TestBase.driver;
		personalinformation = new Personalinformation(driver);
	}

	@When("user navigate account detail page from left panel")
	public void user_navigate_account_detail_page_from_left_panel() {
		try {
			personalinformation.navigateAccountDetailMenu();
			personalinformation.verifyAccountDetailPageHeading();
			personalinformation.verifyPersonalInfoHeading();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify items available in Personal information section")
	public void user_verify_items_available_in_personal_information_section() {
		try {
			personalinformation.verifyPersonalInfoItems();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify edit-update Personal information section")
	public void user_verify_edit_update_personal_information_section() {
		try {
			personalinformation.verifyToUpdatePersonalInfo();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify success message display on personal info")
	public void user_verify_success_message_display_on_personal_info() {
		try {
			personalinformation.verifyUpdatePersonalInfoSuccessMessage();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user edit-updating the old data in Personal information section")
	public void user_edit_updating_the_old_data_in_personal_information_section() {
		try {
			personalinformation.verifyToUpdateOldDataPersonalInfo();
			personalinformation.verifyUpdatePersonalInfoSuccessMessage();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@When("user navigate account detail page from dashboard home")
	public void user_navigate_account_detail_page_from_dashboard_home() {
		try {
			personalinformation.navigateAccountDetailDashboardLink();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}
}
