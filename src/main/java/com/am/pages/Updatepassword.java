package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class Updatepassword extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(xpath = "//div[normalize-space()='Account access']")
	WebElement accountAccessHeading;

	@FindBy(xpath = "// span[normalize-space()='Email address']")
	WebElement emailLabel;

	@FindBy(xpath = "//span[normalize-space()='Password']")
	WebElement passwordLabel;

	@FindBy(xpath = "//button[@id='emailChange']")
	WebElement emailChangelink;

	@FindBy(xpath = "//button[@id='passwordChange']")
	WebElement passwordChangelink;

	@FindBy(xpath = "//input[@name='old_password']")
	WebElement oldPasswordfield;

	@FindBy(xpath = "//input[@name='new_password']")
	WebElement newPasswordfield;

	@FindBy(xpath = "//input[@class='save-pwd-edit button js-form-submit form-submit btn btn-primary button-acmt form-control']")
	WebElement passwordSavebutton;

	@FindBy(xpath = "//div[@aria-label='Status message']")
	WebElement successMessagePasswordUpdate;

	@FindBy(xpath = "//div[@id='api']/form[@id='localAccountForm']/div[@role='alert']/p")
	WebElement invalidLoginAlert;

	@FindBy(xpath = "//div[@class='invalid-feedback']")
	WebElement passwordFieldValidation;

	@FindBy(id = "edit-openid-connect-client-stuff-azure-adb2c-login")
	public WebElement loginScreenButton;

	@FindBy(xpath = "//input[@name='Email address']")
	public WebElement emailField;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordField;

	@FindBy(xpath = "//button[@id='next']")
	public WebElement logInButton;

	@FindBy(xpath = "//div[@class='user-avatar dropdown-toggle']")
	public WebElement avtarIcon;

	@FindBy(id = "edit-openid-connect-client-stuff-azure-adb2c-login")
	public WebElement topLogin;

	// to initialize the page objects
	public Updatepassword(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:
	public void verifyLabelsInAccountaccess() {
		visibiltyOfElement(20, accountAccessHeading);
		assertPresenceOfElement(accountAccessHeading);
		assertPresenceOfElement(emailLabel);
		assertPresenceOfElement(passwordLabel);
		assertPresenceOfElement(emailChangelink);
		assertPresenceOfElement(passwordChangelink);

	}

	public void verifyToChangeInvalidPassword() {
		click(passwordChangelink);
		visibiltyOfElement(20, oldPasswordfield);
		waitForElementToBeDisplayed(oldPasswordfield);
		assertPresenceOfElement(oldPasswordfield);
		setTextField(oldPasswordfield, TestBase.readDataFromPropertyFile("password"));
		assertPresenceOfElement(newPasswordfield);
		setTextField(newPasswordfield, TestBase.readDataFromPropertyFile("newInvalidPassword"));
		click(passwordSavebutton);
		visibiltyOfElement(20, passwordFieldValidation);
		assertPresenceOfElement(passwordFieldValidation);

	}

	public void verifyToChangeValidPassword() {
		click(passwordChangelink);
		visibiltyOfElement(20, oldPasswordfield);
		assertPresenceOfElement(oldPasswordfield);
		setTextField(oldPasswordfield, TestBase.readDataFromPropertyFile("password"));
		assertPresenceOfElement(newPasswordfield);
		setTextField(newPasswordfield, TestBase.readDataFromPropertyFile("newPassword"));
		visibiltyOfElement(20, passwordSavebutton);
		click(passwordSavebutton);

	}

	public void verifySuccessMessageAfterPasswordUpdate() {
		visibiltyOfElement(20, successMessagePasswordUpdate);
		assertPresenceOfElement(successMessagePasswordUpdate);
		String ActualPasswordUpdateSuccessMessage = successMessagePasswordUpdate.getText();
		System.out.println(ActualPasswordUpdateSuccessMessage);
		assertEqualsOfElements(successMessagePasswordUpdate, ActualPasswordUpdateSuccessMessage,
				TestBase.readDataFromPropertyFile("expectedPasswordupdateSuccessMessage"));

	}

	public void verifyLoginWithOldPassword() {
//		waitForElementToBeDisplayed(loginScreenButton);
//		click(loginScreenButton);
		visibiltyOfElement(20, emailField);
		setTextField(emailField, TestBase.readDataFromPropertyFile("username"));
		waitForElementToBeDisplayed(passwordField);
		setTextField(passwordField, TestBase.readDataFromPropertyFile("password"));
		waitForElementToBeDisplayed(logInButton);
		click(logInButton);

	}

	public void verifyInvalidLoginAlertmessage() {
		visibiltyOfElement(20, invalidLoginAlert);
		waitForElementToBeDisplayed(invalidLoginAlert);
		assertPresenceOfElement(invalidLoginAlert);
	}

	public void verifyLoginWithNewPassword() {
//		waitForElementToBeDisplayed(loginScreenButton);
//		visibiltyOfElement(20, loginScreenButton);
//		click(loginScreenButton);
		visibiltyOfElement(20, emailField);
		setTextField(emailField, TestBase.readDataFromPropertyFile("username"));
		waitForElementToBeDisplayed(passwordField);
		setTextField(passwordField, TestBase.readDataFromPropertyFile("newPassword"));
		click(logInButton);
		visibiltyOfElement(20, topLogin);
		click(topLogin);
	}

	public void verifyAvtarIconAfterLogin() {
		visibiltyOfElement(20, avtarIcon);
		assertPresenceOfElement(avtarIcon);
	}

	public void verifyToUpdatingBackOldPassword() {
		click(passwordChangelink);
		visibiltyOfElement(20, oldPasswordfield);
		assertPresenceOfElement(oldPasswordfield);
		setTextField(oldPasswordfield, TestBase.readDataFromPropertyFile("newPassword"));
		assertPresenceOfElement(newPasswordfield);
		setTextField(newPasswordfield, TestBase.readDataFromPropertyFile("password"));
		click(passwordSavebutton);
	}

}
