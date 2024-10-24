package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.am.pages.Newspaperdeliveryissue;
import com.am.util.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewspaperdeliveryissueStepDefinition {
	WebDriver driver;
	Newspaperdeliveryissue newspaperdeliveryissue;
	private static final Logger LOGGER = Logger.getLogger(NewspaperdeliveryissueStepDefinition.class);

	public NewspaperdeliveryissueStepDefinition() {
		driver = TestBase.driver;
		newspaperdeliveryissue = new Newspaperdeliveryissue(driver);
	}

	@When("user navigate newspaper self service page from dashboard home")
	public void user_navigate_newspaper_self_service_page_from_dashboard_home() {
		try {
			newspaperdeliveryissue.navigateNewspaperPageDashboardLink();
			newspaperdeliveryissue.verifyNewspaperPageHeading();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify to Report delivery issue on newspaper self service page")
	public void user_verify_to_report_delivery_issue_on_newspaper_self_service_page() {
		try {
			newspaperdeliveryissue.selectDeliveryIssueButton();
			newspaperdeliveryissue.selectIssueDate();
			newspaperdeliveryissue.selectDeliveryIssue();
			newspaperdeliveryissue.deliveryIssueSubmit();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify success message displaying for report delivery issue")
	public void user_verify_success_message_displaying_for_report_delivery_issue() {
		try {
			newspaperdeliveryissue.checkDeliveryIssueSuccessMessage();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

}
