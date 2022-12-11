//Extract response field using JsonPath
package com.guru;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ExtractingResponse {
	@Test
	public static void extractRes() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
		Response res=given().log().body().get("posts");
		JsonPath jsonResponse=new JsonPath(res.asString());
		String userId=jsonResponse.getString("[0].userId");
		System.out.println("firstIteraion of userid is "+userId);
	}
}
