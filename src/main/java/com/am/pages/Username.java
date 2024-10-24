package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class Username extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(xpath = "//div[normalize-space()='Stuff profile']")
	WebElement stuffHeading;

	@FindBy(xpath = "//span[normalize-space()='Commenting user name']")
	WebElement usernameLabel;

	// to initialize the page objects
	public Username(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	public void verifyUsernameOnAccountdetail() {
		visibiltyOfElement(20, stuffHeading);
		assertPresenceOfElement(stuffHeading);
		assertPresenceOfElement(usernameLabel);
		highLightWebelement(usernameLabel);

	}
}
