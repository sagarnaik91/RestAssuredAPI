package RestAPI.Automation;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TestCase2 {
	@Test
	public static void post() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		String reqBody = "{\"id\": 0,\"username\": \"string\",\"firstName\": \"string\",\"lastName\": \"string\",\"email\": \"string\",\"password\": \"string\",\"phone\": \"string\",\"userStatus\": 0}";
		given().header("content-type", "application/json").body(reqBody).when().post("user").then().statusCode(200);
	}
	@Test
	public static void post1()
	{
		JSONObject reqbody=new JSONObject();
		reqbody.put("id", "0");
		reqbody.put("username", "string");
		reqbody.put("firstName", "string");
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		Response response=given().header("content-type","application/json").body(reqbody.toJSONString()).when().post("user").then().statusCode(200).log().all().extract().response();
		String val=response.jsonPath().getString("code");
		Assert.assertEquals(val, "200");
	}
}
