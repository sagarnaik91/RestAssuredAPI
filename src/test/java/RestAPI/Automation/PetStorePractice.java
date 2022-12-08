package RestAPI.Automation;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;;
public class PetStorePractice 
{
	@DataProvider(name="testdata1")
	public Object[][] data() throws IOException
	{
		Object[][] obj=testDataPractice.testdata();
		return obj;
	}
	@Test
	public void createUser(String uN,String fn,String ln,String em,String pwd,String ph,String us)
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		JSONObject jobj=new JSONObject();
		jobj.put("username", uN);
		jobj.put("firstname", fn);
		Response response=given().contentType(ContentType.JSON).log().all().when().body(jobj).post("user").then().statusCode(200).log().all().extract().response();
	    String code=response.jsonPath().getString("code");
	    Assert.assertEquals(code, 200);
	}

}
