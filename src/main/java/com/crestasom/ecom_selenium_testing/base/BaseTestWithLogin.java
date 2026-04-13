package com.crestasom.ecom_selenium_testing.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.crestasom.ecom_selenium_testing.utils.AuthUtil;

public class BaseTestWithLogin extends BaseTest {

	@BeforeClass(alwaysRun = true)
	@Parameters({ "username", "password", "role" })
	public void login(String username, String password, String role) {
		System.out.println("set token called");

		AuthUtil.initToken(username, password, role);

	}

	@AfterClass(alwaysRun = true)
	@Parameters("role")
	public void removeLogin(String role) {
		AuthUtil.remove(role);
	}
}
