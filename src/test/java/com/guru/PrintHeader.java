/*Script to print request header, request body and response header and response body
*/
package com.guru;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PrintHeader {
	@Test
	public void headerPrint() {
		RestAssured.baseURI = "https://api.agify.io";
		given().param("name", "meelad").contentType(ContentType.JSON).auth().basic("", "").log().all().when().get("")
				.then().statusCode(200).log().all();
	}
	//Print only response body, response header not needed
	public void responsePrint() {
		RestAssured.baseURI = "https://api.agify.io";
		given().param("name", "meelad").contentType(ContentType.JSON).auth().basic("", "").log().all().when().get("")
				.then().statusCode(200).log().body();
	}
}
