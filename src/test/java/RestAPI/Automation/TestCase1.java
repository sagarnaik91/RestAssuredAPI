package RestAPI.Automation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TestCase1 {
	@Test(enabled=false)
	public static void post() {

		RestAssured.baseURI = "http://localhost:3000";
		String reqBody = "{\"firstName\":\"Sagar\",\"lastName\":\"Naik\",\"place\":\"Gaongeri\"}";
		given().header("content-type", "application/json").body(reqBody).when().post("ibm_example").then()
				.statusCode(201);

	}
	@Test
	public static void example1(ITestContext val)
	{
		JSONObject reqBody=new JSONObject();
		reqBody.put("username", "sagarsn");
		reqBody.put("firstName", "sagar");
		reqBody.put("lastName", "naik");
		reqBody.put("email", "abc@test.com");
		reqBody.put("password", "abc");
		reqBody.put("phone", "8976543547");
		reqBody.put("userStatus", "0");
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		Response response=given().contentType(ContentType.JSON).body(reqBody.toJSONString()).when().post("user").then().statusCode(200).log().all().extract().response();
        String codeval=response.jsonPath().getString("code");
        System.out.println("codeval is "+codeval);
        Assert.assertEquals("200", codeval);
        val.setAttribute("codeNumber", codeval);
        			
	}
	@Test
	public static void example2(ITestContext val1)
	{
		String code=val1.getAttribute("codeNumber").toString();
		System.out.println("code is "+code);
		Response response=given().contentType(ContentType.JSON).log().all().when().get("user"+"/"+code).then().statusCode(404).log().all().extract().response();
		
		
	}
	@Test
	public static void example3()
	{
		Response response=given().contentType(ContentType.JSON).queryParam("username", "sagarsn").queryParam("password", "abc").log().all()
				.when().get("user/login")
				.then().statusCode(200).log().all().extract().response();
	}
}
