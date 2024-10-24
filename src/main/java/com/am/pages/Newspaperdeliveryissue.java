package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class Newspaperdeliveryissue extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(xpath = "//span[@id='nav-nss']")
	WebElement newspaperMenu;

	@FindBy(xpath = "//a[@id='nss-block']")
	WebElement newspaperLinkDashboard;

	@FindBy(xpath = "//h4[normalize-space()='Newspaper self-service']")
	WebElement newspaperPageHeading;

	@FindBy(xpath = "//button[@id='1'][normalize-space()='Report delivery issue']")
	WebElement reportDeliveryIssueButton;

	@FindBy(xpath = "(//span[@id='select2-edit-field-issue-date-container'])[@role='textbox']")
	WebElement issueDateField;

	@FindBy(xpath = "//span[@class='select2-results']//li[@class='select2-results__option'][1]")
	WebElement selectTopDate;

	@FindBy(xpath = "//input[@id='edit-issue-option-misscr']")
	WebElement deliveryIssueType;

	@FindBy(xpath = "//input[@id='edit-save--2']")
	WebElement deliveryIssueSend;

	@FindBy(xpath = "//div[@aria-label='Status message']")
	WebElement deliveryIssueSuccessMessage;

// to initialize the page objects
	public Newspaperdeliveryissue(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

// Actions:

	public void navigateNewspaperPageDashboardLink() {
		visibiltyOfElement(20, newspaperLinkDashboard);
		assertPresenceOfElement(newspaperLinkDashboard);
		click(newspaperLinkDashboard);
	}

	public void verifyNewspaperPageHeading() {
		visibiltyOfElement(20, newspaperPageHeading);
		assertPresenceOfElement(newspaperPageHeading);
	}

	public void selectDeliveryIssueButton() {
		visibiltyOfElement(20, reportDeliveryIssueButton);
		assertPresenceOfElement(reportDeliveryIssueButton);
		click(reportDeliveryIssueButton);
	}

	public void selectIssueDate() {
		visibiltyOfElement(20, issueDateField);
		assertPresenceOfElement(issueDateField);
		click(issueDateField);
		visibiltyOfElement(20, selectTopDate);
		click(selectTopDate);

	}

	public void selectDeliveryIssue() {
		visibiltyOfElement(20, deliveryIssueType);
		assertPresenceOfElement(deliveryIssueType);
		click(deliveryIssueType);
	}

	public void deliveryIssueSubmit() {
		visibiltyOfElement(20, deliveryIssueSend);
		assertPresenceOfElement(deliveryIssueSend);
		click(deliveryIssueSend);
	}

	public void checkDeliveryIssueSuccessMessage() {
		visibiltyOfElement(20, deliveryIssueSuccessMessage);
		assertPresenceOfElement(deliveryIssueSuccessMessage);
	}

}
