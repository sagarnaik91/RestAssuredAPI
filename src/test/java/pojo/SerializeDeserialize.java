package pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeDeserialize {
	@Test
	public static void serialiseDesrialise() throws JsonProcessingException {
		SamplePOJO pojo = new SamplePOJO();
		pojo.setFirstname("abc");
		pojo.setLastname("xyz");
		pojo.setEmployeenumber(1);

		ObjectMapper obj = new ObjectMapper();
		String JSON = obj.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		System.out.println(JSON);
		
		ObjectMapper getObj=new ObjectMapper();
		SamplePOJO pojoobj=getObj.readValue(JSON, SamplePOJO.class);
		System.out.println(pojoobj.getEmployeenumber());
		System.out.println(pojoobj.getFirstname());
		System.out.println(pojoobj.getLastname());
	}
}
