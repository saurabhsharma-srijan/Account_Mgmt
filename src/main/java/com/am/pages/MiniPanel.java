package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class MiniPanel extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(xpath = "//div[@class='user-account-menu-wrapper']")
	WebElement avtaricon;

	@FindBy(xpath = "//li[@class='salutation']")
	WebElement kiaOra;

	@FindBy(xpath = "//a[text()='Your Account']")
	WebElement accnt_minipanel;

	@FindBy(xpath = "//div[@class='mobile-menu d-flex']//h1[(text()='Your Account')]")
	WebElement yourAccountTitle;

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement logoutbuttn;

	@FindBy(id = "edit-openid-connect-client-stuff-azure-adb2c-login")
	public WebElement loginButtn;

	// to initialise the page objects

	public MiniPanel(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:

	public void selectavtar() {
		waitForElementToBeDisplayed(avtaricon);
		assertPresenceOfElement(avtaricon);
		click(avtaricon);
	}

	public void kiaOraVisible() {
		visibiltyOfElement(20, kiaOra);
		waitForElementToBeDisplayed(kiaOra);
		assertPresenceOfElement(kiaOra);
	}

	public void yourAccountVisible() {
		visibiltyOfElement(20, accnt_minipanel);
		waitForElementToBeDisplayed(accnt_minipanel);
		assertPresenceOfElement(accnt_minipanel);
	}

	public void logoutVisible() {
		visibiltyOfElement(20, logoutbuttn);
		waitForElementToBeDisplayed(logoutbuttn);
		assertPresenceOfElement(logoutbuttn);
	}

	public void selectAccountMinipanel() {
		visibiltyOfElement(20, accnt_minipanel);
		waitForElementToBeDisplayed(accnt_minipanel);
		assertPresenceOfElement(accnt_minipanel);
		accnt_minipanel.click();
	}

	public void selectLogout() {
		veryShortPause();

		if (logoutbuttn.isDisplayed()) {
			logoutbuttn.click();
		} else {
			System.out.println("Logout Failed");
		}
	}

	public void loginbuttonVisible() {
		waitForElementToBeDisplayed(loginButtn);
		assertPresenceOfElement(loginButtn);
	}

	public void yourAccountTitleVisible() {
		waitForElementToBeDisplayed(yourAccountTitle);
		assertPresenceOfElement(yourAccountTitle);
	}

}
