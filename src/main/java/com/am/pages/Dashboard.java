package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class Dashboard extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(xpath = "//span[@class='heading'][text()='Newspaper self-service']")
	WebElement newspaperHeading;

	@FindBy(xpath = "//span[@class='heading'][text()='Account details']")
	WebElement accountHeading;

	@FindBy(xpath = "//span[@class='heading'][text()='Stuff newsletters']")
	WebElement newslettersHeading;

	@FindBy(xpath = "//a[@id='nss-block']")
	WebElement newspaperView;

	@FindBy(xpath = "//a[@id='acc-details-block']")
	WebElement accountView;

	@FindBy(xpath = "//a[@id='newsletter-block']")
	WebElement newslettersView;

	@FindBy(xpath = "//span[@id='nav-dashboard']")
	WebElement dashboardHomeMenu;

// to initialize the page objects
	public Dashboard(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:

	public void verfiyNewspaperSection() {
		visibiltyOfElement(20, newspaperHeading);
		assertPresenceOfElement(newspaperHeading);
		assertPresenceOfElement(newspaperView);
		// newspaperView.click();
	}

	public void verfiyAccountDetailSection() {
		visibiltyOfElement(20, accountHeading);
		assertPresenceOfElement(accountHeading);
		assertPresenceOfElement(accountView);
		// accountView.click();
	}

	public void verfiyNewslettersSection() {
		visibiltyOfElement(20, newslettersHeading);
		assertPresenceOfElement(newslettersHeading);
		assertPresenceOfElement(newslettersView);
		// newslettersView.click();
	}

	public void navigateDashboardPage() {
		visibiltyOfElement(20, dashboardHomeMenu);
		assertPresenceOfElement(dashboardHomeMenu);
		click(dashboardHomeMenu);
	}

	public void menuHighlighted() {
		visibiltyOfElement(20, dashboardHomeMenu);
		assertWebElementIsHighlighted(dashboardHomeMenu);
	}
}
