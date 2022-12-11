//Iterating through the array inside json response and fetching value
package com.guru;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IteratingThroughJsonResponse {
	@Test(enabled=false)
	public static void iterateResp() {
		RestAssured.baseURI = "https://run.mocky.io/v3";
		Response res = given().when().get("/8ec8f4f7-8e68-4f4b-ad18-4f0940d40bb7");
		JsonPath j = new JsonPath(res.asString());
		int s = j.getInt("Location.size()");
		System.out.println(s);
		for (int i = 0; i < s; i++) {
			System.out.println(j.getString("Location["+i+"].State"));
		}
	}
	@Test(enabled=false)
	public static void respIterate()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		Response res=given().when().get("posts");
		JsonPath j=new JsonPath(res.asString());
		int s=j.getInt("data.size()");
		System.out.println(s);
		for(int i=0;i<s;i++)
		{
			String userID = j.getString("["+i+"].userId");
			System.out.println(userID);
		}
	}
	@Test
	public static void pgm1()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response res=given().when().get("posts");
		JsonPath j=new JsonPath(res.asString());
		int s=j.getInt("data.size()");
		System.out.println(s);
		for(int i=0;i<s;i++)
		{
			String title=j.getString("["+i+"].title");
			System.out.println(title);
		}
		
	}
	

}
