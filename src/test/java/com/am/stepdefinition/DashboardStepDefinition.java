package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.am.pages.Dashboard;
import com.am.util.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardStepDefinition {
	WebDriver driver;
	Dashboard dashboard;
	private static final Logger LOGGER = Logger.getLogger(DashboardStepDefinition.class);

	public DashboardStepDefinition() {
		driver = TestBase.driver;
		dashboard = new Dashboard(driver);
	}

	@When("user navigate dashboard home page")
	public void user_navigate_dashboard_home_page() {
		try {
			dashboard.navigateDashboardPage();
			dashboard.menuHighlighted();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify dashboard menu is highlighted")
	public void user_verify_dashboard_menu_is_highlighted() {
		try {
			dashboard.menuHighlighted();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify Newspaper self service block")
	public void user_verify_newspaper_self_service_block() {
		try {
			dashboard.verfiyNewspaperSection();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify Account Details block")
	public void user_verify_account_details_block() {
		try {
			dashboard.verfiyAccountDetailSection();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify Newsletters block")
	public void user_verify_newsletters_block() {
		try {
			dashboard.verfiyNewslettersSection();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}
}
