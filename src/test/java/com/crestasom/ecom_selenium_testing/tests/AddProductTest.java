package com.crestasom.ecom_selenium_testing.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crestasom.ecom_selenium_testing.base.BaseTest;
import com.crestasom.ecom_selenium_testing.pages.AddProductPage;
import com.crestasom.ecom_selenium_testing.utils.DriverFactory;

public class AddProductTest extends BaseTest {
	@Test
	public void validAddProductTest() throws InterruptedException {
		WebDriver driver = DriverFactory.getDriver();
		AddProductPage addProductPage = new AddProductPage(driver);
		addProductPage.open();
		addProductPage.addProduct("jeans", "new jeans", "500");
//		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains("products"));
	}

	@Test
	public void inValidAddProductTest() throws InterruptedException {
		WebDriver driver = DriverFactory.getDriver();
		AddProductPage addProductPage = new AddProductPage(driver);
		addProductPage.open();
		addProductPage.addProduct("jeans", "new jeans", "-500");
//		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains("products/add"));
	}

}
