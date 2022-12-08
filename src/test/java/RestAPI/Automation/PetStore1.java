package RestAPI.Automation;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PetStore1 {
	@DataProvider(name = "testdata1")
	public Object[][] testdata1() {
		Object[][] obj = new Object[1][7];
		obj[0][0] = "chinmayeesn";
		obj[0][1] = "chinmayee";
		obj[0][2] = "naik";
		obj[0][3] = "chinmayee@test.com";
		obj[0][4] = "chinmayee";
		obj[0][5] = "8756734509";
		obj[0][6] = "0";
		return obj;
	}

	@Test(dataProvider = "testdata1")
	public void createUser1(String uname, String fName, String lName, String email, String pwd, String ph, String uS,ITestContext val) {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		JSONObject obj = new JSONObject();
		obj.put("username", uname);
		obj.put("firstName", fName);
		obj.put("lastName", lName);
		obj.put("email", email);
		obj.put("password", pwd);
		obj.put("phone", ph);
		obj.put("userStatus", uS);
		given().contentType(ContentType.JSON).log().all()
		.when().body(obj.toJSONString()).post("user")
		.then().statusCode(200).log().all();
		
	}
}
