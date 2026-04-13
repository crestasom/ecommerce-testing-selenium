package com.crestasom.ecom_selenium_testing.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crestasom.ecom_selenium_testing.base.BaseTest;
import com.crestasom.ecom_selenium_testing.pages.AddProductPage;
import com.crestasom.ecom_selenium_testing.utils.DriverFactory;


public class AddProductTest extends BaseTest {
	@Test(groups = { "smoke" })
	@Parameters("role")
	public void validAddProductTest(String role) throws InterruptedException {
		WebDriver driver = DriverFactory.getDriver();

		AddProductPage addProductPage = new AddProductPage(driver);
		addProductPage.open(role);
		addProductPage.addProduct("jeans", "new jeans", "500");
//		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains("products"));
	}

	@Test(groups = { "slow" })
	@Parameters("role")

	public void inValidAddProductTest(String role) throws InterruptedException {
		WebDriver driver = DriverFactory.getDriver();


		AddProductPage addProductPage = new AddProductPage(driver);
		addProductPage.open(role);
		addProductPage.addProduct("jeans", "new jeans", "-500");
//		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains("products/add"));
	}

}
