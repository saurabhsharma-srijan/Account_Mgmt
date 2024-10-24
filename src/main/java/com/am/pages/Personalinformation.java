package com.am.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.am.util.TestBase;
import com.am.util.WebAction;

public class Personalinformation extends WebAction {
	public static WebDriver driver = TestBase.driver;

	@FindBy(xpath = "//span[@id='nav-account']")
	WebElement accountDetailMenu;

	@FindBy(xpath = "//a[@id='acc-details-block']")
	WebElement accountDetailLinkDashboard;

	@FindBy(xpath = "//h4[normalize-space()='Account details']")
	WebElement accountDetailPageHeading;

	@FindBy(xpath = "//div[normalize-space()='Personal Information']")
	WebElement personalinfoHeading;

	@FindBy(xpath = "//span[normalize-space()='First name']")
	WebElement firstNameLabel;

	@FindBy(xpath = "//span[normalize-space()='Last name']")
	WebElement lastNameLabel;

	@FindBy(xpath = "//span[normalize-space()='Mobile number']")
	WebElement mobileNumberLabel;

	@FindBy(xpath = "//span[normalize-space()='Country you live in']")
	WebElement countryLabel;

	@FindBy(xpath = "//span[@class='label'][normalize-space()='Date of birth']")
	WebElement dobLabel;

	@FindBy(xpath = "//span[normalize-space()='Gender']")
	WebElement genderLabel;

	@FindBy(xpath = "//span[normalize-space()='Postcode']")
	WebElement postCodeLabel;

	@FindBy(xpath = "//button[@id='editInfo']")
	WebElement editPersonalInfo;

	@FindBy(xpath = "//input[@name='field_first_name']")
	WebElement editFirstName;

	@FindBy(xpath = "//input[@name='field_last_name']")
	WebElement editLastName;

	@FindBy(xpath = "//input[@name='field_mobile_phone']")
	WebElement editMobileNo;

	@FindBy(xpath = "//select[@name='field_country']")
	WebElement editCountry;

	@FindBy(xpath = "//input[@name='field_postcode']")
	WebElement editPostcode;

	@FindBy(xpath = "//input[@name='field_day']")
	WebElement editBirthDay;

	@FindBy(xpath = "//input[@name='field_month']")
	WebElement editBirthMonth;

	@FindBy(xpath = "//input[@name='field_year']")
	WebElement editBirthYear;

	@FindBy(xpath = "//select[@name='field_gender']")
	WebElement editGenderField;

	@FindBy(xpath = "//input[@formname='personal-information']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@aria-label='Status message']")
	WebElement personalInfosuccessMessage;

	@FindBy(xpath = "//div[@class='iti__flag-container']")
	WebElement flagContainer;

	@FindBy(xpath = "//ul[@class='iti__country-list']")
	WebElement countryList;

	@FindBy(xpath = "//span[contains(text(),'India (भारत)')]")
	WebElement indiaOption;

	// to initialize the page objects
	public Personalinformation(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:

	public void navigateAccountDetailMenu() {
		visibiltyOfElement(20, accountDetailMenu);
		assertPresenceOfElement(accountDetailMenu);
		click(accountDetailMenu);
	}

	public void navigateAccountDetailDashboardLink() {
		visibiltyOfElement(20, accountDetailLinkDashboard);
		assertPresenceOfElement(accountDetailLinkDashboard);
		click(accountDetailLinkDashboard);
	}

	public void verifyAccountDetailPageHeading() {
		visibiltyOfElement(20, accountDetailPageHeading);
		assertPresenceOfElement(accountDetailPageHeading);
	}

	public void verifyPersonalInfoHeading() {
		visibiltyOfElement(20, personalinfoHeading);
		assertPresenceOfElement(personalinfoHeading);
	}

	public void selectCountryflag() {
		visibiltyOfElement(20, flagContainer);
		assertPresenceOfElement(flagContainer);
		click(flagContainer);
		visibiltyOfElement(20, countryList);
		click(indiaOption);
	}

	public void verifyPersonalInfoItems() {
		visibiltyOfElement(20, personalinfoHeading);
		visibiltyOfElement(20, firstNameLabel);
		assertPresenceOfElement(firstNameLabel);
		assertPresenceOfElement(lastNameLabel);
		assertPresenceOfElement(mobileNumberLabel);
		assertPresenceOfElement(countryLabel);
		// assertPresenceOfElement(postCodeLabel);
		assertPresenceOfElement(dobLabel);
		assertPresenceOfElement(genderLabel);
		assertPresenceOfElement(editPersonalInfo);

	}

	public void verifyToUpdatePersonalInfo() {
		visibiltyOfElement(20, editPersonalInfo);
		click(editPersonalInfo);
		visibiltyOfElement(20, editFirstName);
		setTextField(editFirstName, TestBase.readDataFromPropertyFile("firstname1"));
		setTextField(editLastName, TestBase.readDataFromPropertyFile("lastname1"));
		selectCountryflag();
		setTextField(editMobileNo, TestBase.readDataFromPropertyFile("mobilenumber1"));
		selectFromDropDownList(editCountry, TestBase.readDataFromPropertyFile("countryname1"));
		setTextField(editPostcode, TestBase.readDataFromPropertyFile("postcode1"));
		setTextField(editBirthDay, TestBase.readDataFromPropertyFile("birthday1"));
		setTextField(editBirthMonth, TestBase.readDataFromPropertyFile("birthmonth1"));
		setTextField(editBirthYear, TestBase.readDataFromPropertyFile("birthyear1"));
		selectFromDropDownList(editGenderField, TestBase.readDataFromPropertyFile("gender1"));
		click(saveButton);
	}

	public void verifyToUpdateOldDataPersonalInfo() {
		visibiltyOfElement(20, editPersonalInfo);
		click(editPersonalInfo);
		visibiltyOfElement(20, editFirstName);
		setTextField(editFirstName, TestBase.readDataFromPropertyFile("firstname2"));
		setTextField(editLastName, TestBase.readDataFromPropertyFile("lastname2"));
		selectCountryflag();
		setTextField(editMobileNo, TestBase.readDataFromPropertyFile("mobilenumber2"));
		selectFromDropDownList(editCountry, TestBase.readDataFromPropertyFile("countryname2"));
		setTextField(editPostcode, TestBase.readDataFromPropertyFile("postcode2"));
		setTextField(editBirthDay, TestBase.readDataFromPropertyFile("birthday2"));
		setTextField(editBirthMonth, TestBase.readDataFromPropertyFile("birthmonth2"));
		setTextField(editBirthYear, TestBase.readDataFromPropertyFile("birthyear2"));
		selectFromDropDownList(editGenderField, TestBase.readDataFromPropertyFile("gender2"));
		click(saveButton);
	}

	public void verifyUpdatePersonalInfoSuccessMessage() {
		visibiltyOfElement(20, personalInfosuccessMessage);
		assertPresenceOfElement(personalInfosuccessMessage);
		String ActualPersonalInfoSuccessMessage = personalInfosuccessMessage.getText();
		assertEqualsOfElements(personalInfosuccessMessage, ActualPersonalInfoSuccessMessage,
				TestBase.readDataFromPropertyFile("expectedPersonalInfoSuccessMessage"));

	}

}
