package com.crestasom.ecom_selenium_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	private By username;
	private By password;
	private By loginBtn;

	public LoginPage(WebDriver driver, String userNameId, String passwordId, String loginBtnId) {
		this.driver = driver;
		username = By.id(userNameId);
		password = By.id(passwordId);
		loginBtn = By.id(loginBtnId);
	}

	public void open() {
		driver.get("http://localhost:8080/auth/login");
	}

	public void login(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}
}
