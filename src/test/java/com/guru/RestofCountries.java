package com.guru;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RestofCountries {
	@Test(enabled = false)
	public static void countries() {
		RestAssured.baseURI = "https://restcountries.com/v2";
		String resp = given().when().get("all").asString();
		JsonPath jsonresp = new JsonPath(resp);
		int length = jsonresp.getInt("data.size()");
		System.out.println("Total countries are " + length);
		for (int i = 0; i < length; i++) {
			String country = jsonresp.getString("[" + i + "].name");
			System.out.println("Names of country are " + country);
		}
	}

	@Test(enabled = false)
	public static void topLevelDomain() {
		RestAssured.baseURI = "https://restcountries.com/v2";
		String resp = given().when().get("all").asString();
		JsonPath jresp = new JsonPath(resp);
		int totalLength = jresp.getInt("data.size()");
		for (int i = 0; i < totalLength; i++) {
			String topLevelDomain = jresp.getString("[" + i + "].topLevelDomain[0]");
			System.out.println(topLevelDomain);
		}
	}

	@Test
	public static void border() {
		RestAssured.baseURI = "https://restcountries.com/v2";
		String resp = given().when().get("all").asString();
		JsonPath jresp = new JsonPath(resp);
		// String logger=jresp.getString("[2].borders[0]");
		// System.out.println("logger "+logger);
		int totalLength = jresp.getInt("data.size()");
		//int subLength1 = jresp.getInt("[0].borders.size()");
		for (int i = 0; i < totalLength; i++) {
			int subLength = jresp.getInt("[" + i + "].borders.size()");
			System.out.println("borders length is " + subLength);
			
			for (int j = 0; j < subLength; j++) 
			{
				String borders = jresp.getString("[" + i + "].borders[" + j + "]");
				System.out.println(borders);
			}

		}
	}
}
