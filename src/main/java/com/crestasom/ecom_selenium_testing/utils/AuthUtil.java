package com.crestasom.ecom_selenium_testing.utils;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class AuthUtil {
	private static ThreadLocal<String> token = new ThreadLocal<>();

	public static void login(String username, String password) {

		Response response = given().contentType("application/x-www-form-urlencoded").formParam("username", username)
				.formParam("password", password).when().post("http://localhost:8080/auth/login");

		// Extract token from cookie
		String jwtToken = response.getCookie("jwt"); // cookie name may differ

		token.set(jwtToken);
	}

	public static String getToken() {
		return token.get();
	}

	public static void remove() {
		token.remove();
	}
}
