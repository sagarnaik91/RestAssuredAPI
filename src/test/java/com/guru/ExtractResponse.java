//Extract response field using HAMCREST
package com.guru;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class ExtractResponse {
	static String jsonresponse;

	@Test(enabled = true)
	public static void fetchResponse() {
		RestAssured.baseURI = "https://api.first.org/";
		jsonresponse = given().when().get("data/v1/news").asString();
		JsonPath jes=new JsonPath(jsonresponse);
		System.out.println(jes.getString("data[0].id"));
		System.out.println(jes.getString("version"));
		
	}

	//Response validation using hamcrest
	@Test(enabled=false)
	public static void bearer() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		String bearerToken = "";
		String body = "{\"id\": 0,\"username\": \"string\",\"firstName\": \"string\",\"lastName\": \"string\",\"email\": \"string\"}";
		given().header("Authorization", "Bearer " + bearerToken).contentType(ContentType.JSON).body(body).when()
				.post("user").then().assertThat().statusCode(200).and().body("type", equalTo("unknown1"));
	}
	@Test(enabled=false)
	public static void hamcrest()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		String token="sd34";
		String body = "{\"id\": 0,\"username\": \"string\",\"firstName\": \"string\",\"lastName\": \"string\",\"email\": \"string\"}";
		given().header("Authorization", "Bearer "+ token).contentType(ContentType.JSON).body(body).when().post("user").then().assertThat().statusCode(200).and().body("type", equalTo("unknown"));
	}
}
