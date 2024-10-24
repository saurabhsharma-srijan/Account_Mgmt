package com.am.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebAction {
	public Select select;
	public Actions action;
	public WebDriver driver = TestBase.driver;
	int time;
	String currentDir = System.getProperty("user.dir");

	public String TESTDATA_SHEET_PATH = currentDir + File.separator + "src" + File.separator + "main" + File.separator
			+ "java" + File.separator + "ezcontent" + File.separator + "qa" + File.separator + "testdata"
			+ File.separator + "EzcontentTestData.xlsx";

	JavascriptExecutor js;

	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

	// Switch frame by Index
	public void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

//Switch frame by name or Id
	public void switchFrameByNameOrId(String NameOrId) {
		driver.switchTo().frame("String NameOrId");
	}

//Switch frame by WebElement
	public void switchFrameByWebElement(WebElement iframeElement) {
		driver.switchTo().frame(iframeElement);
	}

//Switch back to the main window from iframe
	public void switchBackToWindow() {
		driver.switchTo().defaultContent();
	}

// Select ByVisibleText method
	public void selectByVisibleText(WebElement element, String visibleText) {
		Select oSelect = new Select(element);
		oSelect.selectByVisibleText("visibleText");
	}

// To scroll page or viewport the Webelement
	public void viewportWebElement(WebElement element) {
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].scrollIntoView()", element);
	}

