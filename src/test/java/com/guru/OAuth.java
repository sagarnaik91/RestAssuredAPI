package com.guru;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
@Test
public class OAuth {
	public static void oauth() {
		RestAssured.baseURI = "https://gmail.googleapis.com/gmail/v1";
		String token="ya29.a0AeTM1ieudYhncDxe_tMmQC0VJjkLQ2Wjk_5CrGYVsYDYcdT52H3m4x5F4lIKCGeW3eyFIZ-TbXxG_Ug7jIp6_moXW4FAgZhn8nF5dyjSTv8NaTnXPtNeOt6mU6yynJDlTWB-sOWXuAWF8x03RJunnh68JJwGaCgYKAXwSARASFQHWtWOmG-WfGUzpDJzacaRnOoqpjQ0163";
		String res = given().pathParam("userId", "sagarthbs@gmail.com").header("Authorization","Bearer "+token).log().all().when().get("users/{userId}/profile").asString();
		System.out.println(res);
		JsonPath jes = new JsonPath(res);
		int messagesTotal=jes.get("messagesTotal");
		System.out.println(messagesTotal);
	}
}
