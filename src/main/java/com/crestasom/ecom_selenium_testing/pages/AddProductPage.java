package com.crestasom.ecom_selenium_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.crestasom.ecom_selenium_testing.utils.AuthUtil;

public class AddProductPage {
	WebDriver driver;
	private By name;
	private By description;
	private By price;
	private By btnSave;

	public AddProductPage(WebDriver driver) {
		this.driver = driver;
		name = By.id("name");
		description = By.id("description");
		price = By.id("price");
		btnSave = By.id("btnSave");
	}

	public void open(String role) {
		driver.get("http://localhost:8080");
		driver.manage().addCookie(new Cookie("jwt", AuthUtil.getToken(role)));
		driver.get("http://localhost:8080/products/add");
	}

	public void addProduct(String name, String desc, String price) {
		driver.findElement(this.name).sendKeys(name);
		driver.findElement(this.description).sendKeys(desc);
		driver.findElement(this.price).sendKeys(price);
		driver.findElement(btnSave).click();
	}
}
