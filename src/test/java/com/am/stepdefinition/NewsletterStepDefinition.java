package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.am.pages.Newsletter;
import com.am.util.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewsletterStepDefinition {
	WebDriver driver;
	Newsletter newsletter;
	private static final Logger LOGGER = Logger.getLogger(NewsletterStepDefinition.class);

	public NewsletterStepDefinition() {
		driver = TestBase.driver;
		newsletter = new Newsletter(driver);
	}

	@When("User navigate newsletter page from left menu panel")
	public void user_navigate_newsletter_page_from_left_menu_panel() {
		try {
			newsletter.navigateNewsletterPageMenu();
			newsletter.verifyNewsletterPageHeading();
			newsletter.verifyBreakingNewslabel();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("User Verify to click on Subscribe button")
	public void user_verify_to_click_on_subscribe_button() throws InterruptedException {
		try {
			newsletter.selectBNSubscribeButton();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("User Verify Subscribe label change into Unsubscribe")
	public void user_verify_subscribe_label_change_into_unsubscribe() {
		try {
			newsletter.verifyUnsubscribeLabel();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("User Verify to click on Unsubscribe button")
	public void user_verify_to_click_on_unsubscribe_button() throws InterruptedException {
		try {
			newsletter.selectBNUnSubscribeButton();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("User Verify Unsubscribe label change back into Subscribe")
	public void user_verify_unsubscribe_label_change_back_into_subscribe() {
		try {
			newsletter.verifySubscribeLabel();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@When("User navigate newsletter page from dashboard home")
	public void user_navigate_newsletter_page_from_dashboard_home() {
		try {
			newsletter.navigateNewsletterPageDashboardLink();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}
}
