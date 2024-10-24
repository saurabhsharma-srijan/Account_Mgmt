package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.am.pages.Newspapertemporarystop;
import com.am.util.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewspapertemporarystopStepDefinition {
	WebDriver driver;
	Newspapertemporarystop newspapertemporarystop;
	private static final Logger LOGGER = Logger.getLogger(NewspapertemporarystopStepDefinition.class);

	public NewspapertemporarystopStepDefinition() {
		driver = TestBase.driver;
		newspapertemporarystop = new Newspapertemporarystop(driver);
	}

	@When("user navigate newspaper self service page from left menu panel")
	public void user_navigate_newspaper_self_service_page_from_left_menu_panel() {
		try {
			newspapertemporarystop.navigateNewspaperPageMenu();
			newspapertemporarystop.verifyNewspaperPageHeading();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify to Create temporary stop on newspaper self service page")
	public void user_verify_to_create_temporary_stop_on_newspaper_self_service_page() {
		try {
			newspapertemporarystop.selectCreateTemporaryStop();
			newspapertemporarystop.selectStopDeliverDate();
			newspapertemporarystop.selectRestartDeliverDate();
			newspapertemporarystop.selectSaveButton();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify success message displaying for created a temporary stop")
	public void user_verify_success_message_displaying_for_created_a_temporary_stop() {
		try {
			newspapertemporarystop.tempStopSuccessMessage();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify to delete temporary stop on newspaper self service page")
	public void user_verify_to_delete_temporary_stop_on_newspaper_self_service_page() {
		try {
			newspapertemporarystop.deleteTempStopSection();
			newspapertemporarystop.selectDeleteButton();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify success message displaying for deleted a temporary stop")
	public void user_verify_success_message_displaying_for_deleted_a_temporary_stop() {
		try {
			newspapertemporarystop.deleteTempStopSuccessMessage();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

}
