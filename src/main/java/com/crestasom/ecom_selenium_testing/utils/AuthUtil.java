package com.crestasom.ecom_selenium_testing.utils;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.restassured.response.Response;

public class AuthUtil {
	private static Map<String, String> token = new ConcurrentHashMap<>();

	public static synchronized void initToken(String username, String password, String role) {
		if (!token.containsKey(role)) {
			token.put(role, AuthUtil.login(username, password));
		}
	}

	public static String getToken(String role) {
		return token.get(role);
	}

	public static void remove(String role) {
		token.remove(role);
	}

	public static String login(String username, String password) {
		Response response = given().contentType("application/x-www-form-urlencoded").formParam("username", username)
				.formParam("password", password).when().post("http://localhost:8080/auth/login");

		// Extract token from cookie
		String jwtToken = response.getCookie("jwt"); // cookie name may differ
		return jwtToken;
	}
}
