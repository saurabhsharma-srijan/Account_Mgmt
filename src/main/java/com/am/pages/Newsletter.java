package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class Newsletter extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(xpath = "//span[@id='nav-newsletters']")
	WebElement newslettersMenu;

	@FindBy(xpath = "//a[@id='newsletter-block']")
	WebElement newslettersLinkDashboard;

	@FindBy(xpath = "//h4[normalize-space()='Newsletters']")
	WebElement newslettersPageHeading;

	@FindBy(xpath = "//div[normalize-space()='Breaking News']")
	WebElement breakingNewsletterLabel;

	@FindBy(xpath = "//label[@value='Breaking News']")
	WebElement breakingNewsSubscribe;

	// to initialize the page objects
	public Newsletter(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:
	public void navigateNewsletterPageMenu() {
		visibiltyOfElement(20, newslettersMenu);
		assertPresenceOfElement(newslettersMenu);
		click(newslettersMenu);
	}

	public void navigateNewsletterPageDashboardLink() {
		visibiltyOfElement(20, newslettersLinkDashboard);
		assertPresenceOfElement(newslettersLinkDashboard);
		click(newslettersLinkDashboard);
	}

	public void verifyNewsletterPageHeading() {
		visibiltyOfElement(20, newslettersPageHeading);
		assertPresenceOfElement(newslettersPageHeading);
	}

	public void verifyBreakingNewslabel() {
		visibiltyOfElement(20, breakingNewsletterLabel);
		assertPresenceOfElement(breakingNewsletterLabel);
	}

	public void selectBNSubscribeButton() {
		visibiltyOfElement(20, breakingNewsSubscribe);
		assertPresenceOfElement(breakingNewsSubscribe);
		click(breakingNewsSubscribe);
	}

	public void selectBNUnSubscribeButton() {
		visibiltyOfElement(20, breakingNewsSubscribe);
		assertPresenceOfElement(breakingNewsSubscribe);
		click(breakingNewsSubscribe);
	}

	public void verifyUnsubscribeLabel() {
		visibiltyOfElement(20, breakingNewsSubscribe);
		String unsubscribeLabel = breakingNewsSubscribe.getText();
		System.out.println(unsubscribeLabel);
		assertEqualsOfElements(breakingNewsSubscribe, unsubscribeLabel,
				TestBase.readDataFromPropertyFile("newsletterUnsubLabel"));
	}

	public void verifySubscribeLabel() {
		visibiltyOfElement(20, breakingNewsSubscribe);
		String subscribeLabel = breakingNewsSubscribe.getText();
		System.out.println(subscribeLabel);
		assertEqualsOfElements(breakingNewsSubscribe, subscribeLabel,
				TestBase.readDataFromPropertyFile("newsletterSubLabel"));
	}

}
