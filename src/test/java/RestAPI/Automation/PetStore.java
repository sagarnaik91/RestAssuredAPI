package RestAPI.Automation;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetStore {
	@DataProvider(name = "testdata")
	public Object[][] testdata() throws IOException {
		Object[][] obj = testdata.testdata();
		return obj;
	}

	@Test(dataProvider = "testdata", priority = 1)
	public static void createuser(String uname, String fName, String lName, String email, String pwd, String ph,
			String uS, ITestContext val) {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		JSONObject obj = new JSONObject();
		obj.put("username", uname);
		obj.put("firstName", fName);
		obj.put("lastName", lName);
		obj.put("email", email);
		obj.put("password", pwd);
		obj.put("phone", ph);
		obj.put("userStatus", uS);
		given().contentType(ContentType.JSON).log().all().when().body(obj.toJSONString()).post("user").then()
				.statusCode(200).log().all();
		

	}

	@Test(dataProvider = "testdata", priority = 2)
	public static void modifyuser(String uname, String fName, String lName, String email, String pwd, String ph,
			String uS, ITestContext val1) {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		JSONObject obj = new JSONObject();
		obj.put("username", uname);
		obj.put("firstName", fName);
		obj.put("lastName", lName + "abc");
		obj.put("email", email);
		obj.put("password", pwd);
		obj.put("phone", ph);
		obj.put("userStatus", uS);
		given().contentType(ContentType.JSON).log().all().when().body(obj.toJSONString())
				.put("user/" + val1.getAttribute("uNameval")).then().statusCode(200).log().all();
		val1.setAttribute("passwordVal", pwd);

	}

	@Test(dataProvider = "testdata", priority = 3)
	public static void getUser(String uname, String fName, String lName, String email, String pwd, String ph,
			String uS) {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		String key = "/user/" + uname;
		System.out.println("key is " + key);
		Response res = given().log().all().contentType(ContentType.JSON).when().get(key).then().statusCode(200).log()
				.all().extract().response();
		res.prettyPrint();
	}

	@Test(dataProvider = "testdata", priority = 4)
	public static void login(String uname, String fName, String lName, String email, String pwd, String ph, String uS) {
		given().queryParam("username ", uname).queryParam("password", pwd).when().get("user").then().statusCode(405)
				.log().all();
	}

	@Test(dataProvider = "testdata", priority = 5)
	public static void logout(String uname, String fName, String lName, String email, String pwd, String ph,
			String uS) {
		given().queryParam("username", uname).queryParam("password", pwd).when().get("user").then().statusCode(405)
				.log().all();
	}

	@Test(dataProvider = "testdata", priority = 6)
	public static void delete(String uname, String fName, String lName, String email, String pwd, String ph,
			String uS) {
		given().delete("user/" + uname).then().statusCode(200).log().all();
	}
}
