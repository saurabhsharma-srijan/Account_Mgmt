package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class Newspapertemporarystop extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(xpath = "//span[@id='nav-nss']")
	WebElement newspaperMenu;

	@FindBy(xpath = "//a[@id='nss-block']")
	WebElement newspaperLinkDashboard;

	@FindBy(xpath = "//h4[normalize-space()='Newspaper self-service']")
	WebElement newspaperPageHeading;

	@FindBy(xpath = "//button[@id='1'][normalize-space()='Create temporary stop']")
	WebElement createTemporaryStopButton;

	@FindBy(xpath = "//input[@id='edit-field-stop-date']")
	WebElement stopDateField;

	@FindBy(xpath = "//input[@id='edit-field-resume-date']")
	WebElement restartDateField;

	@FindBy(xpath = "//input[@id='edit-save']")
	WebElement stopSaveButton;

	@FindBy(xpath = "//div[@id='edit-delete-link']")
	WebElement deleteTemporaryStop;

	@FindBy(xpath = "//input[@id='edit-delete']")
	WebElement deleteButton;

	@FindBy(xpath = "//div[@aria-label='Status message']")
	WebElement deleteTempStopSuccessMessage;

	@FindBy(xpath = "//div[@aria-label='Status message']")
	WebElement createTempStopSuccessMessage;

	// to initialize the page objects
	public Newspapertemporarystop(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:
	public void navigateNewspaperPageMenu() {
		visibiltyOfElement(20, newspaperMenu);
		assertPresenceOfElement(newspaperMenu);
		click(newspaperMenu);
	}

	public void navigateNewspaperPageDashboardLink() {
		visibiltyOfElement(20, newspaperLinkDashboard);
		assertPresenceOfElement(newspaperLinkDashboard);
		click(newspaperLinkDashboard);
	}

	public void verifyNewspaperPageHeading() {
		visibiltyOfElement(20, newspaperPageHeading);
		assertPresenceOfElement(newspaperPageHeading);
	}

	public void selectCreateTemporaryStop() {
		visibiltyOfElement(20, createTemporaryStopButton);
		assertPresenceOfElement(createTemporaryStopButton);
		click(createTemporaryStopButton);
	}

	public void selectStopDeliverDate() {
		visibiltyOfElement(20, stopDateField);
		assertPresenceOfElement(stopDateField);
		click(stopDateField);
		stopDateField.sendKeys(TestBase.readDataFromPropertyFile("deliveryStopDate"));

	}

	public void selectRestartDeliverDate() {
		visibiltyOfElement(20, restartDateField);
		assertPresenceOfElement(restartDateField);
		click(restartDateField);
		restartDateField.sendKeys(TestBase.readDataFromPropertyFile("deliveryRestartDate"));
	}

	public void selectSaveButton() {
		visibiltyOfElement(20, stopSaveButton);
		assertPresenceOfElement(stopSaveButton);
		click(stopSaveButton);
	}

	public void tempStopSuccessMessage() {
		visibiltyOfElement(20, createTempStopSuccessMessage);
		assertPresenceOfElement(createTempStopSuccessMessage);
	}

	public void deleteTempStopSection() {
		visibiltyOfElement(20, deleteTemporaryStop);
		assertPresenceOfElement(deleteTemporaryStop);
		click(deleteTemporaryStop);
	}

	public void selectDeleteButton() {
		visibiltyOfElement(20, deleteButton);
		assertPresenceOfElement(deleteButton);
		click(deleteButton);
	}

	public void deleteTempStopSuccessMessage() {
		visibiltyOfElement(20, deleteTempStopSuccessMessage);
		assertPresenceOfElement(deleteTempStopSuccessMessage);
	}

}
