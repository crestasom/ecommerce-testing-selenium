package com.crestasom.ecom_selenium_testing.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crestasom.ecom_selenium_testing.utils.DriverFactory;

public class BaseTest {



	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		DriverFactory.initDriver(browser);
		DriverFactory.getDriver().manage().window().maximize();

	}

	@AfterMethod
	public void teardown() {
		DriverFactory.quitDriver();
	}
}
