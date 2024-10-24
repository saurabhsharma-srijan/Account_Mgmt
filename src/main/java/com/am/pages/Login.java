package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class Login extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(id = "edit-openid-connect-client-stuff-azure-adb2c-login")
	public WebElement loginButtn;

	@FindBy(xpath = "//input[@name='Email address']")
	public WebElement emailfield;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement pswdfield;

	@FindBy(xpath = "//button[@id='next']")
	public WebElement signInButtn;

	@FindBy(xpath = "//div[@class='user-avatar dropdown-toggle']")
	public WebElement avtricon;

	// to initialize the page objects
	public Login(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:

//	public void handleBaseAuth() {
//		String username = "webed";
//		String password = "cabbageGoat55";
//		String URL = "https://" + username + ":" + password + "@"
//				+ "identity-staging.stuff.co.nz/stuffnebb2cstaging.onmicrosoft.com/B2C_1A_SIGNUP_SIGNIN_UPFRONT_DATA_CAPTURE/oauth2/v2.0/authorize?client_id=9b817632-2f57-447a-a71c-85111d379545&response_type=code&scope=openid%20email%20profile&redirect_uri=https%3A//account-management-stage.staging.nebula-drupal.stuff.co.nz/openid-connect/stuff_azure_adb2c&state=jo05WuJ4mlxzmSlBrWKiyHClUEKqHa4C5ZDjW6YCj0k";
//
//		driver.get(URL);
//	}

	public void selectloginbutton() {
		visibiltyOfElement(20, loginButtn);
		assertPresenceOfElement(loginButtn);
		click(loginButtn);
	}

	public void enters_username() {
//		Thread.sleep(7000);
//		waitForElementDisplay(emailfield, 21);
		visibiltyOfElement(20, emailfield);
		assertPresenceOfElement(emailfield);
		setTextField(emailfield, TestBase.readDataFromPropertyFile("username"));
	}

	public void enters_pswd() {
		visibiltyOfElement(20, pswdfield);
		assertPresenceOfElement(pswdfield);
		setTextField(pswdfield, TestBase.readDataFromPropertyFile("password"));
	}

	public void selectsignIn() {
		visibiltyOfElement(20, signInButtn);
		assertPresenceOfElement(signInButtn);
		click(signInButtn);
	}

	public void verifyAvtarIcon() {
		waitForElementToBeDisplayed(avtricon);
		visibiltyOfElement(25, avtricon);
		assertPresenceOfElement(avtricon);
	}
}
