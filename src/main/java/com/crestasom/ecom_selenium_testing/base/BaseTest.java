package com.crestasom.ecom_selenium_testing.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crestasom.ecom_selenium_testing.utils.AuthUtil;
import com.crestasom.ecom_selenium_testing.utils.DriverFactory;

public class BaseTest {
//
	@BeforeClass(alwaysRun = true)
	@Parameters({ "username", "password", "role" })
	public void login(String username, String password, String role) {
		AuthUtil.initToken(username, password, role);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(String browser) {
		DriverFactory.initDriver(browser);
		// DriverFactory.getDriver().manage().window().maximize();

	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		DriverFactory.quitDriver();
	}

	@AfterClass(alwaysRun = true)
	@Parameters("role")
	public void removeLogin(String role) {
		AuthUtil.remove(role);
	}
}
