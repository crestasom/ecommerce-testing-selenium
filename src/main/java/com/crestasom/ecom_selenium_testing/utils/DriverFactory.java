package com.crestasom.ecom_selenium_testing.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver(String browser) {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
//		switch (browser) {
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver.set(new FirefoxDriver());
//			break;
//		case "edge":
//			WebDriverManager.edgedriver().setup();
//			driver.set(new EdgeDriver());
//			break;
//		case "chrome":
//		default:
//			WebDriverManager.chromedriver().setup();
//			driver.set(new ChromeDriver());
//			break;
//		}

		AuthUtil.login();

	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		driver.get().quit();
		driver.remove();
	}
}
