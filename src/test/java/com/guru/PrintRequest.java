package com.guru;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Test
public class PrintRequest {
	public static void printIfValidationFailed() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		JSONObject body = new JSONObject();
		body.put("id", "1");
		body.put("username", "String");
		body.put("firstName", "String");
		given().contentType(ContentType.JSON).body(body.toJSONString()).log().ifValidationFails().when().post("user")
				.then().statusCode(201);
	}
}
