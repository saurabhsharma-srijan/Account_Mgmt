package com.am.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.am.pages.MiniPanel;
import com.am.util.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MiniPanelStepDefinition {
	WebDriver driver;
	public MiniPanel panel;
	LoginStepDefinition loginstepdef;
	private static final Logger LOGGER = Logger.getLogger(MiniPanelStepDefinition.class);

	public MiniPanelStepDefinition() {
		driver = TestBase.driver;
		panel = new MiniPanel(driver);
	}

	@Given("FE user is able to login to FrontEnd")
	public void fe_user_is_able_to_login_to_FrontEnd() {
		try {
			loginstepdef = new LoginStepDefinition();
			loginstepdef.user_validate_login_application();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@When("user open minipanel")
	public void user_open_minipanel() {
		try {
			panel.selectavtar();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify Kia Ora")
	public void user_verify_kia_ora() {
		try {
			panel.kiaOraVisible();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify your account label")
	public void user_verify_your_account_label() {
		try {
			panel.yourAccountVisible();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Then("user verify logout label")
	public void user_verify_logout_label() {
		try {
			panel.logoutVisible();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@And("verify your account link navigation")
	public void verify_your_account_link_navigation() {
		try {
			panel.selectAccountMinipanel();
			panel.yourAccountTitleVisible();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	//// Verify the logout on minipanel

	@Then("User validate logout application")
	public void User_validate_logout_application() {
		try {
			panel.selectLogout();
			panel.loginbuttonVisible();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOGGER.info(e);
		}
	}
}
