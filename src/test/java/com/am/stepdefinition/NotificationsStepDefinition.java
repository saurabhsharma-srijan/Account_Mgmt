package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.am.pages.Notifications;
import com.am.util.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationsStepDefinition {
	WebDriver driver;
	Notifications notifications;
	private static final Logger LOGGER = Logger.getLogger(NotificationsStepDefinition.class);

	public NotificationsStepDefinition() {
		driver = TestBase.driver;
		notifications = new Notifications(driver);
	}

	@When("user navigate Notifications page")
	public void user_navigate_notifications_page() {
		try {
			notifications.navigateNotificationsPage();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify Notifications menu is highlighted")
	public void user_verify_notifications_menu_is_highlighted() {
		try {
			notifications.menuHighlighted();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}

	}

	@Then("user verify page heading")
	public void user_verify_page_heading() {
		try {
			notifications.NotificationsPageHeading();
		}

		catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user select Notifications checkbox")
	public void user_select_notifications_checkbox() {
		try {
			notifications.selectNotificationsCheckbox();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify success message display")
	public void user_verify_success_message_display() {
		try {
			notifications.verifySuccessMessage();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}
}