// To highlight the Webelement 	
	public void highLightWebelement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
	}

	// Navigate to any url
	public void navigateToURL(String url) {
		driver.navigate().to(url);
	}

	// switch to simple alert
	public void switchToSimpleAlert() {
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);
		simpleAlert.accept();
	}

	// Clear any field
	public void clearField(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
		}
	}

	public void scrollToEndOfPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	// To capture screenshot
	public void captureScreenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileWithPath = currentDir + File.separator + "test-output" + File.separator + timeStamp() + ".png";
		File DestFile = new File(fileWithPath);
		try {
			FileUtils.copyFile(srcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void jsExecuterClick(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

	public void scrollToPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 500)");
	}

	// To tackle click intercepted issue
	public void scrollToClickElement(WebElement elementName) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", elementName);
	}

	// Click any element
	public void onClick(WebElement element) {
		element.click();
	}

	// select value from drop-down by index
	public void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	// select value from drop-down by value
	public void selectByValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	// select value from drop-down by visible text
	public void selectByText(WebElement element, String Text) {
		new Select(element).selectByVisibleText(Text);
	}

	// Mouse Hover
	public void mouseHover2(WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	// mouseClick
	public void mouseClick(WebElement element) {
		new Actions(driver).click(element).perform();
	}

	// scroll down by pixel
	public void scroll(int startdimension, int enddimension) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"window.scrollBy(" + String.valueOf(startdimension) + "," + String.valueOf(enddimension) + ")");
	}

	// get excel sheet test data
	/*
	 * public Object[][] getTestData(String sheetName) { FileInputStream file =
	 * null; try { file = new FileInputStream(TESTDATA_SHEET_PATH); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } try { book =
	 * WorkbookFactory.create(file); } catch (InvalidFormatException e) {
	 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); } sheet =
	 * book.getSheet(sheetName); Object[][] data = new
	 * Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 * System.out.println(sheet.getLastRowNum() + "-----" +
	 * sheet.getRow(0).getLastCellNum()); for (int i = 0; i < sheet.getLastRowNum();
	 * i++) { for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	 * data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	 * System.out.println(data[i][k]); } } return data; }
	 */

	/**
	 * Waiting for the element to be displayed by Webelement
	 * 
	 * @param locator
	 */

	public void visibiltyOfElement(long timeout, WebElement element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeDisplayed(final WebElement element) {

		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				ExpectedConditions.visibilityOf(element);
				return element;
			}
		});

	}

	public void waitForElementDisplay(final WebElement element, int timeout) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				ExpectedConditions.visibilityOf(element);
				return element;
			}
		});

	}

	public void waitForElementClickable(final WebElement element, int timeout) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				ExpectedConditions.elementToBeClickable(element);
				return element;
			}
		});

	}

	public boolean CheckImageIsDisplayed(WebElement element) throws Exception {
		try {
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					element);
			if (ImagePresent == true) {
				return true;
			} else {
				System.out.println("Image not displayed   :    " + element);
				return false;
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Waiting for the element to be displayed by locator
	 * 
	 * @param locator
	 */
	public void waitForElementToBeDisplayed(final By locator) {
		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				ExpectedConditions.visibilityOfElementLocated(locator);
				return (WebElement) locator;
			}
		});
	}

	/**
	 * Waiting for the element to be present by locator
	 * 
	 * @param locator
	 */
	public void waitForElementToBePresent(final By locator) {
		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				ExpectedConditions.presenceOfElementLocated(locator);
				return (WebElement) locator;
			}
		});

	}

	/**
	 * Waiting for the element to be clickable
	 * 
	 * @param elementToCLick
	 */
	public void waitForElementTobeClickable(final WebElement elementToCLick) {
		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				ExpectedConditions.elementToBeClickable(elementToCLick);
				return elementToCLick;
			}
		});

	}

	/// <summary>
	/// this function will refreshes the current web page
	/// </summary>
	/**
	 * Refreshing the page using selenium methods
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	/// <summary>
	/// this function will perform move back a single "item" in the web browser's
	/// history
	/// </summary>

	/**
	 * Navingating back using selenium back command
	 */
	public void navigateBack() {
		driver.navigate().back();
	}

	/// <summary>
	/// this function will perform move a single "item" forward in the web browser's
	/// history
	/// </summary>
	/**
	 * Navigating forward using selenium forward command
	 */
	public void navigateForward() {
		driver.navigate().forward();
	}

	/// <summary>
	/// this function will close the working window
	/// </summary>

	/**
	 * Closing the window using selenium webdriver
	 */
	public void closeWindow() {
		driver.close();
	}

	/// <summary>
	/// When a webelement don't have unique selector to locate in that case first we
	/// will find the element in main DOM
	/// and then click on the element by using tagname
	/// </summary>
	/**
	 * Clicking on the element using the tag name
	 * 
	 * @param by
	 * @param tagName
	 * @throws Exception
	 */
	public void clickOnElementUsingTagName(By by, String tagName) throws Exception {
		WebElement tempEle = driver.findElement(by);
		WebElement elementToCLick = tempEle.findElement(By.tagName(tagName));
		waitForElementTobeClickable(elementToCLick);
		Thread.sleep(2000);
		elementToCLick.click();
	}

	/// <summary>
	/// this function will convert the RGB color value to hexadecimal value.
	/// </summary>
	/// <param locator="webElement">webElement to locate on application</param>
	/// <param propertyName="name">name of of the css property</param>
	/**
	 * Converting RGB Color to Hexa Decimal
	 * 
	 * @param css
	 * @param propertyName
	 * @return
	 */
	public String convertRGBColorToHexadecimal(String css, String propertyName) {
		String color = findElementByLocator(By.cssSelector(css)).getCssValue(propertyName);
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}

	/// <summary>
	/// this function is to used to select the particular element using index vale
	/// from the list
	/// </summary>
	/// <param element="webElement">list of web-elements</param>
	/// <param elementIndex="elementToSelect">index of the element on which we have
	/// perform click</param>
	/**
	 * Selecting element from List by Index Positions
	 * 
	 * @param element
	 * @param elementIndex
	 */
	public void SelectElementFromListByIndexPosition(List<WebElement> element, int elementIndex) {
		element.get(elementIndex).click();
	}

	/// <summary>
	/// This method will select a particular element from a list.
	/// </summary>
	/// <param list="listOfWebElement">consist set of webElement returned by
	/// locator</param>
	/// <param elementName="nameOFElement">name of element to be selected</param>
	/**
	 * Selecting element from List by the String
	 * 
	 * @param list
	 * @param elementName
	 */
	public void selectElementFromListByString(List<WebElement> list, String elementName) {
		for (WebElement webElement : list) {
			waitForElementClickable(webElement, 45);
			if (getTextField(webElement).equals(elementName)) {
				// scrollToElement(webElement);
				waitForElementClickable(webElement, 45);
				// clickelementViaAction(webElement);
				click(webElement);
				break;
			}
		}
	}

	public void verifyElementFromListByString(List<WebElement> list, String elementName) {
		for (WebElement webElement : list) {
			if (getTextField(webElement).equals(elementName)) {
				veryShortPause();
				Assert.assertTrue(true);
				break;
			}
		}
	}

	// public String selectElementFromListByStringAndGetTheText(List<WebElement>
	// list, String elementName) {
	//// for (WebElement webElement : list) {
	//// if(getTextField(webElement).equals(elementName)){
	//// return webElement.getText();
	//// }
	//// }
	//// return elementName;
	// }
	//
	/// <summary>
	/// this function set a value to text field
	/// </summary>
	/// <param element="webElement">text field on which we have to set the
	// text</param>
	public void setTextField(WebElement element, String value) {
		waitForElementToBeDisplayed(element);
		// longPause();
		waitForElementTobeClickable(element);
		element.clear();
		element.sendKeys(value);
	}

	/// <summary>
	/// this function get text value from field
	/// </summary>
	/// <param element="webElement">text field on which we have to get the
	/// text</param>
	/** Getting the text Field */
	public String getTextField(WebElement element) {
		waitForElementToBeDisplayed(element);
		return element.getText();
	}

	/// <summary>
	/// this function get page title
	/** Getting the page title */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/// <summary>
	/// this function get the attribute name of the element
	/// </summary>
	/// <param element="webElement">element field on which we have to get the
	/// attribute name</param>
	/** Getting the Attribute */
	public String getAttribute(WebElement element, String attributeName) {
		waitForElementToBeDisplayed(element);
		return element.getAttribute(attributeName);
	}

	/// <summary>
	/// this function get the color attribute name of the element
	/// </summary>
	/// <param element="webElement">element field whose color we have to get</param>
	/**
	 * 
	 * @param element
	 * @return
	 */
	public String getColour(WebElement element) {
		waitForElementToBeDisplayed(element);
		return element.getCssValue("color");
	}

	/// <summary>
	/// this function get the font of the element
	/// </summary>
	/// <param element="webElement">element field whose font we have to get</param>
	public String getFontType(WebElement element) {
		waitForElementToBeDisplayed(element);
		return element.getCssValue("font-weight");
	}

	/// <summary>
	/// this function get the background color of the element
	/// </summary>
	/// <param element="webElement">element field whose font we have to get</param>
	public String getBackgroundColor(WebElement element) {
		waitForElementToBeDisplayed(element);
		return element.getCssValue("background-color");
	}

	public String getBackgroundColor(By by) {
		waitForElementToBeDisplayed(by);
		WebElement element = driver.findElement(by);
		return element.getCssValue("background-color");
	}

	/// <summary>
	/// this function return the text of alert
	/// </summary>
	/// <param alert="typeOfAlert">alert</param>
	public String getAlertText(Alert alert) {
		return alert.getText();
	}

	/// <summary>
	/// this function return a string list that a collection consist
	/// </summary>
	/// <param textCollection="webElement">webElement that return a collection of
	/// elements</param>
	public List<String> getTextCollection(List<WebElement> textCollection) {
		List<String> list = new ArrayList<String>();
		for (WebElement webElement : textCollection) {
			list.add(webElement.getText());
		}
		return list;
	}

	/// <summary>
	/// this function perform a click using action class
	/// </summary>
	/// <param element="webElement">webElement on which we have to perform
	/// click</param>
	public void clickelementViaAction(WebElement element) {
		Actions clicker = new Actions(driver);
		clicker.moveToElement(element).perform();
		clicker.click().perform();
		checkPageIsReady();
		// System.out.println("Clicked on Search Icon");
	}

	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			// System.out.println("Page Is loaded.");
			return;
		}
		// This loop will rotate for 25 times to check If page Is ready after every 1
		// second.
		// You can replace your value with 25 If you wants to Increase or decrease wait
		// time.
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	/// <summary>
	/// this function return the text of button
	/// </summary>
	/// <param element="button">webElement of button</param>
	public String GetButtonText(By by) {
		WebElement element = driver.findElement(by);
		return element.getAttribute("value");
	}

	/// <summary>
	/// sometime selenium waits are not sufficient enough in that we will use hard
	/// wait.
	/// </summary>
	public void longPause() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}
	}

	public void veryLongPause() {
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {

		}
	}

	/// <summary>
	///
	/// </summary>
	public void pauseForTime(long timeInMilliSec) {
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {

		}
	}

	/// <summary>
	/// sometime selenium waits are not sufficient enough in that we will use hard
	/// wait.
	/// </summary>
	public void shortPause() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
	}

	/// <summary>
	/// sometime selenium waits are not sufficient enough in that we will use hard
	/// wait.
	/// </summary>
	public void veryShortPause() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
	}

	/// <summary>
	/// this function will copy the content from text file in to the text field.
	/// </summary>
	/// <param locator="webElement">webElement(text field on which we have to copy
	/// the content) to locate on application</param>
	public void CopyContentFromFile(WebElement element, String filePath) throws Exception {
		String data;
		int counter = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((data = reader.readLine()) != null) {
				element.sendKeys(data);
				counter++;
			}
			reader.close();
		} catch (IOException e) {
			// do nothing
		}
	}

	/// <summary>
	/// this function will convert the RGB color value to hexadecimal value.
	/// </summary>
	/// <param locator="webElement">webElement to locate on application</param>
	/// <param propertyName="name">name of of the css property</param>
	public String convertRGBColorToHexadecimal(WebElement element, String propertyName) {
		String color = element.getCssValue(propertyName);
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}

	/// <summary>
	/// this function will delete the file from downloads folder if found
	/// </summary>
	public void verifyAndDeleteFile(String downloads, String fileName) {
		File path = new File(downloads + fileName);
		if (path.exists()) {
			path.delete();
			System.out.println("File has been deleted");
		} else {
			System.out.println("File not present");
		}
	}

	/// <summary>
	/// this function will verify if the file exists at a path
	/// </summary>
	public boolean checkFileInFolder(String downloads, String fileName) {
		boolean flag = false;
		File path = new File(downloads + fileName);
		System.out.println(path);
		if (path.exists()) {
			flag = true;
			System.out.println("File present");
		} else {
			flag = false;
			System.out.println("File not present");
		}
		return flag;
	}

	/// <summary>
	/// this function will upload a file to the application
	/// </summary>
	public void fileUpload(String relativePath) throws Exception {
		File file = new File(relativePath);
		Runtime.getRuntime().exec(file.getAbsolutePath());
	}

	/// <summary>
	/// this function will verify if text present is read only
	/// </summary>
	public boolean verifyReadOnlyText(WebElement ele) {
		boolean flag = false;
		waitForElementToBeDisplayed(ele);
		String tempText = getTextField(ele);
		try {
			ele.sendKeys("...");
		} catch (WebDriverException ex) {

		}
		if (tempText.equals(getTextField(ele))) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	/// <summary>
	/// this function will return the system date in the form of DD/MM/YYYY
	/// HR:MIN:SEC
	/// </summary>
	public String getDate() {

		int day, month, year;
		int second, minute, hour;
		GregorianCalendar date = new GregorianCalendar();

		day = date.get(Calendar.DAY_OF_MONTH);
		month = date.get(Calendar.MONTH);
		year = date.get(Calendar.YEAR);

		second = date.get(Calendar.SECOND);
		minute = date.get(Calendar.MINUTE);
		hour = date.get(Calendar.HOUR);

		String dateAndTime = " " + day + "/" + (month + 1) + "/" + year + " " + hour + " : " + minute + " : " + second;
		return dateAndTime;
	}

	/// <summary>
	/// this function will wait for an element to become clickable and then click it
	/// </summary>
	public void click(WebElement element) {
		waitForElementTobeClickable(element);
		element.click();
	}

	/// <summary>
	/// this function will return a Webelement when found by a By locator
	/// </summary>
	public WebElement findElementByLocator(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}

	/// <summary>
	/// this function will return a list of Webelements when found by a By locator
	/// </summary>
	public List<WebElement> findElements(By by) {
		List<WebElement> list = driver.findElements(by);
		return list;
	}

	/// <summary>
	/// this function will upload the file.
	/// </summary>
	/// <param fileToBeUploaded="fileName">file to be uploaded from resources
	/// folder</param>
	public void uploadFile(String fileToBeUploaded) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("Printing name of file to verify correct file has been picked: " + fileToBeUploaded);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(fileToBeUploaded);
		System.out.println(stringSelection);
		clipboard.setContents(stringSelection, null);
		System.out.println(clipboard.getContents(stringSelection));
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/// <summary>
	/// this method is used to select the particular option from the list
	/// </summary>
	/// <param "textToSelect">on which option we want to select
	/// from the list</param>
	/// <param webelements="listOfWebelements">list of web-elements from which we
	/// have to select the option</param>
	public void selectoptionFromLists(String textToSelect, List<WebElement> webelements) {
		List<WebElement> optionList = webelements;

		for (WebElement webElement : optionList) {
			String webElementText = webElement.getText();
			System.out.println(webElementText);
			if (webElementText.equalsIgnoreCase(textToSelect)) {
				waitForElementTobeClickable(webElement);
				// shortPause();
				webElement.click();
				break;
			}
		}
	}

	/// <summary>
	/// this function return a Split part of the String with the particular
	/// expression
	/// </summary>
	/// <param stringToSplit is the string which needs to be splitted and Expression
	/// is by which split needs to be performed</param>
	public List<String> splitStringIntoList(String stringToSplit, String expression) {
		List<String> list = new ArrayList<String>();
		String[] parts = stringToSplit.split(expression);
		String part1 = parts[0];
		String part2 = parts[1];
		String part3 = parts[2];
		list.add(part1);
		list.add(part2);
		list.add(part3);
		return list;
	}

	/// <summary>
	/// this function will perform double click on web-element.
	/// </summary>
	/// <param webelement="elementOnWhichAction">list of web-elements from which we
	/// have to select the option</param>
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver).doubleClick(element);
		action.build().perform();
	}

	/// <summary>
	/// this function will perform selecting element from dropdown list.
	/// </summary>
	public void selectFromDropDownList(WebElement element, String byVisibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(byVisibleText);
	}

	/// <summary>
	/// this function will perform selecting element from dropdown list by value
	/// </summary>
	public void selectFromDropDownListByValue(WebElement element, String byValue) {
		Select select = new Select(element);
		select.selectByValue(byValue);
	}

	/// <summary>
	/// this function will perform selecting element from dropdown list.
	/// </summary>
	public String getSelectedElementFromDropDownList(WebElement element) {
		Select select = new Select(element);
		String selectedValue = select.getFirstSelectedOption().getText();
		return selectedValue;
	}

	/// <summary>
	/// this function will perform selecting element from dropdown list by index
	/// </summary>
	public void selectFromDropDownListByIndex(WebElement element, int indexValue) {
		Select select = new Select(element);
		select.selectByIndex(indexValue);
	}

	// <summary>
	/// this function will perform click on web-element using java script.
	/// </summary>
	/// <param webelement="elementOnWhichAction">list of web-elements from which we
	// have to select the option</param>
	public void clickUsingJavaScript(String elementToCLick) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(elementToCLick);
	}

	public void clickUsingJavaScriptWebelement(WebElement elementToCLick) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", elementToCLick);
		checkPageIsReady();
	}

	/// <summary>
	/// this function will return true if element is visible or displayed else
	/// retrun false
	/// </summary>
	public boolean isElementVisible(WebElement element) {
		try {
			element.isDisplayed();
			// System.out.println("Element is located");
			return true;
		} catch (org.openqa.selenium.NoSuchElementException msg) {
			// System.out.println("Element is not visible");
			return false;
		}
	}

	// this function will check the element is not displayed
	public boolean elementNotDisplayed(WebElement element) {
		try {
			if (element.isDisplayed()) {
				// System.out.println("Element is located");
				return false;
			}
			return false;
		} catch (org.openqa.selenium.NoSuchElementException msg) {
			System.out.println("Element is not displayed");
			return true;
		}

	}

	/// <summary>
	/// this function will return true if element is visible or displayed else
	/// retrun false
	/// </summary>
	public void checkElementVisible(WebElement element) {
		element.isDisplayed();
		System.out.println(element + ": Is successfully located");
	}

	/// <summary>
	/// this function will scroll the page at the end of it
	/// </summary>
	public void scrollPageEnd() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// public void scrollToElementWithList(List<WebElement> element){
	// JavascriptExecutor js = ((JavascriptExecutor) driver);
	// js.executeScript("arguments[0].scrollIntoView(true);", element);
	// }

	public void scrollToElementFromBottomView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	public void scrollDownUsingcoordinates() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(500,300)", "");
	}

	public void mouseHoverAndClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public String getBodyTextFromPage() {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		return bodyText;
	}

	/** Closing the pop up window and switching back */
	public void closePopUpWindowByHandlesSwitchBackToOriginalWindow() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		System.out.println(handles);

		// Pass a window handle to the other window

		for (String handle1 : driver.getWindowHandles()) {

			System.out.println(handle1);

			driver.switchTo().window(handle1);

		}

		// Closing Pop Up window
		Thread.sleep(5000);

		driver.close();

		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);

	}

	public void switchBackToParentWindow() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		driver.switchTo().window(parentWindow);
	}

	/** Closing the pop up window */
	public void closePopUpWindowByHandles() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		System.out.println(handles);

		// Pass a window handle to the other window

		for (String handle1 : driver.getWindowHandles()) {

			System.out.println(handle1);

			driver.switchTo().window(handle1);

		}

		// Closing Pop Up window
		veryShortPause();

		driver.close();

		shortPause();
		driver.switchTo().window(parentWindow);

	}

	public void switchToPreviousTabAndCloseCurrentTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// int tabSize=tabs.size();

		// Switch newly open Tab
		driver.switchTo().window(tabs.get(1));

		// Close newly open tab after performing some operations.
		driver.close();

		// Switch to old(Parent) tab.
		driver.switchTo().window(tabs.get(0));

		System.out.println("driver.getTitle()------->" + driver.getTitle());
	}

	/** Switching over the window */
	public void switchOverWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				driver.close(); // closing child window
				driver.switchTo().window(parentWindow); // cntrl to parent window
			}
		}
	}

	public void switchToDifferentTab() {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
			}
		}

	}

	public void switchToPopUpWindow() {
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
	}

	public void pressEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public Boolean verifyingCurrentURL(String url) {
		System.out.println(driver.getCurrentUrl());
		boolean flag = false;
		if (driver.getCurrentUrl().contains(url)) {
			Assert.assertTrue(true);
			System.out.println("URL matched");
			flag = true;
		} else {
			Assert.fail();
			flag = false;
		}
		return flag;
	}

	public String getCurrentURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}

	/** Open new tab in browser */
	public void openNewTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	/** Assert Element from list by string */
	public void assertElementFromListByString(List<WebElement> list, String elementName) {
		try {
			for (WebElement webElement : list) {
				if (getTextField(webElement).equals(elementName)) {
					Assert.assertEquals(getTextField(webElement), elementName);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail();
			e.printStackTrace();
		}
	}

	/**
	 * Assert Presence of Elements
	 * 
	 * @param element
	 * @return
	 */
	public Boolean assertPresenceOfElement(WebElement element) {
		try {
			waitForElementDisplay(element, 60);
			Assert.assertTrue(element.isDisplayed());
			return true;
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Assert absence of Elements
	 * 
	 * @param element
	 * @return
	 */
	public Boolean assertElementNotPresent(WebElement element) {
		try {
			// waitForElementToBeDisplayed(element);
			Assert.assertFalse(element.isDisplayed());
			return true;
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			return false;
		}

	}

	/** Assert Elements */
	public Boolean assertEqualsOfElements(WebElement element, String actual, String expected) {
		try {
			waitForElementToBeDisplayed(element);
			Assert.assertEquals(actual, expected);
			return true;
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			return false;
		}

	}

	/** Assert Elements */
	public Boolean assertNotEqualsOfElements(Object unexpected, Object actual) {
		try {
			Assert.assertNotSame(unexpected, actual);
			return true;
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			return false;
		}

	}

	/** Verify the text on UI to the Input Value */
	public Boolean verifyTextOnUIToInputValue(WebElement element, String inputValueInPropertyFile) {
		waitForElementToBeDisplayed(element);
		String dataFromUI = getAttribute(element, "value");
		System.out.println("dataFromUI------->" + dataFromUI);
		System.out.println("inputValueInPropertyFile---->" + inputValueInPropertyFile);
		return assertEqualsOfElements(element, inputValueInPropertyFile, dataFromUI);
	}

	/** verify the src !=null to check image is loading fine */
	public Boolean verifyImageIsDisplaying(WebElement element) {
		waitForElementToBeDisplayed(element);
		if (element.getAttribute("src") != null) {
			System.out.println(element.getAttribute("src"));
			return true;
		} else {
			return false;
		}
	}

	/** navigate to a page */
	public void navigateToAPage(String url) {
		driver.navigate().to(url);
	}

	/**
	 * uploading image using sendKeys()
	 * 
	 * @param element
	 * @param filename
	 */
	public void imageUpload(WebElement element, String filename) {
		waitForElementToBeDisplayed(element);
		// wait.until(ExpectedConditions.elementToBeClickable(element));

		String fileAbsolutePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
				+ filename;

		// String fileAbsolutePath = "/Nalx/resources/clinique_wheel_final_version2_0
		// (1).zip";
		System.out.println(fileAbsolutePath);
		element.sendKeys(fileAbsolutePath);

	}

	/** switching to an iframe */
	public void switchToIframe(WebElement element) {
		waitForElementToBeDisplayed(element);
		driver.switchTo().frame(element);
	}

	/** switch back from iframe */
	public void switchBackfromIframe() {
		driver.switchTo().defaultContent();
	}

	/** to check webElement Is Highlighted */
	public Boolean assertWebElementIsHighlighted(WebElement element) {
		try {
			waitForElementDisplay(element, 60);
			String color = element.getCssValue("color");
			String backcolor = element.getCssValue("background-color");
			// System.out.println(color);
			// System.out.println(backcolor);
			if (!color.equals(backcolor)) {
				System.out.println("webElement is highlighted!");
			}
			return true;

		} catch (Exception e) {
			System.out.println("webElement is not highlighted!");
			Assert.fail();
			e.printStackTrace();
			return false;
		}
	}

}
