package com.crestasom.ecom_selenium_testing.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crestasom.ecom_selenium_testing.base.BaseTest;
import com.crestasom.ecom_selenium_testing.pages.LoginPage;
import com.crestasom.ecom_selenium_testing.utils.DriverFactory;

public class LoginTest extends BaseTest {
	@Test
	public void validLoginTest() throws InterruptedException {
		WebDriver driver = DriverFactory.getDriver();
		LoginPage loginPage = new LoginPage(driver, "username", "password", "loginBtn");
		loginPage.open();
		loginPage.login("crestasom", "shrestha@132");
		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains("products"));
	}

	@Test
	public void inValidLoginTest() throws InterruptedException {
		WebDriver driver = DriverFactory.getDriver();
		LoginPage loginPage = new LoginPage(driver, "username", "password", "loginBtn");
		loginPage.open();
		loginPage.login("crestasom", "wrongpassword");
		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}
}
