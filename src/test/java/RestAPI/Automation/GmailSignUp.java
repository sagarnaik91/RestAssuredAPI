package RestAPI.Automation;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GmailSignUp {
	@DataProvider(name = "testdata")
	public Object[][] testData() throws IOException {
		Object[][] userDetails = UsersTestData.users();
		return userDetails;
	}

	@Test(dataProvider = "testdata")
	public static void createUsers(String fName, String lName, String dob, String number, String em) {
		JSONObject requestBody = new JSONObject();
		requestBody.put("firstName", fName);
		requestBody.put("lastName", lName);
		requestBody.put("dob", dob);
		requestBody.put("mobilenumber", number);
		requestBody.put("email", em);
		RestAssured.baseURI = "https://www.gmail.com/";
		Response response = given().contentType(ContentType.JSON).auth().basic("username", "password")
				.body(requestBody.toJSONString()).when().post("account/new").then().statusCode(200).log().all()
				.extract().response();
	}
}
