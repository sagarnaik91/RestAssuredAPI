package com.guru;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class ReqBodyConstruction {
	@Test
	public static void reqBody() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		JSONObject reqSchema = new JSONObject();
		reqSchema.put("name", "Sagar");
		reqSchema.put("lastname", "Naik");
		JSONArray mobiles = new JSONArray();
		mobiles.add(123);
		mobiles.add(456);
		JSONObject address = new JSONObject();
		address.put("line1", "abc");
		address.put("line2", "xyz");
		reqSchema.put("mobiles", mobiles);
		reqSchema.put("address", address);
		String res = given().contentType(ContentType.JSON).body(reqSchema).log().all().when().post("user").asString();
		JsonPath jes = new JsonPath(res);

	}
}
