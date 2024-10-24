package com.am.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	static String currentDir = System.getProperty("user.dir");

	static String configFilePath = currentDir + File.separator + "src" + File.separator + "main" + File.separator
			+ "java" + File.separator + "com" + File.separator + "am" + File.separator + "config" + File.separator
			+ "config.properties";

	static String chromeDriverPath = currentDir + File.separator + "drivers" + File.separator + "chromedriver";
	static String fireFoxDriverPath = currentDir + File.separator + "drivers" + File.separator + "geckodriver";

	public static String readDataFromPropertyFile(String key) {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(configFilePath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	@Before
	public WebDriver browserLaunch() throws Exception {
		String browserName = readDataFromPropertyFile("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1200,800");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(readDataFromPropertyFile("stageurl"));
		}

		else if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(readDataFromPropertyFile("stageurl"));
		}

		else {
			System.out.println(
					"***** WARNING ***** - BROWSER  provided is Incorrect so initiating default (chrome) browser.");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(readDataFromPropertyFile("stageurl"));
		}

		return driver;
	}

	public WebDriver getDriver() throws MalformedURLException {
		if (driver == null) {
			try {
				driver = browserLaunch();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.close();
		}
	}
}
