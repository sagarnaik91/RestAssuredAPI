package com.guru;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PrintResponse {
	@Test
	public void responseHeader() {
		System.out.println("Logging only in case of error");
		JSONObject body = new JSONObject();
		body.put("id", "1");
		body.put("username", "String");
		body.put("firstName", "String");
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		given().contentType(ContentType.JSON).body(body.toJSONString()).when().post("user").then().log().ifError();
	}

	@Test
	public void responseStatus() {
		System.out.println("Logging only status code");
		JSONObject body = new JSONObject();
		body.put("id", "1");
		body.put("username", "String");
		body.put("firstName", "String");
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		given().contentType(ContentType.JSON).body(body.toJSONString()).when().post("user").then().log().status();
	}

}
