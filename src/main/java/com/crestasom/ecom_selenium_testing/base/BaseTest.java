package com.crestasom.ecom_selenium_testing.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crestasom.ecom_selenium_testing.utils.AuthUtil;
import com.crestasom.ecom_selenium_testing.utils.DriverFactory;

public class BaseTest {
//
//	@BeforeClass
//	@Parameters({ "username", "password" })
//	public void login(String username, String password) {
//		AuthUtil.login(username, password);
//	}

	@BeforeMethod
	@Parameters({ "browser", "username", "password" })

	public void setup(String browser, String username, String password) {
		DriverFactory.initDriver(browser);
		AuthUtil.login(username, password);
		// DriverFactory.getDriver().manage().window().maximize();

	}

	@AfterMethod
	public void teardown() {
		DriverFactory.quitDriver();
	}

//	@AfterClass
//	public void removeLogin() {
//		AuthUtil.remove();
//	}
}
