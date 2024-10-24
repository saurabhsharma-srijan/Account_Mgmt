package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class Notifications extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(xpath = "//span[@id='nav-notifications']")
	WebElement notificationsMenu;

	@FindBy(xpath = "//h4[text()='Preferences']")
	WebElement notificationPageHeading;

	@FindBy(xpath = "//input[@id='edit-notification-prefer']")
	WebElement notificationCheckbox;

	@FindBy(xpath = "//div[@aria-label='Status message']")
	WebElement successMessage;

	// to initialize the page objects
	public Notifications(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:

	public void navigateNotificationsPage() {
		visibiltyOfElement(20, notificationsMenu);
		assertPresenceOfElement(notificationsMenu);
		click(notificationsMenu);
	}

	public void menuHighlighted() {
		visibiltyOfElement(20, notificationsMenu);
		assertWebElementIsHighlighted(notificationsMenu);
	}

	public void NotificationsPageHeading() {
		visibiltyOfElement(20, notificationPageHeading);
		assertPresenceOfElement(notificationPageHeading);
	}

	public void selectNotificationsCheckbox() {
		visibiltyOfElement(20, notificationCheckbox);
		assertPresenceOfElement(notificationCheckbox);
		click(notificationCheckbox);
	}

	public void verifySuccessMessage() {
		visibiltyOfElement(20, successMessage);
		assertPresenceOfElement(successMessage);
		String ActualNotSuccessMessage = successMessage.getText();
		// System.out.println(ActualNotSuccessMessage);
		assertEqualsOfElements(successMessage, ActualNotSuccessMessage,
				TestBase.readDataFromPropertyFile("expectedNotSuccessMessage"));

	}
}
