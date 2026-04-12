package com.crestasom.ecom_selenium_testing.utils;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//	public static void initDriver(String browser) {
//		WebDriverManager.chromedriver().setup();
//		driver.set(new ChromeDriver());
////		switch (browser) {
////		case "firefox":
////			WebDriverManager.firefoxdriver().setup();
////			driver.set(new FirefoxDriver());
////			break;
////		case "edge":
////			WebDriverManager.edgedriver().setup();
////			driver.set(new EdgeDriver());
////			break;
////		case "chrome":
////		default:
////			WebDriverManager.chromedriver().setup();
////			driver.set(new ChromeDriver());
////			break;
////		}
//
//		AuthUtil.login();
//
//	}

	public static void initDriver(String browser) {
		String driverPath = Paths.get("src", "test", "resources", "drivers").toString();

		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Paths.get(driverPath, "chromedriver.exe").toString());
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", Paths.get(driverPath, "geckodriver.exe").toString());
			driver.set(new FirefoxDriver());
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", Paths.get(driverPath, "msedgedriver.exe").toString());
			driver.set(new EdgeDriver());
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}


	}

	public static WebDriver getDriver() {
		WebDriver webDriver = driver.get();
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		return webDriver;
	}

	public static void quitDriver() {
		driver.get().quit();
		driver.remove();
	}
}
